package com.google.ads;

import android.webkit.WebView;
import com.google.ads.AdActivity;
import com.google.ads.internal.C0247d;
import com.google.ads.internal.C0248e;
import com.google.ads.util.C0284b;
import java.util.HashMap;

/* renamed from: com.google.ads.z */
public class C0314z implements C0273o {

    /* renamed from: a */
    private AdActivity.StaticMethodWrapper f751a;

    public C0314z() {
        this(new AdActivity.StaticMethodWrapper());
    }

    public C0314z(AdActivity.StaticMethodWrapper staticMethodWrapper) {
        this.f751a = staticMethodWrapper;
    }

    /* renamed from: a */
    public void mo3325a(C0247d dVar, HashMap<String, String> hashMap, WebView webView) {
        String str = hashMap.get("a");
        if (str == null) {
            C0284b.m480a("Could not get the action parameter for open GMSG.");
        } else if (str.equals("webapp")) {
            this.f751a.launchAdActivity(dVar, new C0248e("webapp", hashMap));
        } else if (str.equals("expand")) {
            this.f751a.launchAdActivity(dVar, new C0248e("expand", hashMap));
        } else {
            this.f751a.launchAdActivity(dVar, new C0248e("intent", hashMap));
        }
    }
}
