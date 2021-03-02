package com.google.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.forexcrunch.forexcrunch.gui.ChartActivity;
import com.google.ads.internal.C0238c;
import com.google.ads.internal.C0247d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.google.ads.w */
public class C0311w implements C0273o {
    /* renamed from: a */
    public void mo3325a(C0247d dVar, HashMap<String, String> hashMap, WebView webView) {
        C0238c.C0245d dVar2;
        String str = hashMap.get("url");
        String str2 = hashMap.get(ChartActivity.TYPE);
        String str3 = hashMap.get("afma_notify_dt");
        String str4 = hashMap.get("activation_overlay_url");
        String str5 = hashMap.get("check_packages");
        boolean equals = "1".equals(hashMap.get("drt_include"));
        String str6 = hashMap.get("request_scenario");
        boolean equals2 = "1".equals(hashMap.get("use_webview_loadurl"));
        if (C0238c.C0245d.OFFLINE_EMPTY.f523e.equals(str6)) {
            dVar2 = C0238c.C0245d.OFFLINE_EMPTY;
        } else if (C0238c.C0245d.OFFLINE_USING_BUFFERED_ADS.f523e.equals(str6)) {
            dVar2 = C0238c.C0245d.OFFLINE_USING_BUFFERED_ADS;
        } else if (C0238c.C0245d.ONLINE_USING_BUFFERED_ADS.f523e.equals(str6)) {
            dVar2 = C0238c.C0245d.ONLINE_USING_BUFFERED_ADS;
        } else {
            dVar2 = C0238c.C0245d.ONLINE_SERVER_REQUEST;
        }
        C0284b.m486c("Received ad url: <url: \"" + str + "\" type: \"" + str2 + "\" afmaNotifyDt: \"" + str3 + "\" activationOverlayUrl: \"" + str4 + "\" useWebViewLoadUrl: \"" + equals2 + "\">");
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str)) {
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str5.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (AdUtil.m450a((Context) dVar.mo3550i().f656c.mo3728a(), split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            String format = String.format(Locale.US, "%X", new Object[]{bigInteger2});
            str = str.replaceAll("%40installed_markets%40", format);
            C0265m.m411a().f615a.mo3727a(format);
            C0284b.m486c("Ad url modified to " + str);
        }
        C0238c k = dVar.mo3552k();
        if (k != null) {
            k.mo3506d(equals);
            k.mo3495a(dVar2);
            k.mo3508e(equals2);
            k.mo3507e(str4);
            k.mo3505d(str);
        }
    }
}
