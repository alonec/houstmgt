package com.housemgt.dao;

import com.housemgt.model.Building;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

//楼宇信息
@Mapper
@Repository
public interface BuildingDao {
    String TABLE_NAME = "building";//表名

    String INSET_FIELDS = "buildingNumber,buildingName,structureType,mainBody,coveredArea," +
            "price,startTime,endTime,projectedArea,investmentChannel,floornumber,elementnumber," +
            "communityName,location,buildingStructPicture,buildingHousemNumber,buildingKeeping," +
            "buildingSecurity,propertyManager";

    //添加操作
    @Insert({"insert into",TABLE_NAME,"(",INSET_FIELDS,") values (#{buildingNumber},#{buildingName}," +
            "#{structureType},#{mainBody},#{coveredArea},#{price},#{startTime},#{endTime},#{projectedArea}," +
            "#{investmentChannel},#{floornumber},#{elementnumber},#{communityName},#{location}," +
            "#{buildingStructPicture},#{buildingHousemNumber},#{buildingKeeping},#{buildingSecurity}" +
            ",#{propertyManager})" })
    void addBuilding(Building building);
    //删除楼宇操作
    @Delete({"delete from",TABLE_NAME,"where buildingNumber=#{buildingNumber} and buildingName=#{buildingName} "})
    void deleteBuilding(@Param("buildingNumber") String buildingNumber, @Param("buildingName") String buildingName);

    //删除所有楼宇操作
    @Delete({"delete from",TABLE_NAME,"where communityName=#{communityName}  "})
    void deleteAllBuilding(@Param("communityName") String communityName);

    @Update({"update",TABLE_NAME,"set structureType=#{structureType},mainBody=#{mainBody},coveredArea=#{coveredArea},pri" +
            "ce=#{price},startTime=#{startTime},endTime=#{endTime},projectedArea=#{projectedArea},investmentChannel=#{in" +
            "vestmentChannel},floornumber=#{floornumber},elementnumber=#{elementnumber},communityName=#{communityName},l" +
            "ocation=#{location},buildingStructPicture=#{buildingStructPicture},buildingHousemNumber=#{buildingHousemNum" +
            "ber},buildingKeeping=#{buildingKeeping},buildingSecurity=#{buildingSecurity},propertyManager=#{propertyMana" +
            "ger} where buildingNumber=#{buildingNumber} and buildingName=#{buildingName}"})
    void updateBuilding(Building building);
}
