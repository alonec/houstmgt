package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.Apply;
import com.housemgt.model.Building;
import com.housemgt.model.MessageDTO;
import com.housemgt.service.ApplyService;
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
public class ApplyController {


    @Autowired
    ApplyService applyService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //管理员查询所有申请通过操作
    @RequestMapping(path = {"/getResultApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getResultApply(  @RequestParam("result") int  result)  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getResultApply(result);
            return list;
        }catch (Exception e){
            logger.error("查询申请通过的失败！！！"+e.getMessage());
           return null;
        }
    }

    //查询本人的申请信息
    @RequestMapping(path = {"/getSelfApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getSelfApply(  @RequestParam("name") String   name,
                                      @RequestParam("staffCode" )String staffCode
    )  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getSelfApply(name,staffCode);
            return list;
        }catch (Exception e){
            logger.error("查询本人申请的失败！！！"+e.getMessage());
            return null;
        }
    }
    //前端分页查询所有申请
    @RequestMapping(path = {"/getAllApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public MessageDTO getAllApply(@RequestParam("page") int  page)  {

        try {
            int p = (page - 1)*10;
            MessageDTO messageDTO = new MessageDTO();
            messageDTO = applyService.getAllApply(p);
            return messageDTO;
        }catch (Exception e){
            logger.error("查询申请通过的失败！！！"+e.getMessage());
            return null;
        }
    }

}
