package com.housemgt.controller;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private UserService baseService;

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ResponseBody
    @RequestMapping("/login")
    public Object login(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                        @RequestParam("isAdmin") int isAdmin) {
        ResultMsg resultMsg = null;
        try {
            if (baseService.checkLogin(username, password, isAdmin) == true) {
                resultMsg = ResultMsg.success();
                System.out.println("用戶："+ username + "," + password + "登录成功");
            } else {
                resultMsg = ResultMsg.error(CodeMsg.PARAMETER_ISNULL);
                System.out.println("用戶："+ username + "," + password + "登录失败");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
            System.out.println("用戶："+ username + "," + password + "登录失败");
        }
        return resultMsg;
    }

    @ResponseBody
    @RequestMapping("/register")
    public Object register(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                           @RequestParam("isAdmin") int isAdmin) {
        ResultMsg resultMsg = null;
        boolean result = baseService.registerData(username,password, isAdmin);
        if(result){
            resultMsg = ResultMsg.success();
        } else {
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }
}
