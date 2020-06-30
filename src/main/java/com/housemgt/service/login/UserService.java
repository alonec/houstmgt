package com.housemgt.service.login;

import com.housemgt.model.User;

import java.util.Map;

public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 将数据封装到Map类型中
     */
    public User queryInfoByUsername(String username);

    /**
     * 登錄功能
     * @param username 用户名
     * @param password 密码
     * @param isAdmin 管理員標識
     * @return
     */
    boolean checkLogin(String username, String password, int isAdmin);
    /**
     * 注册功能
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public boolean registerData(String username, String password, int isAdmin, int staffId);
}
