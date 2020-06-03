package com.housemgt.service.impl;

import com.github.pagehelper.PageHelper;
import com.housemgt.mapper.AreaRuleMapper;
import com.housemgt.model.AreaRule;
import com.housemgt.service.AreaRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaRuleServiceImpl implements AreaRuleService {

    @Autowired
    private AreaRuleMapper areaRuleMapper;

    @Override
    public int insertSelective(AreaRule record) {
        if (record == null){
            return 0;
        }
        return areaRuleMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer areaRuleId) {
        if (areaRuleId < 1){
            return 0;
        }
        return areaRuleMapper.deleteByPrimaryKey(areaRuleId);
    }

    @Override
    public int updateByPrimaryKeySelective(AreaRule record) {
        if (record == null){
            return 0;
        }
        return areaRuleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int countBySerealId(Integer serealId) {
        if (serealId < 1){
            return 0;
        }
        return areaRuleMapper.countBySerealId(serealId);
    }

    @Override
    public List<AreaRule> selectBySerealId(Integer serealId, Integer pageNumber, Integer pageSize) {
        if(serealId == 0){
            return null;
        }
        PageHelper.startPage(pageNumber, pageSize);
        return areaRuleMapper.selectBySerealId(serealId);
    }
}
