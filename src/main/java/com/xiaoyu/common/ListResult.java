package com.xiaoyu.common;

import lombok.Data;

import java.util.List;

/**
 * 查询列表封装
 *
 * @param <T> 列表对象
 */
@Data
public class ListResult<T> {
    private List<T> list;
    private Pagination pagination;
}
