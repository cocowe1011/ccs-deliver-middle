package com.middle.pcs.login.service;


import java.util.HashMap;
import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
public interface LoginService {

    /**
     * q3
     * @return
     */
    List<HashMap<String, Object>> getValidCode();

}
