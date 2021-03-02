package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.C0247d;
import com.google.ads.util.C0284b;
import java.util.HashMap;

/* renamed from: com.google.ads.u */
public class C0279u implements C0273o {
    /* renamed from: a */
    public void mo3325a(C0247d dVar, HashMap<String, String> hashMap, WebView webView) {
        String str = hashMap.get(AdActivity.URL_PARAM);
        if (TextUtils.isEmpty(str)) {
            C0284b.m490e("Could not get URL from track gmsg.");
        } else {
            new Thread(new C0170ae(str, dVar.mo3550i().f659f.mo3725a())).start();
        }
    }
}
