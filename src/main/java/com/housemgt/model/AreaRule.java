package com.housemgt.model;

public class AreaRule {
    private Integer areaRuleId;

    private Integer serealId;

    private String levelName;

    private String levelPeople;

    private String levelGrade;

    private Integer levelPeopleId;

    public Integer getAreaRuleId() {
        return areaRuleId;
    }

    public void setAreaRuleId(Integer areaRuleId) {
        this.areaRuleId = areaRuleId;
    }

    public Integer getSerealId() {
        return serealId;
    }

    public void setSerealId(Integer serealId) {
        this.serealId = serealId;
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

    public String getLevelGrade() {
        return levelGrade;
    }

    public void setLevelGrade(String levelGrade) {
        this.levelGrade = levelGrade == null ? null : levelGrade.trim();
    }

    public Integer getLevelPeopleId() {
        return levelPeopleId;
    }

    public void setLevelPeopleId(Integer levelPeopleId) {
        this.levelPeopleId = levelPeopleId;
    }
}