package com.google.ads;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.C0247d;
import com.google.ads.internal.C0252g;
import com.google.ads.util.C0284b;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.google.ads.r */
public class C0276r implements C0273o {
    /* renamed from: a */
    public void mo3325a(C0247d dVar, HashMap<String, String> hashMap, WebView webView) {
        Uri uri;
        Uri parse;
        String host;
        String str = hashMap.get(AdActivity.URL_PARAM);
        if (str == null) {
            C0284b.m490e("Could not get URL from click gmsg.");
            return;
        }
        C0252g n = dVar.mo3555n();
        if (!(n == null || (host = parse.getHost()) == null || !host.toLowerCase(Locale.US).endsWith(".admob.com"))) {
            String str2 = null;
            String path = (parse = Uri.parse(str)).getPath();
            if (path != null) {
                String[] split = path.split("/");
                if (split.length >= 4) {
                    str2 = split[2] + "/" + split[3];
                }
            }
            n.mo3582a(str2);
        }
        C0272n i = dVar.mo3550i();
        Context a = i.f659f.mo3725a();
        Uri parse2 = Uri.parse(str);
        try {
            C0192al a2 = i.f672s.mo3726a();
            if (a2 != null && a2.mo3344a(parse2)) {
                uri = a2.mo3342a(parse2, a);
                new Thread(new C0170ae(uri.toString(), a)).start();
            }
        } catch (C0193am e) {
            C0284b.m490e("Unable to append parameter to URL: " + str);
        }
        uri = parse2;
        new Thread(new C0170ae(uri.toString(), a)).start();
    }
}
