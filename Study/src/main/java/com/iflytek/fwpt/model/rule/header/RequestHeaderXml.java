package com.iflytek.fwpt.model.rule.header;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "request")
public class RequestHeaderXml implements Serializable
{

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "business")
    private String business = "realTimeWarnning";

    @XmlElement(name = "requesttype")
    private String requestType = "command";

    @XmlElement(name = "source")
    private String source;

    @XmlElement(name = "task")
    private TaskXml task;

	// @XmlElement(name = "sharehosts")
	// private String sharehosts;

    public String getBusiness()
    {
        return business;
    }

    public void setBusiness(String business)
    {
        this.business = business;
    }

    public String getRequestType()
    {
        return requestType;
    }

    public void setRequestType(String requestType)
    {
        this.requestType = requestType;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }


    public TaskXml getTask()
    {
        return task;
    }

    public void setTask(TaskXml task)
    {
        this.task = task;
    }

	// public String getSharehosts()
	// {
	// return sharehosts;
	// }
	//
	// public void setSharehosts(String sharehosts)
	// {
	// this.sharehosts = sharehosts;
	// }

}
