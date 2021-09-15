package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.dao.UserMapper;
import com.xiaoyu.entity.UserBean;
import com.xiaoyu.service.baseservice.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserBean> queryUserList(UserBean userBean) {
        return userMapper.queryUserList(userBean);
    }
}
