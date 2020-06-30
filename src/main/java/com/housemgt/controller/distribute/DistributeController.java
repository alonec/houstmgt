package com.housemgt.controller.distribute;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.common.utils.Copper;
import com.housemgt.common.utils.DateUtil;
import com.housemgt.dto.CountResultDTO;
import com.housemgt.dto.PageDTO;
import com.housemgt.model.*;
import com.housemgt.service.distribute.CountResultService;
import com.housemgt.service.distribute.DistributeService;
import com.housemgt.service.setparam.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class DistributeController {
    @Autowired
    private CountResultService countResultService;

    @Autowired
    private AreaRuleService areaRuleService;

    @Autowired
    private DistributeService distributeService;

    private final Logger logger = LoggerFactory.getLogger(DistributeController.class);

    @ResponseBody
    @RequestMapping(value = "/distribute/selectAreaByUser",  method = { RequestMethod.GET})
    public Object selectAreaByUser(@RequestParam("username") String username) {
        ResultMsg resultMsg = null;
        PageDTO pageDTO = new PageDTO();
        try {
            logger.info("/distribute/selectAreaByUser   start!");
            logger.info("username: #{}", username);
            Map entry = new HashMap(4);
            entry.put("staffCode", username);
            entry.put("staffName", null);
            entry.put("college", null);
            entry.put("showTimes", null);

            List<CountResult> countResults = countResultService.select(entry, 1, 1);
            if(countResults != null && countResults.size() > 0){
                String job = countResults.get(0).getJob();
                Map<String, String> areaRule = this.getAreaRule();
                String area = areaRule.get(job);
                resultMsg = ResultMsg.success(area);
            } else {
                resultMsg = ResultMsg.success();
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        logger.info("/distribute/selectAreaByUser   end!");
        return resultMsg;
    }


    @ResponseBody
    @RequestMapping("/distribute/selectAll")
    public Object selectAll(@RequestParam("pageNumber") Integer pageNumber,
                           @RequestParam("pageSize") Integer pageSize) {
        ResultMsg resultMsg = null;
        PageDTO pageDTO = new PageDTO();
        try {
            logger.info("/distribute/selectAll   start!");
            Map entry = new HashMap(4);
            entry.put("staffCode", null);
            entry.put("staffName", null);
            entry.put("college", null);
            entry.put("showTimes", null);

            int tatals = countResultService.count(entry);
            if (tatals > 0) {
                List<CountResult> countResults = countResultService.select(entry, pageNumber, pageSize);
                if(countResults != null && countResults.size() > 0){
                    List<CountResultDTO> dataList = new ArrayList<>(countResults.size());
                    for (CountResult cr : countResults
                         ) {
                        CountResultDTO countResultDTO = new CountResultDTO();
                        Copper.Copy(cr, countResultDTO);
                        countResultDTO.setFullTimeCollegeTimeStr(DateUtil.getDateYMD(cr.getFullTimeCollegeTime()));
                        countResultDTO.setStartWorkTimeStr(DateUtil.getDateYMD(cr.getStartWorkTime()));
                        countResultDTO.setSchoolWorkTimeStr(DateUtil.getDateYMD(cr.getSchoolWorkTime()));
                        countResultDTO.setTimeInJobStr(DateUtil.getDateYMD(cr.getTimeInJob()));
                        dataList.add(countResultDTO);
                    }
                    pageDTO.setList(dataList);
                    pageDTO.setTotals(tatals);
                    resultMsg = ResultMsg.success(pageDTO);
                }
            } else {
                resultMsg = ResultMsg.success();
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        logger.info("/distribute/selectAll   end!");
        return resultMsg;
    }

    @ResponseBody
    @RequestMapping("/distribute/select")
    public Object select(@RequestParam(value = "staffCode", defaultValue = "") String staffCode,
                           @RequestParam(value = "staffName", defaultValue = "") String staffName,
                           @RequestParam(value = "college", defaultValue = "") String college,
                           @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                           @RequestParam(value = "pageSize", defaultValue = "500") Integer pageSize) {
        ResultMsg resultMsg = null;

        try {
            logger.info("/distribute/select   start!");
            logger.info("staffCode: #{}, staffName: #{}, college: #{}", staffCode, staffName, staffCode);
            Map entry = new HashMap(4);
            entry.put("staffCode", "".equals(staffCode)? null: staffCode);
            entry.put("staffName", "".equals(staffName)? null: staffName);
            entry.put("college", "".equals(college)? null: college);
            entry.put("showTimes", "1");

            int tatals = countResultService.count(entry);
            if (tatals > 0) {
                List<CountResult> countResults = countResultService.select(entry, pageNumber, pageSize);
                if(countResults != null && countResults.size() > 0){
                    resultMsg = ResultMsg.success(countResults);
                }
            } else {
                resultMsg = ResultMsg.success();
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        logger.info("/distribute/select   end!");
        return resultMsg;
    }

    @ResponseBody
    @PostMapping("/distribute/update")
    public Object update(@RequestBody CountResult countResultVo) {
        ResultMsg resultMsg = null;
        try {
            if (countResultService.updateByPrimaryKeySelective(countResultVo) > 0){
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

    private Map<String, String> getAreaRule(){
        List<AreaRule> data = areaRuleService.selectBySerealId(1, 1, Integer.MAX_VALUE);
        Map<String, String> job = new HashMap<>();
        if (data != null && data.size() > 0){
            for (AreaRule areaRule : data) {
                job.put(areaRule.getLevelPeople(), areaRule.getLevelGrade());
            }
        }
        return job;
    }

    @ResponseBody
    @RequestMapping("/distribute/startDistribute")
    public Object startDistribute() {
        ResultMsg resultMsg = null;
        try {
            distributeService.count();
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }
}
