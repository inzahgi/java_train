package com.inzahgi.game.entity;

import com.inzahgi.game.enums.ClientStatus;
import com.inzahgi.game.enums.ClientType;
import io.netty.channel.Channel;

public class Client {

	private int id;// from channel id

	private int roomId;

	private String nickname;

	private ClientStatus status;

	private ClientType clientType;

	private transient Channel channel;

	public Client() {}

	public Client(int id, ClientStatus status, Channel channel) {
		this.id = id;
		this.status = status;
		this.channel = channel;
	}
	
	public void init() {
		roomId = 0;
		status = ClientStatus.TO_CHOOSE;
	}

	public final String getNickname() {
		return nickname;
	}

	public final void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public final Channel getChannel() {
		return channel;
	}

	public final void setChannel(Channel channel) {
		this.channel = channel;
	}

	public final int getRoomId() {
		return roomId;
	}

	public final void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public final ClientStatus getStatus() {
		return status;
	}

	public final void setStatus(ClientStatus status) {
		this.status = status;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
