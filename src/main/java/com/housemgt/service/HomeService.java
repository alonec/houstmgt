package com.housemgt.service;

import com.housemgt.Dao.HomeDao;
import com.housemgt.model.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    HomeDao homeDao;


    public void addHome(Home home) {
        homeDao.addHome(home);
    }

    public void deleteHome(String elementNumber,String houseNumber){
        homeDao.deleteHome(elementNumber,houseNumber);
    }

    public void updateHome(Home home){
        homeDao.updateMessage(home);
    }

    public List<Home> getHomeByStatus (int status){
        return homeDao.getHomeByStatus(status);
    }

    public String getStatusByHome(String elementNumber,String houseNumber){
        return  homeDao.getStatusByHome(elementNumber,houseNumber);
    }


    public void updateStatus(int status,String elementNumber,String houseNumber){
        homeDao.updateHomeStatus(status,elementNumber,houseNumber);
    }


    //根据房间面积区间查询房间
    public List<Home> getHomeByArea(double area1,double area2){
        return homeDao.getHomeByArea(area1, area2);
    }
}
