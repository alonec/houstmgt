package com.housemgt.service.impl;

import com.github.pagehelper.PageHelper;
import com.housemgt.mapper.CountResultMapper;
import com.housemgt.model.CountResult;
import com.housemgt.service.CountResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CountResultServiceImpl implements CountResultService {
    @Autowired
    private CountResultMapper countResultMapper;

    @Override
    public List<CountResult> select(Map entry, Integer pageNumber, Integer pageSize) {
        if(entry == null) {
            return null;
        }
        PageHelper.startPage(pageNumber, pageSize);
        return countResultMapper.select(entry);
    }

    @Override
    public int count(Map entry) {
        if(entry == null) {
            return 0;
        }
        return countResultMapper.count(entry);
    }

    @Override
    public int updateByPrimaryKeySelective(CountResult record) {
        if (record == null) {
            return 0;
        }
        return countResultMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(CountResult record) {
        if (record == null){
            return 0;
        }
        return countResultMapper.insertSelective(record);
    }
}

