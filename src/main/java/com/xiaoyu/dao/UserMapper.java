package com.xiaoyu.dao;

import com.xiaoyu.entity.UserBean;

import java.util.List;

public interface UserMapper {
    List<UserBean> queryUserList(UserBean userBean);

    int addUser(UserBean userBean);

    UserBean queryUser(UserBean userBean);

    int queryUserByUsername(String username);
}
