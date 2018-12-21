/*
 * 文件名：FastDFSFile.java
 * 版权：Copyright by www.iflytek.com
 * 描述：
 * 修改人：admin
 * 修改时间：2018年4月27日
 */

package com.iflytek.fwpt.model.sys;

/**
 * 文件辅助类
 * 〈功能详细描述〉
 * @author xinguo@iflytek.com
 * @version 2018年4月27日
 */
public class FastDFSFile
{
    public FastDFSFile(String fileName, byte[] file_buff, String ext)
    {
        this.setName(fileName);
        this.setContent(file_buff);
        this.setExt(ext);
    }

    private String name;

    private byte[] content;

    private String ext;

    private String md5;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public byte[] getContent()
    {
        return content;
    }

    public void setContent(byte[] content)
    {
        this.content = content;
    }

    public String getExt()
    {
        return ext;
    }

    public void setExt(String ext)
    {
        this.ext = ext;
    }

    public String getMd5()
    {
        return md5;
    }

    public void setMd5(String md5)
    {
        this.md5 = md5;
    }

}
