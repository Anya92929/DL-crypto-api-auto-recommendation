package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzin
/* renamed from: com.google.android.gms.internal.la */
class C1706la {

    /* renamed from: a */
    private final List f5261a;

    /* renamed from: b */
    private final List f5262b;

    /* renamed from: c */
    private final String f5263c;

    /* renamed from: d */
    private final String f5264d;

    /* renamed from: e */
    private final String f5265e;

    /* renamed from: f */
    private final String f5266f;

    /* renamed from: g */
    private final boolean f5267g;

    /* renamed from: h */
    private final boolean f5268h;

    /* renamed from: i */
    private final String f5269i;

    /* renamed from: j */
    private final String f5270j;

    /* renamed from: k */
    private String f5271k;

    /* renamed from: l */
    private int f5272l;

    public C1706la(int i, Map map) {
        this.f5271k = (String) map.get("url");
        this.f5264d = (String) map.get("base_uri");
        this.f5265e = (String) map.get("post_parameters");
        this.f5267g = m6455b((String) map.get("drt_include"));
        this.f5268h = m6455b((String) map.get("pan_include"));
        this.f5263c = (String) map.get("activation_overlay_url");
        this.f5262b = m6456c((String) map.get("check_packages"));
        this.f5269i = (String) map.get("request_id");
        this.f5266f = (String) map.get("type");
        this.f5261a = m6456c((String) map.get("errors"));
        this.f5272l = i;
        this.f5270j = (String) map.get("fetched_ad");
    }

    /* renamed from: b */
    private static boolean m6455b(String str) {
        return str != null && (str.equals("1") || str.equals("true"));
    }

    /* renamed from: c */
    private List m6456c(String str) {
        if (str == null) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    /* renamed from: a */
    public int mo7452a() {
        return this.f5272l;
    }

    /* renamed from: a */
    public void mo7453a(String str) {
        this.f5271k = str;
    }

    /* renamed from: b */
    public List mo7454b() {
        return this.f5261a;
    }

    /* renamed from: c */
    public String mo7455c() {
        return this.f5265e;
    }

    /* renamed from: d */
    public String mo7456d() {
        return this.f5271k;
    }

    /* renamed from: e */
    public String mo7457e() {
        return this.f5266f;
    }

    /* renamed from: f */
    public boolean mo7458f() {
        return this.f5267g;
    }

    /* renamed from: g */
    public String mo7459g() {
        return this.f5269i;
    }

    /* renamed from: h */
    public String mo7460h() {
        return this.f5270j;
    }
}
