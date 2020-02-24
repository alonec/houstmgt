package com.housemgt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 参数设置功能模块
 * @author chenxin
 */
@RestController
public class ParamSetting {

    @RequestMapping("/paramSetting")
    public String demo() {
        return "hello,你好!";
    }
}
