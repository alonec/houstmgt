package com.housemgt.controller.sweeney;


import com.housemgt.model.*;
import com.housemgt.service.GetMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetMessageController {

    @Autowired
    GetMessageService getMessageService;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //根据房间号查询房屋
    @RequestMapping(path = {"/getHomeByNum/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Home> getHomeByNum(@RequestParam("houseNumber") String houseNumber

    )  {

        try {
            List<Home> list = new ArrayList<Home>();
            list = getMessageService.getHomeByNum(houseNumber);
            return list;
        }catch (Exception e){
            logger.error("根据房间号查询房屋失败！！！"+e.getMessage());
            return null;
        }
    }

    //根据单元编号查询单元
    @RequestMapping(path = {"/getElementByNum/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Element> getElementByNum(@RequestParam("elementNumber") String elementNumber

    )  {

        try {
            List<Element> list = new ArrayList<Element>();
            list = getMessageService.getElementByNum(elementNumber);
            return list;
        }catch (Exception e){
            logger.error("根据单元编号查询单元失败！！！"+e.getMessage());
            return null;
        }
    }

    //根据楼宇名称查询楼宇

    @RequestMapping(path = {"/getBuildingByName/"},method = {RequestMethod.GET})
    @ResponseBody
    public List<Building> getBuildingByName(@RequestParam("buildingName") String buildingName){

        try {

            List<Building> list = new ArrayList<Building>();
            list = getMessageService.getBuildingByName(buildingName);
            return list;
        }catch (Exception e){
            logger.error("根据楼宇名称查询楼宇"+e.getMessage());
            return  null;
        }
    }

    //根据小区名称查询小区
    @RequestMapping(path = {"/getCommunityByName/"},method = {RequestMethod.GET})
    @ResponseBody
    public List<Community> getCommunityByName(@RequestParam("name") String name){

        try {
            List<Community> list = new ArrayList<Community>();
            list = getMessageService.getCommunityByName(name);
            return list;
        }catch (Exception e){
            logger.error("根据小区名称查询小区"+e.getMessage());
            return  null;
        }
    }


//    //拉取首页小区信息
//    @RequestMapping(path = {"/getFirstCommunity/"},method = {RequestMethod.GET})
//    @ResponseBody
//    public List<Community> getFirstCommunity(){
//        try {
//            List<Community> list = new ArrayList<Community>();
//            list = getMessageService.getFirstCommunioty();
//            return list;
//        }catch (Exception e){
//            logger.error("拉取小区信息失败"+e.getMessage());
//            return  null;
//        }
//    }
//    //拉取首页楼宇信息
//    @RequestMapping(path = {"/getFirstBuilding/"},method = {RequestMethod.GET})
//    @ResponseBody
//    public List<Building> getFirstBuilding(){
//        try {
//            List<Building> list = new ArrayList<Building>();
//            list = getMessageService.getFirstBuilding();
//            return list;
//        }catch (Exception e){
//            logger.error("拉取楼宇信息失败"+e.getMessage());
//            return null;
//        }
//    }
//    //拉取首页单元信息
//    @RequestMapping(path = {"/getFirstElement/"},method = {RequestMethod.GET})
//    @ResponseBody
//    public List<Element> getFirstElement(){
//        try {
//            List<Element> list = new ArrayList<Element>();
//            list = getMessageService.getFirstElement();
//            return list;
//        }catch (Exception e){
//            logger.error("拉取单元信息失败"+e.getMessage());
//            return null;
//        }
//    }
//    //拉取首页房屋信息
//    @RequestMapping(path = {"/getFirstHome/"},method = {RequestMethod.GET})
//    @ResponseBody
//    public List<Home> getFirstHome(){
//        try{
//            List<Home>list = new ArrayList<Home>();
//            list = getMessageService.getFirstHome();
//            return list;
//        }catch (Exception e ){
//            logger.error("拉取房屋信息失败"+e.getMessage());
//            return null;
//        }
//    }


    //根据小区名称查询楼宇
    @RequestMapping(path = {"/getBuildingByCommunityName/"},method = {RequestMethod.GET})
    @ResponseBody
    public List<Building> getBuildingByCommunityName(@RequestParam("name") String name
    ){
        try{
            List<Building>list = new ArrayList<Building>();
            list = getMessageService.getBuildingByCommunityName(name);
            return list;
        }catch (Exception e ){
            logger.error("根据小区名称查询楼宇失败"+e.getMessage());
            return null;
        }
    }

    //根据楼宇名称查询单元
    @RequestMapping(path = {"/getElementByBuildingNum/"},method = {RequestMethod.GET})
    @ResponseBody
    public List<Element> getElementByBuildingNum(@RequestParam("buildingName") String buildingName){
        try{
            List<Element>list = new ArrayList<Element>();
            list = getMessageService.getElementByBuildingNum(buildingName);
            return list;
        }catch (Exception e ){
            logger.error("拉取房屋信息失败"+e.getMessage());
            return null;
        }
    }

    //根据单元名称查询房屋
    @RequestMapping(path = {"/getHomeByElementNum/"},method = {RequestMethod.GET})
    @ResponseBody
    public List<Home> getHomeByElementNum(@RequestParam("elementNumber") String elementNumber){
        try{
            List<Home>list = new ArrayList<Home>();
            list = getMessageService.getHomeByElementNum(elementNumber);
            return list;
        }catch (Exception e ){
            logger.error("拉取房屋信息失败"+e.getMessage());
            return null;
        }
    }

    //所有小区信息拉取
    @RequestMapping(path = {"/getAllCommunity/"},method = {RequestMethod.GET})
    @ResponseBody
    public MessageDTO getAllCommunity(@RequestParam("page") int page){
        try{
            int p = (page-1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = getMessageService.getAllCommunity(p);
            return  messageDTO;
        }catch (Exception e ){
            logger.error("拉取小区信息失败"+e.getMessage());
            return null;
        }
    }
    //所有楼宇信息拉取
    @RequestMapping(path = {"/getAllBuilding/"},method = {RequestMethod.GET})
    @ResponseBody
    public MessageDTO getAllBuilding(@RequestParam("page") int page){
        try{
            int p = (page-1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = getMessageService.getAllBuilding(p);
            return  messageDTO;
        }catch (Exception e ){
            logger.error("拉取楼宇信息失败"+e.getMessage());
            return null;
        }
    }
    //所有单元信息拉取
    @RequestMapping(path = {"/getAllElement/"},method = {RequestMethod.GET})
    @ResponseBody
    public MessageDTO getAllElement(@RequestParam("page") int page){
        try{
            int p = (page-1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = getMessageService.getAllElement(p);
            return  messageDTO;
        }catch (Exception e ){
            logger.error("拉取单元信息失败"+e.getMessage());
            return null;
        }
    }
    //所有房屋信息拉取
    @RequestMapping(path = {"/getAllHome/"},method = {RequestMethod.GET})
    @ResponseBody
    public MessageDTO getAllHome(@RequestParam("page") int page){
        try{
            int p = (page-1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = getMessageService.getAllHome(p);
            return  messageDTO;
        }catch (Exception e ){
            logger.error("拉取房屋信息失败"+e.getMessage());
            return null;
        }
    }

}
