package com.housemgt.mapper;

import com.housemgt.model.applyHouse;

public interface applyHouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(applyHouse record);

    int insertSelective(applyHouse record);

    applyHouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(applyHouse record);

    int updateByPrimaryKey(applyHouse record);
}