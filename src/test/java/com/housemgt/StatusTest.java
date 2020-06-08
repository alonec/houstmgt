package com.housemgt;


import com.housemgt.Dao.ActivityStatusDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusTest {


    @Autowired
    ActivityStatusDao activityStatusDao;
    @Test
    public void contextLoads() {
        activityStatusDao.addStatus("周洁肤","16407010223",1);
        activityStatusDao.updateStatus("徐文涛","16407010223",3);
        System.out.println(activityStatusDao.selectStatus("徐文涛"));
    }
}
