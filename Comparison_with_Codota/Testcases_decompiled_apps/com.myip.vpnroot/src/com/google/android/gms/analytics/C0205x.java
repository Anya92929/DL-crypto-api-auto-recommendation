package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.x */
class C0205x {
    /* renamed from: a */
    static String m303a(C0204w wVar, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(wVar.mo3747eG());
        if (wVar.mo3749eI() > 0) {
            long eI = j - wVar.mo3749eI();
            if (eI >= 0) {
                sb.append("&qt").append("=").append(eI);
            }
        }
        sb.append("&z").append("=").append(wVar.mo3748eH());
        return sb.toString();
    }

    static String encode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }

    /* renamed from: z */
    static Map<String, String> m304z(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            if (((String) next.getKey()).startsWith("&") && next.getValue() != null) {
                String substring = ((String) next.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, next.getValue());
                }
            }
        }
        return hashMap;
    }
}
