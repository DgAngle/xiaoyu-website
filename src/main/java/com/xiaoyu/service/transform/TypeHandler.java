package com.xiaoyu.service.transform;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/23 10:12
 */
public interface TypeHandler {
    String getType();

    Object transformStringToType(String str);

    String transformTypeToString(Object obj);
}
