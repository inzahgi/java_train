package com.iflytek.fwpt.model.rule;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "location")
public class StationXml implements Serializable
{

    @XmlElement(name = "net")
    private String net;

    @XmlElement(name = "type")
    private String type;

    @XmlElement(name = "value")
    private String value;

    public String getNet()
    {
        return net;
    }

    public void setNet(String net)
    {
        this.net = net;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
