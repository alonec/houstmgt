package com.housemgt.service.sweeney;

import com.housemgt.dao.ElementDao;
import com.housemgt.dao.HomeDao;
import com.housemgt.model.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElementService {
    @Autowired
    ElementDao elementDao;
    @Autowired
    HomeDao homeDao;

    public void addElement(Element element){
        elementDao.addElement(element);
    }

    public void deleteElement(String buildingNumber,String elementNumber ){
        homeDao.deleteAllHome(elementNumber);//先删掉单元所属房屋
        elementDao.deleteHome(buildingNumber,elementNumber);
    }

    public void updateElement(Element element){
        elementDao.updateMessage(element);
    }
}
