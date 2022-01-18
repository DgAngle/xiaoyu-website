package com.xiaoyu.dao;

import com.xiaoyu.entity.SysParamBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/18 14:28
 */
public interface SysParamMapper {
    @Select("select * from sys_param")
    List<SysParamBean> queryAllSysParam();
}
