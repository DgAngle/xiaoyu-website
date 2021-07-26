package com.xiaoyu.entity;

import lombok.Data;

import java.util.Date;

/**
 * 笔记标签
 */
@Data
public class LabelBean {
    private long labelId; // 标签主键
    private String labelName; // 标签名称
    private int useCount; // 使用数量
    private int labelType; // 标签类型, 笔记的标签, 音乐的标签, 其他标签等等
    private int nameSymbol; // 标签首字母拼音符号, 用于按照字母分类查找标签
    private int orderNum; //排序号
    private Date createDt; // 创建时间
    private String createBy; // 创建人
}
