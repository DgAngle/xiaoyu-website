package com.xiaoyu.vo.basevo;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/8 15:01
 */
@Data
public class CollectionQuery extends Pagination {
    private String collectionId; // 主键
    private String collectionName; // 收藏名称
    private String collectionUrl; // 收藏地址
    private String collectionCatId; // 收藏分类主键
    private String remark; // 备注
    private String createDt; // 创建时间
    private String createBy; // 创建人
}
