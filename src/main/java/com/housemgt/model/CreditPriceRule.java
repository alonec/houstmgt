package com.housemgt.model;

public class CreditPriceRule {
    private Integer id;

    private Integer serealId;

    private String baseGrade;

    private String specialPriceGrade;

    private String firstPriceGrade;

    private String secondPriceGrade;

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

    public String getSpecialPriceGrade() {
        return specialPriceGrade;
    }

    public void setSpecialPriceGrade(String specialPriceGrade) {
        this.specialPriceGrade = specialPriceGrade == null ? null : specialPriceGrade.trim();
    }

    public String getFirstPriceGrade() {
        return firstPriceGrade;
    }

    public void setFirstPriceGrade(String firstPriceGrade) {
        this.firstPriceGrade = firstPriceGrade == null ? null : firstPriceGrade.trim();
    }

    public String getSecondPriceGrade() {
        return secondPriceGrade;
    }

    public void setSecondPriceGrade(String secondPriceGrade) {
        this.secondPriceGrade = secondPriceGrade == null ? null : secondPriceGrade.trim();
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