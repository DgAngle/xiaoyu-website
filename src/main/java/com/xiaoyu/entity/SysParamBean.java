package com.xiaoyu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/18 14:16
 */
@Data
public class SysParamBean {
    private long sysParamId; // 系统参数主键
    private String sysParamName; // 系统参数名称
    private String sysParamKey; // 系统参数Key
    private String sysParamSecret; // 系统参数密钥
    private Date createDt; // 创建时间
    private String createBy; // 创建人
}
