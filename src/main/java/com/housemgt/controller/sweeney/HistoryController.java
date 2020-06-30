package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.History;
import com.housemgt.model.MessageDTO;
import com.housemgt.service.sweeney.HistoryService;
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
public class HistoryController {
    @Autowired
    HistoryService historyService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //添加房产变更记录
    @RequestMapping(path = {"/addHistory/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String addHistory(@RequestParam("doorNumber") String doorNumber,
                          @RequestParam("buildingNumber") String buildingNumber,
                          @RequestParam("elementnumber") String elementnumber,
                          @RequestParam("housenumber") String housenumber,
                          @RequestParam("residentsToChange") String residentsToChange,
                          @RequestParam("infrastructureChanges") String infrastructureChanges,
                          @RequestParam("structuremodify") String structuremodify,
                          @RequestParam("time1") String time1,
                          @RequestParam("time2") String time2,
                          @RequestParam("time3") String time3
    )  {

        try {
            History history = new History();
            history.setDoorNumber(doorNumber);
            history.setBuildingNumber(buildingNumber);
            history.setElementnumber(elementnumber);
            history.setHousenumber(housenumber);
            history.setResidentsToChange(residentsToChange);
            history.setInfrastructureChanges(infrastructureChanges);
            history.setStructuremodify(structuremodify);
            history.setTime1(time1);
            history.setTime2(time2);
            history.setTime3(time3);
            historyService.addHistory(history);
            return HouseUtil.getJSONString(0,"添加房产变更记录成功");
        }catch (Exception e){
            logger.error("添加房产变更记录失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"添加房产变更记录失败!!!");
        }
    }

    //所有历史信息拉取信息拉取
    @RequestMapping(path = {"/getAllHistory/"},method = {RequestMethod.GET})
    @ResponseBody
    public MessageDTO getAllHome(@RequestParam("page") int page){
        try{
            int p = (page-1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = historyService.getAllHistory(p);
            return  messageDTO;
        }catch (Exception e ){
            logger.error("拉取历史信息失败"+e.getMessage());
            return null;
        }
    }

    //根据小区编号 楼宇编号  单元编号 房屋编号查询历史变更记录
    @RequestMapping(path = {"/findHistory/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<History> getHistory(@RequestParam("doorNumber") String doorNumber,
                             @RequestParam("buildingNumber") String buildingNumber,
                             @RequestParam("elementnumber") String elementnumber,
                             @RequestParam("housenumber") String housenumber
    )  {

        try {
            List<History> list = new ArrayList<History>();
            list = historyService.findHistory(doorNumber, buildingNumber, elementnumber,  housenumber);
            return list;
        }catch (Exception e){
            logger.error("历史记录查询成功失败！！！"+e.getMessage());
            return null;
        }
    }

//    //历史记录查询
//    @RequestMapping(path = {"/getHistory/"} , method = { RequestMethod.POST})
//    @ResponseBody
//    public String getHistory(@RequestParam("doorNumber") String doorNumber,
//                             @RequestParam("buildingNumber") String buildingNumber,
//                             @RequestParam("elementnumber") String elementnumber,
//                             @RequestParam("housenumber") String housenumber,
//                             @RequestParam("pageRange") int pageRange
//    )  {
//
//        try {
//            List<History> list = new ArrayList<History>();
//            list = historyService.getHistory(doorNumber, buildingNumber, elementnumber,  housenumber,pageRange*10);
//            return HouseUtil.getJSONString(0,"历史记录查询成功！！！！");
//        }catch (Exception e){
//            logger.error("历史记录查询成功失败！！！"+e.getMessage());
//            return HouseUtil.getJSONString(1,"历史记录查询成功失败!!!");
//        }
//    }

//    //编辑房屋历史修改信息
//    @RequestMapping(path = {"/updateHistoryMessage/"} , method = { RequestMethod.POST})
//    @ResponseBody
//    public String updateHistoryMessage(@RequestParam("doorNumber") String doorNumber,
//                             @RequestParam("buildingNumber") String buildingNumber,
//                             @RequestParam("elementnumber") String elementnumber,
//                             @RequestParam("housenumber") String housenumber,
//                             @RequestParam("residentsToChange") String residentsToChange,
//                             @RequestParam("infrastructureChanges") String infrastructureChanges,
//                             @RequestParam("structuremodify") String structuremodify,
//                             @RequestParam("time1") String time1,
//                             @RequestParam("time2") String time2,
//                             @RequestParam("time3") String time3
//    )  {
//
//        try {
//            History history = new History();
//            history.setDoorNumber(doorNumber);
//            history.setBuildingNumber(buildingNumber);
//            history.setElementnumber(elementnumber);
//            history.setHousenumber(housenumber);
//            history.setResidentsToChange(residentsToChange);
//            history.setInfrastructureChanges(infrastructureChanges);
//            history.setStructuremodify(structuremodify);
//            history.setTime1(time1);
//            history.setTime2(time2);
//            history.setTime3(time3);
//            historyService.updateMessage(history);
//            return HouseUtil.getJSONString(0,"编辑房屋历史修改信息成功");
//        }catch (Exception e){
//            logger.error("编辑房屋历史修改信息失败！！！"+e.getMessage());
//            return HouseUtil.getJSONString(1,"编辑房屋历史修改信息失败!!!");
//        }
//    }
}
