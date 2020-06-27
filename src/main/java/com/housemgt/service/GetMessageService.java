package com.housemgt.service;


import com.housemgt.Dao.GetMessageDao;
import com.housemgt.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class GetMessageService {


    @Autowired
    GetMessageDao getMessageDao;
//    @Autowired
//    MessageDTO messageDTO;



    //根据房间号查询房屋
    public List<Home> getHomeByNum(String houseNumber){
        return getMessageDao.getHomeByNum(houseNumber);
    }

    //根据单元编号查询单元
    public List<Element> getElementByNum(String elementNumber){
        return getMessageDao.getElementByNum(elementNumber);
    }

    //根据楼宇名称查询楼宇
    public List<Building> getBuildingByName(String buildingName){
        return getMessageDao.getBuildingByName(buildingName);
    }

    //根据小区名称查询小区
    public List<Community> getCommunityByName(String name){
        return  getMessageDao.getCommunityByName(name);
    }
//
//    //首页小区信息拉取
//    public  List<Community> getFirstCommunioty(){
//        return getMessageDao.getFirstCommunity();
//    }
//
//    //首页楼宇信息拉取
//    public List<Building> getFirstBuilding(){
//        return getMessageDao.getFirstBuilding();
//    }
//
//    //首页单元信息获取
//    public List<Element> getFirstElement(){
//        return getMessageDao.getFirstElement();
//    }
//    //首页房屋信息获取
//    public List<Home> getFirstHome(){
//        return getMessageDao.getFirstHome();
//    }
//

    //根据小区名称查询楼宇
    public List<Building> getBuildingByCommunityName(String name){
        return getMessageDao.getBuildingByCommunityName(name);
    }
    //根据楼宇名称查询单元
    public List<Element> getElementByBuildingNum(String buildingName){
        return  getMessageDao.getElementByBuildingNum(buildingName);
    }
    //根据单元名称查询房屋
    public List<Home> getHomeByElementNum(String elementNumber){
        return getMessageDao.getHomeByElementNum(elementNumber);
    }

    //所有小区信息拉取
    public MessageDTO getAllCommunity(Integer page){

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(getMessageDao.getAllCommunityNum());
        messageDTO.setList(getMessageDao.getAllCommunity(page));
        return messageDTO;
    }
    //所有楼宇信息拉取
    public MessageDTO getAllBuilding(Integer page){

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(getMessageDao.getAllBuildingNum());
        messageDTO.setList(getMessageDao.getAllBuilding(page));
        return messageDTO;
    }
    //所有单元信息拉取
    public MessageDTO getAllElement(Integer page){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(getMessageDao.getAllElementNum());
        messageDTO.setList(getMessageDao.getAllElement(page));
        return messageDTO;
    }
    //所有房屋信息拉取
    public MessageDTO getAllHome(Integer page){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(getMessageDao.getAllHomeNum());
        messageDTO.setList(getMessageDao.getAllHome(page));
        return messageDTO;
    }
}
