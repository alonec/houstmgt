package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.Apply;
import com.housemgt.model.MessageDTO;
import com.housemgt.service.ApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ApplyController {


    @Autowired
    ApplyService applyService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //管理员查询所有申请通过操作
    @RequestMapping(path = {"/getResultApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getResultApply(  @RequestParam("result") int  result)  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getResultApply(result);
            return list;
        }catch (Exception e){
            logger.error("查询申请通过的失败！！！"+e.getMessage());
           return null;
        }
    }

    //查询本人的申请信息
    @RequestMapping(path = {"/getSelfApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getSelfApply(  @RequestParam("name") String   name,
                                      @RequestParam("staffCode" )String staffCode
    )  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getSelfApply(name,staffCode);
            return list;
        }catch (Exception e){
            logger.error("查询本人申请的失败！！！"+e.getMessage());
            return null;
        }
    }
    //前端分页查询所有申请
    @RequestMapping(path = {"/getAllApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public MessageDTO getAllApply(@RequestParam("page") int  page)  {

        try {
            int p = (page - 1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = applyService.getAllApply(p);
            return messageDTO;
        }catch (Exception e){
            logger.error("查询申请通过的失败！！！"+e.getMessage());
            return null;
        }
    }
    //查询已审核的
    @RequestMapping(path = {"/getYesApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getYesApply()  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getYesApply();
            return list;
        }catch (Exception e){
            logger.error("查询已审核的失败！！！"+e.getMessage());
            return null;
        }
    }

    //查询未审核
    @RequestMapping(path = {"/getNoApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getNoApply()  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getNoApply();
            return list;
        }catch (Exception e){
            logger.error("查询未审核的失败！！！"+e.getMessage());
            return null;
        }
    }
    //修改个人申请操作
    @RequestMapping(path = {"/addApply/"} , method = { RequestMethod.POST})
    @ResponseBody
    public String addApply(@RequestParam("name") String name,
                           @RequestParam("sex") String sex,
                           @RequestParam("staffCode") String staffCode,
                           @RequestParam("birthdate") String birthdate,
                           @RequestParam("postsHeld") String postsHeld,
                           @RequestParam("timeInJob") String timeInJob,
                           @RequestParam("startingDates") String startingDates,
                           @RequestParam("timeToWork") String timeToWork,
                           @RequestParam("timeToSchool") String timeToSchool,
                           @RequestParam("officialAcademicCredentials") String officialAcademicCredentials,
                           @RequestParam("marriage") String marriage,
                           @RequestParam("linkNum") String linkNum,
                           @RequestParam("idCardNo") String idCardNo,
                           @RequestParam("areaOfStructureNow") double areaOfStructureNow,
                           @RequestParam("statusNow") String statusNow,
                           @RequestParam("addressNow") String addressNow,
                           @RequestParam("type") String type,
                           @RequestParam("spouseName") String spouseName,
                           @RequestParam("spouseBirthdate") String spouseBirthdate,
                           @RequestParam("spouseWorkUnit") String spouseWorkUnit,
                           @RequestParam("spousePostsHeld") String spousePostsHeld,
                           @RequestParam("twoStaffCode") String twoStaffCode,
                           @RequestParam("spouseIdCardNo") String spouseIdCardNo,
                           @RequestParam("spouseAreaOfStructure") double spouseAreaOfStructure,
                           @RequestParam("spouseStatus") String spouseStatus,
                           @RequestParam("spouseHousingMonetizationSubsidies") double spouseHousingMonetizationSubsidies,
                           @RequestParam("spouseAddress") String spouseAddress,
                           @RequestParam("result") int result,
                           @RequestParam("approvalOpinion") String approvalOpinion,
                           @RequestParam("approvalTime") String approvalTime,
                           @RequestParam("approvalPerson") String approvalPerson,
                           @RequestParam("awardGrade") String awardGrade,
                           @RequestParam("returnedOverseas") String returnedOverseas,
                           @RequestParam("depedndentOfMartyrs") String depedndentOfMartyrs,
                           @RequestParam("onlyChild") String onlyChild,
                           @RequestParam("dualEmployeeSpouse") String dualEmployeeSpouse,
                           @RequestParam("unit") String unit
    )  {

        try {

            Apply apply = new Apply();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            apply.setName(name);
            apply.setSex(sex);
            apply.setBirthdate(simpleDateFormat.parse(birthdate));
            apply.setStaffCode(staffCode);
            apply.setPostsHeld(postsHeld);
            apply.setTimeInJob(simpleDateFormat.parse(timeInJob));
            apply.setAppointmentTime(simpleDateFormat.parse(approvalTime));
            apply.setStartingDates(simpleDateFormat.parse(startingDates));
            apply.setTimeToWork(simpleDateFormat.parse(timeToWork));
            apply.setTimeToSchool(simpleDateFormat.parse(timeToSchool));
            apply.setOfficialAcademicCredentials(officialAcademicCredentials);
            apply.setMarriage(marriage);
            apply.setLinkNum(linkNum);
            apply.setIdCardNo(idCardNo);
            apply.setAreaOfStructureNow(areaOfStructureNow);
            apply.setStatusNow(statusNow);
            apply.setType(type);
            apply.setSpouseName(spouseName);
            apply.setSpouseBirthdate(simpleDateFormat.parse(spouseBirthdate));
            apply.setSpouseWorkUnit(spouseWorkUnit);
            apply.setSpousePostsHeld(spousePostsHeld);
            apply.setTwoStaffCode(twoStaffCode);
            apply.setAddressNow(addressNow);
            apply.setSpouseIdCardNo(spouseIdCardNo);
            apply.setSpouseAreaOfStructure(spouseAreaOfStructure);
            apply.setSpouseStatus(spouseStatus);
            apply.setSpouseHousingMonetizationSubsidies(spouseHousingMonetizationSubsidies);
            apply.setSpouseAddress(spouseAddress);
            apply.setApprovalPerson(approvalPerson);
            apply.setResult(result);
            apply.setApprovalOpinion(approvalOpinion);
            apply.setApprovalTime(simpleDateFormat.parse(approvalTime));
            apply.setApprovalPerson(approvalPerson);
            apply.setReturnedOverseas(returnedOverseas);
            apply.setDepedndentOfMartyrs(depedndentOfMartyrs);
            apply.setOnlyChild(onlyChild);
            apply.setDualEmployeeSpouse(dualEmployeeSpouse);
            apply.setUnit(unit);
            applyService.addApply(apply);
            return HouseUtil.getJSONString(0,"增加申请成功");
        }catch (Exception e){
            logger.error("增加申请失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"增加申请失败!!!");
        }
    }


    //提交申请操作

    //撤销个人申请操作
    @RequestMapping(path = {"/deleteApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String  deleteApply(  @RequestParam("name") String   name,
                                 @RequestParam("staffCode" )String staffCode
    )  {

        try {
            applyService.deleteApply(name, staffCode);
            return HouseUtil.getJSONString(0,"撤销申请成功");
        }catch (Exception e){
            logger.error("撤销申请失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"撤销申请失败!!!");
        }
    }
}
