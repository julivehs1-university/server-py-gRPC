from concurrent import futures
import logging
import grpc

from out_python import Tracker_pb2 as Tracker_pb2
from out_python import Tracker_pb2_grpc as Tracker_pb2_grpc

class Tracker(Tracker_pb2_grpc.TrackerServicer):
    def GetPosition(self, request, context):
        return Tracker_pb2.Position(x=42, y=32, orientation=10)

    def GetAllRobots(self, request, context):
        return Tracker_pb2.RobotList([
            Tracker_pb2.Robot(robot_id=1)
        ])
    



def serve():
    port = "50051"
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    Tracker_pb2_grpc.add_TrackerServicer_to_server(Tracker(), server)
    server.add_insecure_port("[::]:" + port)
    server.start()
    print("Server started, listening on " + port)
    server.wait_for_termination()


if __name__ == "__main__":
    logging.basicConfig()
    serve()