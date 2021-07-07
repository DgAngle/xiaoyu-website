package com.xiaoyu.common;

import lombok.Data;

/**
 * 分页
 */
@Data
public class Pagination {
    private int start; // 开始数目
    private int pageCount; // 每页数量
    private int totalCount; // 总数量
    private int currentPage; // 当前页码
    private int totalPage; // 总页码
}
