package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.Element;
import com.housemgt.service.ElementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ElementController {
    @Autowired
    ElementService elementService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    //添加单元
    @RequestMapping(path = {"/addElement/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String addElement(@RequestParam("buildingNumber") String buildingNumber,
                          @RequestParam("elementNumber") String elementNumber,
                          @RequestParam("floorNumber") int  floorNumber,
                          @RequestParam("households") int  households,
                          @RequestParam("elevatorstatus") int  elevatorstatus,
                          @RequestParam("elementPicture") String  elementPicture
    )  {

        try {
            Element element = new Element();
            element.setBuildingNumber(buildingNumber);
            element.setElementNumber(elementNumber);
            element.setFloorNumber(floorNumber);
            element.setHouseholds(households);
            element.setElevatorstatus(elevatorstatus);
            element.setElementPicture(elementPicture);
            elementService.addElement(element);

            return HouseUtil.getJSONString(0,"增加单元成功");
        }catch (Exception e){
            logger.error("增加单元失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"增加单元失败!!!");
        }
    }

    //删除单元
    @RequestMapping(path = {"/deleteElement/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String deleteElement(@RequestParam("buildingNumber") String buildingNumber,
                          @RequestParam("elementNumber") String elementNumber
    )  {

        try {
            elementService.deleteElement(buildingNumber,elementNumber);
            return HouseUtil.getJSONString(0,"删除单元成功");
        }catch (Exception e){
            logger.error("删除单元失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"删除单元失败!!!");
        }
    }

    //更新单元信息
    @RequestMapping(path = {"/updateElementMessage/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String updateElementMessage(@RequestParam("buildingNumber") String buildingNumber,
                          @RequestParam("elementNumber") String elementNumber,
                          @RequestParam("floorNumber") int  floorNumber,
                          @RequestParam("households") int  households,
                          @RequestParam("elevatorstatus") int  elevatorstatus,
                          @RequestParam("elementPicture") String  elementPicture
    )  {

        try {
            Element element = new Element();
            element.setBuildingNumber(buildingNumber);
            element.setElementNumber(elementNumber);
            element.setFloorNumber(floorNumber);
            element.setHouseholds(households);
            element.setElevatorstatus(elevatorstatus);
            element.setElementPicture(elementPicture);
            elementService.updateElement(element);

            return HouseUtil.getJSONString(0,"更新单元信息成功");
        }catch (Exception e){
            logger.error("更新单元信息失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"更新单元信息失败!!!");
        }
    }
}
