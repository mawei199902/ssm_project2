package com.qianfeng.dao;

import com.qianfeng.pojo.Businesspass;
import com.qianfeng.pojo.LoginPass;

public interface BusinesspassDao {

    /**
     * <!--##检查用户名对应密码是否正确-->
     * @param businesspass
     * @return
     */
    Businesspass selectBusinessPass(Businesspass businesspass);


    /**
     * <!--##创建对应用户的密码-->
     * @param businesspass
     * @return
     */


    int insertBusinessPass(Businesspass businesspass);

    /**
     * 更改商户密码
     * @param businesspass
     * @return
     */
    int updateBusinessPassWord(Businesspass businesspass);

}
