#!/usr/bin/env python3

from robots import robots, server_none, server_tuda

import asyncio
import websockets
import json
import signal
import time
import sys
from enum import Enum
import time
import random
import inspect

import colorama
from colorama import Fore

from concurrent import futures
import logging
import grpc

from out_python import Tracker_pb2 as Tracker_pb2
from out_python import Tracker_pb2_grpc as Tracker_pb2_grpc

colorama.init(autoreset=True)


##
# All ports should remain at 80.
##
server_address = server_tuda
server_port = 6001
robot_port = 80
##

if len(server_address) == 0:
    raise Exception(f"Enter local tracking server address on line {inspect.currentframe().f_lineno - 6}, "
                    f"then re-run this script.")


# Persistent Websockets!!!!!!!!!!!!!!!!
# https://stackoverflow.com/questions/59182741/python-websockets-lib-client-persistent-connection-with-class-implementation

server_connection = None
active_robots = {}
ids = []


# Main Robot class to keep track of robot states
class Robot:

    def __init__(self, robot_id):
        self.id = robot_id
        self.connection = None

        self.orientation = 0
        self.positionX = 0
        self.positionY = 0
        self.neighbours = {}


# Check if robot is awake by sending the "check_awake" command to its websocket server
async def check_awake(connection):
    awake = False

    try:
        message = {"check_awake": True}

        # Send request for data and wait for reply
        await connection.send(json.dumps(message))
        reply_json = await connection.recv()
        reply = json.loads(reply_json)

        # Reply should contain "awake" with value True
        awake = reply["awake"]

    except Exception as e:
        print(f"{type(e).__name__}: {e}")

    return awake



# Connect to websocket server of tracking server
async def connect_to_server():
    uri = f"ws://{server_address}:{server_port}"
    connection = await websockets.connect(uri)

    print("Opening connection to server: " + uri)

    awake = await check_awake(connection)

    if awake:
        print("Server is awake")
        global server_connection
        server_connection = connection
    else:
        print("Server did not respond")


# Get robots' virtual sensor data from the tracking server, for our active robots
async def get_server_data(robot_id):
    try:
        global ids
        message = {"get_robots": True}

        # Send request for data and wait for reply
        await server_connection.send(json.dumps(message))
        reply_json = await server_connection.recv()
        reply = json.loads(reply_json)

        # Filter reply from the server, based on our active robots of interest
        filtered_reply = {int(k): v for (k, v) in reply.items() if int(k) in active_robots.keys()}

        ids = list(filtered_reply.keys())

        # Receive robot virtual sensor data from the server
        for id, robot in filtered_reply.items():
            if id == robot_id:
                active_robots[id].orientation = robot["orientation"]
                active_robots[id].positionX = robot["positionX"]
                active_robots[id].positionY = robot["positionY"]
                return robot["positionX"], robot["positionY"], robot["orientation"]



        return -1, -1, -1

    except Exception as e:
        print(f"{type(e).__name__}: {e}")



# Send message to a websocket server
async def send_message(websocket, message):
    await websocket.send(json.dumps({"prompt": message}))


class Tracker(Tracker_pb2_grpc.TrackerServicer):
    def GetPosition(self, request, context):
        print(Fore.GREEN + "[INFO]: Requesting data from tracking server")
        x, y, orientation = loop.run_until_complete(get_server_data(request.robot_id))
        return Tracker_pb2.Position(x=x, y=y, orientation=orientation)

    def GetAllRobots(self, request, context):
        result = []
        for id in robot_ids:
            result.append(Tracker_pb2.Robot(robot_id=id))

        return Tracker_pb2.RobotList(robots=result)


def serve():
    port = "50051"
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    Tracker_pb2_grpc.add_TrackerServicer_to_server(Tracker(), server)
    server.add_insecure_port("[::]:" + port)
    server.start()
    print("Server started, listening on " + port)
    server.wait_for_termination()

# Main entry point for robot control client sample code
if __name__ == "__main__":
    loop = asyncio.get_event_loop()

    loop.run_until_complete(connect_to_server())

    if server_connection is None:
        print(Fore.RED + "[ERROR]: No connection to server")
        sys.exit(1)

    # Specify robot IDs to work with here. For example for robots 11-15 use:
    #  robot_ids = range(11, 16)
    #robot_ids = range(43, 45)
    #robot_ids = range(6, 7)
    robot_ids = [44,45]
    #robot_ids = range(44, 47)

    if len(robot_ids) == 0:
        raise Exception(f"Enter range of robot IDs to control on line {inspect.currentframe().f_lineno - 3}, "
                        f"then re-run this script.")

    # Create Robot objects
    for robot_id in robot_ids:
        if robots[robot_id] != '':
            active_robots[robot_id] = Robot(robot_id)
        else:
            print(f"No IP defined for robot {robot_id}")
            

    logging.basicConfig()
    serve()

    sys.exit(0)
