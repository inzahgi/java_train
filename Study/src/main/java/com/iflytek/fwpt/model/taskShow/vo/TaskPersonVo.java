package com.iflytek.fwpt.model.taskShow.vo;


import java.util.List;


public class TaskPersonVo
{

    private List<List<double[]>> areas;

    private List<PersonVo> persons;

    public List<PersonVo> getPersons()
    {
        return persons;
    }

    public void setPersons(List<PersonVo> persons)
    {
        this.persons = persons;
    }

    public List<List<double[]>> getAreas()
    {
        return areas;
    }

    public void setAreas(List<List<double[]>> areas)
    {
        this.areas = areas;
    }

}
