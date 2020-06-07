package com.housemgt.service;

import com.housemgt.Dao.ActivityStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {


    @Autowired
    ActivityStatusDao activityStatusDao;

    public void updateStatus(String name,String staffCode,int status){
        activityStatusDao.updateStatus(name, staffCode, status);
    }

    public int selectStatus(String name,String staffCode){
        return  activityStatusDao.selectStatus(name, staffCode);
    }
}
