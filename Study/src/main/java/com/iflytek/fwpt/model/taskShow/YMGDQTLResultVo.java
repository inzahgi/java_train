/*
 * 文件名：YMGDQTLResultVo.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年6月2日
 */

package com.iflytek.fwpt.model.taskShow;

/**
 * 与敏感地区通联预警结果表
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年6月2日
 */
public class YMGDQTLResultVo extends BaseResultVo
{
    
    /**
     * 唯一标识符<br>
     */
    private String id;

    /**
     * 联系区号<br>
     */
    private String relateHome;
    
    /**
     * 联系账号<br>
     */
    private String relateAccount;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getRelateHome()
    {
        return relateHome;
    }

    public void setRelateHome(String relateHome)
    {
        this.relateHome = relateHome;
    }

    public String getRelateAccount()
    {
        return relateAccount;
    }

    public void setRelateAccount(String relateAccount)
    {
        this.relateAccount = relateAccount;
    }
}
