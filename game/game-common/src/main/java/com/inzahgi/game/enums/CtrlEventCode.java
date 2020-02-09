package com.inzahgi.game.enums;

public enum  CtrlEventCode {
    // RESP 表示服务端发送给客户端 客户端处理
    // REQ  表示客户端发送给服务端 服务端处理

    //客户端首次连接 服务端返回连接成功信息

    CTRL_CONNECT_RESP(1,"客户端连接成功"),
    //客户端请求登录
    CTRL_LOGIN_REQ(2,"客户端请求登录"),
    //客户端登录成功 服务端返回用户状态
    CTRL_LOGIN_RESP(3,"服务端返回登录状态"),
    //客户端登录失败
    //CTRL_LOGIN_FAIL_RESP(4, "客户端登录失败"),
    //客户端选择游戏类型
    CTRL_SELECT_GAME_REQ(5, "客户端选择游戏类型"),
    //服务端返回游戏信息(房间情况)
    CTRL_SHOW_GAME_HALL_RESP(6, "服务端返回游戏信息(房间情况)"),
    //客户端选择房间(包括自己创建)
    CTRL_SELECT_ROOM_REQ(7, "客户端选择房间(包括自己创建)"),
    //服务端返回客户端的房间信息
    CTRL_JOIN_ROOM_RESP(8, "服务端返回客户端的房间信息"),
    //客户端退出房间
    CTRL_EXIT_ROOM_REQ(9, "退出房间"),
    //客户端退出游戏
    CTRL_EXIT_GAME_REQ(10, "推出游戏"),
    //服务端发送开始游戏
    CTRL_START_GAME_RESP(11, "开始游戏"),
    //客户端掉线，服务端自动托管
    CTRL_USER_LOGOUT_RESP(12,""),
    //客户端超时，服务端托管
    CTRL_USER_TIME_OUT_RESP(13,""),
    //服务端发送游戏结束
    CTRL_GAME_OVER_RESP(14, ""),
    //服务端返回客户端无效指令
    CTRL_INVAILD_CMD_RESP(100, "服务端返回客户端无效指令")
    ;


    private int code;

    private String msg;

    CtrlEventCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CtrlEventCode getByCode(int code){
        for( CtrlEventCode c : CtrlEventCode.values()){
            if(c.getCode() == code){
                return c;
            }
        }
        return null;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
