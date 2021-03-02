package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0247d;
import com.google.ads.util.C0284b;
import java.util.HashMap;

/* renamed from: com.google.ads.ab */
public class C0168ab implements C0273o {
    /* renamed from: a */
    public void mo3325a(C0247d dVar, HashMap<String, String> hashMap, WebView webView) {
        if (dVar.mo3550i().f656c.mo3728a() == null) {
            C0284b.m490e("Activity was null while responding to touch gmsg.");
            return;
        }
        String str = hashMap.get("tx");
        String str2 = hashMap.get("ty");
        String str3 = hashMap.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            C0190ak a = dVar.mo3550i().f671r.mo3726a();
            if (a != null) {
                a.mo3335a(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException e) {
            C0284b.m490e("Could not parse touch parameters from gmsg.");
        }
    }
}
