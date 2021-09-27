package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.dao.UserMapper;
import com.xiaoyu.entity.UserBean;
import com.xiaoyu.service.baseservice.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserBean> queryUserList(UserBean userBean) {
        return userMapper.queryUserList(userBean);
    }

    @Override
    public int addUser(UserBean userBean) {
        userBean.setUserId(UUID.randomUUID().toString());
        userBean.setIsDel(0);
        userBean.setCreateDt(new Date());
        return userMapper.addUser(userBean);
    }

    @Override
    public UserBean queryUser(UserBean userBean) {
        return userMapper.queryUser(userBean);
    }

    @Override
    public int queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }
}
