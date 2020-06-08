package com.housemgt.controller.sweeney;

import com.housemgt.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ActivityController {


    @Autowired
    ActivityService activityService;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(path = {"/getStatus/"} , method = { RequestMethod.GET})
    @ResponseBody
    public int getStatus(//@RequestParam("name") String   name,
                                    @RequestParam("staffCode" )String staffCode
    )  {

        try {
            return  activityService.selectStatus( staffCode);

        }catch (Exception e){
            return 0;
        }
    }

}
