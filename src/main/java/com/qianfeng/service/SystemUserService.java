package com.qianfeng.service;

import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.BusinessUserAndUsername;
import com.qianfeng.pojo.SystemUserAndUsername;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface SystemUserService {

    List<SystemUserAndUsername> getSystemUserAllInfo();

    /**
     * 根据id查询系统用户信息
     * @param login_user_id
     * @return
     */
    SystemUserAndUsername selectSystemUserByID(int login_user_id);


     List<BusinessUserAndUsername> getBusinessUserAllInfo();

    /**
     * 根据id查询商户信息
     * @param business_id
     * @return
     */
    BusinessUserAndUsername selectBusinessUserByID(int business_id);

    /**
     * 修改系统用户数据
     * @param systemUserAndUsername
     * @param request
     * @return
     */
    boolean updateSystemUser(SystemUserAndUsername systemUserAndUsername, HttpServletRequest request);

}
