// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DataProtoc.proto

package com.inzahgi.game.entity;

public final class DataProtoc {
  private DataProtoc() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface DataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.inzahgi.game.entity.Data)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint64 msg_id = 1;</code>
     * @return The msgId.
     */
    long getMsgId();

    /**
     * <code>int32 msg_type = 2;</code>
     * @return The msgType.
     */
    int getMsgType();

    /**
     * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
     * @return Whether the ctrlMsg field is set.
     */
    boolean hasCtrlMsg();
    /**
     * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
     * @return The ctrlMsg.
     */
    ControlDataProtoc.ControlData getCtrlMsg();
    /**
     * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
     */
    ControlDataProtoc.ControlDataOrBuilder getCtrlMsgOrBuilder();

    /**
     * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
     * @return Whether the gameMsg field is set.
     */
    boolean hasGameMsg();
    /**
     * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
     * @return The gameMsg.
     */
    GameDataProtoc.GameData getGameMsg();
    /**
     * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
     */
    GameDataProtoc.GameDataOrBuilder getGameMsgOrBuilder();

    /**
     * <code>string info = 10;</code>
     * @return The info.
     */
    String getInfo();
    /**
     * <code>string info = 10;</code>
     * @return The bytes for info.
     */
    com.google.protobuf.ByteString
        getInfoBytes();
  }
  /**
   * Protobuf type {@code com.inzahgi.game.entity.Data}
   */
  public  static final class Data extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.inzahgi.game.entity.Data)
      DataOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Data.newBuilder() to construct.
    private Data(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Data() {
      info_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new Data();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Data(
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

              msgId_ = input.readUInt64();
              break;
            }
            case 16: {

              msgType_ = input.readInt32();
              break;
            }
            case 26: {
              ControlDataProtoc.ControlData.Builder subBuilder = null;
              if (ctrlMsg_ != null) {
                subBuilder = ctrlMsg_.toBuilder();
              }
              ctrlMsg_ = input.readMessage(ControlDataProtoc.ControlData.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(ctrlMsg_);
                ctrlMsg_ = subBuilder.buildPartial();
              }

              break;
            }
            case 34: {
              GameDataProtoc.GameData.Builder subBuilder = null;
              if (gameMsg_ != null) {
                subBuilder = gameMsg_.toBuilder();
              }
              gameMsg_ = input.readMessage(GameDataProtoc.GameData.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(gameMsg_);
                gameMsg_ = subBuilder.buildPartial();
              }

              break;
            }
            case 82: {
              String s = input.readStringRequireUtf8();

              info_ = s;
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
      return DataProtoc.internal_static_com_inzahgi_game_entity_Data_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return DataProtoc.internal_static_com_inzahgi_game_entity_Data_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Data.class, Builder.class);
    }

    public static final int MSG_ID_FIELD_NUMBER = 1;
    private long msgId_;
    /**
     * <code>uint64 msg_id = 1;</code>
     * @return The msgId.
     */
    public long getMsgId() {
      return msgId_;
    }

    public static final int MSG_TYPE_FIELD_NUMBER = 2;
    private int msgType_;
    /**
     * <code>int32 msg_type = 2;</code>
     * @return The msgType.
     */
    public int getMsgType() {
      return msgType_;
    }

    public static final int CTRL_MSG_FIELD_NUMBER = 3;
    private ControlDataProtoc.ControlData ctrlMsg_;
    /**
     * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
     * @return Whether the ctrlMsg field is set.
     */
    public boolean hasCtrlMsg() {
      return ctrlMsg_ != null;
    }
    /**
     * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
     * @return The ctrlMsg.
     */
    public ControlDataProtoc.ControlData getCtrlMsg() {
      return ctrlMsg_ == null ? ControlDataProtoc.ControlData.getDefaultInstance() : ctrlMsg_;
    }
    /**
     * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
     */
    public ControlDataProtoc.ControlDataOrBuilder getCtrlMsgOrBuilder() {
      return getCtrlMsg();
    }

    public static final int GAME_MSG_FIELD_NUMBER = 4;
    private GameDataProtoc.GameData gameMsg_;
    /**
     * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
     * @return Whether the gameMsg field is set.
     */
    public boolean hasGameMsg() {
      return gameMsg_ != null;
    }
    /**
     * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
     * @return The gameMsg.
     */
    public GameDataProtoc.GameData getGameMsg() {
      return gameMsg_ == null ? GameDataProtoc.GameData.getDefaultInstance() : gameMsg_;
    }
    /**
     * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
     */
    public GameDataProtoc.GameDataOrBuilder getGameMsgOrBuilder() {
      return getGameMsg();
    }

    public static final int INFO_FIELD_NUMBER = 10;
    private volatile Object info_;
    /**
     * <code>string info = 10;</code>
     * @return The info.
     */
    public String getInfo() {
      Object ref = info_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        info_ = s;
        return s;
      }
    }
    /**
     * <code>string info = 10;</code>
     * @return The bytes for info.
     */
    public com.google.protobuf.ByteString
        getInfoBytes() {
      Object ref = info_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        info_ = b;
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
      if (msgId_ != 0L) {
        output.writeUInt64(1, msgId_);
      }
      if (msgType_ != 0) {
        output.writeInt32(2, msgType_);
      }
      if (ctrlMsg_ != null) {
        output.writeMessage(3, getCtrlMsg());
      }
      if (gameMsg_ != null) {
        output.writeMessage(4, getGameMsg());
      }
      if (!getInfoBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 10, info_);
      }
      unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (msgId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, msgId_);
      }
      if (msgType_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, msgType_);
      }
      if (ctrlMsg_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, getCtrlMsg());
      }
      if (gameMsg_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(4, getGameMsg());
      }
      if (!getInfoBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, info_);
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
      if (!(obj instanceof Data)) {
        return super.equals(obj);
      }
      Data other = (Data) obj;

      if (getMsgId()
          != other.getMsgId()) return false;
      if (getMsgType()
          != other.getMsgType()) return false;
      if (hasCtrlMsg() != other.hasCtrlMsg()) return false;
      if (hasCtrlMsg()) {
        if (!getCtrlMsg()
            .equals(other.getCtrlMsg())) return false;
      }
      if (hasGameMsg() != other.hasGameMsg()) return false;
      if (hasGameMsg()) {
        if (!getGameMsg()
            .equals(other.getGameMsg())) return false;
      }
      if (!getInfo()
          .equals(other.getInfo())) return false;
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
      hash = (37 * hash) + MSG_ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getMsgId());
      hash = (37 * hash) + MSG_TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMsgType();
      if (hasCtrlMsg()) {
        hash = (37 * hash) + CTRL_MSG_FIELD_NUMBER;
        hash = (53 * hash) + getCtrlMsg().hashCode();
      }
      if (hasGameMsg()) {
        hash = (37 * hash) + GAME_MSG_FIELD_NUMBER;
        hash = (53 * hash) + getGameMsg().hashCode();
      }
      hash = (37 * hash) + INFO_FIELD_NUMBER;
      hash = (53 * hash) + getInfo().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Data parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Data parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Data parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Data parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Data parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Data parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Data parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Data parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Data parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Data parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Data parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Data parseFrom(
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
    public static Builder newBuilder(Data prototype) {
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
     * Protobuf type {@code com.inzahgi.game.entity.Data}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.inzahgi.game.entity.Data)
        DataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return DataProtoc.internal_static_com_inzahgi_game_entity_Data_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return DataProtoc.internal_static_com_inzahgi_game_entity_Data_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Data.class, Builder.class);
      }

      // Construct using com.inzahgi.game.entity.DataProtoc.Data.newBuilder()
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
        msgId_ = 0L;

        msgType_ = 0;

        if (ctrlMsgBuilder_ == null) {
          ctrlMsg_ = null;
        } else {
          ctrlMsg_ = null;
          ctrlMsgBuilder_ = null;
        }
        if (gameMsgBuilder_ == null) {
          gameMsg_ = null;
        } else {
          gameMsg_ = null;
          gameMsgBuilder_ = null;
        }
        info_ = "";

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return DataProtoc.internal_static_com_inzahgi_game_entity_Data_descriptor;
      }

      @Override
      public Data getDefaultInstanceForType() {
        return Data.getDefaultInstance();
      }

      @Override
      public Data build() {
        Data result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public Data buildPartial() {
        Data result = new Data(this);
        result.msgId_ = msgId_;
        result.msgType_ = msgType_;
        if (ctrlMsgBuilder_ == null) {
          result.ctrlMsg_ = ctrlMsg_;
        } else {
          result.ctrlMsg_ = ctrlMsgBuilder_.build();
        }
        if (gameMsgBuilder_ == null) {
          result.gameMsg_ = gameMsg_;
        } else {
          result.gameMsg_ = gameMsgBuilder_.build();
        }
        result.info_ = info_;
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
        if (other instanceof Data) {
          return mergeFrom((Data)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Data other) {
        if (other == Data.getDefaultInstance()) return this;
        if (other.getMsgId() != 0L) {
          setMsgId(other.getMsgId());
        }
        if (other.getMsgType() != 0) {
          setMsgType(other.getMsgType());
        }
        if (other.hasCtrlMsg()) {
          mergeCtrlMsg(other.getCtrlMsg());
        }
        if (other.hasGameMsg()) {
          mergeGameMsg(other.getGameMsg());
        }
        if (!other.getInfo().isEmpty()) {
          info_ = other.info_;
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
        Data parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Data) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long msgId_ ;
      /**
       * <code>uint64 msg_id = 1;</code>
       * @return The msgId.
       */
      public long getMsgId() {
        return msgId_;
      }
      /**
       * <code>uint64 msg_id = 1;</code>
       * @param value The msgId to set.
       * @return This builder for chaining.
       */
      public Builder setMsgId(long value) {
        
        msgId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint64 msg_id = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMsgId() {
        
        msgId_ = 0L;
        onChanged();
        return this;
      }

      private int msgType_ ;
      /**
       * <code>int32 msg_type = 2;</code>
       * @return The msgType.
       */
      public int getMsgType() {
        return msgType_;
      }
      /**
       * <code>int32 msg_type = 2;</code>
       * @param value The msgType to set.
       * @return This builder for chaining.
       */
      public Builder setMsgType(int value) {
        
        msgType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 msg_type = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearMsgType() {
        
        msgType_ = 0;
        onChanged();
        return this;
      }

      private ControlDataProtoc.ControlData ctrlMsg_;
      private com.google.protobuf.SingleFieldBuilderV3<
          ControlDataProtoc.ControlData, ControlDataProtoc.ControlData.Builder, ControlDataProtoc.ControlDataOrBuilder> ctrlMsgBuilder_;
      /**
       * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
       * @return Whether the ctrlMsg field is set.
       */
      public boolean hasCtrlMsg() {
        return ctrlMsgBuilder_ != null || ctrlMsg_ != null;
      }
      /**
       * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
       * @return The ctrlMsg.
       */
      public ControlDataProtoc.ControlData getCtrlMsg() {
        if (ctrlMsgBuilder_ == null) {
          return ctrlMsg_ == null ? ControlDataProtoc.ControlData.getDefaultInstance() : ctrlMsg_;
        } else {
          return ctrlMsgBuilder_.getMessage();
        }
      }
      /**
       * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
       */
      public Builder setCtrlMsg(ControlDataProtoc.ControlData value) {
        if (ctrlMsgBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ctrlMsg_ = value;
          onChanged();
        } else {
          ctrlMsgBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
       */
      public Builder setCtrlMsg(
          ControlDataProtoc.ControlData.Builder builderForValue) {
        if (ctrlMsgBuilder_ == null) {
          ctrlMsg_ = builderForValue.build();
          onChanged();
        } else {
          ctrlMsgBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
       */
      public Builder mergeCtrlMsg(ControlDataProtoc.ControlData value) {
        if (ctrlMsgBuilder_ == null) {
          if (ctrlMsg_ != null) {
            ctrlMsg_ =
              ControlDataProtoc.ControlData.newBuilder(ctrlMsg_).mergeFrom(value).buildPartial();
          } else {
            ctrlMsg_ = value;
          }
          onChanged();
        } else {
          ctrlMsgBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
       */
      public Builder clearCtrlMsg() {
        if (ctrlMsgBuilder_ == null) {
          ctrlMsg_ = null;
          onChanged();
        } else {
          ctrlMsg_ = null;
          ctrlMsgBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
       */
      public ControlDataProtoc.ControlData.Builder getCtrlMsgBuilder() {
        
        onChanged();
        return getCtrlMsgFieldBuilder().getBuilder();
      }
      /**
       * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
       */
      public ControlDataProtoc.ControlDataOrBuilder getCtrlMsgOrBuilder() {
        if (ctrlMsgBuilder_ != null) {
          return ctrlMsgBuilder_.getMessageOrBuilder();
        } else {
          return ctrlMsg_ == null ?
              ControlDataProtoc.ControlData.getDefaultInstance() : ctrlMsg_;
        }
      }
      /**
       * <code>.com.inzahgi.game.entity.ControlData ctrl_msg = 3;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          ControlDataProtoc.ControlData, ControlDataProtoc.ControlData.Builder, ControlDataProtoc.ControlDataOrBuilder>
          getCtrlMsgFieldBuilder() {
        if (ctrlMsgBuilder_ == null) {
          ctrlMsgBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              ControlDataProtoc.ControlData, ControlDataProtoc.ControlData.Builder, ControlDataProtoc.ControlDataOrBuilder>(
                  getCtrlMsg(),
                  getParentForChildren(),
                  isClean());
          ctrlMsg_ = null;
        }
        return ctrlMsgBuilder_;
      }

      private GameDataProtoc.GameData gameMsg_;
      private com.google.protobuf.SingleFieldBuilderV3<
          GameDataProtoc.GameData, GameDataProtoc.GameData.Builder, GameDataProtoc.GameDataOrBuilder> gameMsgBuilder_;
      /**
       * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
       * @return Whether the gameMsg field is set.
       */
      public boolean hasGameMsg() {
        return gameMsgBuilder_ != null || gameMsg_ != null;
      }
      /**
       * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
       * @return The gameMsg.
       */
      public GameDataProtoc.GameData getGameMsg() {
        if (gameMsgBuilder_ == null) {
          return gameMsg_ == null ? GameDataProtoc.GameData.getDefaultInstance() : gameMsg_;
        } else {
          return gameMsgBuilder_.getMessage();
        }
      }
      /**
       * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
       */
      public Builder setGameMsg(GameDataProtoc.GameData value) {
        if (gameMsgBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          gameMsg_ = value;
          onChanged();
        } else {
          gameMsgBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
       */
      public Builder setGameMsg(
          GameDataProtoc.GameData.Builder builderForValue) {
        if (gameMsgBuilder_ == null) {
          gameMsg_ = builderForValue.build();
          onChanged();
        } else {
          gameMsgBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
       */
      public Builder mergeGameMsg(GameDataProtoc.GameData value) {
        if (gameMsgBuilder_ == null) {
          if (gameMsg_ != null) {
            gameMsg_ =
              GameDataProtoc.GameData.newBuilder(gameMsg_).mergeFrom(value).buildPartial();
          } else {
            gameMsg_ = value;
          }
          onChanged();
        } else {
          gameMsgBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
       */
      public Builder clearGameMsg() {
        if (gameMsgBuilder_ == null) {
          gameMsg_ = null;
          onChanged();
        } else {
          gameMsg_ = null;
          gameMsgBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
       */
      public GameDataProtoc.GameData.Builder getGameMsgBuilder() {
        
        onChanged();
        return getGameMsgFieldBuilder().getBuilder();
      }
      /**
       * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
       */
      public GameDataProtoc.GameDataOrBuilder getGameMsgOrBuilder() {
        if (gameMsgBuilder_ != null) {
          return gameMsgBuilder_.getMessageOrBuilder();
        } else {
          return gameMsg_ == null ?
              GameDataProtoc.GameData.getDefaultInstance() : gameMsg_;
        }
      }
      /**
       * <code>.com.inzahgi.game.entity.GameData game_msg = 4;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          GameDataProtoc.GameData, GameDataProtoc.GameData.Builder, GameDataProtoc.GameDataOrBuilder>
          getGameMsgFieldBuilder() {
        if (gameMsgBuilder_ == null) {
          gameMsgBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              GameDataProtoc.GameData, GameDataProtoc.GameData.Builder, GameDataProtoc.GameDataOrBuilder>(
                  getGameMsg(),
                  getParentForChildren(),
                  isClean());
          gameMsg_ = null;
        }
        return gameMsgBuilder_;
      }

      private Object info_ = "";
      /**
       * <code>string info = 10;</code>
       * @return The info.
       */
      public String getInfo() {
        Object ref = info_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          info_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string info = 10;</code>
       * @return The bytes for info.
       */
      public com.google.protobuf.ByteString
          getInfoBytes() {
        Object ref = info_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          info_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string info = 10;</code>
       * @param value The info to set.
       * @return This builder for chaining.
       */
      public Builder setInfo(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        info_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string info = 10;</code>
       * @return This builder for chaining.
       */
      public Builder clearInfo() {
        
        info_ = getDefaultInstance().getInfo();
        onChanged();
        return this;
      }
      /**
       * <code>string info = 10;</code>
       * @param value The bytes for info to set.
       * @return This builder for chaining.
       */
      public Builder setInfoBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        info_ = value;
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


      // @@protoc_insertion_point(builder_scope:com.inzahgi.game.entity.Data)
    }

    // @@protoc_insertion_point(class_scope:com.inzahgi.game.entity.Data)
    private static final Data DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Data();
    }

    public static Data getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Data>
        PARSER = new com.google.protobuf.AbstractParser<Data>() {
      @Override
      public Data parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Data(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Data> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Data> getParserForType() {
      return PARSER;
    }

    @Override
    public Data getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_inzahgi_game_entity_Data_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_inzahgi_game_entity_Data_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\020DataProtoc.proto\022\027com.inzahgi.game.ent" +
      "ity\032\024GameDataProtoc.proto\032\027ControlDataPr" +
      "otoc.proto\"\243\001\n\004Data\022\016\n\006msg_id\030\001 \001(\004\022\020\n\010m" +
      "sg_type\030\002 \001(\005\0226\n\010ctrl_msg\030\003 \001(\0132$.com.in" +
      "zahgi.game.entity.ControlData\0223\n\010game_ms" +
      "g\030\004 \001(\0132!.com.inzahgi.game.entity.GameDa" +
      "ta\022\014\n\004info\030\n \001(\tB%\n\027com.inzahgi.game.ent" +
      "ityB\nDataProtocb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          GameDataProtoc.getDescriptor(),
          ControlDataProtoc.getDescriptor(),
        });
    internal_static_com_inzahgi_game_entity_Data_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_inzahgi_game_entity_Data_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_inzahgi_game_entity_Data_descriptor,
        new String[] { "MsgId", "MsgType", "CtrlMsg", "GameMsg", "Info", });
    GameDataProtoc.getDescriptor();
    ControlDataProtoc.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
