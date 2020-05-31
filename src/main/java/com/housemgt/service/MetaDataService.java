package com.housemgt.service;

import com.housemgt.model.MetaData;

import java.util.List;

/***
 * 元数据配置业务层接口
 * @author chenxin
 */
public interface MetaDataService {

    /**
     * 添加元数据配置
     * @param metaData
     * @return
     */
    int insert(MetaData metaData);

    /**
     * 根据系列ID修改元数据配置
     */
    int deleteBySerealId(Integer serealId);

    /**
     * 根据系列ID修改元数据配置
     */
    int updateBySerealId(MetaData record);

    /**
     * 查询全部元数据配置列表
     */
    List<MetaData> selectAll();

    /**
     * 根据业务类型查询元数据配置列表
     */
    List<MetaData> selectByBizType(Integer bizType);
}
