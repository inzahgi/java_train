/*
 * 文件名：ZDYResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

/**
 * 自定义预警结果表
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class ZDYResultVo extends BaseResultVo
{

    /**
     * 唯一标识符<br>
     */
    private String id;
    
    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private String destfrontendname;
    
    /**
     * 表名<br>
     */
    private String tbName;
    
    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private String category;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getDestfrontendname()
    {
        return destfrontendname;
    }

    public void setDestfrontendname(String destfrontendname)
    {
        this.destfrontendname = destfrontendname;
    }

    public String getTbName()
    {
        return tbName;
    }

    public void setTbName(String tbName)
    {
        this.tbName = tbName;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }
}
