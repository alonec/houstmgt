package com.housemgt;

import com.housemgt.Dao.HomeDao;
import com.housemgt.model.Home;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeTest {

    @Autowired
    HomeDao homeDao;

    @Test
    public void contextLoads() {
        List<Home> list = new ArrayList<>();
        list = homeDao.getHomeByArea(111,500);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getStatus());
        }
    }
}
