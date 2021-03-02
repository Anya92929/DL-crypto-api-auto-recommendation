package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
public class C1332w {

    /* renamed from: a */
    static Map<String, String> f5411a = new HashMap();

    /* renamed from: a */
    public static String m5438a(String str, String str2) {
        if (str2 != null) {
            return Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    /* renamed from: a */
    public static void m5439a(Context context, String str) {
        String a = m5438a(str, "conv");
        if (a != null && a.length() > 0) {
            f5411a.put(a, str);
            C1293az.m5323a(context, "gtm_click_referrers", a, str);
        }
    }
}
