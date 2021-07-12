package com.xiaoyu.service.impl;

import com.xiaoyu.dao.UserMapper;
import com.xiaoyu.entity.UserBean;
import com.xiaoyu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserBean> queryUser(UserBean userBean) {
        return userMapper.queryUser(userBean);
    }
}
