package com.qianfeng.dao;

import com.qianfeng.pojo.Business;

public interface BusinessDao {

    /**
     * 查询对应用户名的数据
     * @param business_username
     * @return
     */
    Business selectByUsername(String business_username);

    /**
     * 插入商户登录名信息
     * @param business_username
     * @return
     */
    int insertBusiness(String business_username);

    /**
     * 更改商铺名
     * @param business
     * @return
     */

    int updateBusinessName(Business business);
}
