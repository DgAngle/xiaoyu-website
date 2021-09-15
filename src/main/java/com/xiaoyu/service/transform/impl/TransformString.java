package com.xiaoyu.service.transform.impl;

import com.xiaoyu.service.transform.TypeHandler;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/23 10:14
 */
public class TransformString implements TypeHandler {
    @Override
    public String getType() {
        return "date";
    }

    @Override
    public String transformStringToType(String str) {
        return str;
    }

    @Override
    public String transformTypeToString(Object obj) {
        return String.valueOf(obj);
    }
}
