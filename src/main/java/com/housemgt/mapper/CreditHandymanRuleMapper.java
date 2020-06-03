package com.housemgt.mapper;

import com.housemgt.model.CreditHandyManRule;

import java.util.List;

public interface CreditHandymanRuleMapper {
    /**
     *  增加面积规则
     */
    int insertSelective(CreditHandyManRule record);

    int insert(CreditHandyManRule record);

    /**
     *  删除面积规则
     */
    int deleteByPrimaryKey(Integer areaRuleId);

    /**
     *  修改面积规则
     */
    int updateByPrimaryKeySelective(CreditHandyManRule record);

    int updateByPrimaryKey(CreditHandyManRule record);

    /**
     *  根据系列id查询计分规则配置
     */
    List<CreditHandyManRule> selectBySerealId(Integer serealId);

    /**
     * 根据系列id查询计分规则配置总数
     */
    int countBySerealId(Integer serealId);

    CreditHandyManRule selectByPrimaryKey(Integer id);

}