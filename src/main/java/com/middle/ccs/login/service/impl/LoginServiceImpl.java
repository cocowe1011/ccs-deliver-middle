package com.middle.ccs.login.service.impl;

import com.middle.ccs.login.dao.LoginServiceMapper;
import com.middle.ccs.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginServiceMapper loginServiceMapper;


    @Override
    public List<HashMap<String, Object>> getValidCode() {
        return loginServiceMapper.getValidCode();
    }
}
