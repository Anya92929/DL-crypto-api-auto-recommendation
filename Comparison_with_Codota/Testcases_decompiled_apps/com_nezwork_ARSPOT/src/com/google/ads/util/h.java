package com.google.ads.util;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;
import com.google.ads.m;
import com.google.ads.util.g;

@TargetApi(14)
public class h {

    public static class a extends g.a {
        public a(m mVar) {
            super(mVar);
        }

        public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
            callback.onCustomViewHidden();
        }
    }
}
