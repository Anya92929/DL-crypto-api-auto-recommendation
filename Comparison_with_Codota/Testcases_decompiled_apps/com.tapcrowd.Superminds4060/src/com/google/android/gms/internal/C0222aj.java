package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.aj */
public final class C0222aj implements C0221ai {
    /* renamed from: a */
    private static boolean m491a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    /* renamed from: b */
    private static int m492b(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return C0337ci.m701ao();
            }
            if ("l".equalsIgnoreCase(str)) {
                return C0337ci.m700an();
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void mo4037a(C0347cq cqVar, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            C0344cn.m737q("Action missing from an open GMSG.");
            return;
        }
        C0348cr aw = cqVar.mo4212aw();
        if ("expand".equalsIgnoreCase(str)) {
            if (cqVar.mo4215az()) {
                C0344cn.m737q("Cannot expand WebView that is already expanded.");
            } else {
                aw.mo4226a(m491a(map), m492b(map));
            }
        } else if ("webapp".equalsIgnoreCase(str)) {
            String str2 = map.get("u");
            if (str2 != null) {
                aw.mo4227a(m491a(map), m492b(map), str2);
            } else {
                aw.mo4228a(m491a(map), m492b(map), map.get("html"), map.get("baseurl"));
            }
        } else {
            aw.mo4222a(new C0279be(map.get("i"), map.get("u"), map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
        }
    }
}
