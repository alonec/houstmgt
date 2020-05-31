package com.housemgt.service.impl;

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
        if (serealId < 0 && levelName == null && levelName.equals("")){
            return null;
        }
        return levelPeopleMapper.selectBySerealIdAndLevelName(serealId, levelName);
    }

    @Override
    public LevelPeople selectByPrimaryKey(Integer levelPeopleId) {
        if (levelPeopleId < 0){
            return null;
        }
        return levelPeopleMapper.selectByPrimaryKey(levelPeopleId);
    }
}
