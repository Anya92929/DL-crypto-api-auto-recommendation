package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.cc */
public final class C0328cc {

    /* renamed from: gX */
    private String f952gX;

    /* renamed from: gY */
    private String f953gY;

    /* renamed from: gZ */
    private List<String> f954gZ;

    /* renamed from: ha */
    private List<String> f955ha;

    /* renamed from: hb */
    private long f956hb = -1;

    /* renamed from: hc */
    private boolean f957hc = false;

    /* renamed from: hd */
    private final long f958hd = -1;

    /* renamed from: he */
    private List<String> f959he;

    /* renamed from: hf */
    private long f960hf = -1;

    /* renamed from: hg */
    private int f961hg = -1;

    /* renamed from: a */
    private static long m670a(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                C0344cn.m737q("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    /* renamed from: b */
    private static List<String> m671b(Map<String, List<String>> map, String str) {
        String str2;
        List list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = (String) list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    /* renamed from: e */
    private void m672e(Map<String, List<String>> map) {
        List<String> b = m671b(map, "X-Afma-Click-Tracking-Urls");
        if (b != null) {
            this.f954gZ = b;
        }
    }

    /* renamed from: f */
    private void m673f(Map<String, List<String>> map) {
        List<String> b = m671b(map, "X-Afma-Tracking-Urls");
        if (b != null) {
            this.f955ha = b;
        }
    }

    /* renamed from: g */
    private void m674g(Map<String, List<String>> map) {
        long a = m670a(map, "X-Afma-Interstitial-Timeout");
        if (a != -1) {
            this.f956hb = a;
        }
    }

    /* renamed from: h */
    private void m675h(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.f957hc = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    /* renamed from: i */
    private void m676i(Map<String, List<String>> map) {
        List<String> b = m671b(map, "X-Afma-Manual-Tracking-Urls");
        if (b != null) {
            this.f959he = b;
        }
    }

    /* renamed from: j */
    private void m677j(Map<String, List<String>> map) {
        long a = m670a(map, "X-Afma-Refresh-Rate");
        if (a != -1) {
            this.f960hf = a;
        }
    }

    /* renamed from: k */
    private void m678k(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.f961hg = C0337ci.m701ao();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.f961hg = C0337ci.m700an();
            }
        }
    }

    /* renamed from: a */
    public void mo4189a(String str, Map<String, List<String>> map, String str2) {
        this.f952gX = str;
        this.f953gY = str2;
        mo4191d(map);
    }

    /* renamed from: ak */
    public C0316bw mo4190ak() {
        return new C0316bw(this.f952gX, this.f953gY, this.f954gZ, this.f955ha, this.f956hb, this.f957hc, -1, this.f959he, this.f960hf, this.f961hg);
    }

    /* renamed from: d */
    public void mo4191d(Map<String, List<String>> map) {
        m672e(map);
        m673f(map);
        m674g(map);
        m675h(map);
        m676i(map);
        m677j(map);
        m678k(map);
    }
}
