package real.grpc.tracker;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.0)",
    comments = "Source: Tracker.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TrackerGrpc {

  private TrackerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "real.grpc.tracker.Tracker";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<real.grpc.tracker.Robot,
      real.grpc.tracker.Position> getGetPositionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPosition",
      requestType = real.grpc.tracker.Robot.class,
      responseType = real.grpc.tracker.Position.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<real.grpc.tracker.Robot,
      real.grpc.tracker.Position> getGetPositionMethod() {
    io.grpc.MethodDescriptor<real.grpc.tracker.Robot, real.grpc.tracker.Position> getGetPositionMethod;
    if ((getGetPositionMethod = TrackerGrpc.getGetPositionMethod) == null) {
      synchronized (TrackerGrpc.class) {
        if ((getGetPositionMethod = TrackerGrpc.getGetPositionMethod) == null) {
          TrackerGrpc.getGetPositionMethod = getGetPositionMethod =
              io.grpc.MethodDescriptor.<real.grpc.tracker.Robot, real.grpc.tracker.Position>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPosition"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  real.grpc.tracker.Robot.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  real.grpc.tracker.Position.getDefaultInstance()))
              .setSchemaDescriptor(new TrackerMethodDescriptorSupplier("GetPosition"))
              .build();
        }
      }
    }
    return getGetPositionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<real.grpc.tracker.Empty,
      real.grpc.tracker.RobotList> getGetAllRobotsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllRobots",
      requestType = real.grpc.tracker.Empty.class,
      responseType = real.grpc.tracker.RobotList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<real.grpc.tracker.Empty,
      real.grpc.tracker.RobotList> getGetAllRobotsMethod() {
    io.grpc.MethodDescriptor<real.grpc.tracker.Empty, real.grpc.tracker.RobotList> getGetAllRobotsMethod;
    if ((getGetAllRobotsMethod = TrackerGrpc.getGetAllRobotsMethod) == null) {
      synchronized (TrackerGrpc.class) {
        if ((getGetAllRobotsMethod = TrackerGrpc.getGetAllRobotsMethod) == null) {
          TrackerGrpc.getGetAllRobotsMethod = getGetAllRobotsMethod =
              io.grpc.MethodDescriptor.<real.grpc.tracker.Empty, real.grpc.tracker.RobotList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllRobots"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  real.grpc.tracker.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  real.grpc.tracker.RobotList.getDefaultInstance()))
              .setSchemaDescriptor(new TrackerMethodDescriptorSupplier("GetAllRobots"))
              .build();
        }
      }
    }
    return getGetAllRobotsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrackerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrackerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrackerStub>() {
        @java.lang.Override
        public TrackerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrackerStub(channel, callOptions);
        }
      };
    return TrackerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrackerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrackerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrackerBlockingStub>() {
        @java.lang.Override
        public TrackerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrackerBlockingStub(channel, callOptions);
        }
      };
    return TrackerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrackerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrackerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrackerFutureStub>() {
        @java.lang.Override
        public TrackerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrackerFutureStub(channel, callOptions);
        }
      };
    return TrackerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getPosition(real.grpc.tracker.Robot request,
        io.grpc.stub.StreamObserver<real.grpc.tracker.Position> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPositionMethod(), responseObserver);
    }

    /**
     */
    default void getAllRobots(real.grpc.tracker.Empty request,
        io.grpc.stub.StreamObserver<real.grpc.tracker.RobotList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllRobotsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Tracker.
   */
  public static abstract class TrackerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TrackerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Tracker.
   */
  public static final class TrackerStub
      extends io.grpc.stub.AbstractAsyncStub<TrackerStub> {
    private TrackerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrackerStub(channel, callOptions);
    }

    /**
     */
    public void getPosition(real.grpc.tracker.Robot request,
        io.grpc.stub.StreamObserver<real.grpc.tracker.Position> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPositionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllRobots(real.grpc.tracker.Empty request,
        io.grpc.stub.StreamObserver<real.grpc.tracker.RobotList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllRobotsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Tracker.
   */
  public static final class TrackerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TrackerBlockingStub> {
    private TrackerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrackerBlockingStub(channel, callOptions);
    }

    /**
     */
    public real.grpc.tracker.Position getPosition(real.grpc.tracker.Robot request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPositionMethod(), getCallOptions(), request);
    }

    /**
     */
    public real.grpc.tracker.RobotList getAllRobots(real.grpc.tracker.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllRobotsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Tracker.
   */
  public static final class TrackerFutureStub
      extends io.grpc.stub.AbstractFutureStub<TrackerFutureStub> {
    private TrackerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrackerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrackerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<real.grpc.tracker.Position> getPosition(
        real.grpc.tracker.Robot request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPositionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<real.grpc.tracker.RobotList> getAllRobots(
        real.grpc.tracker.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllRobotsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_POSITION = 0;
  private static final int METHODID_GET_ALL_ROBOTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_POSITION:
          serviceImpl.getPosition((real.grpc.tracker.Robot) request,
              (io.grpc.stub.StreamObserver<real.grpc.tracker.Position>) responseObserver);
          break;
        case METHODID_GET_ALL_ROBOTS:
          serviceImpl.getAllRobots((real.grpc.tracker.Empty) request,
              (io.grpc.stub.StreamObserver<real.grpc.tracker.RobotList>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetPositionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              real.grpc.tracker.Robot,
              real.grpc.tracker.Position>(
                service, METHODID_GET_POSITION)))
        .addMethod(
          getGetAllRobotsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              real.grpc.tracker.Empty,
              real.grpc.tracker.RobotList>(
                service, METHODID_GET_ALL_ROBOTS)))
        .build();
  }

  private static abstract class TrackerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrackerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return real.grpc.tracker.TrackerOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Tracker");
    }
  }

  private static final class TrackerFileDescriptorSupplier
      extends TrackerBaseDescriptorSupplier {
    TrackerFileDescriptorSupplier() {}
  }

  private static final class TrackerMethodDescriptorSupplier
      extends TrackerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TrackerMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TrackerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrackerFileDescriptorSupplier())
              .addMethod(getGetPositionMethod())
              .addMethod(getGetAllRobotsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
