package com.xiaoyu.web.connect.service;

import com.xiaoyu.utils.UserUtil;
import com.xiaoyu.web.connect.bean.DBConfig;
import com.xiaoyu.web.connect.mapper.ConnectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/11 13:13
 */
@Service
public class ConnectService {
    @Resource
    private ConnectMapper connectMapper;

    // 查询配置列表
    public List<DBConfig> queryList(DBConfig dbConfig) {
        return connectMapper.queryList();
    }

    // 新增配置
    public int insertConnect(DBConfig dbConfig) {
        return connectMapper.insertConnect(dbConfig);
    }

    // 更新配置
    public int updateConnect(DBConfig dbConfig) {
        dbConfig.setUpdateBy(UserUtil.getUser().getUserId());
        dbConfig.setUpdateDt(new Date());
        return connectMapper.updateConnect(dbConfig);
    }
}
