package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Paint;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

@C1130ez
/* renamed from: com.google.android.gms.internal.gn */
public final class C1221gn {
    /* renamed from: a */
    public static void m4651a(Context context, WebSettings webSettings) {
        webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        webSettings.setAppCacheMaxSize(0);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
    }

    /* renamed from: a */
    public static void m4652a(Window window) {
        window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
    }

    /* renamed from: a */
    public static void m4653a(WebView webView) {
        webView.onPause();
    }

    /* renamed from: b */
    public static void m4654b(WebView webView) {
        webView.onResume();
    }

    /* renamed from: i */
    public static void m4655i(View view) {
        view.setLayerType(1, (Paint) null);
    }

    /* renamed from: j */
    public static void m4656j(View view) {
        view.setLayerType(0, (Paint) null);
    }
}
