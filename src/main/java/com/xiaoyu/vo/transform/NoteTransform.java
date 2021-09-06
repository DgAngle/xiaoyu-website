package com.xiaoyu.vo.transform;

import lombok.Data;

@Data
public class NoteTransform {
    private String noteId; // 笔记主键
    private String noteName; // 笔记名称
    private String noteCatId; // 笔记分类
    private String noteLabel; // 笔记标签, 多个;号分隔
    private String noteContent; // 笔记内容
    private String level; // 重要等级 1-7, 用于非置顶排序;
    private String isTop; // 是否置顶 0:不公开, 1:公开 默认0
    private String createDt; // 创建时间
    private String createBy; // 创建人
}
