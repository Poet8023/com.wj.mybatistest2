package com.wj.entity;

import java.io.Serializable;

public class StudentCard implements Serializable {
    private  int stucardId;
    private String stucardInfo;

    public int getStucardId() {
        return stucardId;
    }

    public void setStucardId(int stucardId) {
        this.stucardId = stucardId;
    }

    public String getStucardInfo() {
        return stucardInfo;
    }

    public void setStucardInfo(String stucardInfo) {
        this.stucardInfo = stucardInfo;
    }
}
