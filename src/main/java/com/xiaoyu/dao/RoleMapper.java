package com.xiaoyu.dao;

import com.xiaoyu.entity.RoleBean;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/7/13 14:48
 */
public interface RoleMapper {
    List<RoleBean> queryRole(RoleBean roleBean);
}
