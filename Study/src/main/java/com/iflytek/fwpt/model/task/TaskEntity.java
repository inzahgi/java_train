package com.iflytek.fwpt.model.task;




import com.iflytek.fwpt.model.area.AreaEntity;
import com.iflytek.fwpt.model.person.PersonVo;
import com.iflytek.fwpt.model.rule.vo.WarningRuleVo;

import java.util.List;


public class TaskEntity
{
    private String id;

    private String type;

    private String typeName;

    private String oldType;

    private List<String> types;

    private String name;

    private String startTime;

    private String endTime;

    private String status;

    private String statusName;

    private String ruleId;

    private String createUser;

    private String createTime;

    private String areaIds;

    private String filePath;

    private String fileName;

    private String personIds;

    private List<PersonVo> persons;

    private List<AreaEntity> areas;

    private List<WarningRuleVo> rules;

    private Integer warningCount = 0;
    
    //added by xinguo in 20180608
    /**
     * 所有历史预警消息<br>
     */
    private int allRecordNum;
    
    /**
     * 当日预警消息<br>
     */
    private int todayRecordNum;
    
    /**
     * 任务监控总人数<br>
     */
    private int totalPerson;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getRuleId()
    {
        return ruleId;
    }

    public void setRuleId(String ruleId)
    {
        this.ruleId = ruleId;
    }

    public String getCreateUser()
    {
        return createUser;
    }

    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getAreaIds()
    {
        return areaIds;
    }

    public void setAreaIds(String areaIds)
    {
        this.areaIds = areaIds;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getPersonIds()
    {
        return personIds;
    }

    public void setPersonIds(String personIds)
    {
        this.personIds = personIds;
    }

    public List<String> getTypes()
    {
        return types;
    }

    public void setTypes(List<String> types)
    {
        this.types = types;
    }

    public String getOldType()
    {
        return oldType;
    }

    public void setOldType(String oldType)
    {
        this.oldType = oldType;
    }

    public List<PersonVo> getPersons()
    {
        return persons;
    }

    public void setPersons(List<PersonVo> persons)
    {
        this.persons = persons;
    }

    public List<AreaEntity> getAreas()
    {
        return areas;
    }

    public void setAreas(List<AreaEntity> areas)
    {
        this.areas = areas;
    }

    public List<WarningRuleVo> getRules()
    {
        return rules;
    }

    public void setRules(List<WarningRuleVo> rules)
    {
        this.rules = rules;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public Integer getWarningCount()
    {
        return warningCount;
    }

    public void setWarningCount(Integer warningCount)
    {
        this.warningCount = warningCount;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public String getStatusName()
    {
        return statusName;
    }

    public void setStatusName(String statusName)
    {
        this.statusName = statusName;
    }

    public int getAllRecordNum()
    {
        return allRecordNum;
    }

    public void setAllRecordNum(int allRecordNum)
    {
        this.allRecordNum = allRecordNum;
    }

    public int getTodayRecordNum()
    {
        return todayRecordNum;
    }

    public void setTodayRecordNum(int todayRecordNum)
    {
        this.todayRecordNum = todayRecordNum;
    }

    public int getTotalPerson()
    {
        return totalPerson;
    }

    public void setTotalPerson(int totalPerson)
    {
        this.totalPerson = totalPerson;
    }

}
