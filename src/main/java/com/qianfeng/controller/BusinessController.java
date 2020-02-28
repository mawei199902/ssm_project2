package com.qianfeng.controller;

import com.qianfeng.pojo.BusinessUserAndUsername;
import com.qianfeng.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/BusinessController")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @RequestMapping("/updateBusinessInfo")
    public String updateBusinessInfo(BusinessUserAndUsername businessUserAndUsername, HttpServletRequest request){

        boolean b = businessService.updateBusinessInfo(businessUserAndUsername,request);
        if(b){
            request.setAttribute("msg","修改成功");
        }else{
            request.setAttribute("msg","修改失败");
        }

        return "../page/business/businessoper.jsp";
    }
}
