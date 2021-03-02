package com.forexcrunch.forexcrunch.gcm;

import android.content.Context;
import com.google.android.gcm.GCMBroadcastReceiver;

public class GCMReceiver extends GCMBroadcastReceiver {
    /* access modifiers changed from: protected */
    public String getGCMIntentServiceClassName(Context context) {
        return "com.forexcrunch.forexcrunch.gcm.GCMIntentService";
    }
}
