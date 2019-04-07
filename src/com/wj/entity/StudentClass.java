package com.wj.entity;

import java.util.List;

public class StudentClass {
    private  int classId;
    private String className;
    private List<Student> students;

    public int getclassId() {
        return classId;
    }

    public void setclassId(int classId) {
        this.classId = classId;
    }

    public String getclassName() {
        return className;
    }

    public void setclassName(String className) {
        this.className = className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
