package com.iflytek.fwpt.model.taskShow.vo;


import java.util.List;


public class WarningMessagePageVo
{

    private Long totalSize;

    private List<List<WarningMessageVo>> data;

    private Integer readSize;

    private Integer unReadSize;

    private Integer titalMessageSize;

    public Long getTotalSize()
    {
        return totalSize;
    }

    public void setTotalSize(Long totalSize)
    {
        this.totalSize = totalSize;
    }

    public List<List<WarningMessageVo>> getData()
    {
        return data;
    }

    public void setData(List<List<WarningMessageVo>> data)
    {
        this.data = data;
    }

    public Integer getReadSize()
    {
        return readSize;
    }

    public void setReadSize(Integer readSize)
    {
        this.readSize = readSize;
    }

    public Integer getUnReadSize()
    {
        return unReadSize;
    }

    public void setUnReadSize(Integer unReadSize)
    {
        this.unReadSize = unReadSize;
    }

    public Integer getTitalMessageSize()
    {
        return titalMessageSize;
    }

    public void setTitalMessageSize(Integer titalMessageSize)
    {
        this.titalMessageSize = titalMessageSize;
    }

}
