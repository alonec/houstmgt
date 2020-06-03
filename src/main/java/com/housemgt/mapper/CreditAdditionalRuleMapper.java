package com.housemgt.mapper;

import com.housemgt.model.CreditAdditionalRule;

import java.util.List;

public interface CreditAdditionalRuleMapper {
    /**
     *  增加计分规则
     */
    int insertSelective(CreditAdditionalRule record);

    int insert(CreditAdditionalRule record);

    /**
     *  删除计分规则
     */
    int deleteByPrimaryKey(Integer areaRuleId);

    /**
     *  修改计分规则
     */
    int updateByPrimaryKeySelective(CreditAdditionalRule record);

    int updateByPrimaryKey(CreditAdditionalRule record);

    /**
     *  根据系列id查询计分规则配置
     */
    List<CreditAdditionalRule> selectBySerealId(Integer serealId);

    /**
     * 根据系列id查询计分规则配置总数
     */
    int countBySerealId(Integer serealId);
}