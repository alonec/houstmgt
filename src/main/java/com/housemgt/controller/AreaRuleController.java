package com.housemgt.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.controller.DTO.PageDTO;
import com.housemgt.model.AreaRule;
import com.housemgt.model.LevelPeople;
import com.housemgt.model.MetaData;
import com.housemgt.service.AreaRuleService;
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
 * 面积规则
 * @author chenxin
 */
@Controller
public class AreaRuleController {

    @Autowired
    private AreaRuleService areaRuleService;

    @Autowired
    private MetaDataService metaDataService;

    @Autowired
    private LevelPeopleService levelPeopleService;

    @ResponseBody
    @RequestMapping(value = "/rule/area/add")
    public Object add(@RequestParam("serealId") Integer serealId,
                      @RequestParam("levelPeopleId") Integer levelPeopleId,
                      @RequestParam("levelGrade") String levelGrade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            AreaRule areaRule = new AreaRule();
            areaRule.setSerealId(serealId);
            if (levelPeople != null){
                areaRule.setLevelName(levelPeople.getLevelName());
                areaRule.setLevelPeople(levelPeople.getLevelPeople());
            }
            areaRule.setLevelGrade(levelGrade);
            if (areaRuleService.insertSelective(areaRule) > 0){
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
    @RequestMapping(value = "/rule/area/update")
    public Object update(@RequestParam("areaRuleId") Integer areaRuleId,
                         @RequestParam("serealId") Integer serealId,
                         @RequestParam("levelPeopleId") Integer levelPeopleId,
                         @RequestParam("levelGrade") String levelGrade) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeople = levelPeopleService.selectByPrimaryKey(levelPeopleId);
            AreaRule areaRule = new AreaRule();
            areaRule.setAreaRuleId(areaRuleId);
            areaRule.setSerealId(serealId);
            if (levelPeople != null){
                areaRule.setLevelName(levelPeople.getLevelName());
                areaRule.setLevelPeople(levelPeople.getLevelPeople());
            }
            areaRule.setLevelGrade(levelGrade);
            if (areaRuleService.updateByPrimaryKeySelective(areaRule) > 0){
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
    @RequestMapping(value = "/rule/area/delete")
    public Object delete(@RequestParam("areaRuleId") Integer areaRuleId) {
        ResultMsg resultMsg = null;
        try {
            if (areaRuleService.deleteByPrimaryKey(areaRuleId) > 0){
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
    @RequestMapping(value = "/rule/area/selectMenu")
    public Object selectMenu() {
        ResultMsg resultMsg = null;
        try {
            // 面积规则业务类型为1
            List<MetaData> metaData = metaDataService.selectByBizType(1);
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
    @RequestMapping(value = "/rule/area/selectBySerealId",  method = { RequestMethod.GET})
    public Object selectBySerealId(@RequestParam("serealId") Integer serealId,
                                   @RequestParam("pageNumber") Integer pageNumber,
                                   @RequestParam("pageSize") Integer pageSize) {
        ResultMsg resultMsg = null;
        try {
            PageDTO pageDTO = new PageDTO();
            int count = areaRuleService.countBySerealId(serealId);
            List<AreaRule> data = areaRuleService.selectBySerealId(serealId, pageNumber, pageSize);
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
