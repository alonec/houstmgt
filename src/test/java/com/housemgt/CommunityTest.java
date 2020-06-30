package com.housemgt;



import com.housemgt.dao.CommunityDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityTest {

    @Autowired
    CommunityDao communityDao;
    @Test
    public void contextLoads() {
        communityDao.deleteCommunity("秦汉校园","2");
    }
}
