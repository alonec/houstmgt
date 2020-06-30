package com.housemgt;


import com.housemgt.dao.HistoryDao;
import com.housemgt.model.History;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoryTest {

    @Autowired
    HistoryDao historyDao;
    @Test
    public void contextLoads() {
        List<History> list = new ArrayList<>();
        list = historyDao.findHistory("110","14","二单元","34077");
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getInfrastructureChanges());
        }
    }
}
