package com.housemgt.controller.feng;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.controller.DTO.PageDTO;
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

    @Autowired
    private MetaDataService metaDataService;

    @ResponseBody
    @RequestMapping(value = "/rule/level/add")
    public Object update(@RequestParam("bizType") Integer bizType,
                         @RequestParam("serealId") Integer serealId,
                         @RequestParam("levelName") String levelName,
                         @RequestParam("levelPeople") String levelPeople) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeopleDO = new LevelPeople();
            levelPeopleDO.setBizType(bizType);
            levelPeopleDO.setSerealId(serealId);
            levelPeopleDO.setLevelName(levelName);
            levelPeopleDO.setLevelPeople(levelPeople);
            // 根据serearId去查询到serealName
            MetaData metaData = metaDataService.selectBySerealId(serealId);
            if (metaData != null){
                levelPeopleDO.setSerealId(metaData.getSerealId() );
            }
            if (levelPeopleService.updateByPrimaryKeySelective(levelPeopleDO) > 0){
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
    @RequestMapping(value = "/rule/level/update")
    public Object update(@RequestParam("levelPeopleId") Integer levelPeopleId,
                         @RequestParam("bizType") Integer bizType,
                         @RequestParam("serealId") Integer serealId,
                         @RequestParam("serealName") Integer serealName,
                         @RequestParam("levelName") String levelName,
                         @RequestParam("levelPeople") String levelPeople) {
        ResultMsg resultMsg = null;
        try {
            LevelPeople levelPeopleDO = new LevelPeople();
            levelPeopleDO.setLevelPeopleId(levelPeopleId);
            levelPeopleDO.setBizType(bizType);
            levelPeopleDO.setSerealId(serealId);
            levelPeopleDO.setSerealId(serealName);
            levelPeopleDO.setLevelName(levelName);
            levelPeopleDO.setLevelPeople(levelPeople);

            if (levelPeopleService.updateByPrimaryKeySelective(levelPeopleDO) > 0){
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
    @RequestMapping(value = "/rule/level/delete")
    public Object delete(@RequestParam("levelPeopleId") Integer levelPeopleId) {
        ResultMsg resultMsg = null;
        try {
            if (levelPeopleService.deleteByPrimaryKey(levelPeopleId) > 0){
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
    @RequestMapping(value = "/rule/level/selectByBizSerealPeople")
    public Object selectByBizSerealPeople(@RequestParam("bizType") Integer bizType,
                                          @RequestParam("serealId") Integer serealId,
                                          @RequestParam("levelPeople") String levelPeople,
                                          @RequestParam("pageNumber") Integer pageNumber,
                                          @RequestParam("pageSize") Integer pageSize) {
        ResultMsg resultMsg = null;
        try {
            PageDTO pageDTO = new PageDTO();
            int count = levelPeopleService.countByBizSerealPeople(bizType, serealId, levelPeople);
            List<LevelPeople> data = levelPeopleService.selectByBizSerealPeople(bizType, serealId, levelPeople, pageNumber, pageSize);
            if (data != null && data.size() > 0){
                pageDTO.setTotals(count);
                pageDTO.setList(data);
                resultMsg = ResultMsg.success(data);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }

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
