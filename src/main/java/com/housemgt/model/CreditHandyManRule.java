package com.housemgt.model;

public class CreditHandyManRule {
    private Integer id;

    private Integer serealId;

    private String baseGrade;

    private String grade;

    private String levelPeople;

    private Integer levelPeopleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerealId() {
        return serealId;
    }

    public void setSerealId(Integer serealId) {
        this.serealId = serealId;
    }

    public String getBaseGrade() {
        return baseGrade;
    }

    public void setBaseGrade(String baseGrade) {
        this.baseGrade = baseGrade == null ? null : baseGrade.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getLevelPeople() {
        return levelPeople;
    }

    public void setLevelPeople(String levelPeople) {
        this.levelPeople = levelPeople == null ? null : levelPeople.trim();
    }

    public Integer getLevelPeopleId() {
        return levelPeopleId;
    }

    public void setLevelPeopleId(Integer levelPeopleId) {
        this.levelPeopleId = levelPeopleId;
    }
}