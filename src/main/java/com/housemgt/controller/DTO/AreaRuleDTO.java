package com.housemgt.controller.DTO;

import com.housemgt.model.AreaRule;
import com.housemgt.model.MetaData;

import java.util.List;

public class AreaRuleDTO {

    private List<MetaData> metaData;

    private List<AreaRule> data;

    public List<MetaData> getMetaData() {
        return metaData;
    }

    public void setMetaData(List<MetaData> metaData) {
        this.metaData = metaData;
    }

    public List<AreaRule> getData() {
        return data;
    }

    public void setData(List<AreaRule> data) {
        this.data = data;
    }
}
