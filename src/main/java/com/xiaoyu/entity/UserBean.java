package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

@Data
public class UserBean extends Pagination {
    // private long id; // 用户ID
    private String userId; // 用户主键
    private String realname; // 真实姓名
    private String username; // 用户名
    private String password; // 密码
    private int sex; // 性别：0：女, 1：男
    private String email; // 邮箱
    private String phone; // 手机
    private String identify; // 身份证
    private String remark; // 备注
}
