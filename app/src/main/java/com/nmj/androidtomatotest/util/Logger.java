package com.nmj.androidtomatotest.util;

/**
 * Created by nmj on 15. 6. 20..
 */
public class Logger {
    public static String TAG = "tomato";

    // debug
    public static void log(String log) {
        android.util.Log.d(TAG, log);
    }

    public static void log(String tag, String log) {
        android.util.Log.d(tag, log);
    }

    // warning
    public static void logw(String log) {
        android.util.Log.w(TAG, log);
    }
    public static void logw(String tag, String log) {
        android.util.Log.w(tag, log);
    }

    // error
    public static void loge(String log) {
        android.util.Log.e(TAG, log);
    }
    public static void loge(String tag, String log) { android.util.Log.e(tag, log); }

    // 클래스 이름으로 tag 생성
    public static String tag(Class<?> clazz) { return clazz.getName(); }
}