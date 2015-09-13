package com.cooliean.common.core.utils;

/**
 * Created by Cooliean on 15/8/7.
 */
public class Convertor {
    /**
     * 字符串转Double
     * @param s
     * @return
     */
    public static double parserToDouble(String s) {
        double result = 0;
        try {
            result = Double.valueOf(s);
            return result;
        } catch (Exception e) {
        }
        return 0;
    }
}
