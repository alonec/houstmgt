package com.housemgt.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Apply {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "sex")
    private String sex;
    @JsonProperty(value = "staffCode")
    private String staffCode;
    @JsonProperty(value = "birthdate")
    private Date birthdate;
    @JsonProperty(value = "postsHeld")
    private String postsHeld;
    @JsonProperty(value = "timeInJob")
    private Date timeInJob;
    @JsonProperty(value = "appointmentTime")
    private Date appointmentTime;
    @JsonProperty(value = "startingDates")
    private Date startingDates;
    @JsonProperty(value = "timeToWork")
    private Date timeToWork;
    @JsonProperty(value = "timeToSchool")
    private Date timeToSchool;
    @JsonProperty(value = "officialAcademicCredentials")
    private String officialAcademicCredentials;
    @JsonProperty(value = "marriage")
    private String marriage;
    @JsonProperty(value = "linkNum")
    private String linkNum;
    @JsonProperty(value = "idCardNo")
    private String idCardNo;
    @JsonProperty(value = "areaOfStructureNow")
    private String areaOfStructureNow;
    @JsonProperty(value = "statusNow")
    private String statusNow;
    @JsonProperty(value = "addressNow")
    private String addressNow;
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "spouseName")
    private String spouseName;
    @JsonProperty(value = "spouseBirthdate")
    private Date spouseBirthdate;
    @JsonProperty(value = "spouseWorkUnit")
    private String spouseWorkUnit;
    @JsonProperty(value = "spousePostsHeld")
    private String spousePostsHeld;
    @JsonProperty(value = "twoStaffCode")
    private String twoStaffCode;
    @JsonProperty(value = "spouseIdCardNo")
    private String spouseIdCardNo;
    @JsonProperty(value = "spouseAreaOfStructure")
    private String spouseAreaOfStructure;
    @JsonProperty(value = "spouseStatus")
    private String spouseStatus;
    @JsonProperty(value = "spouseHousingMonetizationSubsidies")
    private String spouseHousingMonetizationSubsidies;
    @JsonProperty(value = "spouseAddress")
    private String spouseAddress;
    @JsonProperty(value = "result")
    private int result;
    @JsonProperty(value = "approvalOpinion")
    private String approvalOpinion;
    @JsonProperty(value = "approvalTime")
    private Date approvalTime;
    @JsonProperty(value = "approvalPerson")
    private String approvalPerson;
    @JsonProperty(value = "awardGrade")
    private String awardGrade;
    @JsonProperty(value = "returnedOverseas")
    private String returnedOverseas;
    @JsonProperty(value = "depedndentOfMartyrs")
    private String depedndentOfMartyrs;
    @JsonProperty(value = "onlyChild")
    private  String onlyChild;
    @JsonProperty(value = "dualEmployeeSpouse")
    private String dualEmployeeSpouse;
    @JsonProperty(value = "unit")
    private String unit;
    @JsonProperty(value = "tag")
    private int tag;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getAwardGrade() {
        return awardGrade;
    }

    public void setAwardGrade(String awardGrade) {
        this.awardGrade = awardGrade;
    }

    public String getReturnedOverseas() {
        return returnedOverseas;
    }

    public void setReturnedOverseas(String returnedOverseas) {
        this.returnedOverseas = returnedOverseas;
    }

    public String getDepedndentOfMartyrs() {
        return depedndentOfMartyrs;
    }

    public void setDepedndentOfMartyrs(String depedndentOfMartyrs) {
        this.depedndentOfMartyrs = depedndentOfMartyrs;
    }

    public String getOnlyChild() {
        return onlyChild;
    }

    public void setOnlyChild(String onlyChild) {
        this.onlyChild = onlyChild;
    }

    public String getDualEmployeeSpouse() {
        return dualEmployeeSpouse;
    }

    public void setDualEmployeeSpouse(String dualEmployeeSpouse) {
        this.dualEmployeeSpouse = dualEmployeeSpouse;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public Date getBirthdate() {

        //return birthdate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化规则
        Date date = birthdate;         //获得你要处理的时间 Date型
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

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPostsHeld() {
        return postsHeld;
    }

    public void setPostsHeld(String postsHeld) {
        this.postsHeld = postsHeld;
    }

    public Date getTimeInJob() {

        //return timeInJob;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化规则
        Date date = timeInJob;         //获得你要处理的时间 Date型
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

    public void setTimeInJob(Date timeInJob) {
        this.timeInJob = timeInJob;
    }

    public Date getAppointmentTime() {

        //return appointmentTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化规则
        Date date = appointmentTime;         //获得你要处理的时间 Date型
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

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Date getStartingDates() {


        //return startingDates;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化规则
        Date date = startingDates;         //获得你要处理的时间 Date型
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


    public void setStartingDates(Date startingDates) {
        this.startingDates = startingDates;
    }

    public Date getTimeToWork() {

        //return timeToWork;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化规则
        Date date = timeToWork;         //获得你要处理的时间 Date型
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

    public void setTimeToWork(Date timeToWork) {
        this.timeToWork = timeToWork;
    }

    public Date getTimeToSchool() {

        //return timeToSchool;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化规则
        Date date = timeToSchool;         //获得你要处理的时间 Date型
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

    public void setTimeToSchool(Date timeToSchool) {
        this.timeToSchool = timeToSchool;
    }

    public String getOfficialAcademicCredentials() {
        return officialAcademicCredentials;
    }

    public void setOfficialAcademicCredentials(String officialAcademicCredentials) {
        this.officialAcademicCredentials = officialAcademicCredentials;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getLinkNum() {
        return linkNum;
    }

    public void setLinkNum(String linkNum) {
        this.linkNum = linkNum;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getAreaOfStructureNow() {
        return areaOfStructureNow;
    }

    public void setAreaOfStructureNow(String areaOfStructureNow) {
        this.areaOfStructureNow = areaOfStructureNow;
    }

    public String getStatusNow() {
        return statusNow;
    }

    public void setStatusNow(String statusNow) {
        this.statusNow = statusNow;
    }

    public String getAddressNow() {
        return addressNow;
    }

    public void setAddressNow(String addressNow) {
        this.addressNow = addressNow;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public Date getSpouseBirthdate() {

        //return spouseBirthdate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化规则
        Date date = spouseBirthdate;         //获得你要处理的时间 Date型
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

    public void setSpouseBirthdate(Date spouseBirthdate) {
        this.spouseBirthdate = spouseBirthdate;
    }

    public String getSpouseWorkUnit() {
        return spouseWorkUnit;
    }

    public void setSpouseWorkUnit(String spouseWorkUnit) {
        this.spouseWorkUnit = spouseWorkUnit;
    }

    public String getSpousePostsHeld() {
        return spousePostsHeld;
    }

    public void setSpousePostsHeld(String spousePostsHeld) {
        this.spousePostsHeld = spousePostsHeld;
    }

    public String getTwoStaffCode() {
        return twoStaffCode;
    }

    public void setTwoStaffCode(String twoStaffCode) {
        this.twoStaffCode = twoStaffCode;
    }

    public String getSpouseIdCardNo() {
        return spouseIdCardNo;
    }

    public void setSpouseIdCardNo(String spouseIdCardNo) {
        this.spouseIdCardNo = spouseIdCardNo;
    }

    public String getSpouseAreaOfStructure() {
        return spouseAreaOfStructure;
    }

    public void setSpouseAreaOfStructure(String spouseAreaOfStructure) {
        this.spouseAreaOfStructure = spouseAreaOfStructure;
    }

    public String getSpouseStatus() {
        return spouseStatus;
    }

    public void setSpouseStatus(String spouseStatus) {
        this.spouseStatus = spouseStatus;
    }

    public String getSpouseHousingMonetizationSubsidies() {
        return spouseHousingMonetizationSubsidies;
    }

    public void setSpouseHousingMonetizationSubsidies(String spouseHousingMonetizationSubsidies) {
        this.spouseHousingMonetizationSubsidies = spouseHousingMonetizationSubsidies;
    }

    public String getSpouseAddress() {
        return spouseAddress;
    }

    public void setSpouseAddress(String spouseAddress) {
        this.spouseAddress = spouseAddress;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public Date getApprovalTime() {

        //return approvalTime;
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

    public String getApprovalPerson() {
        return approvalPerson;
    }

    public void setApprovalPerson(String approvalPerson) {
        this.approvalPerson = approvalPerson;
    }
}
