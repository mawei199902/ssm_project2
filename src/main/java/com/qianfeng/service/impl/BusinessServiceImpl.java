package com.qianfeng.service.impl;

import com.qianfeng.dao.BusinessDao;
import com.qianfeng.dao.BusinessinfoDao;
import com.qianfeng.dao.BusinesspassDao;
import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.BusinessUserAndUsername;
import com.qianfeng.pojo.Businessinfo;
import com.qianfeng.pojo.Businesspass;
import com.qianfeng.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BusinessDao businessDao;
    @Autowired
    BusinesspassDao businesspassDao;
    @Autowired
    BusinessinfoDao businessinfoDao;

    @Override
    @Transactional
    public boolean updateBusinessInfo(BusinessUserAndUsername businessUserAndUsername, HttpServletRequest request) {
        //0获取session

        int business_id = ((Business)request.getSession().getAttribute("business")).getBusiness_id();

        //1.修改商户名

        Business business = new Business();
        business.setBusiness_id(business_id);
        business.setBusiness_username(business.getBusiness_username());
        int res1 = businessDao.updateBusinessName(business);
        //2.修改商户密码

        Businesspass businesspass = new Businesspass();
        businesspass.setBusiness_pass_word(businesspass.getBusiness_pass_word());
        businesspass.setBusiness_id(business_id);
        int res2=businesspassDao.updateBusinessPassWord(businesspass);

        //3.修改商户信息

        Businessinfo businessinfo = new Businessinfo();

        businessinfo.setBusiness_id(business_id);
        businessinfo.setBusiness_info_legal_person(businessUserAndUsername.getBusiness_info_legal_person());
        businessinfo.setBusiness_info_legal_person_tel(businessUserAndUsername.getBusiness_info_legal_person_tel());
        businessinfo.setBusiness_info_name(businessUserAndUsername.getBusiness_info_name());

        int res3 = businessinfoDao.updateBusinessInfo(businessinfo);

        if(res1>0&&res2>0&&res3>0){
            return  true;

        }else {

            return  false;
        }

    }
}
