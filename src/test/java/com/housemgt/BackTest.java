package com.housemgt;


import com.housemgt.dao.CoupleBackDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackTest {


    @Autowired
    CoupleBackDao coupleBackDao;
    @Test
    public void contextLoads() {
//        CoupleBack c1 = new CoupleBack();
//        c1.setNo(1);
//        c1.setName("梁晨");
//        c1.setStaffCode("16407010223");
//        c1.setMessage("附加分有异议");
//        coupleBackDao.addBack(c1);
//        CoupleBack c2 = new CoupleBack();
//        c2.setNo(2);
//        c2.setName("梁晨");
//        c2.setStaffCode("16407010223");
//        c2.setMessage("附加分有异议");
//        coupleBackDao.addBack(c2);
//        CoupleBack c3 = new CoupleBack();
//        c3.setNo(3);
//        c3.setName("梁晨");
//        c3.setStaffCode("16407010223");
//        c3.setMessage("附加分有异议");
//        coupleBackDao.addBack(c3);
//        CoupleBack c4 = new CoupleBack();
//        c4.setNo(1);
//        c4.setName("何静");
//        c4.setStaffCode("16407010223");
//        c4.setMessage("附加分有异议");
//        coupleBackDao.addBack(c4);
//        CoupleBack c5 = new CoupleBack();
//        c5.setNo(2);
//        c5.setName("何静");
//        c5.setStaffCode("16407010223");
//        c5.setMessage("附加分有异议");
//        coupleBackDao.addBack(c5);
//        CoupleBack c6 = new CoupleBack();
//        c6.setNo(3);
//        c6.setName("何静");
//        c6.setStaffCode("16407010223");
//        c6.setMessage("附加分有异议");
//        coupleBackDao.addBack(c6);
//        CoupleBack c7 = new CoupleBack();
//        c7.setNo(1);
//        c7.setName("money");
//        c7.setStaffCode("16407010223");
//        c7.setMessage("附加分有异议");
//        coupleBackDao.addBack(c7);
        int count = coupleBackDao.getAllBackNumByNO(1);
        int count1 = coupleBackDao.getAllBackNumByName("money");
        System.out.println("¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥count1"+count1+"¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥");
        System.out.println("¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥count"+count+"¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥");
    }
}
