package com.xiaoyu.service;

import com.xiaoyu.entity.RoleBean;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/7/13 14:47
 */
public interface RoleService {
    List<RoleBean> queryRole(RoleBean roleBean);
}
