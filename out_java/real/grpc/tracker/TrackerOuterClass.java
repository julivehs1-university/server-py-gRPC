// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Tracker.proto

// Protobuf Java Version: 3.25.1
package real.grpc.tracker;

public final class TrackerOuterClass {
  private TrackerOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_real_grpc_tracker_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_real_grpc_tracker_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_real_grpc_tracker_Robot_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_real_grpc_tracker_Robot_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_real_grpc_tracker_RobotList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_real_grpc_tracker_RobotList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_real_grpc_tracker_Position_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_real_grpc_tracker_Position_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rTracker.proto\022\021real.grpc.tracker\"\007\n\005Em" +
      "pty\"\031\n\005Robot\022\020\n\010robot_id\030\001 \001(\005\"5\n\tRobotL" +
      "ist\022(\n\006robots\030\001 \003(\0132\030.real.grpc.tracker." +
      "Robot\"5\n\010Position\022\t\n\001x\030\001 \001(\002\022\t\n\001y\030\002 \001(\002\022" +
      "\023\n\013orientation\030\003 \001(\0022\233\001\n\007Tracker\022F\n\013GetP" +
      "osition\022\030.real.grpc.tracker.Robot\032\033.real" +
      ".grpc.tracker.Position\"\000\022H\n\014GetAllRobots" +
      "\022\030.real.grpc.tracker.Empty\032\034.real.grpc.t" +
      "racker.RobotList\"\000B\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_real_grpc_tracker_Empty_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_real_grpc_tracker_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_real_grpc_tracker_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_real_grpc_tracker_Robot_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_real_grpc_tracker_Robot_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_real_grpc_tracker_Robot_descriptor,
        new java.lang.String[] { "RobotId", });
    internal_static_real_grpc_tracker_RobotList_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_real_grpc_tracker_RobotList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_real_grpc_tracker_RobotList_descriptor,
        new java.lang.String[] { "Robots", });
    internal_static_real_grpc_tracker_Position_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_real_grpc_tracker_Position_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_real_grpc_tracker_Position_descriptor,
        new java.lang.String[] { "X", "Y", "Orientation", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}