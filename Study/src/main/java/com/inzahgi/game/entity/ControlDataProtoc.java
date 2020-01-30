// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ControlDataProtoc.proto

package com.inzahgi.game.entity;

public final class ControlDataProtoc {
  private ControlDataProtoc() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ControlDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.inzahgi.game.entity.ControlData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 msg_code = 1;</code>
     * @return The msgCode.
     */
    int getMsgCode();

    /**
     * <code>bytes data = 2;</code>
     * @return The data.
     */
    com.google.protobuf.ByteString getData();

    /**
     * <code>string playload = 3;</code>
     * @return The playload.
     */
    String getPlayload();
    /**
     * <code>string playload = 3;</code>
     * @return The bytes for playload.
     */
    com.google.protobuf.ByteString
        getPlayloadBytes();
  }
  /**
   * Protobuf type {@code com.inzahgi.game.entity.ControlData}
   */
  public  static final class ControlData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.inzahgi.game.entity.ControlData)
      ControlDataOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ControlData.newBuilder() to construct.
    private ControlData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ControlData() {
      data_ = com.google.protobuf.ByteString.EMPTY;
      playload_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new ControlData();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ControlData(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {

              msgCode_ = input.readInt32();
              break;
            }
            case 18: {

              data_ = input.readBytes();
              break;
            }
            case 26: {
              String s = input.readStringRequireUtf8();

              playload_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ControlDataProtoc.internal_static_com_inzahgi_game_entity_ControlData_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ControlDataProtoc.internal_static_com_inzahgi_game_entity_ControlData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ControlData.class, Builder.class);
    }

    public static final int MSG_CODE_FIELD_NUMBER = 1;
    private int msgCode_;
    /**
     * <code>int32 msg_code = 1;</code>
     * @return The msgCode.
     */
    public int getMsgCode() {
      return msgCode_;
    }

    public static final int DATA_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString data_;
    /**
     * <code>bytes data = 2;</code>
     * @return The data.
     */
    public com.google.protobuf.ByteString getData() {
      return data_;
    }

    public static final int PLAYLOAD_FIELD_NUMBER = 3;
    private volatile Object playload_;
    /**
     * <code>string playload = 3;</code>
     * @return The playload.
     */
    public String getPlayload() {
      Object ref = playload_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        playload_ = s;
        return s;
      }
    }
    /**
     * <code>string playload = 3;</code>
     * @return The bytes for playload.
     */
    public com.google.protobuf.ByteString
        getPlayloadBytes() {
      Object ref = playload_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        playload_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (msgCode_ != 0) {
        output.writeInt32(1, msgCode_);
      }
      if (!data_.isEmpty()) {
        output.writeBytes(2, data_);
      }
      if (!getPlayloadBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, playload_);
      }
      unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (msgCode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, msgCode_);
      }
      if (!data_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, data_);
      }
      if (!getPlayloadBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, playload_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof ControlData)) {
        return super.equals(obj);
      }
      ControlData other = (ControlData) obj;

      if (getMsgCode()
          != other.getMsgCode()) return false;
      if (!getData()
          .equals(other.getData())) return false;
      if (!getPlayload()
          .equals(other.getPlayload())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MSG_CODE_FIELD_NUMBER;
      hash = (53 * hash) + getMsgCode();
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getData().hashCode();
      hash = (37 * hash) + PLAYLOAD_FIELD_NUMBER;
      hash = (53 * hash) + getPlayload().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ControlData parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ControlData parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ControlData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ControlData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ControlData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ControlData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ControlData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ControlData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ControlData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ControlData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ControlData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ControlData parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ControlData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.inzahgi.game.entity.ControlData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.inzahgi.game.entity.ControlData)
        ControlDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ControlDataProtoc.internal_static_com_inzahgi_game_entity_ControlData_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ControlDataProtoc.internal_static_com_inzahgi_game_entity_ControlData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ControlData.class, Builder.class);
      }

      // Construct using com.inzahgi.game.entity.ControlDataProtoc.ControlData.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @Override
      public Builder clear() {
        super.clear();
        msgCode_ = 0;

        data_ = com.google.protobuf.ByteString.EMPTY;

        playload_ = "";

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ControlDataProtoc.internal_static_com_inzahgi_game_entity_ControlData_descriptor;
      }

      @Override
      public ControlData getDefaultInstanceForType() {
        return ControlData.getDefaultInstance();
      }

      @Override
      public ControlData build() {
        ControlData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public ControlData buildPartial() {
        ControlData result = new ControlData(this);
        result.msgCode_ = msgCode_;
        result.data_ = data_;
        result.playload_ = playload_;
        onBuilt();
        return result;
      }

      @Override
      public Builder clone() {
        return super.clone();
      }
      @Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.setField(field, value);
      }
      @Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.addRepeatedField(field, value);
      }
      @Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ControlData) {
          return mergeFrom((ControlData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ControlData other) {
        if (other == ControlData.getDefaultInstance()) return this;
        if (other.getMsgCode() != 0) {
          setMsgCode(other.getMsgCode());
        }
        if (other.getData() != com.google.protobuf.ByteString.EMPTY) {
          setData(other.getData());
        }
        if (!other.getPlayload().isEmpty()) {
          playload_ = other.playload_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ControlData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ControlData) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int msgCode_ ;
      /**
       * <code>int32 msg_code = 1;</code>
       * @return The msgCode.
       */
      public int getMsgCode() {
        return msgCode_;
      }
      /**
       * <code>int32 msg_code = 1;</code>
       * @param value The msgCode to set.
       * @return This builder for chaining.
       */
      public Builder setMsgCode(int value) {
        
        msgCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 msg_code = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMsgCode() {
        
        msgCode_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes data = 2;</code>
       * @return The data.
       */
      public com.google.protobuf.ByteString getData() {
        return data_;
      }
      /**
       * <code>bytes data = 2;</code>
       * @param value The data to set.
       * @return This builder for chaining.
       */
      public Builder setData(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes data = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearData() {
        
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }

      private Object playload_ = "";
      /**
       * <code>string playload = 3;</code>
       * @return The playload.
       */
      public String getPlayload() {
        Object ref = playload_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          playload_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string playload = 3;</code>
       * @return The bytes for playload.
       */
      public com.google.protobuf.ByteString
          getPlayloadBytes() {
        Object ref = playload_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          playload_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string playload = 3;</code>
       * @param value The playload to set.
       * @return This builder for chaining.
       */
      public Builder setPlayload(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        playload_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string playload = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearPlayload() {
        
        playload_ = getDefaultInstance().getPlayload();
        onChanged();
        return this;
      }
      /**
       * <code>string playload = 3;</code>
       * @param value The bytes for playload to set.
       * @return This builder for chaining.
       */
      public Builder setPlayloadBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        playload_ = value;
        onChanged();
        return this;
      }
      @Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:com.inzahgi.game.entity.ControlData)
    }

    // @@protoc_insertion_point(class_scope:com.inzahgi.game.entity.ControlData)
    private static final ControlData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ControlData();
    }

    public static ControlData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ControlData>
        PARSER = new com.google.protobuf.AbstractParser<ControlData>() {
      @Override
      public ControlData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ControlData(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ControlData> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<ControlData> getParserForType() {
      return PARSER;
    }

    @Override
    public ControlData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_inzahgi_game_entity_ControlData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_inzahgi_game_entity_ControlData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\027ControlDataProtoc.proto\022\027com.inzahgi.g" +
      "ame.entity\"?\n\013ControlData\022\020\n\010msg_code\030\001 " +
      "\001(\005\022\014\n\004data\030\002 \001(\014\022\020\n\010playload\030\003 \001(\tB,\n\027c" +
      "om.inzahgi.game.entityB\021ControlDataProto" +
      "cb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_inzahgi_game_entity_ControlData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_inzahgi_game_entity_ControlData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_inzahgi_game_entity_ControlData_descriptor,
        new String[] { "MsgCode", "Data", "Playload", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
