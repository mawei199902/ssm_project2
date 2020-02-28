package com.qianfeng.controller;

import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.BusinessUserAndUsername;
import com.qianfeng.pojo.LoginUser;
import com.qianfeng.pojo.SystemUserAndUsername;
import com.qianfeng.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/SystemUserController")
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;

    @RequestMapping("/getSystemUserAllInfo")
    public String getSystemUserAllInfo(HttpServletRequest request){
        List<SystemUserAndUsername> list = systemUserService.getSystemUserAllInfo();
        request.setAttribute("list",list);
        return "../page/system/systemoper.jsp";
    }

    @RequestMapping("/getSystemUserByID")
    @ResponseBody
    public SystemUserAndUsername getSystemUserByID(HttpServletRequest request){
        HttpSession session = request.getSession();
        int login_user_id = ((LoginUser)session.getAttribute("loginUser")).getLogin_user_id();
        return systemUserService.selectSystemUserByID(login_user_id);
    }

    @RequestMapping("/getBusinessUserAllInfo")
    public String getBusinessUserAllInfo(HttpServletRequest request){
        List<BusinessUserAndUsername> list = systemUserService.getBusinessUserAllInfo();
        request.setAttribute("list",list);
        return "../page/system/selectBusinessInfo.jsp";
    }

    @RequestMapping("/getBusinessUserByID")
    @ResponseBody
    public BusinessUserAndUsername getBusinessUserByID(HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        return systemUserService.selectBusinessUserByID(business_id);
    }



    @RequestMapping("/updateSystemUser")
    public String updateSystemUser(SystemUserAndUsername systemUserAndUsername,HttpServletRequest request){

        boolean b = systemUserService.updateSystemUser(systemUserAndUsername,request);
        if(b){
            request.setAttribute("msg","修改成功");
        }else{
            request.setAttribute("msg","修改失败");
        }

        return "../page/system/addSystemoper.jsp";
    }

}
