package com.xiaoyu.web.connect.bean;

import com.xiaoyu.entity.BaseBean;
import lombok.Data;

/**
 * 数据库配置
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/11 13:16
 */
@Data
public class DBConfig extends BaseBean {
    private Long dbConfigId; // 驱动
    private String connectName; // 连接名称
    private String dbName; // 数据库名称
    private String driver; // 驱动
    private String host; // 主机地址
    private String port; // 端口
    private String type; // 类型: mysql、oracle
    private String username; // 用户名
    private String password; // 密码
    private String url; // 连接串
    private String remark; // 备注
}
