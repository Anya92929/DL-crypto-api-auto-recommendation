package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzkd;

/* renamed from: com.google.android.gms.ads.internal.ad */
class C1217ad extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ zzt f3439a;

    C1217ad(zzt zzt) {
        this.f3439a = zzt;
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.f3439a.f4077g != null) {
            try {
                this.f3439a.f4077g.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzkd.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.f3439a.mo5895b())) {
            return false;
        }
        if (str.startsWith((String) zzdc.zzbcy.get())) {
            if (this.f3439a.f4077g != null) {
                try {
                    this.f3439a.f4077g.onAdFailedToLoad(3);
                } catch (RemoteException e) {
                    zzkd.zzd("Could not call AdListener.onAdFailedToLoad().", e);
                }
            }
            this.f3439a.mo5894a(0);
            return true;
        } else if (str.startsWith((String) zzdc.zzbcz.get())) {
            if (this.f3439a.f4077g != null) {
                try {
                    this.f3439a.f4077g.onAdFailedToLoad(0);
                } catch (RemoteException e2) {
                    zzkd.zzd("Could not call AdListener.onAdFailedToLoad().", e2);
                }
            }
            this.f3439a.mo5894a(0);
            return true;
        } else if (str.startsWith((String) zzdc.zzbda.get())) {
            if (this.f3439a.f4077g != null) {
                try {
                    this.f3439a.f4077g.onAdLoaded();
                } catch (RemoteException e3) {
                    zzkd.zzd("Could not call AdListener.onAdLoaded().", e3);
                }
            }
            this.f3439a.mo5894a(this.f3439a.mo5892a(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.f3439a.f4077g != null) {
                try {
                    this.f3439a.f4077g.onAdLeftApplication();
                } catch (RemoteException e4) {
                    zzkd.zzd("Could not call AdListener.onAdLeftApplication().", e4);
                }
            }
            this.f3439a.m5863c(this.f3439a.m5859b(str));
            return true;
        }
    }
}
