package com.housemgt.service;


import com.housemgt.Dao.ApplyHouseDao;
import com.housemgt.model.Apply;
import com.housemgt.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyService {

    @Autowired
    ApplyHouseDao applyHouseDao;

    //管理员查询所有申请通过操作
    public List<Apply> getResultApply(int result){
        return  applyHouseDao.getResultApply(result);
    }

    //查询本人的申请信息
    public List<Apply> getSelfApply(String name,String staffCode){
        return applyHouseDao.getSelfApply( name, staffCode);
    }
    //前端查询所有申请
    public MessageDTO getAllApply(int page){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(applyHouseDao.getAllApplyNum());
        messageDTO.setList(applyHouseDao.getAllApply(page));
        return messageDTO;
    }
}
