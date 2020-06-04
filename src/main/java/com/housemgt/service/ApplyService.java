package com.housemgt.service;


import com.housemgt.Dao.ApplyHouseDao;
import com.housemgt.model.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyService {

    @Autowired
    ApplyHouseDao applyHouseDao;

    //管理员查询所有申请操作
    public List<Apply> getAllApply(){
        return  applyHouseDao.getAllApply();
    }
}
