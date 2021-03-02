package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.c;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class v implements n {
    public void a(d dVar, HashMap<String, String> hashMap, WebView webView) {
        String str = hashMap.get("url");
        boolean equals = "1".equals(hashMap.get("drt_include"));
        b.c("Received ad url: <url: \"" + str + "\" type: \"" + hashMap.get("type") + "\" afmaNotifyDt: \"" + hashMap.get("afma_notify_dt") + "\">");
        c j = dVar.j();
        if (j != null) {
            j.c(equals);
            j.d(str);
        }
    }
}
