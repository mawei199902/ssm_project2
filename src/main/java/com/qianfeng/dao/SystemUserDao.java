package com.qianfeng.dao;

import com.qianfeng.pojo.BusinessUserAndUsername;
import com.qianfeng.pojo.SystemUser;
import com.qianfeng.pojo.SystemUserAndUsername;

import java.util.List;

public interface SystemUserDao {

    /**
     * 查询所有系统用户信息
     * @return
     */
    List<SystemUserAndUsername> selectSystemUserAllInfo();

    SystemUserAndUsername selectSystemUserByID(int login_user_id);



    List<BusinessUserAndUsername> selectBusinessUserAllInfo();

    /**
     * 根据id查询系统用户信息
     * @param business_id
     * @return
     */
    BusinessUserAndUsername selectBusinessUserByID(int business_id);

    /**
     * 修改个人信息
     * @param systemUser
     * @return
     */
    int updateAllData(SystemUser systemUser);
}
