package com.xiaoyu.service;

import com.xiaoyu.entity.UserBean;

import java.util.List;

public interface UserService {
    List<UserBean> queryUser(UserBean userBean);
}
