package com.housemgt.service.setparam.impl;

import com.github.pagehelper.PageHelper;
import com.housemgt.mapper.CreditHandymanRuleMapper;
import com.housemgt.model.CreditHandyManRule;
import com.housemgt.service.setparam.CreditHandymanRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditHandymanRuleServiceImpl implements CreditHandymanRuleService {

    @Autowired
    private CreditHandymanRuleMapper creditHandymanRuleMapper;

    @Override
    public int insertSelective(CreditHandyManRule record) {
        if (record == null){
            return 0;
        }
        return creditHandymanRuleMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer areaRuleId) {
        if (areaRuleId < 1){
            return 0;
        }
        return creditHandymanRuleMapper.deleteByPrimaryKey(areaRuleId);
    }

    @Override
    public int updateByPrimaryKeySelective(CreditHandyManRule record) {
        if (record == null){
            return 0;
        }
        return creditHandymanRuleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int countBySerealId(Integer serealId) {
        if (serealId < 1){
            return 0;
        }
        return creditHandymanRuleMapper.countBySerealId(serealId);
    }

    @Override
    public List<CreditHandyManRule> selectBySerealId(Integer serealId, Integer pageNumber, Integer pageSize) {
        if(serealId == 0){
            return null;
        }
        PageHelper.startPage(pageNumber, pageSize);
        return creditHandymanRuleMapper.selectBySerealId(serealId);
    }
}
