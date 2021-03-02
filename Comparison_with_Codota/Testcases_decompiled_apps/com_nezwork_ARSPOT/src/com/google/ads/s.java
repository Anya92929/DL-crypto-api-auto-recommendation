package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class s implements n {
    private static final a a = a.a.b();

    public void a(d dVar, HashMap<String, String> hashMap, WebView webView) {
        String str = hashMap.get("js");
        if (str == null) {
            b.b("Could not get the JS to evaluate.");
        } else if (webView instanceof AdWebView) {
            AdActivity d = ((AdWebView) webView).d();
            if (d == null) {
                b.b("Could not get the AdActivity from the AdWebView.");
                return;
            }
            AdWebView openingAdWebView = d.getOpeningAdWebView();
            if (openingAdWebView == null) {
                b.b("Could not get the opening WebView.");
            } else {
                a.a((WebView) openingAdWebView, str);
            }
        } else {
            b.b("Trying to evaluate JS in a WebView that isn't an AdWebView");
        }
    }
}
