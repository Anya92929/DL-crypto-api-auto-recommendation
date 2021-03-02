package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

@C1130ez
/* renamed from: com.google.android.gms.internal.gp */
public final class C1226gp {
    /* renamed from: a */
    public static void m4664a(Context context, WebSettings webSettings) {
        C1221gn.m4651a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
