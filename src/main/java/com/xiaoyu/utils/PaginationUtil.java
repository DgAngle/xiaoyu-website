package com.xiaoyu.utils;

import com.xiaoyu.common.Pagination;

/**
 * 分页工具类
 */
public class PaginationUtil<T> {
    public static Pagination instance() {
        Pagination pagination = new Pagination();
        pagination.setCurrentPage(1);
        pagination.setStart(0);
        return pagination;
    }

    public static Pagination instance(int pageCount) {
        Pagination pagination = new Pagination();
        return pagination;
    }

    public static Pagination queryPagination(Pagination pagination) {
        return instance();
    }
}
