package com.housemgt.controller;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.service.BaseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LoginController {
    @Autowired
    private BaseService baseService;

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ResponseBody
    @RequestMapping(value = "/login", method = POST)
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject currentUser = SecurityUtils.getSubject();

        ResultMsg resultMsg = null;

        try {
            currentUser.login(token);
            // 判断当前用户是否登录
            if (currentUser.isAuthenticated() == true) {
                resultMsg = ResultMsg.success();
                System.out.println("登录成功, 用户名：" + username);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
            System.out.println("登录失败, 用户名：" + username);
        }
        return resultMsg;
    }
}
