package com.xiaoyu.service.transform.impl;

import com.xiaoyu.service.transform.TypeHandler;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/23 10:14
 */
public class TransformLong implements TypeHandler {
    @Override
    public String getType() {
        return "long";
    }

    @Override
    public Long transformStringToType(String str) {
        return Long.parseLong(str);
    }

    @Override
    public String transformTypeToString(Object obj) {
        return String.valueOf(obj);
    }
}
