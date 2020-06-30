package com.housemgt.service.sweeney;


import com.housemgt.dao.HistoryDao;
import com.housemgt.dao.HomeDao;
import com.housemgt.model.History;
import com.housemgt.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    HistoryDao historyDao;

    @Autowired
    HomeDao homeDao;

    public void addHistory(History history){
        historyDao.addHistory(history);
        homeDao.updateHomeHistory(history.getStructuremodify(),history.getResidentsToChange(),history.getInfrastructureChanges(),history.getElementnumber(),history.getHousenumber());
    }

//    public List<History> getHistory(String  doorNumber, String buildingNumber, String elementnumber, String housenumber,int pageRange){
//        return  historyDao.getByNumber(doorNumber, buildingNumber, elementnumber,  housenumber,pageRange);
//
//    }
    public MessageDTO getAllHistory(int page){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(historyDao.getAllHistoryNum());
        messageDTO.setList(historyDao.getAllHistory(page));
        return messageDTO;
    }



    //编辑房屋历史修改信息
    public void updateMessage(History history){
        historyDao.updateMessage(history);
    }

    //根据小区编号 楼宇编号  单元编号 房屋编号查询历史变更记录
    public List<History> findHistory(String doorNumber,String buildingNumber,String elementnumber,String housenumber){
        return historyDao.findHistory(doorNumber, buildingNumber, elementnumber, housenumber);
    }
}
