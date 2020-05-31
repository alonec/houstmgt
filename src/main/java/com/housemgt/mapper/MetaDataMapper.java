package com.housemgt.mapper;

import com.housemgt.model.MetaData;

import java.util.List;

public interface MetaDataMapper {

    /**
     * 根据系列ID修改元数据配置
     */
    int deleteByPrimaryKey(Integer serealId);

    int insert(MetaData record);

    /**
     * 添加元数据配置
     */
    int insertSelective(MetaData record);

    MetaData selectByPrimaryKey(Integer serealId);

    /**
     * 查询全部元数据配置列表
     */
    List<MetaData> selectAll();

    /**
     * 根据业务类型查询元数据配置列表
     */
    List<MetaData> selectByBizType(Integer bizType);

    /**
     * 根据系列ID修改元数据配置
     */
    int updateByPrimaryKeySelective(MetaData record);

    int updateByPrimaryKey(MetaData record);
}