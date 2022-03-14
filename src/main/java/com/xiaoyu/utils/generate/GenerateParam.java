package com.xiaoyu.utils.generate;

import lombok.Data;

/**
 * 封装生成代码必需参数
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/14 15:30
 */
@Data
public class GenerateParam {
    private String author; // 作者
    private String version; // 版本
    private String currentDate; // 当前时间
    private String tableName; // 表名
    private String packageName; // 包名
    private String tableAnnotation; // 表注解
    private String driver; // 数据库驱动
    private String url; // 数据库连接串
    private String user; // 数据库用户名
    private String password; // 数据库密码
    private String diskPath; // 本地磁盘路径
}
