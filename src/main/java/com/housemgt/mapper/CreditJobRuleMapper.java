package com.housemgt.mapper;

import com.housemgt.model.CreditJobRule;

import java.util.List;

public interface CreditJobRuleMapper {
    /**
     *  增加计分规则
     */
    int insertSelective(CreditJobRule record);

    int insert(CreditJobRule record);

    /**
     *  删除计分规则
     */
    int deleteByPrimaryKey(Integer areaRuleId);

    /**
     *  修改计分规则
     */
    int updateByPrimaryKeySelective(CreditJobRule record);

    int updateByPrimaryKey(CreditJobRule record);

    /**
     *  根据系列id查询计分规则配置
     */
    List<CreditJobRule> selectBySerealId(Integer serealId);

    /**
     * 根据系列id查询计分规则配置总数
     */
    int countBySerealId(Integer serealId);

    CreditJobRule selectByPrimaryKey(Integer id);

}