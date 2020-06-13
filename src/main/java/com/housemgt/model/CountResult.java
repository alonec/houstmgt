package com.housemgt.model;

import java.util.Date;

public class CountResult {
    private Integer id;

    private String staffCode; // 员工代码

    private String staffName; // 员工姓名

    private String college; // 单位

    private String highestDegree; // 最高学历

    private String job; // 职称

    private String sex; // 性别

    private Date birthday; // 生日

    private Date fullTimeCollegeTime; // 全日制大中专上学时间

    private Date startWorkTime; // 参加工作时间

    private Date schoolWorkTime; // 到校工作时间

    private String jobBaseGrade; // 职务职称基础分

    private Date timeInJob; // 职务职称任职时间

    private String timeInJobCount; // 职称任职年限

    private String timeInJobCountGrade; // 职称任职年限分

    private Date doctoralDegreeGetTime; // 博士学历学位获得时间 .....不取

    private String lengthOfServiceGrade; // 分房工龄分

    private String ageDivisionGrade; // 校龄分

    private String awardGrade; // 奖励分

    private String depedndentOfMartyrsGrade; // 配偶烈属分

    private String returnedOverseasGrade; // 归侨分

    private String onlyChildGrade; // 独生子女分

    private String dualEmployeeSpouseGrade; // 双职工配偶分

    private String totalGrade; // 综合积分

    private Integer showTimes; // 公示次数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode == null ? null : staffCode.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree == null ? null : highestDegree.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getJobBaseGrade() {
        return jobBaseGrade;
    }

    public void setJobBaseGrade(String jobBaseGrade) {
        this.jobBaseGrade = jobBaseGrade == null ? null : jobBaseGrade.trim();
    }

    public Date getTimeInJob() {
        return timeInJob;
    }

    public void setTimeInJob(Date timeInJob) {
        this.timeInJob = timeInJob;
    }

    public String getTimeInJobCount() {
        return timeInJobCount;
    }

    public void setTimeInJobCount(String timeInJobCount) {
        this.timeInJobCount = timeInJobCount == null ? null : timeInJobCount.trim();
    }

    public String getTimeInJobCountGrade() {
        return timeInJobCountGrade;
    }

    public void setTimeInJobCountGrade(String timeInJobCountGrade) {
        this.timeInJobCountGrade = timeInJobCountGrade == null ? null : timeInJobCountGrade.trim();
    }

    public Date getDoctoralDegreeGetTime() {
        return doctoralDegreeGetTime;
    }

    public void setDoctoralDegreeGetTime(Date doctoralDegreeGetTime) {
        this.doctoralDegreeGetTime = doctoralDegreeGetTime;
    }

    public String getLengthOfServiceGrade() {
        return lengthOfServiceGrade;
    }

    public void setLengthOfServiceGrade(String lengthOfServiceGrade) {
        this.lengthOfServiceGrade = lengthOfServiceGrade == null ? null : lengthOfServiceGrade.trim();
    }

    public String getAgeDivisionGrade() {
        return ageDivisionGrade;
    }

    public void setAgeDivisionGrade(String ageDivisionGrade) {
        this.ageDivisionGrade = ageDivisionGrade == null ? null : ageDivisionGrade.trim();
    }

    public String getAwardGrade() {
        return awardGrade;
    }

    public void setAwardGrade(String awardGrade) {
        this.awardGrade = awardGrade == null ? null : awardGrade.trim();
    }

    public String getDepedndentOfMartyrsGrade() {
        return depedndentOfMartyrsGrade;
    }

    public void setDepedndentOfMartyrsGrade(String depedndentOfMartyrsGrade) {
        this.depedndentOfMartyrsGrade = depedndentOfMartyrsGrade == null ? null : depedndentOfMartyrsGrade.trim();
    }

    public String getReturnedOverseasGrade() {
        return returnedOverseasGrade;
    }

    public void setReturnedOverseasGrade(String returnedOverseasGrade) {
        this.returnedOverseasGrade = returnedOverseasGrade == null ? null : returnedOverseasGrade.trim();
    }

    public String getOnlyChildGrade() {
        return onlyChildGrade;
    }

    public void setOnlyChildGrade(String onlyChildGrade) {
        this.onlyChildGrade = onlyChildGrade == null ? null : onlyChildGrade.trim();
    }

    public String getDualEmployeeSpouseGrade() {
        return dualEmployeeSpouseGrade;
    }

    public void setDualEmployeeSpouseGrade(String dualEmployeeSpouseGrade) {
        this.dualEmployeeSpouseGrade = dualEmployeeSpouseGrade == null ? null : dualEmployeeSpouseGrade.trim();
    }

    public String getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(String totalGrade) {
        this.totalGrade = totalGrade == null ? null : totalGrade.trim();
    }

    public Integer getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(Integer showTimes) {
        this.showTimes = showTimes;
    }
}