package com.iflytek.fwpt.model.rule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "area")
public class EAreaXml implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "areaid")
	private String areaId;

	@XmlElement(name = "core_locations")
	private StationListXml coreLocations;

	// @XmlElement(name = "buffer_locations")
	// private StationListXml bufferLocations;

	@XmlElement(name = "buffer_border")
	private BorderXml bufferBorder;

	@XmlElement(name = "corer_border")
	private BorderXml coreBorder;

	public StationListXml getCoreLocations() {
		return coreLocations;
	}

	public void setCoreLocations(StationListXml coreLocations) {
		this.coreLocations = coreLocations;
	}

	public BorderXml getBufferBorder() {
		return bufferBorder;
	}

	public void setBufferBorder(BorderXml bufferBorder) {
		this.bufferBorder = bufferBorder;
	}

	public BorderXml getCoreBorder() {
		return coreBorder;
	}

	public void setCoreBorder(BorderXml coreBorder) {
		this.coreBorder = coreBorder;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

}
