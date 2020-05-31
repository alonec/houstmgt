package com.housemgt.model;

public class LevelPeople {
    private Integer levelPeopleId;

    private String levelName;

    private String levelPeople;

    public Integer getLevelPeopleId() {
        return levelPeopleId;
    }

    public void setLevelPeopleId(Integer levelPeopleId) {
        this.levelPeopleId = levelPeopleId;
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
}