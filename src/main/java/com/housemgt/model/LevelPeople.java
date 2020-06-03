package com.housemgt.model;

public class LevelPeople {
    private Integer levelPeopleId;

    private Integer serealId;

    private String serealName;

    private String levelName;

    private String levelPeople;

    private Integer bizType;

    public Integer getLevelPeopleId() {
        return levelPeopleId;
    }

    public void setLevelPeopleId(Integer levelPeopleId) {
        this.levelPeopleId = levelPeopleId;
    }

    public Integer getSerealId() {
        return serealId;
    }

    public void setSerealId(Integer serealId) {
        this.serealId = serealId;
    }

    public String getSerealName() {
        return serealName;
    }

    public void setSerealName(String serealName) {
        this.serealName = serealName == null ? null : serealName.trim();
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    public String getLevelPeople() {
        return levelPeople;
    }

    public void setLevelPeople(String levelPeople) {
        this.levelPeople = levelPeople == null ? null : levelPeople.trim();
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }
}