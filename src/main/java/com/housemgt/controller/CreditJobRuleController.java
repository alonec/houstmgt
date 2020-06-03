package com.housemgt.controller;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.controller.DTO.PageDTO;
import com.housemgt.model.CreditJobRule;
import com.housemgt.model.LevelPeople;
import com.housemgt.service.CreditJobRuleService;
import com.housemgt.service.LevelPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 计分规则  -- 职务职称系列
 * @author chenxin
 */
@Controller
public class CreditJobRuleController {

    @Autowired
    private CreditJobRuleService creditJobRuleService;

    @Autowired
    private LevelPeopleService levelPeopleService;

    @ResponseBody
    @RequestMapping(value = "/rule/credit/job/add")
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
    @RequestMapping(value = "/rule/credit/job/update")
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
    @RequestMapping(value = "/rule/credit/job/delete")
    public Object delete(@RequestParam("id") Integer id) {
        ResultMsg resultMsg = null;
        try {
            if (creditJobRuleService.deleteByPrimaryKey(id) > 0){
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
    @RequestMapping(value = "/rule/credit/job/selectBySerealId",  method = { RequestMethod.GET})
    public Object selectBySerealId(@RequestParam("serealId") Integer serealId,
                                   @RequestParam("pageNumber") Integer pageNumber,
                                   @RequestParam("pageSize") Integer pageSize) {
        ResultMsg resultMsg = null;
        try {
            PageDTO pageDTO = new PageDTO();
            int count = creditJobRuleService.countBySerealId(serealId);
            List<CreditJobRule> data = creditJobRuleService.selectBySerealId(serealId, pageNumber, pageSize);
            if (data != null && data.size() > 0){
                pageDTO.setTotals(count);
                pageDTO.setList(data);
                resultMsg = ResultMsg.success(pageDTO);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }
}
