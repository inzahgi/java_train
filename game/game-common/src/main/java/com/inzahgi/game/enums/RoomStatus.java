package com.inzahgi.game.enums;

public enum RoomStatus{

	//initial room
	BLANK("空闲"),
	// have player
	WAIT("等待"),
	//
	STARTING("等开始"),

	PLAY("等开始"),


	;
	
	private String msg;

	private RoomStatus(String msg) {
		this.msg = msg;
	}

	public final String getMsg() {
		return msg;
	}

	public final void setMsg(String msg) {
		this.msg = msg;
	}
	
}
