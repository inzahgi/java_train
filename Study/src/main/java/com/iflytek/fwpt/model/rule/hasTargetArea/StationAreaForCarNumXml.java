package com.iflytek.fwpt.model.rule.hasTargetArea;

import com.iflytek.fwpt.model.rule.BorderXml;
import com.iflytek.fwpt.model.rule.StationListXml;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "area")
public class StationAreaForCarNumXml implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "areaid")
	private String areaId;

	@XmlElement(name = "core_locations")
	private StationListXml coreLocation;

	@XmlElement(name = "buffer_locations")
	private StationListXml bufferLocation;

	@XmlElement(name = "corer_border")
	private BorderXml coreBorder;

	@XmlElement(name = "buffer_border")
	private BorderXml bufferBorder;

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public StationListXml getCoreLocation() {
		return coreLocation;
	}

	public void setCoreLocation(StationListXml coreLocation) {
		this.coreLocation = coreLocation;
	}

	public StationListXml getBufferLocation() {
		return bufferLocation;
	}

	public void setBufferLocation(StationListXml bufferLocation) {
		this.bufferLocation = bufferLocation;
	}

	public BorderXml getCoreBorder() {
		return coreBorder;
	}

	public void setCoreBorder(BorderXml coreBorder) {
		this.coreBorder = coreBorder;
	}

	public BorderXml getBufferBorder() {
		return bufferBorder;
	}

	public void setBufferBorder(BorderXml bufferBorder) {
		this.bufferBorder = bufferBorder;
	}
}
