package com.qianfeng.service.impl;

import com.qianfeng.dao.BusinessDao;
import com.qianfeng.dao.BusinessinfoDao;
import com.qianfeng.dao.BusinesspassDao;
import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.Businesspass;
import com.qianfeng.service.BusinessLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class BusinessLoginServiceImpl implements BusinessLoginService {

    @Autowired
    BusinessDao businessDao;
    @Autowired
    BusinesspassDao businesspassDao;
    @Autowired
    BusinessinfoDao businessinfoDao;
    /**
     * 登录相关操作
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> businessLogin(Map<String, Object> map, HttpServletRequest request) {

        Map<String, Object> returnmap = new HashMap<>();

        //1 接收数据
        String business_username = (String)map.get("business_username");
        String business_pass_word = (String)map.get("business_pass_word");
        //2 开始处理登录功能
        Business business = businessDao.selectByUsername(business_username);
        if(business != null){   //用户名存在，继续判断密码
            Businesspass businesspass = new Businesspass();
            businesspass.setBusiness_id(business.getBusiness_id());
            businesspass.setBusiness_pass_word(business_pass_word);
            Businesspass businesspass1 = businesspassDao.selectBusinessPass(businesspass);

            if (businesspass1 != null){     // 登录成功
                returnmap.put("result",true);
                //==================start====================================================
                //0 获取session
                HttpSession session = request.getSession();
                //1 在session空间中保存一份角色类型
                session.setAttribute("roleType","2"); //普通商户
                //2 在session空间中保存一份用户相关信息（Business）
                session.setAttribute("business",business);
                //==================end====================================================


            }else{
                returnmap.put("result",false);
                returnmap.put("msg","请审核您的密码是否有误！！");
                returnmap.put("falseType",1);   // 密码错误
            }
        }else{  //反馈信息
            returnmap.put("result",false);
            returnmap.put("msg","您是否还没有账户，我们可以直接为您创建");
            returnmap.put("falseType",2);   //用户名不存在
        }
        return returnmap;
    }

    /**
     *
     * @param map
     * @return
     */
    @Override
    @Transactional
    public Map<String, Object> businessRegister(Map<String, Object> map,HttpServletRequest request) {

        Map<String, Object> returnmap = new HashMap<>();

        //1 接收数据
        String business_username = (String)map.get("business_username");
        String business_pass_word = (String)map.get("business_pass_word");

        //1 创建用户
        int res1 = businessDao.insertBusiness(business_username);
        //2 查询当前用户的id
        Business business = businessDao.selectByUsername(business_username);
        //3 创建对应用户的密码
        Businesspass businesspass = new Businesspass();
        businesspass.setBusiness_pass_word(business_pass_word);
        businesspass.setBusiness_id(business.getBusiness_id());
        int res2 = businesspassDao.insertBusinessPass(businesspass);
        //4 创建账户商家信息
        int res3 = businessinfoDao.insertBusinessInfo(business.getBusiness_id());
        if(res1>0 && res2>0 && res3>0){

            //==================start====================================================
            //0 获取session
            HttpSession session = request.getSession();
            //1 在session空间中保存一份角色类型
            session.setAttribute("roleType","2"); //普通商户
            //2 在session空间中保存一份用户相关信息（Business）
            session.setAttribute("business",business);
            //==================end====================================================

            returnmap.put("result",true);
            returnmap.put("msg","注册成功");
        }else{
            returnmap.put("result",false);
            returnmap.put("msg","注册失败");
        }
        return returnmap;
    }
}
