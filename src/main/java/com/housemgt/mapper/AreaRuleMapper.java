package com.housemgt.mapper;

import com.housemgt.model.AreaRule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaRuleMapper {
    int deleteByPrimaryKey(Integer areaRuleId);

    int insert(AreaRule record);

    int insertSelective(AreaRule record);

    AreaRule selectByPrimaryKey(Integer areaRuleId);

    int updateByPrimaryKeySelective(AreaRule record);

    int updateByPrimaryKey(AreaRule record);

    /**
     * 根据系列id查询面积规则配置总数
     */
    int countBySerealId(Integer serealId);

    /**
     * 根据系列id查询面积规则配置
     */
    List<AreaRule> selectBySerealId(Integer serealId);
}