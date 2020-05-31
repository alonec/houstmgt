package com.housemgt.model;

public class MetaData {
    private Integer serealId;

    private String bizName;

    private String bizType;

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

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getSerealName() {
        return serealName;
    }

    public void setSerealName(String serealName) {
        this.serealName = serealName == null ? null : serealName.trim();
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "serealId=" + serealId +
                ", bizName='" + bizName + '\'' +
                ", bizType='" + bizType + '\'' +
                ", serealName='" + serealName + '\'' +
                '}';
    }
}