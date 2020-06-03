package com.housemgt.Dao;


import com.housemgt.model.Apply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApplyHouseDao {

    String TABLE_NAME = "apply_house";
    String INSET_FIELDS = "name,sex,staffCode,birthdate,postsHeld,timeInJob,appointmentTime,startingDates,timeToWork,tim" +
            "eToSchool,officialAcademicCredentials,marriage,linkNum,idCardNo,areaOfStructureNow,statusNow,addressNow,typ" +
            "e,spouseName,spouseBirthdate,spouseWorkUnit,spousePostsHeld,twoStaffCode,spouseIdCardNo,spouseAreaOfStructu" +
            "re,spouseStatus,spouseHousingMonetizationSubsidies,spouseAddress,result,approvalOpinion,approvalTime,approv" +
            "alPerson";
    String SET_UPDATE = "set sex=#{sex},birthdate=#{birthdate},postsHeld=#{postsHeld},timeInJob=#{timeInJob},appointmentT" +
            "ime=#{appointmentTime},startingDates=#{startingDates},timeToWork=#{timeToWork},timeToSchool=#{timeToSchool}" +
            ",officialAcademicCredentials=#{officialAcademicCredentials},marriage=#{marriage},linkNum=#{linkNum},idCardN" +
            "o=#{idCardNo},areaOfStructureNow=#{areaOfStructureNow},statusNow=#{statusNow},addressNow=#{addressNow},type" +
            "=#{type},spouseName=#{spouseName},spouseBirthdate=#{spouseBirthdate},spouseWorkUnit=#{spouseWorkUnit},spous" +
            "ePostsHeld=#{spousePostsHeld},twoStaffCode=#{twoStaffCode},spouseIdCardNo=#{spouseIdCardNo},spouseAreaOfStr" +
            "ucture=#{spouseAreaOfStructure},spouseStatus=#{spouseStatus},spouseHousingMonetizationSubsidies=#{spouseHou" +
            "singMonetizationSubsidies},spouseAddress=#{spouseAddress},result=#{result},approvalOpinion=#{approvalOpinio" +
            "n},approvalTime=#{approvalTime},approvalPerson=#{approvalPerson}";

    //提交申请操作
    @Insert({"insert into",TABLE_NAME,"(",INSET_FIELDS,") values (#{name},#{sex},#{staffCode},#{birthdate},#{postsHeld}," +
            "#{timeInJob},#{appointmentTime},#{startingDates},#{timeToWork},#{timeToSchool},#{officialAcademicCredential" +
            "s},#{marriage},#{linkNum},#{idCardNo},#{areaOfStructureNow},#{statusNow},#{addressNow},#{type},#{spouseName" +
            "},#{spouseBirthdate},#{spouseWorkUnit},#{spousePostsHeld},#{twoStaffCode},#{spouseIdCardNo},#{spouseAreaOfS" +
            "tructure},#{spouseStatus},#{spouseHousingMonetizationSubsidies},#{spouseAddress},#{result},#{approvalOpinio" +
            "n},#{approvalTime},#{approvalPerson})" })
    void addApply(Apply apply);

    //修改申请操作
    @Update({"update",TABLE_NAME,SET_UPDATE,"where name=#{name} and staffCode = #{staffCode}"})
    void updateApply(Apply apply);

    //撤销申请操作
    @Delete({"delete  from",TABLE_NAME,"where name = #{arg0} and staffCode=#{staffCode}"})
    void deleteApply(String name, String staffCode);

    //查询所有申请
    @Select({"select count(*) from",TABLE_NAME})
    int getAllApplyNum();
    @Select({"select ",INSET_FIELDS,"from",TABLE_NAME,"limit #{page},10"})
    List<Apply> getAllApply(int page);
}

