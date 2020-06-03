package com.housemgt.service;


import com.housemgt.Dao.HistoryDao;
import com.housemgt.Dao.HomeDao;
import com.housemgt.model.History;
import com.housemgt.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
