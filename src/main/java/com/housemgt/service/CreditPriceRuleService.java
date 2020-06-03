package com.housemgt.service;

import com.housemgt.model.CreditPriceRule;

import java.util.List;

/***
 * 计分规则配置业务层接口
 * @author chenxin
 */
public interface CreditPriceRuleService {

    /**
     *  增加计分规则
     */
    int insertSelective(CreditPriceRule record);

    /**
     *  删除计分规则
     */
    int deleteByPrimaryKey(Integer areaRuleId);

    /**
     *  修改计分规则
     */
    int updateByPrimaryKeySelective(CreditPriceRule record);

    /**
     * 根据系列id查询计分规则配置总数
     */
    int countBySerealId(Integer serealId);

    /**
     *  根据系列id查询计分规则配置
     */
    List<CreditPriceRule> selectBySerealId(Integer serealId, Integer pageNumber, Integer pageSize);
}
