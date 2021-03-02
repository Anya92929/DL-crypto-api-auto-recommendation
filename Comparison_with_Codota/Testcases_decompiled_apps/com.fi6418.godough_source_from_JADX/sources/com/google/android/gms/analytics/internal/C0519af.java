package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.C1009bf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.internal.af */
public class C0519af {

    /* renamed from: a */
    private final long f3721a;

    /* renamed from: b */
    private final String f3722b;

    /* renamed from: c */
    private final String f3723c;

    /* renamed from: d */
    private final boolean f3724d;

    /* renamed from: e */
    private long f3725e;

    /* renamed from: f */
    private final Map<String, String> f3726f;

    public C0519af(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        C1009bf.m4530a(str);
        C1009bf.m4530a(str2);
        this.f3721a = j;
        this.f3722b = str;
        this.f3723c = str2;
        this.f3724d = z;
        this.f3725e = j2;
        if (map != null) {
            this.f3726f = new HashMap(map);
        } else {
            this.f3726f = Collections.emptyMap();
        }
    }

    /* renamed from: a */
    public long mo6639a() {
        return this.f3721a;
    }

    /* renamed from: a */
    public void mo6640a(long j) {
        this.f3725e = j;
    }

    /* renamed from: b */
    public String mo6641b() {
        return this.f3722b;
    }

    /* renamed from: c */
    public String mo6642c() {
        return this.f3723c;
    }

    /* renamed from: d */
    public boolean mo6643d() {
        return this.f3724d;
    }

    /* renamed from: e */
    public long mo6644e() {
        return this.f3725e;
    }

    /* renamed from: f */
    public Map<String, String> mo6645f() {
        return this.f3726f;
    }
}
