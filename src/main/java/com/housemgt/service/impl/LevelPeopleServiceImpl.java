package com.housemgt.service.impl;

import com.github.pagehelper.PageHelper;
import com.housemgt.mapper.LevelPeopleMapper;
import com.housemgt.model.LevelPeople;
import com.housemgt.service.LevelPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelPeopleServiceImpl implements LevelPeopleService {

    @Autowired
    private LevelPeopleMapper levelPeopleMapper;

    @Override
    public int insertSelective(LevelPeople record) {
        if (record == null){
            return 0;
        }
        return levelPeopleMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer areaRuleId) {
        if (areaRuleId < 1){
            return 0;
        }
        return levelPeopleMapper.deleteByPrimaryKey(areaRuleId);
    }

    @Override
    public int updateByPrimaryKeySelective(LevelPeople record) {
        if (record == null){
            return 0;
        }
        return levelPeopleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<LevelPeople> selectBySerealId(Integer serealId) {
        if (serealId < 0){
            return null;
        }
        return levelPeopleMapper.selectBySerealId(serealId);
    }

    @Override
    public List<LevelPeople> selectLevelBySerealId(Integer serealId) {
        if (serealId < 0){
            return null;
        }
        return levelPeopleMapper.selectLevelBySerealId(serealId);
    }

    @Override
    public List<LevelPeople> selectBySerealIdAndLevelName(Integer serealId, String levelName) {
        if (serealId < 0 || levelName != null || levelName.equals("")){
            return null;
        }
        return levelPeopleMapper.selectBySerealIdAndLevelName(serealId, levelName);
    }

    @Override
    public List<LevelPeople> selectByBizSerealPeople(Integer bizType, Integer serealId, String levelPeople
            , Integer pageNumber, Integer pageSize) {
        if(bizType == 0){
            bizType = null;
        }
        if(serealId == 0){
            serealId = null;
        }
        if(levelPeople != null && levelPeople.equals("")){
            levelPeople = null;
        }
        PageHelper.startPage(pageNumber, pageSize);
        return levelPeopleMapper.selectByBizSerealPeople(bizType, serealId, levelPeople);
    }

    @Override
    public int countByBizSerealPeople(Integer bizType, Integer serealId, String levelPeople) {

        return levelPeopleMapper.countByBizSerealPeople(bizType, serealId, levelPeople);
    }

    @Override
    public LevelPeople selectByPrimaryKey(Integer levelPeopleId) {
        if (levelPeopleId < 0){
            return null;
        }
        return levelPeopleMapper.selectByPrimaryKey(levelPeopleId);
    }
}
