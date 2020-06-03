package com.housemgt.controller;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.controller.DTO.PageDTO;
import com.housemgt.model.CreditPriceRule;
import com.housemgt.model.LevelPeople;
import com.housemgt.service.CreditPriceRuleService;
import com.housemgt.service.LevelPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 计分规则  -- 奖励分系列
 * @author chenxin
 */
@Controller
public class CreditPriceRuleController {

    @Autowired
    private CreditPriceRuleService creditPriceRuleService;

    @Autowired
    private LevelPeopleService levelPeopleService;

    @ResponseBody
    @RequestMapping(value = "/rule/credit/price/add")
    public Object add(@RequestParam("serealId") Integer serealId,
                      @RequestParam("levelPeopleId") Integer levelPeopleId,
                      @RequestParam("baseGrade") String baseGrade,
                      @RequestParam("specialPriceGrade") String specialPriceGrade,
                      @RequestParam("firstPriceGrade") String firstPriceGrade,
                      @RequestParam("secondPriceGrade") String secondPriceGrade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            CreditPriceRule creditPriceRule = new CreditPriceRule();
            creditPriceRule.setSerealId(serealId);
            if (levelPeople != null){
                creditPriceRule.setLevelPeople(levelPeople.getLevelPeople());
                creditPriceRule.setLevelPeopleId(levelPeople.getLevelPeopleId());
            }
            creditPriceRule.setBaseGrade(baseGrade);
            creditPriceRule.setSpecialPriceGrade(specialPriceGrade);
            creditPriceRule.setFirstPriceGrade(firstPriceGrade);
            creditPriceRule.setSecondPriceGrade(secondPriceGrade);
            if (creditPriceRuleService.insertSelective(creditPriceRule) > 0){
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
    @RequestMapping(value = "/rule/credit/price/update")
    public Object update(@RequestParam("id") Integer id,
                         @RequestParam("serealId") Integer serealId,
                         @RequestParam("levelPeopleId") Integer levelPeopleId,
                         @RequestParam("baseGrade") String baseGrade,
                         @RequestParam("specialPriceGrade") String specialPriceGrade,
                         @RequestParam("firstPriceGrade") String firstPriceGrade,
                         @RequestParam("secondPriceGrade") String secondPriceGrade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            CreditPriceRule creditPriceRule = new CreditPriceRule();
            creditPriceRule.setId(id);
            creditPriceRule.setSerealId(serealId);
            if (levelPeople != null){
                creditPriceRule.setLevelPeople(levelPeople.getLevelPeople());
                creditPriceRule.setLevelPeopleId(levelPeople.getLevelPeopleId());
            }
            creditPriceRule.setBaseGrade(baseGrade);
            creditPriceRule.setSpecialPriceGrade(specialPriceGrade);
            creditPriceRule.setFirstPriceGrade(firstPriceGrade);
            creditPriceRule.setSecondPriceGrade(secondPriceGrade);
            if (creditPriceRuleService.updateByPrimaryKeySelective(creditPriceRule) > 0){
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
    @RequestMapping(value = "/rule/credit/price/delete")
    public Object delete(@RequestParam("id") Integer id) {
        ResultMsg resultMsg = null;
        try {
            if (creditPriceRuleService.deleteByPrimaryKey(id) > 0){
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
    @RequestMapping(value = "/rule/credit/price/selectBySerealId",  method = { RequestMethod.GET})
    public Object selectBySerealId(@RequestParam("serealId") Integer serealId,
                                   @RequestParam("pageNumber") Integer pageNumber,
                                   @RequestParam("pageSize") Integer pageSize) {
        ResultMsg resultMsg = null;
        try {
            PageDTO pageDTO = new PageDTO();
            int count = creditPriceRuleService.countBySerealId(serealId);
            List<CreditPriceRule> data = creditPriceRuleService.selectBySerealId(serealId, pageNumber, pageSize);
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
