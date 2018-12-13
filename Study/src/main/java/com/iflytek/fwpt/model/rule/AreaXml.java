package com.iflytek.fwpt.model.rule;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "area")
public class AreaXml implements Serializable
{

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "areaid")
    private String areaId;

    @XmlElement(name = "locations")
    private StationListXml locations;

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public StationListXml getLocations()
    {
        return locations;
    }

    public void setLocations(StationListXml locations)
    {
        this.locations = locations;
    }

}
