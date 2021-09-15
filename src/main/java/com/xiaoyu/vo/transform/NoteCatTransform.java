package com.xiaoyu.vo.transform;

import lombok.Data;

@Data
public class NoteCatTransform {
    private String noteCatId; // 分类主键
    private String noteCatName; // 分类名称
    private String noteCatNum; // 笔记分类编号,四位一级,例：000100010001
    private String parentNoteCatId; // 父级主键
    private String parentNoteCatNum; // 父级主键
    private String orderNum; //排序号
    private String createDt; // 创建时间
    private String createBy; // 创建人
}
