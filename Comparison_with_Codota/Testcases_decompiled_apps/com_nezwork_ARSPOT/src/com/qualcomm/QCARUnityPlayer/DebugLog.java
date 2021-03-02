package com.qualcomm.QCARUnityPlayer;

import android.util.Log;

public class DebugLog {
    private static final String LOGTAG = "QCAR";

    public static final void LOGE(String nMessage) {
        Log.e(LOGTAG, nMessage);
    }

    public static final void LOGW(String nMessage) {
        Log.w(LOGTAG, nMessage);
    }

    public static final void LOGD(String nMessage) {
        Log.d(LOGTAG, nMessage);
    }

    public static final void LOGI(String nMessage) {
        Log.i(LOGTAG, nMessage);
    }
}
