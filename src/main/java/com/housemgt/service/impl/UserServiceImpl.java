package com.housemgt.service.impl;

import com.housemgt.mapper.UserMapper;
import com.housemgt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String queryInfoByUsername(String username) {
        return userMapper.queryInfoByUsername(username);
    }

}

