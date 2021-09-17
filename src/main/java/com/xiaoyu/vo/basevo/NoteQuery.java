package com.xiaoyu.vo.basevo;

import com.xiaoyu.common.Pagination;
import lombok.Data;

import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/9/6 10:05
 */
@Data
public class NoteQuery extends Pagination {
    private String noteId; // 笔记主键
    private String noteName; // 笔记名称
    private String noteCatId; // 笔记分类
    private String noteLabel; // 笔记标签, 多个;号分隔
    private String noteContent; // 笔记内容
    private int level; // 重要等级 1-7, 用于非置顶排序;
    private int isTop; // 是否置顶 0:不公开, 1:公开 默认0
    private String createDt; // 创建时间
    private String createBy; // 创建人

    private String createStartDt;
    private String createEndDt;

}
