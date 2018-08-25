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
public class GKMBTLAreaListXml implements Serializable
{

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "area")
    private List<GKMBTLAreaXml> areas;

    public List<GKMBTLAreaXml> getAreas()
    {
        return areas;
    }

    public void setAreas(List<GKMBTLAreaXml> areas)
    {
        this.areas = areas;
    }

}
