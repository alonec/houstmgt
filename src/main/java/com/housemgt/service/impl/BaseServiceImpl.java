package com.housemgt.service.impl;

import com.housemgt.common.utils.UUIDUtil;
import com.housemgt.mapper.UserMapper;
import com.housemgt.service.BaseService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String queryInfoByUsername(String username) {
        return userMapper.queryInfoByUsername(username);
    }

}

