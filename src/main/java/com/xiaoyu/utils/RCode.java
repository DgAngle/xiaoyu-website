package com.xiaoyu.utils;

/**
 * 返回代码
 */
public interface RCode {
    /************ 返回值 ************/
    public static final boolean success_value = true; // 调用成功
    public static final boolean error_value = false; // 调用失败

    /************ 返回状态码 ************/
    public static final int error_code = 30400; // 调用失败
    public static final int success_code = 30200; // 调用成功
    public static final int not_understand_code = 30400; // 无法解析的请求
    public static final int not_found_code = 30404; // 请求未找到
    public static final int service_error_code = 30500; // 请求未找到

    /************ 返回提示信息 ************/
    public static final String success_message = "调用成功！";
    public static final String error_message = "调用失败！";
    public static final String not_understand_message = "无法解析的请求！";
    public static final String not_found_message = "服务器找不到请求的网页！";
    public static final String service_error_message = "服务器遇到错误，无法完成请求！";
}
