package com.housemgt.controller.sweeney;


import com.housemgt.common.utils.HouseUtil;
import com.housemgt.model.Apply;
import com.housemgt.model.Building;
import com.housemgt.service.ApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ApplyController {


    @Autowired
    ApplyService applyService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(path = {"/getAllApply/"} , method = { RequestMethod.GET})
    @ResponseBody
    public List<Apply> getAllApply()  {

        try {
            List<Apply> list = new ArrayList<>();
            list = applyService.getAllApply();
            return list;
        }catch (Exception e){
            logger.error("删除小区失败！！！"+e.getMessage());
           return null;
        }
    }
}
