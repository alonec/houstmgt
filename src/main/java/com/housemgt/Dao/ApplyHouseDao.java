package com.housemgt.Dao;


import com.housemgt.model.Apply;
import com.housemgt.model.ApplyPart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ApplyHouseDao {

    String TABLE_NAME = "apply_house";
    String INSET_FIELDS = "name,sex,staffCode,birthdate,postsHeld,timeInJob,appointmentTime,startingDates,timeToWork,tim" +
            "eToSchool,officialAcademicCredentials,marriage,linkNum,idCardNo,areaOfStructureNow,statusNow,addressNow,typ" +
            "e,spouseName,spouseBirthdate,spouseWorkUnit,spousePostsHeld,twoStaffCode,spouseIdCardNo,spouseAreaOfStructu" +
            "re,spouseStatus,spouseHousingMonetizationSubsidies,spouseAddress,result,approvalOpinion,approvalTime,approv" +
            "alPerson,awardGrade,returnedOverseas,depedndentOfMartyrs,onlyChild,dualEmployeeSpouse,unit,tag";
    String SET_UPDATE = "set sex=#{sex},birthdate=#{birthdate},postsHeld=#{postsHeld},timeInJob=#{timeInJob},appointmentT" +
            "ime=#{appointmentTime},startingDates=#{startingDates},timeToWork=#{timeToWork},timeToSchool=#{timeToSchool}" +
            ",officialAcademicCredentials=#{officialAcademicCredentials},marriage=#{marriage},linkNum=#{linkNum},idCardN" +
            "o=#{idCardNo},areaOfStructureNow=#{areaOfStructureNow},statusNow=#{statusNow},addressNow=#{addressNow},type" +
            "=#{type},spouseName=#{spouseName},spouseBirthdate=#{spouseBirthdate},spouseWorkUnit=#{spouseWorkUnit},spous" +
            "ePostsHeld=#{spousePostsHeld},twoStaffCode=#{twoStaffCode},spouseIdCardNo=#{spouseIdCardNo},spouseAreaOfStr" +
            "ucture=#{spouseAreaOfStructure},spouseStatus=#{spouseStatus},spouseHousingMonetizationSubsidies=#{spouseHou" +
            "singMonetizationSubsidies},spouseAddress=#{spouseAddress},result=#{result},approvalOpinion=#{approvalOpinio" +
            "n},approvalTime=#{approvalTime},approvalPerson=#{approvalPerson},awardGrade=#{awardGrade},returnedOverseas=" +
            "#{returnedOverseas},depedndentOfMartyrs=#{depedndentOfMartyrs},onlyChild=#{onlyChild},dualEmployeeSpouse=#{" +
            "dualEmployeeSpouse},unit = #{unit},tag = #{tag}";
    String IN_NAME = " (#{name},#{sex},#{staffCode},#{birthdate},#{postsHeld},#{timeInJob},#{appointmentTime},#{starting" +
            "Dates},#{timeToWork},#{timeToSchool},#{officialAcademicCredentials},#{marriage},#{linkNum},#{idCardNo},#{ar" +
            "eaOfStructureNow},#{statusNow},#{addressNow},#{type},#{spouseName},#{spouseBirthdate},#{spouseWorkUnit},#{s" +
            "pousePostsHeld},#{twoStaffCode},#{spouseIdCardNo},#{spouseAreaOfStructure},#{spouseStatus},#{spouseHousingM" +
            "onetizationSubsidies},#{spouseAddress},3,#{approvalOpinion},#{approvalTime},#{approvalPerson},#{awa" +
            "rdGrade},#{returnedOverseas},#{depedndentOfMartyrs},#{onlyChild},#{dualEmployeeSpouse},#{unit},#{tag})";
    String INSET_FIELDS1 = "name,staffCode";


    //提交申请操作
    @Insert({"insert into",TABLE_NAME,"(",INSET_FIELDS,") values",IN_NAME })
    void addApply(Apply apply);

    //修改个人申请操作
    @Update({"update",TABLE_NAME,SET_UPDATE,"where name=#{name} and staffCode = #{staffCode}"})
    void updateApply(Apply apply);

    //撤销个人申请操作
    @Delete({"delete from",TABLE_NAME,"where name=#{arg0} and staffCode=#{arg1} "})
    void deleteSelfApply(String name, String staffCode);


    //查询所有常规申请
    @Select({"select count(*) from",TABLE_NAME,"where tag=0 "})
    int getAllApplyNum();
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where tag=1 limit #{page} ,10 "})
    List<Apply> getAllApply(int page);

    //查询所有即时申请
    @Select({"select count(*) from",TABLE_NAME,"where tag=0 "})
    int getAllApplyNumNow();
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where tag=0 limit #{page},10 "})
    List<Apply> getAllApplyNow(int page);

    //管理员查询所有常规通过操作
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where result = #{arg0}  "})
    List<Apply> getResultApply(int result);

    //查询本人的申请信息
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where name = #{arg0} and staffCode=#{arg1}"})
    List<Apply> getSelfApply(String name,String staffCode);

    //查询已审核常规的
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME," where result  >1 and tag=1"})
    List<Apply> getYesApply();

    //查询未审核常规
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where result  >1 and tag=1"})
    List<Apply> getNoApply();
    //查询已审核即时的
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME," where result  >1 and tag=0"})
    List<Apply> getYesApplyNow();

    //查询未审核即时
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where result >1 and tag=0"})
    List<Apply> getNoApplyNow();

    //更新审核状态
    @Update({"update",TABLE_NAME,"set result =#{arg2},approvalOpinion=#{arg3},approvalTime=#{arg4},approvalPerson=#{arg5} where name=#{arg0} and staffCode=#{arg1}"})
    void updateApplyResult(String name, String staffCode, int result, String approvalOpinion, Date approvalTime, String approvalPerson);


    //查看详情页
    @Select({"select",INSET_FIELDS,"from",TABLE_NAME,"where name= #{arg0} and staffCode=#{arg1}"})
    List<Apply> getYesApplyByName(String name,String  staffCode);


    //查询已审核常规的
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME," where result  <2 and tag=1"})
    List<ApplyPart> getYesApplyF();

    //查询未审核常规
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where result  =3 and tag=1"})
    List<ApplyPart> getNoApplyF();
    //查询已审核即时的
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME," where result  <2 and tag=0"})
    List<ApplyPart> getYesApplyNowF();

    //查询未审核即时
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"where result =3 and tag=0"})
    List<ApplyPart> getNoApplyNowF();


}

