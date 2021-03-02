package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0247d;
import com.google.ads.util.C0284b;
import java.util.HashMap;

/* renamed from: com.google.ads.p */
public class C0274p implements C0273o {
    /* renamed from: a */
    public void mo3325a(C0247d dVar, HashMap<String, String> hashMap, WebView webView) {
        String str = hashMap.get("name");
        if (str == null) {
            C0284b.m484b("Error: App event with no name parameter.");
        } else {
            dVar.mo3535a(str, hashMap.get("info"));
        }
    }
}
