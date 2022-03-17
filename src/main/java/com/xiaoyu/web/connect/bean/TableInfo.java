package com.xiaoyu.web.connect.bean;

import com.xiaoyu.utils.DateUtil;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 数据表信息
 *
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/11 13:17
 */
@Data
public class TableInfo {
    private String tableName; // 表的名称
    private String tableComment; // 表的备注
    private String engine; // 数据库引擎
    private Date createTime; // 数据库引擎
    private String createTimeStr; // 数据库引擎

    private ColumnInfo primaryKey; // 表的主键
    private List<ColumnInfo> columns; //表的列名(不包含主键)
    private String classUppercaseName; //类名(第一个字母大写)，如：sys_user => SysUser
    private String classLowercaseName;  //类名(第一个字母小写)，如：sys_user => sysUser

    public String getCreateTimeStr() {
        if (createTime != null) return DateUtil.dateToString(createTime);
        return createTimeStr;
    }
}
