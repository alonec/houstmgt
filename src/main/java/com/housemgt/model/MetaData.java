package com.housemgt.model;

public class MetaData {
    private Integer serealId;

    private String bizName;

    private Integer bizType;

    private String serealName;

    public Integer getSerealId() {
        return serealId;
    }

    public void setSerealId(Integer serealId) {
        this.serealId = serealId;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName == null ? null : bizName.trim();
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public String getSerealName() {
        return serealName;
    }

    public void setSerealName(String serealName) {
        this.serealName = serealName == null ? null : serealName.trim();
    }

}