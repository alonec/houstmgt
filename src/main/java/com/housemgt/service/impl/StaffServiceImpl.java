package com.housemgt.service.impl;

import com.housemgt.mapper.StaffMapper;
import com.housemgt.mapper.UserMapper;
import com.housemgt.model.Staff;
import com.housemgt.model.User;
import com.housemgt.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public Staff queryInfoByUsername(String username) {
        if (username == null && username.equals("")){
            return null;
        }
        User userInfo = userMapper.queryInfoByUsername(username);
        if(userInfo == null) {
            int staffId = userInfo.getStaffId();
            Staff staff = staffMapper.selectByPrimaryKey(staffId);
            return staff;
        }
        return null;
    }
}

