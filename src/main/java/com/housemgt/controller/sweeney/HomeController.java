package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.Home;
import com.housemgt.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    HomeService homeService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //添加房屋
    @RequestMapping(path = {"/addHome/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String addHome(@RequestParam("elementNumber") String elementNumber,
                              @RequestParam("houseNumber") String houseNumber,
                              @RequestParam("houseType") String houseType,
                              @RequestParam("housePicture") String housePicture,
                              @RequestParam("houseArea") double houseArea,
                              @RequestParam("status") int status,
                              @RequestParam("householderId") String householderId,
                              @RequestParam("residentsToChange") String residentsToChange,
                              @RequestParam("infrastructureChanges") String infrastructureChanges,
                              @RequestParam("structuremodify") String structuremodify
                              )  {

        try {
            Home home = new Home();
            home.setElementNumber(elementNumber);
            home.setHouseNumber(houseNumber);
            home.setHouseType(houseType);
            home.setHousePicture(housePicture);
            home.setHouseArea(houseArea);
            home.setStatus(status);
            home.setHouseholderId(householderId);
            home.setResidentsToChange(residentsToChange);
            home.setInfrastructureChanges(infrastructureChanges);
            home.setStructuremodify(structuremodify);
            homeService.addHome(home);

            return HouseUtil.getJSONString(0,"增加房源成功");
        }catch (Exception e){
            logger.error("增加房源失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"增加房源失败!!!");
        }
    }

    //删除房屋
    @RequestMapping(path = {"/deleteHome/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String deleteHome(@RequestParam("elementNumber") String elementNumber,
                          @RequestParam("houseNumber") String houseNumber

    )  {

        try {
            homeService.deleteHome(elementNumber,houseNumber);
            return HouseUtil.getJSONString(0,"删除房源成功");
        }catch (Exception e){
            logger.error("删除房源失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"删除房源失败!!!");
        }
    }

    //更新房屋信息
    @RequestMapping(path = {"/updateHomeMessage/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String updateHomeMessage(@RequestParam("elementNumber") String elementNumber,
                          @RequestParam("houseNumber") String houseNumber,
                          @RequestParam("houseType") String houseType,
                          @RequestParam("housePicture") String housePicture,
                          @RequestParam("houseArea") double houseArea,
                          @RequestParam("status") int status,
                          @RequestParam("householderId") String householderId,
                          @RequestParam("residentsToChange") String residentsToChange,
                          @RequestParam("infrastructureChanges") String infrastructureChanges,
                          @RequestParam("structuremodify") String structuremodify
    )  {

        try {
            Home home = new Home();
            home.setElementNumber(elementNumber);
            home.setHouseNumber(houseNumber);
            home.setHouseType(houseType);
            home.setHousePicture(housePicture);
            home.setHouseArea(houseArea);
            home.setStatus(status);
            home.setHouseholderId(householderId);
            home.setResidentsToChange(residentsToChange);
            home.setInfrastructureChanges(infrastructureChanges);
            home.setStructuremodify(structuremodify);
            homeService.updateHome(home);

            return HouseUtil.getJSONString(0,"更新房源信息成功");
        }catch (Exception e){
            logger.error("更新房源信息失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"更新房源信息失败!!!");
        }
    }


    //根据房屋状态查看房屋使用情况
    @RequestMapping(path = {"/getHomeByStatus/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Home> getHomeByStatus(
                             @RequestParam("status") int status
    )  {

        try {
            List<Home> list = new ArrayList<Home>();
            list = homeService.getHomeByStatus(status);
            return list;
        }catch (Exception e){
            logger.error("根据房屋状态查看房屋使用情况失败！！！"+e.getMessage());
            return  null;
        }
    }

    //查看房屋使用状态
    @RequestMapping(path = {"/getStatusByHome/"} , method = { RequestMethod.POST})
    @ResponseBody
    public String getStatusByHome(@RequestParam("elementNumber") String elementNumber,
                             @RequestParam("houseNumber") String houseNumber
    )  {

        try {
            String result = " ";
            result = homeService.getStatusByHome(elementNumber,houseNumber);
            return HouseUtil.getJSONString(0,"查看房屋使用状态成功"+result);
        }catch (Exception e){
            logger.error("查看房屋使用状态失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"查看房屋使用状态失败!!!");
        }
    }


    //查看房屋使用状态
    @RequestMapping(path = {"/updateStatus/"} , method = { RequestMethod.POST})
    @ResponseBody
    public String updateStatus(@RequestParam("elementNumber") String elementNumber,
                                  @RequestParam("houseNumber") String houseNumber,
                               @RequestParam("status") int  status
    )  {

        try {
             homeService.updateStatus(status,elementNumber,houseNumber);
            return HouseUtil.getJSONString(0,"更新房屋使用状态成功");
        }catch (Exception e){
            logger.error("更新房屋使用状态失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"更新房屋使用状态失败!!!");
        }
    }
}
