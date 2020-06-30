package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.Building;
import com.housemgt.service.sweeney.BuildingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BuildingController {
    @Autowired
    BuildingService buildingService;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    //添加楼宇
    @RequestMapping(path = {"/addBuilding/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String addBuilding(@RequestParam("buildingNumber") String buildingNumber,
                              @RequestParam("buildingName") String buildingName,
                              @RequestParam("structureType") String structureType,
                              @RequestParam("mainBody") int mainBody,
                              @RequestParam("coveredArea") String coveredArea,
                              @RequestParam("price") String  price,
                              @RequestParam("startTime") String  startTime,
                              @RequestParam("endTime") String  endTime,
                              @RequestParam("projectedArea") String projectedArea,
                              @RequestParam("investmentChannel") String investmentChannel,
                              @RequestParam("floornumber") int floornumber,
                              @RequestParam("elementnumber") int elementnumber,
                              @RequestParam("communityName") String communityName,
                              @RequestParam("location") String location,
                              @RequestParam("buildingStructPicture") String buildingStructPicture,
                              @RequestParam("buildingHousemNumber") int buildingHousemNumber,
                              @RequestParam("buildingKeeping") String buildingKeeping,
                              @RequestParam("buildingSecurity") String buildingSecurity,
                              @RequestParam("propertyManager") String propertyManager

    )  {

        try {
            Building building = new Building();
            building.setBuildingNumber(buildingNumber);
            building.setBuildingName(buildingName);
            building.setStructureType(structureType);
            building.setMainBody(mainBody);
            building.setCoveredArea(coveredArea);
            building.setPrice(price);
            building.setStartTime(startTime);
            building.setEndTime(endTime);
            building.setProjectedArea(projectedArea);
            building.setInvestmentChannel(investmentChannel);
            building.setFloornumber(floornumber);
            building.setElementnumber(elementnumber);
            building.setCommunityName(communityName);
            building.setLocation(location);
            building.setBuildingStructPicture(buildingStructPicture);
            building.setBuildingHousemNumber(buildingHousemNumber);
            building.setBuildingKeeping(buildingKeeping);
            building.setBuildingSecurity(buildingSecurity);
            building.setPropertyManager(propertyManager);
            buildingService.addBuilding(building);

            return HouseUtil.getJSONString(0,"增加楼宇成功");
        }catch (Exception e){
            logger.error("增加楼宇失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"增加楼宇失败!!!");
        }
    }
    //删除楼宇
    @RequestMapping(path = {"/deleteBuilding/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String deleteBuilding(@RequestParam("buildingNumber") String buildingNumber,
                                 @RequestParam("buildingName") String buildingName
    )  {

        try {
            buildingService.deleteBuilding(buildingNumber,buildingName);
            return HouseUtil.getJSONString(0,"删除楼宇成功");
        }catch (Exception e){
            logger.error("删除楼宇失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"删除楼宇失败!!!");
        }
    }

    //更新楼宇信息
    @RequestMapping(path = {"/updateBuildingMessage/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String updateBuildingMessage(@RequestParam("buildingNumber") String buildingNumber,
                              @RequestParam("buildingName") String buildingName,
                              @RequestParam("structureType") String structureType,
                              @RequestParam("mainBody") int mainBody,
                              @RequestParam("coveredArea") String coveredArea,
                              @RequestParam("price") String  price,
                              @RequestParam("startTime") String  startTime,
                              @RequestParam("endTime") String  endTime,
                              @RequestParam("projectedArea") String projectedArea,
                              @RequestParam("investmentChannel") String investmentChannel,
                              @RequestParam("floornumber") int floornumber,
                              @RequestParam("elementnumber") int elementnumber,
                              @RequestParam("communityName") String communityName,
                              @RequestParam("location") String location,
                              @RequestParam("buildingStructPicture") String buildingStructPicture,
                              @RequestParam("buildingHousemNumber") int buildingHousemNumber,
                              @RequestParam("buildingKeeping") String buildingKeeping,
                              @RequestParam("buildingSecurity") String buildingSecurity,
                              @RequestParam("propertyManager") String propertyManager

    )  {

        try {
            Building building = new Building();
            building.setBuildingNumber(buildingNumber);
            building.setBuildingName(buildingName);
            building.setStructureType(structureType);
            building.setMainBody(mainBody);
            building.setCoveredArea(coveredArea);
            building.setPrice(price);
            building.setStartTime(startTime);
            building.setEndTime(endTime);
            building.setProjectedArea(projectedArea);
            building.setInvestmentChannel(investmentChannel);
            building.setFloornumber(floornumber);
            building.setElementnumber(elementnumber);
            building.setCommunityName(communityName);
            building.setLocation(location);
            building.setBuildingStructPicture(buildingStructPicture);
            building.setBuildingHousemNumber(buildingHousemNumber);
            building.setBuildingKeeping(buildingKeeping);
            building.setBuildingSecurity(buildingSecurity);
            building.setPropertyManager(propertyManager);
            buildingService.updateBuilding(building);

            return HouseUtil.getJSONString(0,"更新楼宇信息成功");
        }catch (Exception e){
            logger.error("更新楼宇信息失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"更新楼宇信息失败!!!");
        }
    }
}
