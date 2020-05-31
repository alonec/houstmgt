package com.housemgt.controller;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.model.CreditJobRule;
import com.housemgt.model.LevelPeople;
import com.housemgt.model.MetaData;
import com.housemgt.service.CreditJobRuleService;
import com.housemgt.service.LevelPeopleService;
import com.housemgt.service.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 计分规则
 * @author chenxin
 */
@Controller
public class CreditJobRuleController {

    @Autowired
    private CreditJobRuleService creditJobRuleService;

    @Autowired
    private MetaDataService metaDataService;

    @Autowired
    private LevelPeopleService levelPeopleService;

    @ResponseBody
    @RequestMapping(value = "/rule/credit/add")
    public Object add(@RequestParam("serealId") Integer serealId,
                      @RequestParam("levelPeopleId") Integer levelPeopleId,
                      @RequestParam("baseGrade") String baseGrade,
                      @RequestParam("grade") String grade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            CreditJobRule creditJobRule = new CreditJobRule();
            creditJobRule.setSerealId(serealId);
            if (levelPeople != null){
                creditJobRule.setLevelPeople(levelPeople.getLevelPeople());
                creditJobRule.setLevelPeopleId(levelPeople.getLevelPeopleId());
            }
            creditJobRule.setBaseGrade(baseGrade);
            creditJobRule.setGrade(grade);
            if (creditJobRuleService.insertSelective(creditJobRule) > 0){
                resultMsg = ResultMsg.success();
            } else {
                resultMsg = ResultMsg.error(CodeMsg.ERROR);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/rule/credit/update")
    public Object update(@RequestParam("id") Integer id,
                         @RequestParam("serealId") Integer serealId,
                         @RequestParam("levelPeopleId") Integer levelPeopleId,
                         @RequestParam("baseGrade") String baseGrade,
                         @RequestParam("grade") String grade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            CreditJobRule creditJobRule = new CreditJobRule();
            creditJobRule.setId(id);
            creditJobRule.setSerealId(serealId);
            if (levelPeople != null){
                creditJobRule.setLevelPeople(levelPeople.getLevelPeople());
                creditJobRule.setLevelPeopleId(levelPeople.getLevelPeopleId());
            }
            creditJobRule.setBaseGrade(baseGrade);
            creditJobRule.setGrade(grade);
            if (creditJobRuleService.updateByPrimaryKeySelective(creditJobRule) > 0){
                resultMsg = ResultMsg.success();
            } else {
                resultMsg = ResultMsg.error(CodeMsg.ERROR);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/rule/credit/delete")
    public Object delete(@RequestParam("areaRuleId") Integer areaRuleId) {
        ResultMsg resultMsg = null;
        try {
            if (creditJobRuleService.deleteByPrimaryKey(areaRuleId) > 0){
                resultMsg = ResultMsg.success();
            } else {
                resultMsg = ResultMsg.error(CodeMsg.ERROR);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/rule/credit/selectMenu")
    public Object selectMenu() {
        ResultMsg resultMsg = null;
        try {
            // 计分规则业务类型为2
            List<MetaData> metaData = metaDataService.selectByBizType(2);
            if (metaData != null && metaData.size() > 0){
                resultMsg = ResultMsg.success(metaData);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }

    @ResponseBody
    @RequestMapping(value = "/rule/credit/selectBySerealId",  method = { RequestMethod.GET})
    public Object selectBySerealId(@RequestParam("serealId") Integer serealId) {
        ResultMsg resultMsg = null;
        try {
            List<CreditJobRule> data = creditJobRuleService.selectBySerealId(serealId);
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
