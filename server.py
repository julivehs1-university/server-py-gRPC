#!/usr/bin/env python3
from robots import robots, server_none, server_tuda
import sys
import cv2
import math
import threading
import asyncio
import websockets
import json
from camera import *
from vector2d import Vector2D
import itertools
import random
import angles
import time

red = (0, 0, 255)
green = (0, 255, 0)
magenta = (255, 0, 255)
cyan = (255, 255, 0)
yellow = (50, 255, 255)
black = (0, 0, 0)
white = (255, 255, 255)

class Tag:
    def __init__(self, id, raw_tag):
        self.id = id
        self.raw_tag = raw_tag
        self.corners = raw_tag.tolist()[0]

        # Individual corners (e.g. tl = top left corner in relation to the tag, not the camera)
        self.tl = Vector2D(int(self.corners[0][0]), int(self.corners[0][1])) # Top left
        self.tr = Vector2D(int(self.corners[1][0]), int(self.corners[1][1])) # Top right
        self.br = Vector2D(int(self.corners[2][0]), int(self.corners[2][1])) # Bottom right
        self.bl = Vector2D(int(self.corners[3][0]), int(self.corners[3][1])) # Bottom left

        # Calculate centre of the tag
        self.centre = Vector2D(int((self.tl.x + self.tr.x + self.br.x + self.bl.x) / 4),
                               int((self.tl.y + self.tr.y + self.br.y + self.bl.y) / 4))

        # Calculate centre of top of tag
        self.front = Vector2D(int((self.tl.x + self.tr.x) / 2),
                              int((self.tl.y + self.tr.y) / 2))

        # Calculate orientation of tag
        self.forward = math.atan2(self.front.y - self.centre.y, self.front.x - self.centre.x) # Forward vector
        self.angle = self.forward # Angle between forward vector and x-axis
        # sollte jetzt rad statt degree liefern

class Robot:
    def __init__(self, tag, position):
        self.tag = tag
        self.id = tag.id
        self.position = position
        self.orientation = tag.angle
        self.sensor_range = 0.1 # 30cm sensing radius
        self.neighbours = {}
        self.tasks = {}

class SensorReading:
    def __init__(self, range, bearing, orientation=0, workers=0):
        self.range = range
        self.bearing = bearing
        self.orientation = orientation
        self.workers = workers



class Tracker(threading.Thread):

    def __init__(self):
        threading.Thread.__init__(self)
        self.camera = Camera()
        self.calibrated = False
        self.num_corner_tags = 0
        self.min_x = 0 # In pixels
        self.min_y = 0 # In pixels
        self.max_x = 0 # In pixels
        self.max_y = 0 # In pixels
        self.centre = Vector2D(0, 0) # In metres
        self.corner_distance_metres = 1.8 # Euclidean distance between corner tags in metres
        self.corner_distance_pixels = 0
        self.scale_factor = 0
        self.robots = {}

    def run(self):
        while True:        
            image = self.camera.get_frame()
            overlay = image.copy()
            
            aruco_dictionary = cv2.aruco.getPredefinedDictionary(cv2.aruco.DICT_4X4_250) #cv2.aruco.Dictionary_get(cv2.aruco.DICT_4X4_100)
            aruco_parameters = cv2.aruco.DetectorParameters() #cv2.aruco.DetectorParameters_create()

            (raw_tags, tag_ids, rejected) = cv2.aruco.detectMarkers(image, aruco_dictionary, parameters=aruco_parameters)

            self.robots = {} # Clear dictionary every frame in case robots have disappeared

            # Check whether any tags were detected in this camera frame
            if tag_ids is not None and len(tag_ids.tolist()) > 0:

                tag_ids = list(itertools.chain(*tag_ids))
                tag_ids = [int(id) for id in tag_ids] # Convert from numpy.int32 to int

                # Process raw ArUco output
                for id, raw_tag in zip(tag_ids, raw_tags):

                    tag = Tag(id, raw_tag)

                    if self.calibrated:
                        if tag.id != 0: # Reserved tag ID for corners
                            position = Vector2D(tag.centre.x / self.scale_factor, tag.centre.y / self.scale_factor) # Convert pixel coordinates to metres
                            self.robots[id] = Robot(tag, position)
                    else: # Only calibrate the first time two corner tags are detected
                       
                        if tag.id == 0: # Reserved tag ID for corners

                            if self.num_corner_tags == 0: # Record the first corner tag detected
                                self.min_x = tag.centre.x
                                self.max_x = tag.centre.x
                                self.min_y = tag.centre.y
                                self.max_y = tag.centre.y
                            else: # Set min/max boundaries of arena based on second corner tag detected

                                if tag.centre.x < self.min_x:
                                    self.min_x = tag.centre.x
                                if tag.centre.x > self.max_x:
                                    self.max_x = tag.centre.x
                                if tag.centre.y < self.min_y:
                                    self.min_y = tag.centre.y
                                if tag.centre.y > self.max_y:
                                    self.max_y = tag.centre.y

                                self.corner_distance_pixels = math.dist([self.min_x, self.min_y], [self.max_x, self.max_y]) # Euclidean distance between corner tags in pixels
                                self.scale_factor = self.corner_distance_pixels / self.corner_distance_metres
                                x = ((self.max_x - self.min_x) / 2) / self.scale_factor # Convert to metres
                                y = ((self.max_y - self.min_y) / 2) / self.scale_factor # Convert to metres
                                self.centre = Vector2D(x, y)
                                self.calibrated = True

                            self.num_corner_tags = self.num_corner_tags + 1

                if self.calibrated:

                    # Draw boundary of virtual environment based on corner tag positions
                    cv2.rectangle(image, (self.min_x, self.min_y), (self.max_x, self.max_y), green, 1, lineType=cv2.LINE_AA)
            
                    # Process robots
                    for id, robot in self.robots.items():

                        for other_id, other_robot in self.robots.items():

                            if id != other_id: # Don't check this robot against itself

                                range = robot.position.distance_to(other_robot.position)

                                if range < robot.sensor_range:

                                    absolute_bearing = math.degrees(math.atan2(other_robot.position.y - robot.position.y, other_robot.position.x - robot.position.x))
                                    relative_bearing = absolute_bearing - robot.orientation
                                    normalised_bearing = angles.normalize(relative_bearing, -180, 180)
                                    robot.neighbours[other_id] = SensorReading(range, normalised_bearing, other_robot.orientation)

                        # Draw tag
                        tag = robot.tag

                        # Draw border of tag
                        cv2.line(image, (tag.tl.x, tag.tl.y), (tag.tr.x, tag.tr.y), green, 1, lineType=cv2.LINE_AA)
                        cv2.line(image, (tag.tr.x, tag.tr.y), (tag.br.x, tag.br.y), green, 1, lineType=cv2.LINE_AA)
                        cv2.line(image, (tag.br.x, tag.br.y), (tag.bl.x, tag.bl.y), green, 1, lineType=cv2.LINE_AA)
                        cv2.line(image, (tag.bl.x, tag.bl.y), (tag.tl.x, tag.tl.y), green, 1, lineType=cv2.LINE_AA)
                        
                        # Draw circle on centre point
                        cv2.circle(image, (tag.centre.x, tag.centre.y), 5, red, -1, lineType=cv2.LINE_AA)

                        # Draw robot's sensor range
                        sensor_range_pixels = int(robot.sensor_range * self.scale_factor)
                        cv2.circle(overlay, (tag.centre.x, tag.centre.y), sensor_range_pixels, magenta, -1, lineType=cv2.LINE_AA)

                        # Draw lines between robots if they are within sensor range
                        for neighbour_id in robot.neighbours.keys():
                            neighbour = self.robots[neighbour_id]
                            cv2.line(image, (tag.centre.x, tag.centre.y), (neighbour.tag.centre.x, neighbour.tag.centre.y), black, 10, lineType=cv2.LINE_AA)
                            cv2.line(image, (tag.centre.x, tag.centre.y), (neighbour.tag.centre.x, neighbour.tag.centre.y), cyan, 3, lineType=cv2.LINE_AA)

                    for id, robot in self.robots.items():

                        tag = robot.tag

                        # Draw line from centre point to front of tag
                        forward_point = ((tag.front - tag.centre) * 2) + tag.centre
                        cv2.line(image, (tag.centre.x, tag.centre.y), (forward_point.x, forward_point.y), black, 10, lineType=cv2.LINE_AA)
                        cv2.line(image, (tag.centre.x, tag.centre.y), (forward_point.x, forward_point.y), green, 3, lineType=cv2.LINE_AA)

                        # Draw tag ID
                        text = str(tag.id)
                        font = cv2.FONT_HERSHEY_SIMPLEX
                        font_scale = 1.5
                        thickness = 4
                        textsize = cv2.getTextSize(text, font, font_scale, thickness)[0]
                        position = (int(tag.centre.x - textsize[0]/2), int(tag.centre.y + textsize[1]/2))
                        cv2.putText(image, text, position, font, font_scale, black, thickness * 3, cv2.LINE_AA)
                        cv2.putText(image, text, position, font, font_scale, white, thickness, cv2.LINE_AA)


                    # Transparency for overlaid augments
                    alpha = 0.3
                    image = cv2.addWeighted(overlay, alpha, image, 1 - alpha, 0)

            window_name = 'Praktikum Verteilte Robotiksysteme Gruppe1'

            # screen = screeninfo.get_monitors()[0]
            # width, height = screen.width, screen.height
            # image = cv2.resize(image, (width, height))
            # cv2.namedWindow(window_name, cv2.WND_PROP_FULLSCREEN)
            # cv2.setWindowProperty(window_name, cv2.WND_PROP_FULLSCREEN, cv2.WINDOW_FULLSCREEN)

            cv2.imshow(window_name, image)

            # TODO: Fix quitting with Q (necessary for fullscreen mode)
            if cv2.waitKey(1) == ord('q'):
                sys.exit()

async def handler(websocket):
    async for packet in websocket:
        message = json.loads(packet)
        
        # Process any requests received
        reply = {}
        send_reply = False

        if "check_awake" in message:
            reply["awake"] = True
            send_reply = True

        if "get_robots" in message:

            for id, robot in tracker.robots.items():
                reply[id] = {}
                reply[id]["orientation"] = robot.orientation
                reply[id]["neighbours"] = {}
                reply[id]["positionX"] = robot.position.x*100
                reply[id]["positionY"] = robot.position.y*100

                for neighbour_id, neighbour in robot.neighbours.items():
                    reply[id]["neighbours"][neighbour_id] = {}
                    reply[id]["neighbours"][neighbour_id]["range"] = neighbour.range
                    reply[id]["neighbours"][neighbour_id]["bearing"] = neighbour.bearing
                    reply[id]["neighbours"][neighbour_id]["orientation"] = neighbour.orientation 

            send_reply = True

        # Send reply, if requested
        if send_reply:
            await websocket.send(json.dumps(reply))


if __name__ == "__main__":
    global tracker
    tracker = Tracker()
    tracker.start()

    ##
    # Use the following iptables rule to forward port 80 to 6000 for the server to use:
    #   sudo iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 6001
    # Alternatively, change the port below to 80 and run this Python script as root.
    ##
    start_server = websockets.serve(ws_handler=handler, host=server_tuda, port=6001, ping_interval=None)
    # start_server = websockets.serve(ws_handler=handler, host="144.32.165.233", port=6000)

    loop = asyncio.get_event_loop()
    loop.run_until_complete(start_server)
    loop.run_forever()
