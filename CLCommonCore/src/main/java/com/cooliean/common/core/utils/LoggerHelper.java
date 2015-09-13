package com.cooliean.common.core.utils;

import android.util.Log;

import com.cits.epark.mobile.ietree.BuildConfig;
import com.cits.epark.mobile.ietree.base.Constants;
import com.orhanobut.logger.Logger;

/**
 * Created by Cooliean on 15/7/27.
 */
public class LoggerHelper {
    private final static String LOG_TAG = LoggerHelper.class.getSimpleName();
    private static boolean DEBUG = BuildConfig.DEBUG;
    private String otherTag = "";

    private LoggerHelper() {
    }

    public LoggerHelper(Class clazz) {
        otherTag = clazz.getName();
    }

    public static final void analytics(Class clazz, String log) {
        if (DEBUG)
            Log.d(clazz.getName(), log);
    }

    public static final void error(Class clazz, String log) {
        if (DEBUG)
            Log.e(clazz.getName(), "" + log);
    }

    public static final void log(Class clazz, String log) {
        if (DEBUG)
            Log.i(clazz.getName(), log);
    }

    public static final void log(String log) {
        if (DEBUG)
            Log.i(LOG_TAG, log);
    }

    public static final void logv(Class clazz, String log) {
        if (DEBUG)
            Log.v(clazz.getName(), log);
    }

    public static final void warn(Class clazz, String log) {
        if (DEBUG)
            Log.w(clazz.getName(), log);
    }

    public void i(String log) {
        if (DEBUG)
            Logger.i(log+"", otherTag);
    }

    public void e(String log) {
        if (DEBUG)
            Logger.e(log+"", otherTag);
    }

    public void w(String log) {
        if (DEBUG)
            Logger.w(log+"", otherTag);
    }

    public void json(String log) {
        if (DEBUG)
            Logger.json(log);
    }
}
