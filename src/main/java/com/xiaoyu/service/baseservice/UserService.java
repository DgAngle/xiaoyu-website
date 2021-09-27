package com.xiaoyu.service.baseservice;

import com.xiaoyu.entity.UserBean;

import java.util.List;

public interface UserService {
    List<UserBean> queryUserList(UserBean userBean);

    int addUser(UserBean userBean);

    UserBean queryUser(UserBean userBean);

    int queryUserByUsername(String username);
}
