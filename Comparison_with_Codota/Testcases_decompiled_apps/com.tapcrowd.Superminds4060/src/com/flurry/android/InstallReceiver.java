package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.flurry.android.FlurryAgent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class InstallReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final Handler f73a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public File f74b = null;

    private InstallReceiver() {
        HandlerThread handlerThread = new HandlerThread("InstallReceiver");
        handlerThread.start();
        this.f73a = new Handler(handlerThread.getLooper());
    }

    public final void onReceive(Context context, Intent intent) {
        this.f74b = context.getFileStreamPath(".flurryinstallreceiver." + Integer.toString(FlurryAgent.m48e().hashCode(), 16));
        if (FlurryAgent.isCaptureUncaughtExceptions()) {
            Thread.setDefaultUncaughtExceptionHandler(new FlurryAgent.FlurryDefaultExceptionHandler());
        }
        String stringExtra = intent.getStringExtra("referrer");
        if (stringExtra != null && "com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            try {
                m64a(m63a(stringExtra));
            } catch (IllegalArgumentException e) {
                C0095ai.m104c("InstallReceiver", "Invalid referrer Tag: " + e.getMessage());
            }
        }
    }

    /* renamed from: a */
    private static Map m63a(String str) {
        if (str == null || str.trim().equals("")) {
            throw new IllegalArgumentException("Referrer is null or empty");
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("&");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                C0095ai.m96a("InstallReceiver", "Invalid referrer Element: " + split[i] + " in referrer tag " + str);
            } else {
                hashMap.put(split2[0], split2[1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (hashMap.get("utm_source") == null) {
            sb.append("Campaign Source is missing.\n");
        }
        if (hashMap.get("utm_medium") == null) {
            sb.append("Campaign Medium is missing.\n");
        }
        if (hashMap.get("utm_campaign") == null) {
            sb.append("Campaign Name is missing.\n");
        }
        if (sb.length() <= 0) {
            return hashMap;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: a */
    private synchronized void m64a(Map map) {
        this.f73a.post(new C0118t(this, map));
    }
}
