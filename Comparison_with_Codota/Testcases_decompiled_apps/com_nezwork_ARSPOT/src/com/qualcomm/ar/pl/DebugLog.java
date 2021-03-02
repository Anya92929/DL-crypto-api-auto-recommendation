package com.qualcomm.ar.pl;

import android.util.Log;

public class DebugLog {
    private static final String LOGTAG = "AR";

    public static final void LOGE(String subtag, String nMessage) {
        if (subtag.length() > 0) {
            nMessage = subtag + ": " + nMessage;
        }
        Log.e(LOGTAG, nMessage);
    }

    public static final void LOGW(String subtag, String nMessage) {
        if (subtag.length() > 0) {
            nMessage = subtag + ": " + nMessage;
        }
        Log.w(LOGTAG, nMessage);
    }

    public static final void LOGD(String subtag, String nMessage) {
        if (subtag.length() > 0) {
            nMessage = subtag + ": " + nMessage;
        }
        Log.d(LOGTAG, nMessage);
    }

    public static final void LOGI(String subtag, String nMessage) {
        if (subtag.length() > 0) {
            nMessage = subtag + ": " + nMessage;
        }
        Log.i(LOGTAG, nMessage);
    }
}
