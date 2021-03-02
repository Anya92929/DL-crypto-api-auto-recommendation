package com.google.ads;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.g;
import com.google.ads.util.b;
import java.util.HashMap;
import java.util.Locale;

public class q extends t {
    public void a(d dVar, HashMap<String, String> hashMap, WebView webView) {
        Uri parse;
        String host;
        String str = hashMap.get(AdActivity.URL_PARAM);
        if (str == null) {
            b.e("Could not get URL from click gmsg.");
            return;
        }
        g m = dVar.m();
        if (!(m == null || (host = parse.getHost()) == null || !host.toLowerCase(Locale.US).endsWith(".admob.com"))) {
            String str2 = null;
            String path = (parse = Uri.parse(str)).getPath();
            if (path != null) {
                String[] split = path.split("/");
                if (split.length >= 4) {
                    str2 = split[2] + "/" + split[3];
                }
            }
            m.b(str2);
        }
        super.a(dVar, hashMap, webView);
    }
}
