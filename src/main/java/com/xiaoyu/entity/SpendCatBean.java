package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 消费分类
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/31 9:07
 */
@Data
public class SpendCatBean extends Pagination {
    private long spendCatId; // 消费分类主键
    private String spendCatName; // 消费分类名称
    private int orderNum; // 排序号
    private Date createDt; // 创建时间
    private String createBy; // 创建人
}
