package com.housemgt.service;

import com.housemgt.model.LevelPeople;

import java.util.List;

/***
 * 人员范围配置业务层接口
 * @author chenxin
 */
public interface LevelPeopleService {

    /**
     *  增加数据名称
     */
    int insertSelective(LevelPeople record);

    /**
     *  删除数据名称
     */
    int deleteByPrimaryKey(Integer areaRuleId);

    /**
     *  修改数据名称
     */
    int updateByPrimaryKeySelective(LevelPeople record);

    /**
     * 根据系列id查询人员范围列表
     */
    List<LevelPeople> selectBySerealId(Integer serealId);

    /**
     * 根据系列id查询级别名称列表
     */
    List<LevelPeople> selectLevelBySerealId(Integer serealId);

    /**
     * 根据系列id和级别查询人员范围列表
     */
    List<LevelPeople> selectBySerealIdAndLevelName(Integer serealId, String levelName);

    /**
     * 支持通过业务类型、系列id、人员范围查询列表
     */
    List<LevelPeople> selectByBizSerealPeople(Integer bizType, Integer serealId, String levelPeople
            , Integer pageNumber, Integer pageSize);

    /**
     * 支持通过业务类型、系列id、人员范围查询列表总数
     */
    int countByBizSerealPeople(Integer bizType, Integer serealId, String levelPeople);

    /**
     * 根据主键查询人员范围列表
     */
    LevelPeople selectByPrimaryKey(Integer levelPeopleId);
}
