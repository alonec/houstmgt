package com.housemgt.service;


import com.housemgt.Dao.BuildingDao;
import com.housemgt.Dao.CommunityDao;
import com.housemgt.model.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
    @Autowired
    CommunityDao communityDao;

    @Autowired
    BuildingDao buildingDao;
    public void addCommunity(Community community) {
        communityDao.addCommunity(community);
    }

    public void deleteCommunity(String name,String doorNumber){
        buildingDao.deleteAllBuilding(name);
        communityDao.deleteCommunity(name,doorNumber);
    }

    public void updataCommunity(Community community){
        communityDao.updateMessage(community);
    }
}
