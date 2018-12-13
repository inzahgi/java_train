package com.iflytek.fwpt.model.rule.header;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "task")
public class TaskXml implements Serializable
{

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "tasktype")
    private String taskType;

    @XmlElement(name = "taskid", required = true)
    private String taskId;

    @XmlElement(name = "host")
    private String host;

	// @XmlElement(name = "communication")
	// private CommunicationXml communication;

    public String getTaskType()
    {
        return taskType;
    }

    public void setTaskType(String taskType)
    {
        this.taskType = taskType;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

	// public CommunicationXml getCommunication()
	// {
	// return communication;
	// }
	//
	// public void setCommunication(CommunicationXml communication)
	// {
	// this.communication = communication;
	// }

}
