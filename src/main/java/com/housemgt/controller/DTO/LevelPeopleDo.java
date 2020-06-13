package com.housemgt.controller.DTO;

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
