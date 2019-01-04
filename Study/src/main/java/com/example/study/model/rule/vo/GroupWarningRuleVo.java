package com.example.study.model.rule.vo;

/**
 * 
    * @ClassName: GroupWarningVo
    * @Description: 群体预警规则
    * @author jgwang2
    * @date 2018年5月17日
    *
 */
public class GroupWarningRuleVo
{
    /**
     * 区域聚集预警
     */
    private AreaClusteringVo areaClustering;

    /**
     * 群体失联预警
     */
    private GroupMissingVo groupMiss;

    /**
     * 聚集预警
     */
    private ClusteringWarningVo clusteringWarning;

    private String prevCode;

    private String nextCode;
    
    private String typeCode;

    private String taskName;

    public AreaClusteringVo getAreaClustering()
    {
        return areaClustering;
    }

    public void setAreaClustering(AreaClusteringVo areaClustering)
    {
        this.areaClustering = areaClustering;
    }

    public GroupMissingVo getGroupMiss()
    {
        return groupMiss;
    }

    public void setGroupMiss(GroupMissingVo groupMiss)
    {
        this.groupMiss = groupMiss;
    }

    public ClusteringWarningVo getClusteringWarning()
    {
        return clusteringWarning;
    }

    public void setClusteringWarning(ClusteringWarningVo clusteringWarning)
    {
        this.clusteringWarning = clusteringWarning;
    }

    public String getPrevCode()
    {
        return prevCode;
    }

    public void setPrevCode(String prevCode)
    {
        this.prevCode = prevCode;
    }

    public String getNextCode()
    {
        return nextCode;
    }

    public void setNextCode(String nextCode)
    {
        this.nextCode = nextCode;
    }

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String typeCode)
    {
        this.typeCode = typeCode;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    
}
