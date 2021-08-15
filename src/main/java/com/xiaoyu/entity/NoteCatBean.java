package com.xiaoyu.entity;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * 笔记分类
 */
@Data
public class NoteCatBean extends Pagination {
    private long noteCatId; // 笔记分类主键
    private String noteCatName; // 分类名称
    private String noteCatNum; // 笔记分类编号,四位一级,例：000100010001
    private long parentNoteCatId; // 父级主键
    private String parentNoteCatNum; // 父级主键
    private int orderNum; //排序号
    private Date createDt; // 创建时间
    private String createBy; // 创建人
}
