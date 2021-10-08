package com.xiaoyu.vo.transform;

import lombok.Data;

import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/10/8 13:11
 */
@Data
public class CollectionCatTransform {
    private String collectionCatId; // 收藏分类主键
    private String collectionCatName; // 收藏分类名称
    private String collectionCatNum; // 收藏分类编号,四位一级,例：000100010001
    private String parentCollectionCatId; // 父级收藏主键
    private String parentCollectionCatNum; // 父级收藏编号
    private String orderNum; // 排序号
    private String createDt; // 创建时间
    private String createBy; // 创建人
}
