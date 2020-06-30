package com.housemgt.service.login;

import com.housemgt.model.Staff;

public interface StaffService {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    public Staff queryInfoByUsername(String username);

}
