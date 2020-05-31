package com.housemgt.service;

import com.housemgt.model.AreaRule;

import java.util.List;

/***
 * 元数据配置业务层接口
 * @author chenxin
 */
public interface AreaRuleService {

    /**
     *  增加面积规则
     */
    int insertSelective(AreaRule record);

    /**
     *  删除面积规则
     */
    int deleteByPrimaryKey(Integer areaRuleId);

    /**
     *  修改面积规则
     */
    int updateByPrimaryKeySelective(AreaRule record);

    /**
     * 根据系列id查询面积规则配置总数
     */
    int countBySerealId(Integer serealId);

    /**
     * 根据系列id查询面积规则配置
     */
    List<AreaRule> selectBySerealId(Integer serealId, Integer pageNumber, Integer pageSize);
}
