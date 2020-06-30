package com.housemgt.service.sweeney;



import com.housemgt.dao.CoupleBackDao;
import com.housemgt.model.CoupleBack;
import com.housemgt.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoupleBackService {

    @Autowired
    CoupleBackDao coupleBackDao;

    //用户提交反馈信息
    public void addBack(CoupleBack coupleBack){
        coupleBackDao.addBack(coupleBack);
    }

    //管理员查看所有反馈信息
    public MessageDTO getBackMessage(int page){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(coupleBackDao.getAllBackNum());
        messageDTO.setList(coupleBackDao.getBackMessage(page));
        return messageDTO;
    }
    //管理员根据公示次数查看反馈信息
    public MessageDTO getBackMessageByNo(int no){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(coupleBackDao.getAllBackNumByNO(no));
        messageDTO.setList(coupleBackDao.getBackMessageByNo(no));
        return messageDTO;
    }

    //管理员根据反馈人查看反馈信息
    public MessageDTO getBackMessageByName(String name){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCount(coupleBackDao.getAllBackNumByName(name));
        messageDTO.setList(coupleBackDao.getBackMessageByName(name));
        return messageDTO;
    }
}
