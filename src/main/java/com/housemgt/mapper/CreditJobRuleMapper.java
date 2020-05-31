package com.housemgt.mapper;

import com.housemgt.model.CreditJobRule;

import java.util.List;

public interface CreditJobRuleMapper {
    /**
     *  增加面积规则
     */
    int insertSelective(CreditJobRule record);

    int insert(CreditJobRule record);

    /**
     *  删除面积规则
     */
    int deleteByPrimaryKey(Integer areaRuleId);

    /**
     *  修改面积规则
     */
    int updateByPrimaryKeySelective(CreditJobRule record);

    int updateByPrimaryKey(CreditJobRule record);

    /**
     *  根据系列id查询计分规则配置
     */
    List<CreditJobRule> selectBySerealId(Integer serealId);

    CreditJobRule selectByPrimaryKey(Integer id);

}