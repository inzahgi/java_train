package com.example.study.guava;

public class Employee {
    private String name;

    private String dept;

    private String id;

    public Employee() {
    }

    public Employee(String name, String dept, String id) {
        this.name = name;
        this.dept = dept;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
