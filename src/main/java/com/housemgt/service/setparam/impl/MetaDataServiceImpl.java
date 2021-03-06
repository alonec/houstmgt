package com.housemgt.service.setparam.impl;

import com.housemgt.mapper.MetaDataMapper;
import com.housemgt.model.MetaData;
import com.housemgt.service.setparam.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaDataServiceImpl implements MetaDataService {

    @Autowired
    private MetaDataMapper metaDataMapper;

    @Override
    public int insert(MetaData metaData) {
        if (metaData == null){
            return 0;
        }
        return metaDataMapper.insertSelective(metaData);
    }

    @Override
    public int deleteBySerealId(Integer serealId) {
        if (serealId < 1){
            return 0;
        }
        return metaDataMapper.deleteByPrimaryKey(serealId);
    }

    @Override
    public int updateBySerealId(MetaData metaData) {
        if (metaData == null){
            return 0;
        }
        return metaDataMapper.updateByPrimaryKey(metaData);
    }

    @Override
    public List<MetaData> selectBizType() {
        return metaDataMapper.selectBizType();
    }

    @Override
    public List<MetaData> selectAll() {
        return metaDataMapper.selectAll();
    }

    @Override
    public List<MetaData> selectByBizType(Integer bizType) {
        if (bizType < 1){
            return null;
        }
        return metaDataMapper.selectByBizType(bizType);
    }

    @Override
    public MetaData selectBySerealId(Integer serealId) {
        if (serealId < 0) {
            return null;
        }
        return metaDataMapper.selectByPrimaryKey(serealId);
    }
}
