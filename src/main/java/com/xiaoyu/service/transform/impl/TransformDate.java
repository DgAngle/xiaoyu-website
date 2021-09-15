package com.xiaoyu.service.transform.impl;

import com.xiaoyu.service.transform.TypeHandler;
import com.xiaoyu.utils.DateUtil;

import java.util.Date;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2021/8/23 10:14
 */
public class TransformDate implements TypeHandler {
    @Override
    public String getType() {
        return "date";
    }

    @Override
    public Date transformStringToType(String str) {
        return DateUtil.stringToDate(str);
    }

    @Override
    public String transformTypeToString(Object obj) {
        return String.valueOf(obj);
    }
}
