package com.xiaoyu.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量工具类
 */
public class ConstantUtil {

    // 配置表 configName 索引
    public static String CONFIG_ALIYUN_OSS = "aliyun_oss"; // 阿里云OSS

    // 定义公开的静态常量
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;


    // 小写字母数组
    public static final char[] letter_lowercase_array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    // 大写字母数组
    public static final char[] letter_uppercase_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* 分类编号 */
    public static final int cat_num_length = 4; // 分类编号长度
    public static final String cat_num_begin = "0001"; // 分类编号起始值

    /* 计划状态码 */
    public static final int plan_status_not_start = 0; // 计划未开始
    public static final int plan_status_underway = 2;  // 计划进行中
    public static final int plan_status_unfinished = 3;  // 计划未完成
    public static final int plan_status_cancel = 4;  // 计划取消
    public static final int plan_status_delay = 5;  // 计划延期
    // public static final int plan_status_delay_finished = 58;  // 计划延期完成
    public static final int plan_status_finished = 8;  // 计划已完成

    /* 计划状态码对应信息 */
    public static final String plan_status_not_start_message = "未开始";
    public static final String plan_status_underway_message = "进行中";
    public static final String plan_status_cancel_message = "已取消";
    public static final String plan_status_delay_message = "延期中";
    // public static final String plan_status_delay_finished_message = "延期完成";
    public static final String plan_status_finished_message = "已完成";
    public static final String plan_status_unfinished_message = "未完成";
    /* 计划 Map */
    public static final Map<Integer, String> planMap;

    static {
        planMap = new HashMap<Integer, String>();
        planMap.put(plan_status_not_start, plan_status_not_start_message);
        planMap.put(plan_status_underway, plan_status_underway_message);
        planMap.put(plan_status_cancel, plan_status_cancel_message);
        planMap.put(plan_status_delay, plan_status_delay_message);
        // planMap.put(plan_status_delay_finished, plan_status_delay_finished_message);
        planMap.put(plan_status_finished, plan_status_finished_message);
        planMap.put(plan_status_unfinished, plan_status_unfinished_message);
    }

    ;
}
