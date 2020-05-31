package com.housemgt.mapper;

import com.housemgt.model.LevelPeople;

import java.util.List;

public interface LevelPeopleMapper {
    int deleteByPrimaryKey(Integer levelPeopleId);

    int insert(LevelPeople record);

    int insertSelective(LevelPeople record);

    LevelPeople selectByPrimaryKey(Integer levelPeopleId);

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

    int updateByPrimaryKeySelective(LevelPeople record);

    int updateByPrimaryKey(LevelPeople record);
}