package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ay */
class C2014ay {
    private static String apn;
    static Map<String, String> apo = new HashMap();

    C2014ay() {
    }

    /* renamed from: cC */
    static void m6790cC(String str) {
        synchronized (C2014ay.class) {
            apn = str;
        }
    }

    /* renamed from: d */
    static void m6791d(Context context, String str) {
        C2101cz.m7067a(context, "gtm_install_referrer", "referrer", str);
        m6794f(context, str);
    }

    /* renamed from: e */
    static String m6792e(Context context, String str) {
        if (apn == null) {
            synchronized (C2014ay.class) {
                if (apn == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        apn = sharedPreferences.getString("referrer", "");
                    } else {
                        apn = "";
                    }
                }
            }
        }
        return m6795x(apn, str);
    }

    /* renamed from: f */
    static String m6793f(Context context, String str, String str2) {
        String str3 = apo.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            apo.put(str, str3);
        }
        return m6795x(str3, str2);
    }

    /* renamed from: f */
    static void m6794f(Context context, String str) {
        String x = m6795x(str, "conv");
        if (x != null && x.length() > 0) {
            apo.put(x, str);
            C2101cz.m7067a(context, "gtm_click_referrers", x, str);
        }
    }

    /* renamed from: x */
    static String m6795x(String str, String str2) {
        if (str2 != null) {
            return Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }
}
