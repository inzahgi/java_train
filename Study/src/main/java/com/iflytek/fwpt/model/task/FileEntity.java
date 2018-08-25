package com.iflytek.fwpt.model.task;

public class FileEntity
{
    private String filePath;

    private String taskId;

    private String fileName;

    /**
     * 0表示的是新增预警时上传的文件，1表示的是修改的时候修改
     */
    private String type;

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

}
