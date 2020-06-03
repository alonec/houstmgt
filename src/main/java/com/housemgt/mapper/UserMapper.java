package com.housemgt.mapper;

import com.housemgt.model.User;

public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    public User queryInfoByUsername(String username);

    /**
     * 插入一条数据
     */
    public void insertData(User user);
}