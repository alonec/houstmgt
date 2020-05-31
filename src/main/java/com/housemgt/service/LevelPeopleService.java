package com.housemgt.service;

import com.housemgt.model.LevelPeople;

import java.util.List;

/***
 * 人员范围配置业务层接口
 * @author chenxin
 */
public interface LevelPeopleService {

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
     * 根据主键查询人员范围列表
     */
    LevelPeople selectByPrimaryKey(Integer levelPeopleId);
}
