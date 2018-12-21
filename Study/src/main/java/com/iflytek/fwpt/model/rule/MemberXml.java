package com.iflytek.fwpt.model.rule;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "member")
public class MemberXml implements Serializable
{

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */

    private static final long serialVersionUID = 1L;

    /**
     * 条件表达式
     */
    @XmlElement(name = "info")
    private String info;

    @XmlElement(name = "accounttype")
    private String accountType;

    @XmlElement(name = "account")
    private String account;

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

}
