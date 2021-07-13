package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 角色实体
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/7/13 14:39
 */

@Data
public class RoleBean extends Pagination {
    private long roleId; // 角色ID
    private String roleName; // 角色名称
    private int orderNum; // 排序号
    private Date createDt; // 创建日期
    private String createBy; // 创建人
}
