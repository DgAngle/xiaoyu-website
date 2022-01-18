package com.xiaoyu.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gqshuang
 * @version 1.0
 * @date 2022/1/18 14:37
 */
public class SysParamConfig {
    public static Map<String, String> sysParamsMap = new HashMap<>(); // 系统参数 key <-> value
    public static final String sysParam_userAdmin = "userAdmin"; // 超级管理员 -> key
    public static final String sysParam_uploadPath = "uploadPath"; // 上传路径 -> key
}
