package com.housemgt.Dao;

//房屋信息

import com.housemgt.model.Home;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HomeDao {
    String TABLE_NAME = "home";//表名

    String INSET_FIELDS = "elementNumber,houseNumber,houseType,houseArea,housePicture,status,householderId,residentsToChange,infrastructureChanges,structuremodify";

    String SELECT_HOME = "status";
    //添加操作
    @Insert({"insert into",TABLE_NAME,"(",INSET_FIELDS,") values (#{elementNumber},#{houseNumber},#{houseType},#{houseArea},#{housePicture},#{status},#{householderId},#{residentsToChange},#{infrastructureChanges},#{structuremodify})" })
    void addHome(Home home);

    //删除操作
    @Delete({"delete from",TABLE_NAME,"where elementNumber=#{arg0} and houseNumber=#{arg1} "})
    void deleteHome(String elementNumber, String houseNumber);

    //删除所有房间操作
    @Delete({"delete from",TABLE_NAME,"where elementNumber=#{arg0}"})
    void deleteAllHome(String elementNumber);

    //更新房屋信息
    @Update({"update",TABLE_NAME,"set houseType=#{houseType},houseArea=#{houseArea},housePicture=#{housePicture},status=" +
            "#{status},householderId=#{householderId},residentsToChange=#{residentsToChange},infrastructureChanges=#{inf" +
            "rastructureChanges},structuremodify=#{structuremodify} where elementNumber=#{elementNumber} and houseNumber" +
            "=#{houseNumber}"})
    void updateMessage(Home home);
    //根据房屋状态查看房屋使用情况
    @Select({"select",INSET_FIELDS,"from",TABLE_NAME,"where status= #{arg0}"})
    List<Home> getHomeByStatus(int status);

    //查看房屋使用状态
    @Select({"select",SELECT_HOME,"from",TABLE_NAME,"where elementNumber=#{arg0} and houseNumber=#{arg1}"})
    String  getStatusByHome(String elementNumber, String houseNumber);

    //更新房屋最新的变更记录
    @Update({"update",TABLE_NAME,"set residentsToChange =#{arg0},infrastructureChanges = #{arg1},structuremodify=#{arg2}" +
            " where elementNumber=#{arg3} and houseNumber=#{arg4}"})
    void updateHomeHistory(String residentsToChange, String infrastructureChanges, String structuremodify, String elementNumber, String houseNumber);
    // update home set residentsToChange ='1',infrastructureChanges= '2',structuremodify='3'where elementNumber='一单元' and houseNumber='32434';

    //更新房屋状态
    @Update({"update",TABLE_NAME,"set status =#{arg0} where elementNumber=#{arg3} and houseNumber=#{arg4}"})
    void updateHomeStatus(int status, String elementNumber, String houseNumber);

}


