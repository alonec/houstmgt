package com.housemgt.controller.setparam;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.dto.PageDTO;
import com.housemgt.model.CreditAdditionalRule;
import com.housemgt.model.LevelPeople;
import com.housemgt.service.setparam.CreditAdditionalRuleService;
import com.housemgt.service.setparam.LevelPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 计分规则  -- 附加分系列
 * @author chenxin
 */
@Controller
public class CreditAdditionalRuleController {

    @Autowired
    private CreditAdditionalRuleService creditAdditionalRuleService;

    @Autowired
    private LevelPeopleService levelPeopleService;

    @ResponseBody
    @RequestMapping(value = "/rule/credit/additional/add")
    public Object add(@RequestParam("serealId") Integer serealId,
                      @RequestParam("levelPeopleId") Integer levelPeopleId,
                      @RequestParam("grade") String grade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            CreditAdditionalRule creditAdditionalRule = new CreditAdditionalRule();
            creditAdditionalRule.setSerealId(serealId);
            if (levelPeople != null){
                creditAdditionalRule.setLevelPeople(levelPeople.getLevelPeople());
                creditAdditionalRule.setLevelPeopleId(levelPeople.getLevelPeopleId());
            }
            creditAdditionalRule.setGrade(grade);
            if (creditAdditionalRuleService.insertSelective(creditAdditionalRule) > 0){
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
    @RequestMapping(value = "/rule/credit/additional/update")
    public Object update(@RequestParam("id") Integer id,
                         @RequestParam("serealId") Integer serealId,
                         @RequestParam("levelPeopleId") Integer levelPeopleId,
                         @RequestParam("grade") String grade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            CreditAdditionalRule creditAdditionalRule = new CreditAdditionalRule();
            creditAdditionalRule.setId(id);
            creditAdditionalRule.setSerealId(serealId);
            if (levelPeople != null){
                creditAdditionalRule.setLevelPeople(levelPeople.getLevelPeople());
                creditAdditionalRule.setLevelPeopleId(levelPeople.getLevelPeopleId());
            }
            creditAdditionalRule.setGrade(grade);
            if (creditAdditionalRuleService.updateByPrimaryKeySelective(creditAdditionalRule) > 0){
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
    @RequestMapping(value = "/rule/credit/additional/delete")
    public Object delete(@RequestParam("id") Integer id) {
        ResultMsg resultMsg = null;
        try {
            if (creditAdditionalRuleService.deleteByPrimaryKey(id) > 0){
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
    @RequestMapping(value = "/rule/credit/additional/selectBySerealId",  method = { RequestMethod.GET})
    public Object selectBySerealId(@RequestParam("serealId") Integer serealId,
                                   @RequestParam("pageNumber") Integer pageNumber,
                                   @RequestParam("pageSize") Integer pageSize) {
        ResultMsg resultMsg = null;
        try {
            PageDTO pageDTO = new PageDTO();
            int count = creditAdditionalRuleService.countBySerealId(serealId);
            List<CreditAdditionalRule> data = creditAdditionalRuleService.selectBySerealId(serealId, pageNumber, pageSize);
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
