package com.housemgt.Dao;

import com.housemgt.model.Building;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
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
    @Delete({"delete from",TABLE_NAME,"where buildingNumber=#{arg0} and buildingName=#{arg1} "})
    void deleteBuilding(String buildingNumber, String buildingName);

    //删除所有楼宇操作
    @Delete({"delete from",TABLE_NAME,"where communityName=#{arg0}  "})
    void deleteAllBuilding(String communityName);

    @Update({"update",TABLE_NAME,"set structureType=#{structureType},mainBody=#{mainBody},coveredArea=#{coveredArea},pri" +
            "ce=#{price},startTime=#{startTime},endTime=#{endTime},projectedArea=#{projectedArea},investmentChannel=#{in" +
            "vestmentChannel},floornumber=#{floornumber},elementnumber=#{elementnumber},communityName=#{communityName},l" +
            "ocation=#{location},buildingStructPicture=#{buildingStructPicture},buildingHousemNumber=#{buildingHousemNum" +
            "ber},buildingKeeping=#{buildingKeeping},buildingSecurity=#{buildingSecurity},propertyManager=#{propertyMana" +
            "ger} where buildingNumber=#{buildingNumber} and buildingName=#{buildingName}"})
    void updateBuilding(Building building);
}
