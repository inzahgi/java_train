package com.iflytek.fwpt.model.taskShow.vo;

import java.util.List;

public class WarningMessageVo {

	private List<PersonVo> persons;

	private String ruleInfo;

	private String status;

	private String day;

	private String time;

	private String id;

	private String taskType;

	private String dateLong;

	public List<PersonVo> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonVo> persons) {
		this.persons = persons;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getDateLong() {
		return dateLong;
	}

	public void setDateLong(String dateLong) {
		this.dateLong = dateLong;
	}

	public String getRuleInfo() {
		return ruleInfo;
	}

	public void setRuleInfo(String ruleInfo) {
		this.ruleInfo = ruleInfo;
	}

}
