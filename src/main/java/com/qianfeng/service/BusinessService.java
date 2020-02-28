package com.qianfeng.service;

import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.BusinessUserAndUsername;

import javax.servlet.http.HttpServletRequest;

public interface BusinessService {

    /**
     * 修改商户信息
     * @param businessUserAndUsername
     * @param request
     * @return
     */
    boolean updateBusinessInfo(BusinessUserAndUsername businessUserAndUsername, HttpServletRequest request);
}
