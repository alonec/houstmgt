package com.housemgt.service.setparam.impl;

import com.github.pagehelper.PageHelper;
import com.housemgt.mapper.CreditJobRuleMapper;
import com.housemgt.model.CreditJobRule;
import com.housemgt.service.setparam.CreditJobRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditJobRuleServiceImpl implements CreditJobRuleService {

    @Autowired
    private CreditJobRuleMapper creditJobRuleMapper;

    @Override
    public int insertSelective(CreditJobRule record) {
        if (record == null){
            return 0;
        }
        return creditJobRuleMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer areaRuleId) {
        if (areaRuleId < 1){
            return 0;
        }
        return creditJobRuleMapper.deleteByPrimaryKey(areaRuleId);
    }

    @Override
    public int updateByPrimaryKeySelective(CreditJobRule record) {
        if (record == null){
            return 0;
        }
        return creditJobRuleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int countBySerealId(Integer serealId) {
        if (serealId < 1){
            return 0;
        }
        return creditJobRuleMapper.countBySerealId(serealId);
    }


    @Override
    public List<CreditJobRule> selectBySerealId(Integer serealId, Integer pageNumber, Integer pageSize) {
        if(serealId == 0){
            return null;
        }
        PageHelper.startPage(pageNumber, pageSize);
        return creditJobRuleMapper.selectBySerealId(serealId);
    }
}
