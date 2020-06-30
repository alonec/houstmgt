package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.CoupleBack;
import com.housemgt.model.MessageDTO;
import com.housemgt.service.sweeney.CoupleBackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoupleBackController {


    @Autowired
    CoupleBackService coupleBackService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //用户提交反馈信息
    @RequestMapping(path = {"/addBack/"} , method = { RequestMethod.POST})
    @ResponseBody
    public String  addBack(@RequestParam("no") int  no,
                              @RequestParam("name") String   name,
                              @RequestParam("staffCode") String  staffCode,
                              @RequestParam("message") String  message)  {
        try {
            CoupleBack coupleBack = new CoupleBack();
            coupleBack.setNo(no);
            coupleBack.setName(name);
            coupleBack.setStaffCode(staffCode);
            coupleBack.setMessage(message);
            coupleBackService.addBack(coupleBack);
            return HouseUtil.getJSONString(0,"用户提交反馈信息成功");
        }catch (Exception e){
            return HouseUtil.getJSONString(1,"用户提交反馈信息失败!!!");

        }
    }
    //管理员查看所有反馈信息
    @RequestMapping(path = {"/getBackMessage/"} , method = { RequestMethod.GET})
    @ResponseBody
    public MessageDTO getBackMessage(@RequestParam("page") int  page)  {
        try {
            int p = (page - 1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = coupleBackService.getBackMessage(p);
            return messageDTO;
        }catch (Exception e){
            logger.error("管理员查看所有反馈信息失败！！！"+e.getMessage());
            return null;
        }
    }
    //管理员根据公示次数查看反馈信息
    @RequestMapping(path = {"/getBackMessageByNo/"} , method = { RequestMethod.GET})
    @ResponseBody
    public MessageDTO getBackMessageByNo(@RequestParam("no") int  no)  {
        try {
            //int p = (page - 1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = coupleBackService.getBackMessageByNo(no);
            return messageDTO;
        }catch (Exception e){
            logger.error("管理员根据公示次数查看反馈信息失败！！！"+e.getMessage());
            return null;
        }
    }
    //管理员根据反馈人查看反馈信息
    @RequestMapping(path = {"/getBackMessageByName/"} , method = { RequestMethod.GET})
    @ResponseBody
    public MessageDTO getBackMessageByName(@RequestParam("name") String name)  {
        try {
            //int p = (page - 1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = coupleBackService.getBackMessageByName(name);
            return messageDTO;
        }catch (Exception e){
            logger.error("管理员根据反馈人查看反馈信息失败！！！"+e.getMessage());
            return null;
        }
    }
}
