package com.housemgt.service.impl;

import com.github.pagehelper.PageHelper;
import com.housemgt.mapper.CreditAdditionalRuleMapper;
import com.housemgt.model.CreditAdditionalRule;
import com.housemgt.service.CreditAdditionalRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAdditionalRuleServiceImpl implements CreditAdditionalRuleService {

    @Autowired
    private CreditAdditionalRuleMapper creditAdditionalRuleMapper;

    @Override
    public int insertSelective(CreditAdditionalRule record) {
        if (record == null){
            return 0;
        }
        return creditAdditionalRuleMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer areaRuleId) {
        if (areaRuleId < 1){
            return 0;
        }
        return creditAdditionalRuleMapper.deleteByPrimaryKey(areaRuleId);
    }

    @Override
    public int updateByPrimaryKeySelective(CreditAdditionalRule record) {
        if (record == null){
            return 0;
        }
        return creditAdditionalRuleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int countBySerealId(Integer serealId) {
        if (serealId < 1){
            return 0;
        }
        return creditAdditionalRuleMapper.countBySerealId(serealId);
    }


    @Override
    public List<CreditAdditionalRule> selectBySerealId(Integer serealId, Integer pageNumber, Integer pageSize) {
        if(serealId == 0){
            return null;
        }

        PageHelper.startPage(pageNumber, pageSize);
        return creditAdditionalRuleMapper.selectBySerealId(serealId);
    }
}
