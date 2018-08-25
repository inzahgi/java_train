package com.iflytek.fwpt.model.person;


import java.util.List;


public class PersonList
{
    private String id;

    private List<PersonEntity> list;

    private String phone;

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public List<PersonEntity> getList()
    {
        return list;
    }

    public void setList(List<PersonEntity> list)
    {
        this.list = list;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}
