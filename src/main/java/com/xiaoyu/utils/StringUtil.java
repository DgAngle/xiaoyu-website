package com.xiaoyu.utils;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 字符串是否不为空, 不为空返回true, 为空返回false
     *
     * @param str 要校验的字符串
     * @return boolean
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 字符串是否为空, 为空返回true, 不为空返回false
     * [借鉴 org.apache.commons.lang > StringUtils.isBlank(str)]
     *
     * @param str 要校验的字符串
     * @return boolean
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 返回处理后的编号, 即当前父分类下要插入的下一个编号
     *
     * @param parentCatNum 父分类编号
     * @param maxNum       最大子分类编号
     * @return 处理后的编号
     */
    public static String getCatNum(String parentCatNum, String maxNum) {
        String catNum = "";
        if (StringUtils.isNotBlank(maxNum) && !maxNum.equals(parentCatNum)) {
            // 截取后四位, 即同一父分类下的最大子分类编号
            String temp = maxNum.substring(maxNum.length() - ConstantUtil.cat_num_length);
            catNum = parentCatNum + String.format("%04d", Integer.parseInt(temp) + 1);
        } else {
            catNum = ConstantUtil.cat_num_begin;
        }
        return catNum;
    }

}
