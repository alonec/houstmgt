package com.housemgt.service.setparam.impl;

import com.github.pagehelper.PageHelper;
import com.housemgt.mapper.CreditPriceRuleMapper;
import com.housemgt.model.CreditPriceRule;
import com.housemgt.service.setparam.CreditPriceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditPriceRuleServiceImpl implements CreditPriceRuleService {

    @Autowired
    private CreditPriceRuleMapper creditPriceRuleMapper;

    @Override
    public int insertSelective(CreditPriceRule record) {
        if (record == null){
            return 0;
        }
        return creditPriceRuleMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer areaRuleId) {
        if (areaRuleId < 1){
            return 0;
        }
        return creditPriceRuleMapper.deleteByPrimaryKey(areaRuleId);
    }

    @Override
    public int updateByPrimaryKeySelective(CreditPriceRule record) {
        if (record == null){
            return 0;
        }
        return creditPriceRuleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int countBySerealId(Integer serealId) {
        if (serealId < 1){
            return 0;
        }
        return creditPriceRuleMapper.countBySerealId(serealId);
    }


    @Override
    public List<CreditPriceRule> selectBySerealId(Integer serealId, Integer pageNumber, Integer pageSize) {
        if(serealId == 0){
            return null;
        }
        PageHelper.startPage(pageNumber, pageSize);
        return creditPriceRuleMapper.selectBySerealId(serealId);
    }
}
