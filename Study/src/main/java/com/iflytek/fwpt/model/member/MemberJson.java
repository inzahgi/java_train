package com.iflytek.fwpt.model.member;

public class MemberJson {

	// accountInfo.put("accountType", "3434");
	// accountInfo.put("account", "12");
	// accountInfo.put("time", "455454");
	// accountInfo.put("location", "3434");
	// accountInfo.put("area", "");
	// accountInfo.put("lon", "");
	// accountInfo.put("lat", tempMemberXml.getLat());
	// accountInfo.put("centLon", returnResultObj.getLocationObj().getLon());
	// accountInfo.put("centLat", returnResultObj.getLocationObj().getLat());
	// accountInfo.put("gatherradius", returnResultObj.getGatherradius());

	private String accountType;

	private String account;

	private String name;

	private String time;

	private String location;

	private String area;

	private String lon;

	private String lat;

	private String centLon;

	private String centLat;

	private String gatherradius;

	private String gathertime;

	private String action;

	private String areaCode;

	private String areaId;

	private String receiver;

	private String event;

	private String groupName;

	private String idCard;

	/**
	 * 旧imsi<br>
	 */
	private String oldimsi;

	/**
	 * 旧imei<br>
	 */
	private String oldimei;

	/**
	 * 旧msisdn<br>
	 */
	private String oldmsisdn;

	/**
	 * 新imsi<br>
	 */
	private String newimsi;

	/**
	 * 新imei<br>
	 */
	private String newimei;

	/**
	 * 新msisdn<br>
	 */
	private String newmsisdn;

	private String address;

	private String areaName;

	private String startTime;

	private String endTime;

	private String isShowResult;

	private String minute;

	private String hour;

	private String city;

	private String alarmType;

	private String receiverName;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getCentLon() {
		return centLon;
	}

	public void setCentLon(String centLon) {
		this.centLon = centLon;
	}

	public String getCentLat() {
		return centLat;
	}

	public void setCentLat(String centLat) {
		this.centLat = centLat;
	}

	public String getGatherradius() {
		return gatherradius;
	}

	public void setGatherradius(String gatherradius) {
		this.gatherradius = gatherradius;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getOldimsi() {
		return oldimsi;
	}

	public void setOldimsi(String oldimsi) {
		this.oldimsi = oldimsi;
	}

	public String getOldimei() {
		return oldimei;
	}

	public void setOldimei(String oldimei) {
		this.oldimei = oldimei;
	}

	public String getOldmsisdn() {
		return oldmsisdn;
	}

	public void setOldmsisdn(String oldmsisdn) {
		this.oldmsisdn = oldmsisdn;
	}

	public String getNewimsi() {
		return newimsi;
	}

	public void setNewimsi(String newimsi) {
		this.newimsi = newimsi;
	}

	public String getNewimei() {
		return newimei;
	}

	public void setNewimei(String newimei) {
		this.newimei = newimei;
	}

	public String getNewmsisdn() {
		return newmsisdn;
	}

	public void setNewmsisdn(String newmsisdn) {
		this.newmsisdn = newmsisdn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getGathertime() {
		return gathertime;
	}

	public void setGathertime(String gathertime) {
		this.gathertime = gathertime;
	}

	public String getIsShowResult() {
		return isShowResult;
	}

	public void setIsShowResult(String isShowResult) {
		this.isShowResult = isShowResult;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

}
