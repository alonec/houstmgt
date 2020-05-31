package com.housemgt.mapper;

import com.housemgt.model.AreaRule;

import java.util.List;

public interface AreaRuleMapper {


    int insert(AreaRule record);

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

    int updateByPrimaryKey(AreaRule record);

    AreaRule selectByPrimaryKey(Integer areaRuleId);

    /**
     *  根据系列id查询面积规则配置
     */
    List<AreaRule> selectBySerealId(Integer serealId);

    /**
     * 根据系列id查询面积规则配置总数
     */
    int countBySerealId(Integer serealId);


}