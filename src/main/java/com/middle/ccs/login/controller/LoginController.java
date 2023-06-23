package com.middle.ccs.login.controller;

import com.middle.ccs.login.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 上报网站后台登陆接口
 * @author 文亮
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/getValidCode")
    public List<HashMap<String, Object>> getValidCode() {
        return loginService.getValidCode();
    }
}
