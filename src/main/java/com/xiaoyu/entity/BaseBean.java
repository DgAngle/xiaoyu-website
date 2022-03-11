package com.xiaoyu.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/3/11 13:25
 */
@Data
public class BaseBean {
    private String createBy; // 创建人
    private Date createDt; // 创建时间
    private String updateBy; // 更新人
    private Date updateDt; // 更新时间
}
