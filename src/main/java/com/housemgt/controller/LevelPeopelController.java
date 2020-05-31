package com.housemgt.controller;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.model.LevelPeople;
import com.housemgt.model.MetaData;
import com.housemgt.service.LevelPeopleService;
import com.housemgt.service.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 数据名称配置
 * @author chenxin
 */
@Controller
public class LevelPeopelController {

    @Autowired
    private LevelPeopleService levelPeopleService;

    @ResponseBody
    @RequestMapping(value = "/rule/level/selectBySerealId")
    public Object selectBySerealId(@RequestParam("serealId") Integer serealId) {
        ResultMsg resultMsg = null;
        try {
            List<LevelPeople> data = levelPeopleService.selectBySerealId(serealId);
            if (data != null && data.size() > 0){
                resultMsg = ResultMsg.success(data);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/rule/level/selectLevelNameBySerealId")
    public Object selectLevelBySerealId(@RequestParam("serealId") Integer serealId) {
        ResultMsg resultMsg = null;
        try {
            List<LevelPeople> data = levelPeopleService.selectLevelBySerealId(serealId);
            if (data != null && data.size() > 0){
                resultMsg = ResultMsg.success(data);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/rule/level/selectBySerealIdAndLevelName")
    public Object selectBySerealIdAndLevelName(@RequestParam("serealId") Integer serealId,
                                                @RequestParam("levelName") String levelName) {
        ResultMsg resultMsg = null;
        try {
            List<LevelPeople> data = levelPeopleService.selectBySerealIdAndLevelName(serealId, levelName);
            if (data != null && data.size() > 0){
                resultMsg = ResultMsg.success(data);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }
}
