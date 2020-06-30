package com.housemgt.dto;

import com.housemgt.model.LevelPeople;

public class LevelPeopleDo extends LevelPeople {
    private String bizName;

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }
}
