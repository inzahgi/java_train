package com.example.study.model.rule;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "members")
public class MemberListXml implements Serializable
{

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */

    private static final long serialVersionUID = 1L;

    /**
     * 条件表达式
     */
    @XmlElement(name = "member")
    private List<MemberXml> members;

    public List<MemberXml> getMembers()
    {
        return members;
    }

    public void setMembers(List<MemberXml> members)
    {
        this.members = members;
    }

}
