package com.qianfeng.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录相关业务流程
 */
public interface LoginService {

    Map<String,Object> login(Map<String,Object> map, HttpServletRequest request);

}
