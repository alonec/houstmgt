package com.housemgt.service.sweeney;

import com.housemgt.Dao.ActivityStatusDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ActivityService {

    private static final Logger logger = LoggerFactory.getLogger(ActivityService.class);


    @Autowired
    ActivityStatusDao activityStatusDao;



    @Autowired
    RedisTemplate redisTemplate;

//    public void updateStatus(String name,String staffCode,int status){
//        activityStatusDao.updateStatus(name, staffCode, status);
//    }

    public void updateStatus(String name,String staffCode,int status){
        ValueOperations<String, String > operations = redisTemplate.opsForValue();

        String key = "staff_"+staffCode;
        boolean haskey = redisTemplate.hasKey(key);
        if (haskey) {
            System.out.println("删除缓存中的key-----------> " + key);
            redisTemplate.delete(key);
        }
        // 再将更新后的数据加入缓存
        String ss = String.valueOf(status);
        operations.set(key, ss, 3, TimeUnit.HOURS);
        //activityStatusDao.updateStatus(name, staffCode, status);
    }




//    public int selectStatus(String staffCode){
//
//        return  activityStatusDao.selectStatus(staffCode);
//    }

    public int selectStatus(String staffCode){

        String key = "staff_"+staffCode;
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        //判断redis中是否有键为key的缓存
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            System.out.println("从缓存中获取数据");
            String status = operations.get(key);
            System.out.println("-----------------------------");
            return Integer.parseInt(status);
        }else{
            System.out.println("查询数据库获取数据");
            int status1 =activityStatusDao.selectStatus(staffCode);
            String status = String.valueOf(status1);
            logger.info("status"+status);
            System.out.println("------------写入缓存---------------------");
            //写入缓存
            operations.set(key,status,5, TimeUnit.HOURS);
            System.out.println("------------写入缓存sucess!---------------------");
            return Integer.parseInt(status);
        }

    }



}
