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
    @Delete({"delete from",TABLE_NAME,"where elementNumber=#{elementNumber} and houseNumber=#{houseNumber} "})
    void deleteHome(@Param("elementNumber") String elementNumber, @Param("houseNumber") String houseNumber);

    //删除所有房间操作
    @Delete({"delete from",TABLE_NAME,"where elementNumber=#{elementNumber}"})
    void deleteAllHome(@Param("elementNumber") String elementNumber);

    //更新房屋信息
    @Update({"update",TABLE_NAME,"set houseType=#{houseType},houseArea=#{houseArea},housePicture=#{housePicture},status=" +
            "#{status},householderId=#{householderId},residentsToChange=#{residentsToChange},infrastructureChanges=#{inf" +
            "rastructureChanges},structuremodify=#{structuremodify} where elementNumber=#{elementNumber} and houseNumber" +
            "=#{houseNumber}"})
    void updateMessage(Home home);
    //根据房屋状态查看房屋使用情况
    @Select({"select",INSET_FIELDS,"from",TABLE_NAME,"where status= #{status}"})
    List<Home> getHomeByStatus(@Param("status") int status);

    //查看房屋使用状态
    @Select({"select",SELECT_HOME,"from",TABLE_NAME,"where elementNumber=#{elementNumber} and houseNumber=#{houseNumber}"})
    String  getStatusByHome(@Param("elementNumber") String elementNumber, @Param("houseNumber") String houseNumber);

    //更新房屋最新的变更记录
    @Update({"update",TABLE_NAME,"set residentsToChange =#{residentsToChange},infrastructureChanges = #{infrastructureChanges},structuremodify=#{structuremodify}" +
            " where elementNumber=#{elementNumber} and houseNumber=#{houseNumber}"})
    void updateHomeHistory(@Param("residentsToChange") String residentsToChange,@Param("infrastructureChanges") String infrastructureChanges, @Param("structuremodify") String structuremodify, @Param("elementNumber") String elementNumber, @Param("houseNumber") String houseNumber);
    // update home set residentsToChange ='1',infrastructureChanges= '2',structuremodify='3'where elementNumber='一单元' and houseNumber='32434';

    //更新房屋状态
    @Update({"update",TABLE_NAME,"set status =#{status} where elementNumber=#{elementNumber} and houseNumber=#{houseNumber}"})
    void updateHomeStatus(@Param("status") int status, @Param("elementNumber") String elementNumber, @Param("houseNumber") String houseNumber);

}


