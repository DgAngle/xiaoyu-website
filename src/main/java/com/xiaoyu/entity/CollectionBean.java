package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 收藏
 *
 * @author gqshuang
 * @version 1.0
 * @date 2021/7/27 15:56
 */
@Data
public class CollectionBean extends Pagination {
    private long collectionId; // 主键
    private String collectionName; // 收藏名称
    private String collectionUrl; // 收藏地址
    private long collectionCatId; // 收藏分类主键
    private String remark; // 备注
    private Date createDt; // 创建时间
    private String createBy; // 创建人
}
