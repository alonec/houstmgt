package com.housemgt.service;

import com.housemgt.model.CreditJobRule;

import java.util.List;

/***
 * 计分规则配置业务层接口
 * @author chenxin
 */
public interface CreditJobRuleService {

    /**
     *  增加面积规则
     */
    int insertSelective(CreditJobRule record);

    /**
     *  删除面积规则
     */
    int deleteByPrimaryKey(Integer areaRuleId);

    /**
     *  修改面积规则
     */
    int updateByPrimaryKeySelective(CreditJobRule record);

    /**
     *  根据系列id查询计分规则配置
     */
    List<CreditJobRule> selectBySerealId(Integer serealId);
}
