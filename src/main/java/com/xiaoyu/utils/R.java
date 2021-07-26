package com.xiaoyu.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装接口参数
 */
@Data
public class R {
    private int code; // 返回状态码
    private boolean value; // 返回值
    private String message; // 返回信息
    private Map<String, Object> data = new HashMap<>(); // 返回数据

    // 构造函数私有化, 只能使用提供的创建方法
    private R() {
    }

    /**************** 提供创建方法 ****************/
    // 调用成功的静态方法
    public static R success() {
        R r = new R();
        r.setValue(RCode.success_value);
        r.setCode(RCode.success_code);
        r.setMessage(RCode.success_message);
        return r;
    }

    // 调用失败的静态方法
    public static R error() {
        R r = new R();
        r.setValue(RCode.error_value);
        r.setCode(RCode.error_code);
        r.setMessage(RCode.error_message);
        return r;
    }

    /**************** 链式编程 ****************/

    // 设置返回值
    public R value(boolean value) {
        this.setValue(value);
        return this;
    }

    // 设置返回提示信息
    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    // 设置返回状态码
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    // 设置返回数据方式1
    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    // 设置返回数据方式2
    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}
