package com.example.study.model.rule;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "core_location")
public class StationListXml implements Serializable
{


    @XmlElement(name = "location")
    private List<StationXml> locations;

    public List<StationXml> getLocations()
    {
        return locations;
    }

    public void setLocations(List<StationXml> locations)
    {
        this.locations = locations;
    }

}
