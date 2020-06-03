package com.housemgt.controller.feng;

import com.housemgt.common.msg.CodeMsg;
import com.housemgt.common.msg.ResultMsg;
import com.housemgt.model.MetaData;
import com.housemgt.service.MetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 参数设置菜单控制
 * @author chenxin
 */
@Controller
public class RuleMenuController {

    @Autowired
    private MetaDataService metaDataService;

    /**
     * 面积规则菜单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/rule/area/selectMenu")
    public Object selectAreaMenu() {
        int bizType = 1;
        return getMenu(bizType);
    }

    /**
     * 计分规则菜单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/rule/credit/job/selectMenu")
    public Object selectCreditMenu() {
        int bizType = 2;
        return getMenu(bizType);
    }

    private ResultMsg getMenu(int bizType){
        ResultMsg resultMsg = null;
        try {
            List<MetaData> metaData = metaDataService.selectByBizType(bizType);
            if (metaData != null && metaData.size() > 0){
                resultMsg = ResultMsg.success(metaData);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultMsg = ResultMsg.error(CodeMsg.ERROR);
        }
        return resultMsg;
    }
}
