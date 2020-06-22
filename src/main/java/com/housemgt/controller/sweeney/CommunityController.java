package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.Community;
import com.housemgt.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommunityController {
    @Autowired
    CommunityService communityService;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //添加小区
    @RequestMapping(path = {"/addCommunity/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String addCommunity(@RequestParam("name") String name,
                          @RequestParam("doorNumber") String doorNumber,
                          @RequestParam("mailingAddress") String mailingAddress,
                          @RequestParam("postcode") String postcode,
                          @RequestParam("linkman") String linkman,
                          @RequestParam("phoneNumber") String phoneNumber,
                          @RequestParam("policeStation") String policeStation,
                          @RequestParam("policeman") String policeman,
                          @RequestParam("policePhonenum") String policePhonenum,
                          @RequestParam("buildingPicture") String buildingPicture
    )  {

        try {
            Community community = new Community();
            community.setName(name);
            community.setDoorNumber(doorNumber);
            community.setMailingAddress(mailingAddress);
            community.setPostcode(postcode);
            community.setLinkman(linkman);
            community.setPhoneNumber(phoneNumber);
            community.setPoliceStation(policeStation);
            community.setPoliceman(policeman);
            community.setPolicePhonenum(policePhonenum);
            community.setBuildingPicture(buildingPicture);
            communityService.addCommunity(community);

            return HouseUtil.getJSONString(0,"增加小区成功");
        }catch (Exception e){
            logger.error("增加小区失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"增加小区失败!!!");
        }
    }

    //删除小区
    @RequestMapping(path = {"/deleteCommunity/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String deleteCommunity(@RequestParam("name") String name,
                          @RequestParam("doorNumber") String doorNumber
    )  {

        try {
            System.out.println("name="+name+"doorNum="+doorNumber);
            communityService.deleteCommunity(name,doorNumber);
            return HouseUtil.getJSONString(0,"删除小区成功");
        }catch (Exception e){
            logger.error("删除小区失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"删除小区失败!!!");
        }
    }

    //更新小区信息
    @RequestMapping(path = {"/updateCommunityMessage/"} , method = { RequestMethod.GET})
    @ResponseBody
    public String updateCommunityMessage(@RequestParam("name") String name,
                          @RequestParam("doorNumber") String doorNumber,
                          @RequestParam("mailingAddress") String mailingAddress,
                          @RequestParam("postcode") String postcode,
                          @RequestParam("linkman") String linkman,
                          @RequestParam("phoneNumber") String phoneNumber,
                          @RequestParam("policeStation") String policeStation,
                          @RequestParam("policeman") String policeman,
                          @RequestParam("policePhonenum") String policePhonenum,
                          @RequestParam("buildingPicture") String buildingPicture
    )  {

        try {
            Community community = new Community();
            community.setName(name);
            community.setDoorNumber(doorNumber);
            community.setMailingAddress(mailingAddress);
            community.setPostcode(postcode);
            community.setLinkman(linkman);
            community.setPhoneNumber(phoneNumber);
            community.setPoliceStation(policeStation);
            community.setPoliceman(policeman);
            community.setPolicePhonenum(policePhonenum);
            community.setBuildingPicture(buildingPicture);
            communityService.updataCommunity(community);

            return HouseUtil.getJSONString(0,"更新小区信息成功");
        }catch (Exception e){
            logger.error("更新小区信息失败！！！"+e.getMessage());
            return HouseUtil.getJSONString(1,"更新小区信息失败!!!");
        }
    }
}
