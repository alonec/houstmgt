package com.housemgt.service;


import com.housemgt.Dao.ActivityStatusDao;
import com.housemgt.Dao.ApplyHouseDao;
import com.housemgt.model.Apply;
import com.housemgt.model.ApplyPart;
import com.housemgt.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplyService {

    @Autowired
    ApplyHouseDao applyHouseDao;

    @Autowired
    ActivityStatusDao activityStatusDao;

    //管理员查询所有申请通过操作
    public List<Apply> getResultApply(int result){
        return  applyHouseDao.getResultApply(result);
    }

    //查询本人的申请信息
    public List<Apply> getSelfApply(String name,String staffCode){
        return applyHouseDao.getSelfApply( name, staffCode);
    }
    //前端查询所有常规申请
    public MessageDTO getAllApply(int page){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(applyHouseDao.getAllApplyNum());
        messageDTO.setList(applyHouseDao.getAllApply(page));
        return messageDTO;
    }

    //前端查询所有即时申请
    public MessageDTO getAllApplyNow(int page){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(applyHouseDao.getAllApplyNumNow());
        messageDTO.setList(applyHouseDao.getAllApplyNow(page));
        return messageDTO;
    }
    //查询已审核常规的
    public List<Apply> getYesApply(){
        return applyHouseDao.getYesApply();
    }
    //查询常规未审核
    public List<Apply> getNoApply(){
        return applyHouseDao.getNoApply();
    }

    //查询已审核即时的
    public List<Apply> getYesApplyNow(){
        return applyHouseDao.getYesApplyNow();
    }
    //查询即时未审核
    public List<Apply> getNoApplyNow(){
        return applyHouseDao.getNoApplyNow();
    }

    //修改个人申请操作
    public void deleteApply(String name, String staffCode){
        applyHouseDao.deleteSelfApply(name,staffCode);
    }
    //个人申请操作
    public void addApply(Apply apply){
        applyHouseDao.addApply(apply);
        activityStatusDao.addStatus(apply.getName(),apply.getStaffCode(),1);
    }
    //更新申请操作
    public void updateApply(Apply apply){
        applyHouseDao.updateApply(apply);
    }

    //更新审核状态
    public  void updateApplyResult(String name, String staffCode, int result, String approvalOpinion, Date approvalTime, String approvalPerson){
        applyHouseDao.updateApplyResult(name, staffCode, result, approvalOpinion, approvalTime, approvalPerson);
        activityStatusDao.updateStatus(name,staffCode,2);
    }



    //查询已审核常规的
    public List<ApplyPart> getYesApplyF(){
        return applyHouseDao.getYesApplyF();
    }
    //查询常规未审核
    public List<ApplyPart> getNoApplyF(){
        return applyHouseDao.getNoApplyF();
    }

    //查询已审核即时的
    public List<ApplyPart> getYesApplyNowF(){
        return applyHouseDao.getYesApplyNowF();
    }
    //查询即时未审核
    public List<ApplyPart> getNoApplyNowF(){
        return applyHouseDao.getNoApplyNowF();
    }



    //查看详情页
    public List<Apply> getYesApplyByName(String name,String SatffCode)
    {
        return applyHouseDao.getYesApplyByName(name, SatffCode);
    }
}
