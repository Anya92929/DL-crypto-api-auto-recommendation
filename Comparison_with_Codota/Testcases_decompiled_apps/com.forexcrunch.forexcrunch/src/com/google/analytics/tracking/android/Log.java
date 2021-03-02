package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;

public class Log {
    @VisibleForTesting
    static final String LOG_TAG = "GAV2";
    private static boolean sDebug;

    private Log() {
    }

    public static void setDebug(boolean debug) {
        sDebug = debug;
    }

    public static boolean isDebugEnabled() {
        return sDebug;
    }

    /* renamed from: d */
    public static int m525d(String msg) {
        return android.util.Log.d(LOG_TAG, formatMessage(msg));
    }

    public static int dDebug(String msg) {
        if (sDebug) {
            return m525d(msg);
        }
        return 0;
    }

    /* renamed from: e */
    public static int m526e(String msg) {
        return android.util.Log.e(LOG_TAG, formatMessage(msg));
    }

    public static int eDebug(String msg) {
        if (sDebug) {
            return m526e(msg);
        }
        return 0;
    }

    /* renamed from: i */
    public static int m527i(String msg) {
        return android.util.Log.i(LOG_TAG, formatMessage(msg));
    }

    public static int iDebug(String msg) {
        if (sDebug) {
            return m527i(msg);
        }
        return 0;
    }

    /* renamed from: v */
    public static int m528v(String msg) {
        return android.util.Log.v(LOG_TAG, formatMessage(msg));
    }

    public static int vDebug(String msg) {
        if (sDebug) {
            return m528v(msg);
        }
        return 0;
    }

    /* renamed from: w */
    public static int m529w(String msg) {
        return android.util.Log.w(LOG_TAG, formatMessage(msg));
    }

    public static int wDebug(String msg) {
        if (sDebug) {
            return m529w(msg);
        }
        return 0;
    }

    private static String formatMessage(String msg) {
        return Thread.currentThread().toString() + ": " + msg;
    }
}
