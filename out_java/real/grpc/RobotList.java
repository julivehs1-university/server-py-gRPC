// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Tracker.proto

package real.grpc;

/**
 * Protobuf type {@code real.grpc.RobotList}
 */
public final class RobotList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:real.grpc.RobotList)
    RobotListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RobotList.newBuilder() to construct.
  private RobotList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RobotList() {
    robots_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RobotList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return real.grpc.TrackerOuterClass.internal_static_real_grpc_RobotList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return real.grpc.TrackerOuterClass.internal_static_real_grpc_RobotList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            real.grpc.RobotList.class, real.grpc.RobotList.Builder.class);
  }

  public static final int ROBOTS_FIELD_NUMBER = 1;
  private java.util.List<real.grpc.Robot> robots_;
  /**
   * <code>repeated .real.grpc.Robot robots = 1;</code>
   */
  @java.lang.Override
  public java.util.List<real.grpc.Robot> getRobotsList() {
    return robots_;
  }
  /**
   * <code>repeated .real.grpc.Robot robots = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends real.grpc.RobotOrBuilder> 
      getRobotsOrBuilderList() {
    return robots_;
  }
  /**
   * <code>repeated .real.grpc.Robot robots = 1;</code>
   */
  @java.lang.Override
  public int getRobotsCount() {
    return robots_.size();
  }
  /**
   * <code>repeated .real.grpc.Robot robots = 1;</code>
   */
  @java.lang.Override
  public real.grpc.Robot getRobots(int index) {
    return robots_.get(index);
  }
  /**
   * <code>repeated .real.grpc.Robot robots = 1;</code>
   */
  @java.lang.Override
  public real.grpc.RobotOrBuilder getRobotsOrBuilder(
      int index) {
    return robots_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < robots_.size(); i++) {
      output.writeMessage(1, robots_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < robots_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, robots_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof real.grpc.RobotList)) {
      return super.equals(obj);
    }
    real.grpc.RobotList other = (real.grpc.RobotList) obj;

    if (!getRobotsList()
        .equals(other.getRobotsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getRobotsCount() > 0) {
      hash = (37 * hash) + ROBOTS_FIELD_NUMBER;
      hash = (53 * hash) + getRobotsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static real.grpc.RobotList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static real.grpc.RobotList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static real.grpc.RobotList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static real.grpc.RobotList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static real.grpc.RobotList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static real.grpc.RobotList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static real.grpc.RobotList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static real.grpc.RobotList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static real.grpc.RobotList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static real.grpc.RobotList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static real.grpc.RobotList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static real.grpc.RobotList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(real.grpc.RobotList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code real.grpc.RobotList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:real.grpc.RobotList)
      real.grpc.RobotListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return real.grpc.TrackerOuterClass.internal_static_real_grpc_RobotList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return real.grpc.TrackerOuterClass.internal_static_real_grpc_RobotList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              real.grpc.RobotList.class, real.grpc.RobotList.Builder.class);
    }

    // Construct using real.grpc.RobotList.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (robotsBuilder_ == null) {
        robots_ = java.util.Collections.emptyList();
      } else {
        robots_ = null;
        robotsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return real.grpc.TrackerOuterClass.internal_static_real_grpc_RobotList_descriptor;
    }

    @java.lang.Override
    public real.grpc.RobotList getDefaultInstanceForType() {
      return real.grpc.RobotList.getDefaultInstance();
    }

    @java.lang.Override
    public real.grpc.RobotList build() {
      real.grpc.RobotList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public real.grpc.RobotList buildPartial() {
      real.grpc.RobotList result = new real.grpc.RobotList(this);
      int from_bitField0_ = bitField0_;
      if (robotsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          robots_ = java.util.Collections.unmodifiableList(robots_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.robots_ = robots_;
      } else {
        result.robots_ = robotsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof real.grpc.RobotList) {
        return mergeFrom((real.grpc.RobotList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(real.grpc.RobotList other) {
      if (other == real.grpc.RobotList.getDefaultInstance()) return this;
      if (robotsBuilder_ == null) {
        if (!other.robots_.isEmpty()) {
          if (robots_.isEmpty()) {
            robots_ = other.robots_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureRobotsIsMutable();
            robots_.addAll(other.robots_);
          }
          onChanged();
        }
      } else {
        if (!other.robots_.isEmpty()) {
          if (robotsBuilder_.isEmpty()) {
            robotsBuilder_.dispose();
            robotsBuilder_ = null;
            robots_ = other.robots_;
            bitField0_ = (bitField0_ & ~0x00000001);
            robotsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getRobotsFieldBuilder() : null;
          } else {
            robotsBuilder_.addAllMessages(other.robots_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              real.grpc.Robot m =
                  input.readMessage(
                      real.grpc.Robot.parser(),
                      extensionRegistry);
              if (robotsBuilder_ == null) {
                ensureRobotsIsMutable();
                robots_.add(m);
              } else {
                robotsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<real.grpc.Robot> robots_ =
      java.util.Collections.emptyList();
    private void ensureRobotsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        robots_ = new java.util.ArrayList<real.grpc.Robot>(robots_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        real.grpc.Robot, real.grpc.Robot.Builder, real.grpc.RobotOrBuilder> robotsBuilder_;

    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public java.util.List<real.grpc.Robot> getRobotsList() {
      if (robotsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(robots_);
      } else {
        return robotsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public int getRobotsCount() {
      if (robotsBuilder_ == null) {
        return robots_.size();
      } else {
        return robotsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public real.grpc.Robot getRobots(int index) {
      if (robotsBuilder_ == null) {
        return robots_.get(index);
      } else {
        return robotsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public Builder setRobots(
        int index, real.grpc.Robot value) {
      if (robotsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRobotsIsMutable();
        robots_.set(index, value);
        onChanged();
      } else {
        robotsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public Builder setRobots(
        int index, real.grpc.Robot.Builder builderForValue) {
      if (robotsBuilder_ == null) {
        ensureRobotsIsMutable();
        robots_.set(index, builderForValue.build());
        onChanged();
      } else {
        robotsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public Builder addRobots(real.grpc.Robot value) {
      if (robotsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRobotsIsMutable();
        robots_.add(value);
        onChanged();
      } else {
        robotsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public Builder addRobots(
        int index, real.grpc.Robot value) {
      if (robotsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRobotsIsMutable();
        robots_.add(index, value);
        onChanged();
      } else {
        robotsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public Builder addRobots(
        real.grpc.Robot.Builder builderForValue) {
      if (robotsBuilder_ == null) {
        ensureRobotsIsMutable();
        robots_.add(builderForValue.build());
        onChanged();
      } else {
        robotsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public Builder addRobots(
        int index, real.grpc.Robot.Builder builderForValue) {
      if (robotsBuilder_ == null) {
        ensureRobotsIsMutable();
        robots_.add(index, builderForValue.build());
        onChanged();
      } else {
        robotsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public Builder addAllRobots(
        java.lang.Iterable<? extends real.grpc.Robot> values) {
      if (robotsBuilder_ == null) {
        ensureRobotsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, robots_);
        onChanged();
      } else {
        robotsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public Builder clearRobots() {
      if (robotsBuilder_ == null) {
        robots_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        robotsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public Builder removeRobots(int index) {
      if (robotsBuilder_ == null) {
        ensureRobotsIsMutable();
        robots_.remove(index);
        onChanged();
      } else {
        robotsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public real.grpc.Robot.Builder getRobotsBuilder(
        int index) {
      return getRobotsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public real.grpc.RobotOrBuilder getRobotsOrBuilder(
        int index) {
      if (robotsBuilder_ == null) {
        return robots_.get(index);  } else {
        return robotsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public java.util.List<? extends real.grpc.RobotOrBuilder> 
         getRobotsOrBuilderList() {
      if (robotsBuilder_ != null) {
        return robotsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(robots_);
      }
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public real.grpc.Robot.Builder addRobotsBuilder() {
      return getRobotsFieldBuilder().addBuilder(
          real.grpc.Robot.getDefaultInstance());
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public real.grpc.Robot.Builder addRobotsBuilder(
        int index) {
      return getRobotsFieldBuilder().addBuilder(
          index, real.grpc.Robot.getDefaultInstance());
    }
    /**
     * <code>repeated .real.grpc.Robot robots = 1;</code>
     */
    public java.util.List<real.grpc.Robot.Builder> 
         getRobotsBuilderList() {
      return getRobotsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        real.grpc.Robot, real.grpc.Robot.Builder, real.grpc.RobotOrBuilder> 
        getRobotsFieldBuilder() {
      if (robotsBuilder_ == null) {
        robotsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            real.grpc.Robot, real.grpc.Robot.Builder, real.grpc.RobotOrBuilder>(
                robots_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        robots_ = null;
      }
      return robotsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:real.grpc.RobotList)
  }

  // @@protoc_insertion_point(class_scope:real.grpc.RobotList)
  private static final real.grpc.RobotList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new real.grpc.RobotList();
  }

  public static real.grpc.RobotList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RobotList>
      PARSER = new com.google.protobuf.AbstractParser<RobotList>() {
    @java.lang.Override
    public RobotList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<RobotList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RobotList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public real.grpc.RobotList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

