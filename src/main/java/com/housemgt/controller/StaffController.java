package com.housemgt.controller;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.model.Staff;
import com.housemgt.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StaffController {
    @Autowired
    private StaffService staffService;

    private final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @ResponseBody
    @RequestMapping("/staff/getStaff")
    public Object getStaff(@RequestParam("username") String username) {
        ResultMsg resultMsg = null;
        try {
            Staff staff = staffService.queryInfoByUsername(username);
            if (staff != null){
                resultMsg = ResultMsg.success(staff);
            } else {
                resultMsg = ResultMsg.error(CodeMsg.ERROR);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }

}
