package com.middle.ccs.user.controller;

import com.middle.ccs.hander.ResponseResult;
import com.middle.ccs.user.entity.UserInfo;
import com.middle.ccs.user.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @classDesc: 控制器:(UserInfo)
 * @author: makejava
 * @date: 2023-06-27 20:58:06
 * @copyright 众阳健康
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/save")
    public ResponseResult<Integer> save (@RequestBody UserInfo userInfo) {
        return  ResponseResult.success(userInfoService.save(userInfo));
    }
}