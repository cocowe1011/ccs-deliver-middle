package com.middle.ccs.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.middle.ccs.hander.BusinessException;
import com.middle.ccs.hander.CommonErrorCode;
import com.middle.ccs.user.entity.UserInfo;
import com.middle.ccs.user.dao.UserInfoMapper;
import com.middle.ccs.user.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @classDesc: 业务逻辑:(UserInfo)
 * @author: makejava
 * @date: 2023-06-27 20:58:08
 * @copyright 众阳健康
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;


    @Override
    public Integer save (UserInfo userInfo) {
        // 先判断userCode有没有被注册过
        List<UserInfo> entity =  userInfoMapper.selectUserList(userInfo);
        if(entity.size() > 0) {
            throw BusinessException.build(CommonErrorCode.DUPLICATE_USER_CODE);
        }
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public Boolean verifyName(UserInfo userInfo) {
        List<UserInfo> entity =  userInfoMapper.selectUserList(userInfo);
        if(entity.size() < 1) {
            throw BusinessException.build(CommonErrorCode.NOT_EXITS_USER_CODE);
        }
        return userInfo.getUserName().equals(entity.get(0).getUserName());
    }

    @Override
    public Integer updatePassword(UserInfo userInfo) {
        return userInfoMapper.updatePassword(userInfo);
    }
}
