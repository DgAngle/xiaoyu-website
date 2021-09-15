package com.xiaoyu.common;

import lombok.Data;

/**
 * 分页
 */
@Data
public class Pagination {
    private int start; // 开始数目
    private int pageCount = 15; // 每页数量
    private int totalCount; // 总数量
    private int currentPage = 1; // 当前页码
    private int totalPage; // 总页码

    public int getStart() {
        if (getCurrentPage() >= 1) {
            return (getCurrentPage() - 1) * getPageCount();
        }
        return start;
    }
}
