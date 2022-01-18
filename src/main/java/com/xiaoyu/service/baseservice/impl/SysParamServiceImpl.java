package com.xiaoyu.service.baseservice.impl;

import com.xiaoyu.dao.SysParamMapper;
import com.xiaoyu.entity.SysParamBean;
import com.xiaoyu.service.baseservice.SysParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/18 14:26
 */
@Service
public class SysParamServiceImpl implements SysParamService {
    @Resource
    private SysParamMapper sysParamMapper;

    @Override
    public List<SysParamBean> queryAllSysParam() {
        return sysParamMapper.queryAllSysParam();
    }
}
