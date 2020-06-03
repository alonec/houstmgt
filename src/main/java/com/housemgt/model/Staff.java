package com.housemgt.model;

import java.util.Date;

public class Staff {
    private Integer staffId;

    private String staffName; // 姓名

    private String sex; // 性别

    private String staffCode; // 员工代码

    private Date birthday; // 出生日期

    private String job; // 职务

    private Date officeTime; // 任职时间

    private Date professionalTitle; // 职称

    private Date appointmentTime;  // 聘任时间

    private Date fullTimeCollegeTime;  // 全日制大中专上学时间

    private Date startWorkTime; // 参加工作时间

    private Date schoolWorkTime; // 到校工作时间

    private String highestDegree;  // 最高学历

    /**
     * 婚姻状况(未婚1  已婚2  离异3  丧偶4)
     */
    private Integer maritalStatus;

    private String phoneNumber; // 联系电话

    private String idCard; // 身份证

    private Date createDate;

    private Date modifyDate;

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Date getOfficeTime() {
        return officeTime;
    }

    public void setOfficeTime(Date officeTime) {
        this.officeTime = officeTime;
    }

    public Date getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(Date professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Date getFullTimeCollegeTime() {
        return fullTimeCollegeTime;
    }

    public void setFullTimeCollegeTime(Date fullTimeCollegeTime) {
        this.fullTimeCollegeTime = fullTimeCollegeTime;
    }

    public Date getStartWorkTime() {
        return startWorkTime;
    }

    public void setStartWorkTime(Date startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public Date getSchoolWorkTime() {
        return schoolWorkTime;
    }

    public void setSchoolWorkTime(Date schoolWorkTime) {
        this.schoolWorkTime = schoolWorkTime;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree == null ? null : highestDegree.trim();
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}