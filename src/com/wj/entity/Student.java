package com.wj.entity;

public class Student {
    private int stuno;
    private  String stuname;
    private  int stuage;
    private String gradename;
    private StudentCard studentCard;


    public Student() {
    }

    public Student(int stuno, String stuname, int stuage, String gradename) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
        this.gradename = gradename;
    }

    public int getStuno() {
        return stuno;
    }

    public void setStuno(int stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    @Override
    public String toString() {
        return "stuno=" + stuno +
                ", stuname=" + stuname  +
                ", stuage=" + stuage +
                ", gradename=" + gradename ;
    }
}
