package com.example.study.model.rule;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "border")
public class BorderXml implements Serializable
{

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "coord")
    private List<CoordXml> coords;

    public List<CoordXml> getCoords()
    {
        return coords;
    }

    public void setCoords(List<CoordXml> coords)
    {
        this.coords = coords;
    }

}
