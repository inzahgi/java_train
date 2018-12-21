package com.iflytek.fwpt.model.rule.vo;

public class LeftCityVo extends BaseVo {
	private String areaCode;

	private String exceptionCode;

	private String repeatWarningTime = "0";

	private Integer isLeft;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getRepeatWarningTime() {
		return repeatWarningTime;
	}

	public void setRepeatWarningTime(String repeatWarningTime) {
		this.repeatWarningTime = repeatWarningTime;
	}

	public Integer getIsLeft() {
		return isLeft;
	}

	public void setIsLeft(Integer isLeft) {
		this.isLeft = isLeft;
	}

}
