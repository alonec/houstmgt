package com.housemgt.mapper;

import com.housemgt.model.CreditPriceRule;

import java.util.List;

public interface CreditPriceRuleMapper {
    /**
     *  增加面积规则
     */
    int insertSelective(CreditPriceRule record);

    int insert(CreditPriceRule record);

    /**
     *  删除面积规则
     */
    int deleteByPrimaryKey(Integer areaRuleId);

    /**
     *  修改面积规则
     */
    int updateByPrimaryKeySelective(CreditPriceRule record);

    int updateByPrimaryKey(CreditPriceRule record);

    /**
     *  根据系列id查询计分规则配置
     */
    List<CreditPriceRule> selectBySerealId(Integer serealId);

    /**
     * 根据系列id查询计分规则配置总数
     */
    int countBySerealId(Integer serealId);

    CreditPriceRule selectByPrimaryKey(Integer id);

}