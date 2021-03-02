package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0247d;
import com.google.ads.util.C0284b;
import java.util.HashMap;

/* renamed from: com.google.ads.s */
public class C0277s implements C0273o {
    /* renamed from: a */
    public void mo3325a(C0247d dVar, HashMap<String, String> hashMap, WebView webView) {
        if (webView instanceof AdWebView) {
            ((AdWebView) webView).mo3456f();
        } else {
            C0284b.m484b("Trying to close WebView that isn't an AdWebView");
        }
    }
}
