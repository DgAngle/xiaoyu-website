package com.xiaoyu.config;

import com.xiaoyu.entity.SysParamBean;
import com.xiaoyu.service.baseservice.SysParamService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/18 14:31
 */
@Component
public class SysParamRunner implements ApplicationRunner {
    @Resource
    private SysParamService sysParamService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<SysParamBean> sysParamBeans = sysParamService.queryAllSysParam();
        Optional.ofNullable(sysParamBeans).orElse(new ArrayList<>()).forEach((sysParam) -> {
            // if (SysParamConfig.sysParamsMap == null) SysParamConfig.sysParamsMap = new HashMap<>();
            // System.out.println(sysParam.toString()); w
            SysParamConfig.sysParamsMap.put(sysParam.getSysParamKey(), sysParam.getSysParamSecret());
        });
    }
}
