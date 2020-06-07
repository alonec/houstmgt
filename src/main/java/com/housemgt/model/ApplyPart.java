package com.housemgt.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplyPart {

    private String name;
    private String staffCode;
    private int result;
    private Date approvalTime;
    private String postsHeld;

    public String getPostsHeld() {
        return postsHeld;
    }

    public void setPostsHeld(String postsHeld) {
        this.postsHeld = postsHeld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getApprovalTime() {
//        return approvalTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化规则
        Date date = approvalTime;         //获得你要处理的时间 Date型
        String strDate= sdf.format(date ); //格式化成yyyy-MM-dd格式的时间字符串
        Date newDate = null;
        try {
            newDate = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date resultDate = new java.sql.Date(newDate.getTime());//最后转换成 java.sql.Date类
        return resultDate;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }
}
