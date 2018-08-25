package com.iflytek.fwpt.model.rule;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "arealist")
public class EnterAreaListXml implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "area")
	private List<EAreaXml> areas;

	public List<EAreaXml> getAreas() {
		return areas;
	}

	public void setAreas(List<EAreaXml> areas) {
		this.areas = areas;
	}

}
