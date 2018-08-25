/*
 * 文件名：SysDict.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年4月26日
 */

package com.iflytek.fwpt.model.sys;

/**
 * 系统配置DAO
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年4月26日
 */
public class SysDict
{

    /**
     * 主键id<br>
     */
    private String id;
    
    /**
     * 字典类型编码<br>
     */
    private String dictTypeCode;
    
    /**
     * 字典类型名称<br>
     */
    private String dictTypeName;
    
    /**
     * 字典编码值<br>
     */
    private String dictCode;
    
    /**
     * 字典名称<br>
     */
    private String dictName;
    
    /**
     * 字典序号<br>
     */
    private String sort;
    
    /**
     * 备注信息<br>
     */
    private String remark;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDictTypeCode()
    {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode)
    {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictTypeName()
    {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName)
    {
        this.dictTypeName = dictTypeName;
    }

    public String getDictCode()
    {
        return dictCode;
    }

    public void setDictCode(String dictCode)
    {
        this.dictCode = dictCode;
    }

    public String getDictName()
    {
        return dictName;
    }

    public void setDictName(String dictName)
    {
        this.dictName = dictName;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
