package com.qianfeng.service;

import com.qianfeng.pojo.User;

/**
 * 业务层接口
 */
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);
}
