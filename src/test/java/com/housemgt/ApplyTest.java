package com.housemgt;



import com.housemgt.Dao.ApplyHouseDao;
import com.housemgt.model.Apply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyTest {

    @Autowired
    ApplyHouseDao applyHouseDao;
    @Test
    public void contextLoads() {
//        Apply apply = new Apply();
//        apply.setName("徐文涛");
//        apply.setSex("男");
//        apply.setBirthdate(new Date());
//        apply.setStaffCode("16407010224");
//        apply.setPostsHeld("教授");
//        apply.setTimeInJob(new Date());
//        apply.setAppointmentTime(new Date());
//        apply.setStartingDates(new Date());
//        apply.setTimeToWork(new Date());
//        apply.setTimeToSchool(new Date());
//        apply.setOfficialAcademicCredentials("博士");
//        apply.setMarriage("未婚");
//        apply.setLinkNum("110");
//        apply.setIdCardNo("610***********");
//        apply.setAreaOfStructureNow(32.89);
//        apply.setStatusNow("租房");
//        apply.setType("新建房");
//        apply.setSpouseName("侯祥");
//        apply.setSpouseBirthdate(new Date());
//        apply.setSpouseWorkUnit("西安科技大学");
//        apply.setSpousePostsHeld("教授儿子");
//        apply.setTwoStaffCode("16******");
//        apply.setAddressNow("西安科技大学");
//        apply.setSpouseIdCardNo("610******");
//        apply.setSpouseAreaOfStructure(90.90);
//        apply.setSpouseStatus("租房");
//        apply.setSpouseHousingMonetizationSubsidies(900000.00);
//        apply.setSpouseAddress("瓦国");
//        apply.setApprovalPerson("梁晨");
//        apply.setResult(0);
//        apply.setApprovalOpinion("tongguo");
//        apply.setApprovalTime(new Date());
//        apply.setApprovalPerson("1");
//        apply.setReturnedOverseas("1");
//        apply.setDepedndentOfMartyrs("1");
//        apply.setOnlyChild("0");
//        apply.setDualEmployeeSpouse("0");
//        applyHouseDao.addApply(apply);
//
        List<Apply> list = new ArrayList<>();
        list = applyHouseDao.getResultApply(0);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i).getName()+" &&&&&&&&&&&&&&&&&&&&");
        }

        List<Apply> list1 = new ArrayList<>();
        list1 = applyHouseDao.getSelfApply("徐文涛","16407010224");
        System.out.println(list1.get(0).getName()+" &&&&&&&&&&&&&&&&&&&&");

        Apply apply2 = new Apply();
        apply2.setName("周洁肤");
        apply2.setSex("男");
        apply2.setBirthdate(new Date());
        apply2.setStaffCode("16407010230");
        apply2.setPostsHeld("教授");
        apply2.setTimeInJob(new Date());
        apply2.setAppointmentTime(new Date());
        apply2.setStartingDates(new Date());
        apply2.setTimeToWork(new Date());
        apply2.setTimeToSchool(new Date());
        apply2.setOfficialAcademicCredentials("博士");
        apply2.setMarriage("未婚");
        apply2.setLinkNum("110");
        apply2.setIdCardNo("610***********");
        apply2.setAreaOfStructureNow(32.89);
        apply2.setStatusNow("租房");
        apply2.setType("新建房");
        apply2.setSpouseName("侯还穿");
        apply2.setSpouseBirthdate(new Date());
        apply2.setSpouseWorkUnit("西安科技大学");
        apply2.setSpousePostsHeld("教授儿子");
        apply2.setTwoStaffCode("16******");
        apply2.setAddressNow("西安科技大学");
        apply2.setSpouseIdCardNo("610******");
        apply2.setSpouseAreaOfStructure(90.90);
        apply2.setSpouseStatus("租房");
        apply2.setSpouseHousingMonetizationSubsidies(900000.00);
        apply2.setSpouseAddress("瓦国");
        applyHouseDao.addApply(apply2);


        Apply apply1 = new Apply();
        apply1.setName("张欣");
        apply1.setSex("男");
        apply1.setBirthdate(new Date());
        apply1.setStaffCode("16407010223");
        apply1.setPostsHeld("教授");
        apply1.setTimeInJob(new Date());
        apply1.setAppointmentTime(new Date());
        apply1.setStartingDates(new Date());
        apply1.setTimeToWork(new Date());
        apply1.setTimeToSchool(new Date());
        apply1.setOfficialAcademicCredentials("博士");
        apply1.setMarriage("未婚");
        apply1.setLinkNum("110");
        apply1.setIdCardNo("610***********");
        apply1.setAreaOfStructureNow(32.89);
        apply1.setStatusNow("租房");
        apply1.setType("新建房");
        apply1.setSpouseName("臭妹妹");
        apply1.setSpouseBirthdate(new Date());
        apply1.setSpouseWorkUnit("西安石油大学");
        apply1.setSpousePostsHeld("臭板子");
        apply1.setTwoStaffCode("16******");
        apply1.setAddressNow("西安科技大学");
        apply1.setSpouseIdCardNo("610******");
        apply1.setSpouseAreaOfStructure(90.90);
        apply1.setSpouseStatus("租房");
        apply1.setSpouseHousingMonetizationSubsidies(900000.00);
        apply1.setSpouseAddress("瓦国");
        apply1.setApprovalPerson("梁晨");
        apply1.setResult(0);
        apply1.setApprovalOpinion("tongguo");
        apply1.setApprovalTime(new Date());
        applyHouseDao.addApply(apply1);
        applyHouseDao.updateApply(apply1);
    }
}
