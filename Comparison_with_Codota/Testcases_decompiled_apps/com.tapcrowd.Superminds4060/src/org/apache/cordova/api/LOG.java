package org.apache.cordova.api;

import android.util.Log;

public class LOG {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static int LOGLEVEL = 6;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static void setLogLevel(int logLevel) {
        LOGLEVEL = logLevel;
        Log.i("CordovaLog", "Changing log level to " + logLevel);
    }

    public static void setLogLevel(String logLevel) {
        if ("VERBOSE".equals(logLevel)) {
            LOGLEVEL = 2;
        } else if ("DEBUG".equals(logLevel)) {
            LOGLEVEL = 3;
        } else if ("INFO".equals(logLevel)) {
            LOGLEVEL = 4;
        } else if ("WARN".equals(logLevel)) {
            LOGLEVEL = 5;
        } else if ("ERROR".equals(logLevel)) {
            LOGLEVEL = 6;
        }
        Log.i("CordovaLog", "Changing log level to " + logLevel + "(" + LOGLEVEL + ")");
    }

    public static boolean isLoggable(int logLevel) {
        return logLevel >= LOGLEVEL;
    }

    /* renamed from: v */
    public static void m2224v(String tag, String s) {
        if (2 >= LOGLEVEL) {
            Log.v(tag, s);
        }
    }

    /* renamed from: d */
    public static void m2215d(String tag, String s) {
        if (3 >= LOGLEVEL) {
            Log.d(tag, s);
        }
    }

    /* renamed from: i */
    public static void m2221i(String tag, String s) {
        if (4 >= LOGLEVEL) {
            Log.i(tag, s);
        }
    }

    /* renamed from: w */
    public static void m2227w(String tag, String s) {
        if (5 >= LOGLEVEL) {
            Log.w(tag, s);
        }
    }

    /* renamed from: e */
    public static void m2218e(String tag, String s) {
        if (6 >= LOGLEVEL) {
            Log.e(tag, s);
        }
    }

    /* renamed from: v */
    public static void m2225v(String tag, String s, Throwable e) {
        if (2 >= LOGLEVEL) {
            Log.v(tag, s, e);
        }
    }

    /* renamed from: d */
    public static void m2216d(String tag, String s, Throwable e) {
        if (3 >= LOGLEVEL) {
            Log.d(tag, s, e);
        }
    }

    /* renamed from: i */
    public static void m2222i(String tag, String s, Throwable e) {
        if (4 >= LOGLEVEL) {
            Log.i(tag, s, e);
        }
    }

    /* renamed from: w */
    public static void m2228w(String tag, String s, Throwable e) {
        if (5 >= LOGLEVEL) {
            Log.w(tag, s, e);
        }
    }

    /* renamed from: e */
    public static void m2219e(String tag, String s, Throwable e) {
        if (6 >= LOGLEVEL) {
            Log.e(tag, s, e);
        }
    }

    /* renamed from: v */
    public static void m2226v(String tag, String s, Object... args) {
        if (2 >= LOGLEVEL) {
            Log.v(tag, String.format(s, args));
        }
    }

    /* renamed from: d */
    public static void m2217d(String tag, String s, Object... args) {
        if (3 >= LOGLEVEL) {
            Log.d(tag, String.format(s, args));
        }
    }

    /* renamed from: i */
    public static void m2223i(String tag, String s, Object... args) {
        if (4 >= LOGLEVEL) {
            Log.i(tag, String.format(s, args));
        }
    }

    /* renamed from: w */
    public static void m2229w(String tag, String s, Object... args) {
        if (5 >= LOGLEVEL) {
            Log.w(tag, String.format(s, args));
        }
    }

    /* renamed from: e */
    public static void m2220e(String tag, String s, Object... args) {
        if (6 >= LOGLEVEL) {
            Log.e(tag, String.format(s, args));
        }
    }
}
