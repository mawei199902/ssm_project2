package com.qianfeng.dao;

import com.qianfeng.pojo.Businessinfo;

public interface BusinessinfoDao {

    /**
     * 插入商家信息
     * @param businessinfo
     * @return
     */
    int insertBusinessInfo(int businessinfo);

    /*
    *修改商家信息
     */
    int updateBusinessInfo( Businessinfo businessinfo);
}
