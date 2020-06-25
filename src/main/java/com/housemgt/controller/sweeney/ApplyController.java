package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.Apply;
import com.housemgt.model.ApplyPart;
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

    /**管理员查询所有申请通过操作*/
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

    /**查询本人的申请信息*/
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
    /**前端分页查询所有常规申请*/
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
    //前端分页查询所有即时申请
    @RequestMapping(path = {"/getAllApplyNow/"} , method = { RequestMethod.GET})
    @ResponseBody
    public MessageDTO getAllApplyNow(@RequestParam("page") int  page)  {

        try {
            int p = (page - 1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = applyService.getAllApplyNow(p);
            return messageDTO;
        }catch (Exception e){
            logger.error("查询即时申请通过的失败！！！"+e.getMessage());
            return null;
        }
    }
    //查询常规已审核的
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

    //查询常规未审核
    @RequestMapping(path = {"/getNoApplyNow/"} , method = { RequestMethod.GET})
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
    //查询常规已即时的
    @RequestMapping(path = {"/getYesApplyNow/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getYesApplyNow()  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getYesApplyNow();
            return list;
        }catch (Exception e){
            logger.error("查询已审核的失败！！！"+e.getMessage());
            return null;
        }
    }

    //查询即时未审核
    @RequestMapping(path = {"/getNoApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getNoApplyNow()  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getNoApplyNow();
            return list;
        }catch (Exception e){
            logger.error("查询未审核的失败！！！"+e.getMessage());
            return null;
        }
    }
    //修改个人申请操作
    @RequestMapping(path = {"/updateApply/"} , method = { RequestMethod.POST})
    @ResponseBody
    public String updateApply(@RequestParam("name") String name,
                              @RequestParam("sex") String sex,
                              @RequestParam("staffCode") String staffCode,
                              @RequestParam("birthdate") String birthdate,
                              @RequestParam("postsHeld") String postsHeld,
                              @RequestParam("timeInJob") String timeInJob,
                              @RequestParam("appointmentTime") String  appointmentTime,
                              @RequestParam("startingDates") String startingDates,
                              @RequestParam("timeToWork") String timeToWork,
                              @RequestParam("timeToSchool") String timeToSchool,
                              @RequestParam("officialAcademicCredentials") String officialAcademicCredentials,
                              @RequestParam("marriage") String marriage,
                              @RequestParam("linkNum") String linkNum,
                              @RequestParam("idCardNo") String idCardNo,
                              @RequestParam("areaOfStructureNow") String areaOfStructureNow,
                              @RequestParam("statusNow") String statusNow,
                              @RequestParam("addressNow") String addressNow,
                              @RequestParam("type") String type,
                              @RequestParam("spouseName") String spouseName,
                              @RequestParam("spouseBirthdate") String spouseBirthdate,
                              @RequestParam("spouseWorkUnit") String spouseWorkUnit,
                              @RequestParam("spousePostsHeld") String spousePostsHeld,
                              @RequestParam("twoStaffCode") String twoStaffCode,
                              @RequestParam("spouseIdCardNo") String spouseIdCardNo,
                              @RequestParam("spouseAreaOfStructure") String spouseAreaOfStructure,
                              @RequestParam("spouseStatus") String spouseStatus,
                              @RequestParam("spouseHousingMonetizationSubsidies") String spouseHousingMonetizationSubsidies,
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
                              @RequestParam("unit") String unit,
                              @RequestParam("tag") int tag
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
            apply.setAppointmentTime(simpleDateFormat.parse(appointmentTime));
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
            apply.setAwardGrade(awardGrade);
            apply.setReturnedOverseas(returnedOverseas);
            apply.setDepedndentOfMartyrs(depedndentOfMartyrs);
            apply.setOnlyChild(onlyChild);
            apply.setDualEmployeeSpouse(dualEmployeeSpouse);
            apply.setUnit(unit);
            apply.setTag(tag);
            applyService.updateApply(apply);
            return HouseUtil.getJSONString(0,"修改申请成功");
        }catch (Exception e){
            logger.error("修改申请失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"修改申请失败!!!");
        }
    }


    //提交申请操作
    @RequestMapping(path = {"/addApply/"} , method = { RequestMethod.POST})
    @ResponseBody
    public String addApply(
                           @RequestParam("name") String name,
                           @RequestParam("sex") String sex,
                           @RequestParam("staffCode") String staffCode,
                           @RequestParam("birthdate") String birthdate,
                           @RequestParam("postsHeld") String postsHeld,
                           @RequestParam("timeInJob") String timeInJob,
                           @RequestParam("appointmentTime") String  appointmentTime,
                           @RequestParam("startingDates") String startingDates,
                           @RequestParam("timeToWork") String timeToWork,
                           @RequestParam("timeToSchool") String timeToSchool,
                           @RequestParam("officialAcademicCredentials") String officialAcademicCredentials,
                           @RequestParam("marriage") String marriage,
                           @RequestParam("linkNum") String linkNum,
                           @RequestParam("idCardNo") String idCardNo,
                           @RequestParam("areaOfStructureNow") String areaOfStructureNow,
                           @RequestParam("statusNow") String statusNow,
                           @RequestParam("addressNow") String addressNow,
                           @RequestParam("type") String type,
                           @RequestParam("spouseName") String spouseName,
                           @RequestParam("spouseBirthdate") String spouseBirthdate,
                           @RequestParam("spouseWorkUnit") String spouseWorkUnit,
                           @RequestParam("spousePostsHeld") String spousePostsHeld,
                           @RequestParam("twoStaffCode") String twoStaffCode,
                           @RequestParam("spouseIdCardNo") String spouseIdCardNo,
                           @RequestParam("spouseAreaOfStructure") String spouseAreaOfStructure,
                           @RequestParam("spouseStatus") String spouseStatus,
                           @RequestParam("spouseHousingMonetizationSubsidies") String spouseHousingMonetizationSubsidies,
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
                           @RequestParam("unit") String unit,
                           @RequestParam("tag") int tag
    )  {

        System.out.println("birthdate"+birthdate);
        try {

            Apply apply = new Apply();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            apply.setName(name);
            apply.setSex(sex);
            apply.setBirthdate(simpleDateFormat.parse(birthdate));
            apply.setStaffCode(staffCode);
            apply.setPostsHeld(postsHeld);
            apply.setTimeInJob(simpleDateFormat.parse(timeInJob));
            apply.setAppointmentTime(simpleDateFormat.parse(appointmentTime));
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
            apply.setAwardGrade(awardGrade);
            apply.setReturnedOverseas(returnedOverseas);
            apply.setDepedndentOfMartyrs(depedndentOfMartyrs);
            apply.setOnlyChild(onlyChild);
            apply.setDualEmployeeSpouse(dualEmployeeSpouse);
            apply.setUnit(unit);
            apply.setTag(tag);
            applyService.addApply(apply);
            return HouseUtil.getJSONString(0,"增加申请成功");
        }catch (Exception e){
            logger.error("增加申请失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"增加申请失败!!!");
        }
    }
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

    //更新审核状态
    @RequestMapping(path = {"/updateApplyResult/"} , method = { RequestMethod.POST})
    @ResponseBody
    public String updateApplyResult(@RequestParam("name") String name,
                              @RequestParam("staffCode") String staffCode,
                              @RequestParam("result") int result,
                              @RequestParam("approvalOpinion") String approvalOpinion,
                              @RequestParam("approvalTime") String approvalTime,
                              @RequestParam("approvalPerson") String approvalPerson
    )  {

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            applyService.updateApplyResult(name,staffCode,result,approvalOpinion,simpleDateFormat.parse(approvalTime),approvalPerson);
            return HouseUtil.getJSONString(0,"修改状态成功");
        }catch (Exception e){
            logger.error("修改状态失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"修改状态失败!!!");
        }
    }


    //查询常规已审核的
    @RequestMapping(path = {"/getYesApplyF/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<ApplyPart> getYesApplyF()  {

        try {
            List<ApplyPart> list = new ArrayList<>();
            list = applyService.getYesApplyF();
            return list;
        }catch (Exception e){
            logger.error("查询已审核的失败！！！"+e.getMessage());
            return null;
        }
    }

    //查询常规未审核
    @RequestMapping(path = {"/getNoApplyF/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<ApplyPart> getNoApplyF()  {

        try {
            List<ApplyPart> list = new ArrayList<>();
            list = applyService.getNoApplyF();
            return list;
        }catch (Exception e){
            logger.error("查询未审核的失败！！！"+e.getMessage());
            return null;
        }
    }
    //查询常规已即时的
    @RequestMapping(path = {"/getYesApplyNowF/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<ApplyPart> getYesApplyNowF()  {

        try {
            List<ApplyPart> list = new ArrayList<>();
            list = applyService.getYesApplyNowF();
            return list;
        }catch (Exception e){
            logger.error("查询已审核的失败！！！"+e.getMessage());
            return null;
        }
    }

    //查询即时未审核
    @RequestMapping(path = {"/getNoApplyNowF/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<ApplyPart> getNoApplyNowF()  {

        try {
            List<ApplyPart> list = new ArrayList<>();
            list = applyService.getNoApplyNowF();
            return list;
        }catch (Exception e){
            logger.error("查询未审核的失败！！！"+e.getMessage());
            return null;
        }
    }

    //详情展示
    @RequestMapping(path = {"/getYesApplyByName/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getYesApplyByName(@RequestParam("name") String name,
                                         @RequestParam("staffCode") String staffCode)  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getYesApplyByName(name, staffCode);
            return list;
        }catch (Exception e){
            logger.error("查询已审核的失败！！！"+e.getMessage());
            return null;
        }
    }
}
