package com.housemgt.service;

public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 将数据封装到User类型中
     */
    public String queryInfoByUsername(String username);

}
