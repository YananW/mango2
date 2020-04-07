package com.mly.mango.utils;

/**
 * @author wyn
 * @Description 字符串工具类
 * @date 2020-04-05 10:23
 */
public class StringUtils {

    /**
     * 判空操作
     * @param value
     * @return
     */
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }

}
