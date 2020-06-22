package com.housemgt.Dao;

import com.housemgt.model.Building;
import com.housemgt.model.Community;
import com.housemgt.model.Element;
import com.housemgt.model.Home;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GetMessageDao {


    String HOME_TABLE_NAME = "home";
    String COMMUNITY_TABLE_NAME = "community";
    String BUILDING_TABLE_NAME = "building";
    String ELEMENT_TABLE_NAME = "element";//表名

    String ELEMENTINSET_FIELDS = "buildingNumber,elementNumber,floorNumber,households,elevatorstatus,elementPicture";
    String BUILDING_INSET_FIELDS = "buildingNumber,buildingName,structureType,mainBody,coveredArea," +
            "price,startTime,endTime,projectedArea,investmentChannel,floornumber,elementnumber," +
            "communityName,location,buildingStructPicture,buildingHousemNumber,buildingKeeping," +
            "buildingSecurity,propertyManager";
    String COMMUNITY_INSET_FIELDS = "name,doorNumber,mailingAddress,postcode,linkman,phoneNumber,policeStation,policeman,policePhonenum,buildingPicture";
    String HOME_INSET_FIELDS = "elementNumber,houseNumber,houseType,houseArea,housePicture,status,householderId,residentsToChange,infrastructureChanges,structuremodify";

    //根据小区名称查询小区
    @Select({"select",COMMUNITY_INSET_FIELDS,"from",COMMUNITY_TABLE_NAME,"where name = #{name}"})
    List<Community> getCommunityByName(@Param("name") String name);
    //根据楼宇名称查询楼宇
    @Select({"select",BUILDING_INSET_FIELDS,"from",BUILDING_TABLE_NAME,"where buildingName= #{buildingName}"})
    List<Building> getBuildingByName(@Param("buildingName") String buildingName);
    //根据单元编号查询单元
    @Select({"select",ELEMENTINSET_FIELDS,"from",ELEMENT_TABLE_NAME,"where elementNumber= #{elementNumber}"})
    List<Element> getElementByNum(@Param("elementNumber") String elementNumber);
    //根据房间号查询房屋
    @Select({"select",HOME_INSET_FIELDS,"from",HOME_TABLE_NAME,"where houseNumber= #{houseNumber}"})
    List<Home> getHomeByNum(@Param("houseNumber") String houseNumber);


    //根据小区名称查询楼宇
    @Select({"select",BUILDING_INSET_FIELDS,"from",BUILDING_TABLE_NAME,"where communityName =#{name}"})
    List<Building> getBuildingByCommunityName(@Param("name") String name);
    //根据楼宇名称查询单元
    @Select({"select",ELEMENTINSET_FIELDS,"from",ELEMENT_TABLE_NAME,"where buildingNumber  =#{buildingName}"})
    List<Element> getElementByBuildingNum(@Param("buildingName") String buildingName);
    //根据单元名称查询房屋
    @Select({"select",HOME_INSET_FIELDS,"from",HOME_TABLE_NAME,"where elementNumber = #{elementNumber}"})
    List<Home> getHomeByElementNum(@Param("elementNumber") String elementNumber);

    //查询同一楼宇下的所有单元
    //select * from element where buildingNumber = any(select buildingNumber from building where buildingNumber ='1');
    //@Select({"select",EL})
    //List<Element> getElementByBuildingNum();


//    //首页小区信息获取
//    @Select({"select",COMMUNITY_INSET_FIELDS,"from",COMMUNITY_TABLE_NAME,"limit 10"})
//    List<Community> getFirstCommunity ();
//    //首页楼宇信息获取
//    @Select({"select",BUILDING_INSET_FIELDS,"from",BUILDING_TABLE_NAME,"limit 10" })
//    List<Building> getFirstBuilding();
//    //首页单元信息获取
//    @Select({"select",ELEMENTINSET_FIELDS,"from",ELEMENT_TABLE_NAME,"limit 10"})
//    List<Element> getFirstElement();
//    //首页房屋信息展示
//    @Select({"select",HOME_INSET_FIELDS,"from",HOME_TABLE_NAME,"limit 10"})
//    List<Home> getFirstHome();


    //所有小区信息拉取
    @Select({"select count(*) from",COMMUNITY_TABLE_NAME})
    int getAllCommunityNum();
    @Select({"select ",COMMUNITY_INSET_FIELDS,"from",COMMUNITY_TABLE_NAME,"limit #{page},10"})
    // SELECT id FROM '表' WHERE '条件' LIMIT (i-1)*a,a;
    List<Community> getAllCommunity(int page);
    //所有楼宇信息拉取
    @Select({"select count(*) from",BUILDING_TABLE_NAME})
    int getAllBuildingNum();
    @Select({"select ",BUILDING_INSET_FIELDS,"from",BUILDING_TABLE_NAME,"limit #{page},10"})
        // SELECT id FROM '表' WHERE '条件' LIMIT (i-1)*a,a;
    List<Building> getAllBuilding(int page);
    //所有单元信息拉取
    @Select({"select count(*) from",ELEMENT_TABLE_NAME})
    int getAllElementNum();
    @Select({"select ",ELEMENTINSET_FIELDS,"from",ELEMENT_TABLE_NAME,"limit #{page},10"})
        // SELECT id FROM '表' WHERE '条件' LIMIT (i-1)*a,a;
    List<Element> getAllElement(int page);
    //所有房屋信息拉取
    @Select({"select count(*) from",HOME_TABLE_NAME})
    int getAllHomeNum();
    @Select({"select ",HOME_INSET_FIELDS,"from",HOME_TABLE_NAME,"limit #{page},10"})
        // SELECT id FROM '表' WHERE '条件' LIMIT (i-1)*a,a;
    List<Home> getAllHome(int page);
}
