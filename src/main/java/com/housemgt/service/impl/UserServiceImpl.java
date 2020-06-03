package com.housemgt.service.impl;

import com.housemgt.mapper.UserMapper;
import com.housemgt.model.User;
import com.housemgt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryInfoByUsername(String username) {
        return userMapper.queryInfoByUsername(username);
    }

    @Override
    public boolean checkLogin(String username, String password, int isAdmin) {
        if (username == null || username.equals("") || username.trim().length()<1){
            return false;
        }
        if (password == null || password.equals("") || password.trim().length() <1){
            return false;
        }
        // 查詢账户
        User user = queryInfoByUsername(username);
        if (user == null){
            return false;
        }
        if (password.equals(user.getPassword()) && (isAdmin == (user.getIsAdmin()))){
            return true;
        }
        return false;
    }
    @Override
    public boolean registerData(String username, String password, int isAdmin, int staffId) {
        User userInfo = queryInfoByUsername(username);
        if(userInfo == null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setIsAdmin(isAdmin);
            user.setStaffId(staffId);
            userMapper.insertSelective(user);
            return true;
        }
        return false;
    }
}

