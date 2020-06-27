package com.housemgt.service;

import com.housemgt.Dao.HomeDao;
import com.housemgt.model.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class HomeService {
    @Autowired
    HomeDao homeDao;

    @Autowired
    RedisTemplate redisTemplate;

    public void addHome(Home home) {
        homeDao.addHome(home);
    }

    public void deleteHome(String elementNumber,String houseNumber){
        homeDao.deleteHome(elementNumber,houseNumber);
    }

    public void updateHome(Home home){
        homeDao.updateMessage(home);
    }

    //public List<Home> getHomeByStatus (int status){
//        return homeDao.getHomeByStatus(status);
//    }

    /**
     * 获取策略:先从缓存中获取，没有则读mysql数据，再将数据写入缓存
     */
    public List<Home> getHomeByStatus(int status){
        String key = "Home_"+status;
        ValueOperations<String,List<Home>> operations = redisTemplate.opsForValue();
        //判断redis中是否有键为key的缓存
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            System.out.println("从缓存中获取数据");
            List<Home> list = operations.get(key);
            System.out.println("-----------------------------");
            return list;
        }else{
            System.out.println("查询数据库获取数据");
            List<Home> list =homeDao.getHomeByStatus(status) ;
            System.out.println("------------写入缓存---------------------");
            //写入缓存
            operations.set(key,list,5, TimeUnit.HOURS);
            System.out.println("------------写入缓存sucess!---------------------");
            return list;
        }
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
