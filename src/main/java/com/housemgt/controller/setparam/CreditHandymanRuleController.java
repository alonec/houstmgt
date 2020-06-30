package com.housemgt.controller.setparam;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.dto.PageDTO;
import com.housemgt.model.CreditHandyManRule;
import com.housemgt.model.LevelPeople;
import com.housemgt.service.setparam.CreditHandymanRuleService;
import com.housemgt.service.setparam.LevelPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 计分规则  -- 工勤系列
 * @author chenxin
 */
@Controller
public class CreditHandymanRuleController {

    @Autowired
    private CreditHandymanRuleService creditHandymanRuleService;

    @Autowired
    private LevelPeopleService levelPeopleService;

    @ResponseBody
    @RequestMapping(value = "/rule/credit/handyman/add")
    public Object add(@RequestParam("serealId") Integer serealId,
                      @RequestParam("levelPeopleId") Integer levelPeopleId,
                      @RequestParam("baseGrade") String baseGrade,
                      @RequestParam("grade") String grade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            CreditHandyManRule creditHandyManRule = new CreditHandyManRule();
            creditHandyManRule.setSerealId(serealId);
            if (levelPeople != null){
                creditHandyManRule.setLevelPeople(levelPeople.getLevelPeople());
                creditHandyManRule.setLevelPeopleId(levelPeople.getLevelPeopleId());
            }
            creditHandyManRule.setBaseGrade(baseGrade);
            creditHandyManRule.setGrade(grade);
            if (creditHandymanRuleService.insertSelective(creditHandyManRule) > 0){
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
    @RequestMapping(value = "/rule/credit/handyman/update")
    public Object update(@RequestParam("id") Integer id,
                         @RequestParam("serealId") Integer serealId,
                         @RequestParam("levelPeopleId") Integer levelPeopleId,
                         @RequestParam("baseGrade") String baseGrade,
                         @RequestParam("grade") String grade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            CreditHandyManRule creditHandyManRule = new CreditHandyManRule();
            creditHandyManRule.setId(id);
            creditHandyManRule.setSerealId(serealId);
            if (levelPeople != null){
                creditHandyManRule.setLevelPeople(levelPeople.getLevelPeople());
                creditHandyManRule.setLevelPeopleId(levelPeople.getLevelPeopleId());
            }
            creditHandyManRule.setBaseGrade(baseGrade);
            creditHandyManRule.setGrade(grade);
            if (creditHandymanRuleService.updateByPrimaryKeySelective(creditHandyManRule) > 0){
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
    @RequestMapping(value = "/rule/credit/handyman/delete")
    public Object delete(@RequestParam("id") Integer id) {
        ResultMsg resultMsg = null;
        try {
            if (creditHandymanRuleService.deleteByPrimaryKey(id) > 0){
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
    @RequestMapping(value = "/rule/credit/handyman/selectBySerealId",  method = { RequestMethod.GET})
    public Object selectBySerealId(@RequestParam("serealId") Integer serealId,
                                   @RequestParam("pageNumber") Integer pageNumber,
                                   @RequestParam("pageSize") Integer pageSize) {
        ResultMsg resultMsg = null;
        try {
            PageDTO pageDTO = new PageDTO();
            int count = creditHandymanRuleService.countBySerealId(serealId);
            List<CreditHandyManRule> data = creditHandymanRuleService.selectBySerealId(serealId, pageNumber, pageSize);
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
