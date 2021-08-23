package com.xiaoyu.service.baseservice;

import com.xiaoyu.entity.UserBean;

import java.util.List;

public interface UserService {
    List<UserBean> queryUserList(UserBean userBean);
}
