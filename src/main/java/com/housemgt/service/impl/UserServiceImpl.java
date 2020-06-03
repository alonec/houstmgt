package com.housemgt.service.impl;

import com.housemgt.common.utils.UUIDUtil;
import com.housemgt.mapper.UserMapper;
import com.housemgt.model.User;
import com.housemgt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    public boolean registerData(String username, String password, int isAdmin) {
        // 生成uuid
        String id = UUIDUtil.getOneUUID();

//        // 将用户名作为盐值
//        ByteSource salt = ByteSource.Util.bytes(username);
//        /*
//         * MD5加密：
//         * 使用SimpleHash类对原始密码进行加密。
//         * 第一个参数代表使用MD5方式加密
//         * 第二个参数为原始密码
//         * 第三个参数为盐值，即用户名
//         * 第四个参数为加密次数
//         * 最后用toHex()方法将加密后的密码转成String
//         * */
//        String newPs = new SimpleHash("MD5", password, salt, 1024).toHex();

        // 看数据库中是否存在该账户
        User userInfo = queryInfoByUsername(username);
        if(userInfo == null) {
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setIsAdmin(isAdmin);
            userMapper.insertData(user);
            return true;
        }
        return false;
    }
}

