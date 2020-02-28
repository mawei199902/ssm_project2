package com.qianfeng.controller;

import com.qianfeng.pojo.User;
import com.qianfeng.service.UserService;
import com.qianfeng.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    UserService userService;

    @RequestMapping("/addUser")
    public String addUser(User user){
        boolean b = userService.addUser(user);
        if(b){
            return "../page/success.jsp";
        }else{
            return "../page/error.jsp";
        }
    }
}
