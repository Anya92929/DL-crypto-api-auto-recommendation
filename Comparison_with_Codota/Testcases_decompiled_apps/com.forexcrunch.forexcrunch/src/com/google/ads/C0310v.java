package com.google.ads;

import android.webkit.WebView;
import com.forexcrunch.forexcrunch.gui.ChartActivity;
import com.google.ads.AdRequest;
import com.google.ads.internal.C0238c;
import com.google.ads.internal.C0247d;
import com.google.ads.util.C0284b;
import java.util.HashMap;

/* renamed from: com.google.ads.v */
public class C0310v implements C0273o {
    /* renamed from: a */
    public void mo3325a(C0247d dVar, HashMap<String, String> hashMap, WebView webView) {
        C0284b.m490e("Invalid " + hashMap.get(ChartActivity.TYPE) + " request error: " + hashMap.get("errors"));
        C0238c k = dVar.mo3552k();
        if (k != null) {
            k.mo3491a(AdRequest.ErrorCode.INVALID_REQUEST);
        }
    }
}
