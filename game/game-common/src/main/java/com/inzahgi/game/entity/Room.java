package com.inzahgi.game.entity;

import java.util.List;
import java.util.Map;

import com.inzahgi.game.enums.RoomStatus;
import com.inzahgi.game.enums.RoomType;

public class Room{

	private int id;
	
	private int roomOwnerId;
	
	private RoomStatus status;
	//人人 --- 人机
	private RoomType type;

	private int lastPlayIndex = -1;

	private int curPlayerIndex = -1;
	
	private List<Player> playerList;
	
	private PokerSell lastPokerShell;
	
	private long lastFlushTime;
	
	private long createTime;
	
	public Room() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomOwnerId() {
		return roomOwnerId;
	}

	public void setRoomOwnerId(int roomOwnerId) {
		this.roomOwnerId = roomOwnerId;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public int getLastPlayIndex() {
		return lastPlayIndex;
	}

	public void setLastPlayIndex(int lastPlayIndex) {
		this.lastPlayIndex = lastPlayIndex;
	}

	public int getCurPlayerIndex() {
		return curPlayerIndex;
	}

	public void setCurPlayerIndex(int curPlayerIndex) {
		this.curPlayerIndex = curPlayerIndex;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public PokerSell getLastPokerShell() {
		return lastPokerShell;
	}

	public void setLastPokerShell(PokerSell lastPokerShell) {
		this.lastPokerShell = lastPokerShell;
	}

	public long getLastFlushTime() {
		return lastFlushTime;
	}

	public void setLastFlushTime(long lastFlushTime) {
		this.lastFlushTime = lastFlushTime;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}