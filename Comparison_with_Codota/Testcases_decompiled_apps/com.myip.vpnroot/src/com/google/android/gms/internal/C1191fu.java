package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.fu */
public final class C1191fu {
    private int mOrientation = -1;

    /* renamed from: pn */
    private String f3616pn;

    /* renamed from: uA */
    private List<String> f3617uA;

    /* renamed from: uB */
    private long f3618uB = -1;

    /* renamed from: uC */
    private boolean f3619uC = false;

    /* renamed from: uD */
    private final long f3620uD = -1;

    /* renamed from: uE */
    private long f3621uE = -1;

    /* renamed from: uF */
    private boolean f3622uF = false;

    /* renamed from: uG */
    private boolean f3623uG = false;

    /* renamed from: uH */
    private boolean f3624uH = false;

    /* renamed from: uI */
    private boolean f3625uI = false;

    /* renamed from: ua */
    private List<String> f3626ua;

    /* renamed from: uv */
    private String f3627uv;

    /* renamed from: uw */
    private String f3628uw;

    /* renamed from: ux */
    private List<String> f3629ux;

    /* renamed from: uy */
    private String f3630uy;

    /* renamed from: uz */
    private String f3631uz;

    /* renamed from: a */
    static String m4513a(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    /* renamed from: b */
    static long m4514b(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                C1229gs.m4679W("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    /* renamed from: c */
    static List<String> m4515c(Map<String, List<String>> map, String str) {
        String str2;
        List list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = (String) list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    /* renamed from: d */
    private boolean m4516d(Map<String, List<String>> map, String str) {
        List list = map.get(str);
        return list != null && !list.isEmpty() && Boolean.valueOf((String) list.get(0)).booleanValue();
    }

    /* renamed from: f */
    private void m4517f(Map<String, List<String>> map) {
        this.f3627uv = m4513a(map, "X-Afma-Ad-Size");
    }

    /* renamed from: g */
    private void m4518g(Map<String, List<String>> map) {
        List<String> c = m4515c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.f3629ux = c;
        }
    }

    /* renamed from: h */
    private void m4519h(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.f3630uy = (String) list.get(0);
        }
    }

    /* renamed from: i */
    private void m4520i(Map<String, List<String>> map) {
        List<String> c = m4515c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.f3617uA = c;
        }
    }

    /* renamed from: j */
    private void m4521j(Map<String, List<String>> map) {
        long b = m4514b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.f3618uB = b;
        }
    }

    /* renamed from: k */
    private void m4522k(Map<String, List<String>> map) {
        this.f3631uz = m4513a(map, "X-Afma-ActiveView");
    }

    /* renamed from: l */
    private void m4523l(Map<String, List<String>> map) {
        this.f3623uG |= m4516d(map, "X-Afma-Native");
    }

    /* renamed from: m */
    private void m4524m(Map<String, List<String>> map) {
        this.f3622uF |= m4516d(map, "X-Afma-Custom-Rendering-Allowed");
    }

    /* renamed from: n */
    private void m4525n(Map<String, List<String>> map) {
        this.f3619uC |= m4516d(map, "X-Afma-Mediation");
    }

    /* renamed from: o */
    private void m4526o(Map<String, List<String>> map) {
        List<String> c = m4515c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.f3626ua = c;
        }
    }

    /* renamed from: p */
    private void m4527p(Map<String, List<String>> map) {
        long b = m4514b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.f3621uE = b;
        }
    }

    /* renamed from: q */
    private void m4528q(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = C1213gj.m4634dn();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = C1213gj.m4633dm();
            }
        }
    }

    /* renamed from: r */
    private void m4529r(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.f3624uH = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    /* renamed from: s */
    private void m4530s(Map<String, List<String>> map) {
        List list = map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.f3625uI = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    /* renamed from: a */
    public void mo8529a(String str, Map<String, List<String>> map, String str2) {
        this.f3628uw = str;
        this.f3616pn = str2;
        mo8530e(map);
    }

    /* renamed from: e */
    public void mo8530e(Map<String, List<String>> map) {
        m4517f(map);
        m4518g(map);
        m4519h(map);
        m4520i(map);
        m4521j(map);
        m4525n(map);
        m4526o(map);
        m4527p(map);
        m4528q(map);
        m4522k(map);
        m4529r(map);
        m4524m(map);
        m4523l(map);
        m4530s(map);
    }

    /* renamed from: i */
    public C1171fk mo8531i(long j) {
        return new C1171fk(this.f3628uw, this.f3616pn, this.f3629ux, this.f3617uA, this.f3618uB, this.f3619uC, -1, this.f3626ua, this.f3621uE, this.mOrientation, this.f3627uv, j, this.f3630uy, this.f3631uz, this.f3622uF, this.f3623uG, this.f3624uH, this.f3625uI);
    }
}
