package com.housemgt.service.distribute.impl;

import com.housemgt.mapper.CountResultMapper;
import com.housemgt.model.*;
import com.housemgt.service.sweeney.ApplyService;
import com.housemgt.service.distribute.DistributeService;
import com.housemgt.service.setparam.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class DistributeServiceImpl implements DistributeService {

    @Autowired
    private CreditJobRuleService creditJobRuleService;

    @Autowired
    private CreditHandymanRuleService creditHandymanRuleService;

    @Autowired
    private CreditPriceRuleService creditPriceRuleService;

    @Autowired
    private CreditAdditionalRuleService creditAdditionalRuleService;

    @Autowired
    private CountResultMapper countResultMapper;

    @Autowired
    private ApplyService applyService;

    private Map<String, CreditJobRule> jobGradeMap = new HashMap<>();  // 职称职务分系列参考
    private Map<String, CreditHandyManRule> HandymanGradeMap = new HashMap<>(); // 工勤分系列参考
    private Map<String, CreditPriceRule> priceGradeMap = new HashMap<>(); // 奖励分系列参考
    private Map<String, CreditAdditionalRule> additionalGradeMap = new HashMap<>(); // 附加分系列参考

    private int JOB_CODE = 2; // 职务职称系列
    private int HANDYMAN_CODE = 3; // 工勤系列
    private int PRICE_CODE = 4; // 奖励分系列
    private int ADDITIONAL_CODE = 5; // 附加分系列

    // 使用线程池
    private  static ExecutorService service = Executors.newCachedThreadPool();

    @Override
    public void count() {
        try {
            // 对审批通过的申请者进行积分计算
            service.submit(new CountGrade());
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    class CountGrade implements Runnable{

        @Override
        public void run() {
            try {
                // 先清除积分表中数据
                countResultMapper.truncateTable();
                // 得到计分分数名称和具体分数对应关系的map
                getGradeMap();
                // 查询到所以审批通过的申请信息
                List<Apply> applyList = applyService.getResultApply(1);
                if (applyList != null && applyList.size() > 0) {
                    for (int i = 0; i < applyList.size(); i++) {
                        Apply apply = applyList.get(i);
                        CountResult countResult = new CountResult();
                        countResult.setStaffCode(apply.getStaffCode());
                        countResult.setStaffName(apply.getName());
                        countResult.setCollege(apply.getUnit()); // 单位
                        countResult.setHighestDegree(apply.getOfficialAcademicCredentials());
                        countResult.setJob(apply.getPostsHeld()); // 职务职称
                        countResult.setSex(apply.getSex());
                        countResult.setBirthday(apply.getBirthdate());
                        countResult.setFullTimeCollegeTime(apply.getStartingDates());
                        countResult.setStartWorkTime(apply.getTimeToWork());
                        countResult.setSchoolWorkTime(apply.getTimeToSchool());
                        if (apply.getPostsHeld() != null) {
                            countResult.setJobBaseGrade(jobGradeMap.get(apply.getPostsHeld()).getBaseGrade());// 职务职称基础分
                        }
                        countResult.setTimeInJob(apply.getTimeInJob());
                        if(apply.getTimeInJob() != null) {
                            Date timeInJob =  apply.getTimeInJob();
                            String year = timeInJob.toString().split("-")[0];
                            String now_year = new Date().toString().split("-")[0];
                            int intYear = (Integer.parseInt(now_year) - Integer.parseInt(year));
                            countResult.setTimeInJobCount(String.valueOf(intYear)); // 任职年限数
                        }
                        Double jobGrade = Double.parseDouble(jobGradeMap.get(countResult.getJob()).getGrade());
                        Double jobLength = Double.parseDouble(countResult.getTimeInJobCount());
                        BigDecimal timeInJobGrade = BigDecimal.valueOf(jobGrade).multiply(BigDecimal.valueOf(jobLength));
                        countResult.setTimeInJobCountGrade(String.valueOf(timeInJobGrade)); // 任职年限得分
                        // 计算分房工龄分: 分房工龄分=工龄分+学龄分
                        int fullTimeCollegeTime = getYear(countResult.getFullTimeCollegeTime());// 全日制大中专上学时间
                        int startWorkTime = getYear(countResult.getStartWorkTime());  // 参加工作时间
                        // 工龄分
                        int workGrade = startWorkTime - fullTimeCollegeTime;
                        int startWorkTimeGrade = getYear(countResult.getStartWorkTime());  // 开始工作时间
                        int now = getYear(new Date());
                        // 学龄分
                        int studyGrade = now - startWorkTimeGrade + 1;
                        countResult.setLengthOfServiceGrade(String.valueOf(workGrade + studyGrade)); // 分房工龄分
                        // 校龄分从到校报到之日算起，每年计0.5分
                        int schoolWorkTimeGrade = getYear(countResult.getSchoolWorkTime());  // 到校工作时间
                        BigDecimal schoolGrade = new BigDecimal(now - schoolWorkTimeGrade + 1).multiply(new BigDecimal(0.5));
                        countResult.setAgeDivisionGrade(schoolGrade.toString()); // 校龄分
                        // 奖励分
                        if (apply.getAwardGrade() != null) {
                            CreditPriceRule creditPriceRule = priceGradeMap.get(apply.getAwardGrade());
                            if (creditPriceRule.getBaseGrade() != null) {
                                countResult.setAwardGrade(apply.getAwardGrade());
                            }
                            countResult.setAwardGrade(apply.getAwardGrade());
                        }
                        // 附加分
                        countResult.setDepedndentOfMartyrsGrade(apply.getReturnedOverseas()); // 配偶烈属分
                        countResult.setReturnedOverseasGrade(apply.getDepedndentOfMartyrs()); // 归侨分
                        countResult.setOnlyChildGrade(apply.getOnlyChild()); // 独生子女分
                        countResult.setDualEmployeeSpouseGrade(apply.getDualEmployeeSpouse()); // 双职工配偶分

                        // 综合总得分
                        // 计算职称总得分: 职务（职称）分=基础分+任职年限分（按现任职岗位计）
                        Double jobTotalGrade = Double.parseDouble(countResult.getJobBaseGrade())
                                + Double.parseDouble(countResult.getTimeInJobCountGrade());

                        Double totals = jobTotalGrade + Double.parseDouble(countResult.getLengthOfServiceGrade())
                                + Double.parseDouble(countResult.getAgeDivisionGrade())
                                + Double.parseDouble(countResult.getAwardGrade())
                                + Double.parseDouble(countResult.getDepedndentOfMartyrsGrade())
                                + Double.parseDouble(countResult.getReturnedOverseasGrade())
                                + Double.parseDouble(countResult.getOnlyChildGrade())
                                + Double.parseDouble(countResult.getDualEmployeeSpouseGrade());
                        countResult.setTotalGrade(totals.toString());
                        // 存入数据库
                        countResultMapper.insertSelective(countResult);
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void getGradeMap(){
        List<CreditJobRule> creditJobRules = creditJobRuleService.selectBySerealId(JOB_CODE, 1, Integer.MAX_VALUE);
        if (creditJobRules != null && creditJobRules.size() > 0){
            for (CreditJobRule creditJobRule : creditJobRules) {
                jobGradeMap.put(creditJobRule.getLevelPeople(), creditJobRule);
            }
        }
        List<CreditHandyManRule> creditHandyManRules = creditHandymanRuleService.selectBySerealId(HANDYMAN_CODE, 1, Integer.MAX_VALUE);
        if (creditHandyManRules != null && creditHandyManRules.size() > 0){
            for (CreditHandyManRule creditHandyManRule : creditHandyManRules) {
                HandymanGradeMap.put(creditHandyManRule.getLevelPeople(), creditHandyManRule);
            }
        }
        List<CreditPriceRule> creditPriceRules = creditPriceRuleService.selectBySerealId(PRICE_CODE, 1, Integer.MAX_VALUE);
        if (creditPriceRules != null && creditPriceRules.size() > 0){
            for (CreditPriceRule creditPriceRule : creditPriceRules) {
                priceGradeMap.put(creditPriceRule.getLevelPeople(), creditPriceRule);
            }
        }

        List<CreditAdditionalRule> creditAdditionalRules = creditAdditionalRuleService.selectBySerealId(ADDITIONAL_CODE, 1, Integer.MAX_VALUE);
        if (creditPriceRules != null && creditPriceRules.size() > 0){
            for (CreditAdditionalRule creditAdditionalRule : creditAdditionalRules) {
                additionalGradeMap.put(creditAdditionalRule.getLevelPeople(), creditAdditionalRule);
            }
        }
    }

    private int getYear(Date date){
        String strDate = date.toString().split("-")[0];
        return Integer.parseInt(strDate);
    }

}
