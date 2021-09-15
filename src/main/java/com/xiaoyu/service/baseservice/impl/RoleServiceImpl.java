package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.dao.RoleMapper;
import com.xiaoyu.entity.RoleBean;
import com.xiaoyu.service.baseservice.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/7/13 14:47
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<RoleBean> queryRole(RoleBean roleBean) {
        return roleMapper.queryRole(roleBean);
    }
}
