package com.qianfeng.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface BusinessLoginService {

    /**
     * 商家登录功能
     * @return
     */
     Map<String,Object> businessLogin(Map<String,Object> map, HttpServletRequest request);

    /**
     * 商家注册功能
     * @param map
     * @return
     */
     Map<String,Object> businessRegister(Map<String,Object> map,HttpServletRequest request);



}
