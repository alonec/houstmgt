package com.housemgt.mapper;

import com.housemgt.model.CountResult;

public interface CountResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CountResult record);

    int insertSelective(CountResult record);

    CountResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CountResult record);

    int updateByPrimaryKey(CountResult record);
}