package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 收藏分类
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/7/27 15:59
 */
@Data
public class CollectionCatBean extends Pagination {
    private long collectionCatId; // 收藏分类主键
    private String collectionCatName; // 收藏分类名称
    private int orderNum; // 排序号
    private Date createDt; // 创建时间
    private String createBy; // 创建人
}
