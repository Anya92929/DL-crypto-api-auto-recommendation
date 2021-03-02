package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

/* renamed from: com.google.android.gms.internal.ck */
public final class C0341ck {
    /* renamed from: a */
    public static void m719a(Context context, WebSettings webSettings) {
        C0340cj.m713a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
