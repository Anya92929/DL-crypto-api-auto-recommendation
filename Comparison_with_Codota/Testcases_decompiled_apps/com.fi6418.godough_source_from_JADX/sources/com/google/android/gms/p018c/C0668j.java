package com.google.android.gms.p018c;

import android.text.TextUtils;
import com.google.android.gms.common.internal.C1009bf;
import java.util.HashMap;

/* renamed from: com.google.android.gms.c.j */
public final class C0668j extends C0626ao<C0668j> {

    /* renamed from: a */
    private String f4363a;

    /* renamed from: b */
    private String f4364b;

    /* renamed from: c */
    private String f4365c;

    /* renamed from: d */
    private String f4366d;

    /* renamed from: e */
    private boolean f4367e;

    /* renamed from: f */
    private String f4368f;

    /* renamed from: g */
    private boolean f4369g;

    /* renamed from: h */
    private double f4370h;

    /* renamed from: a */
    public String mo7215a() {
        return this.f4363a;
    }

    /* renamed from: a */
    public void mo7216a(double d) {
        C1009bf.m4537b(d >= 0.0d && d <= 100.0d, "Sample rate must be between 0% and 100%");
        this.f4370h = d;
    }

    /* renamed from: a */
    public void mo7010a(C0668j jVar) {
        if (!TextUtils.isEmpty(this.f4363a)) {
            jVar.mo7218a(this.f4363a);
        }
        if (!TextUtils.isEmpty(this.f4364b)) {
            jVar.mo7221b(this.f4364b);
        }
        if (!TextUtils.isEmpty(this.f4365c)) {
            jVar.mo7224c(this.f4365c);
        }
        if (!TextUtils.isEmpty(this.f4366d)) {
            jVar.mo7226d(this.f4366d);
        }
        if (this.f4367e) {
            jVar.mo7219a(true);
        }
        if (!TextUtils.isEmpty(this.f4368f)) {
            jVar.mo7227e(this.f4368f);
        }
        if (this.f4369g) {
            jVar.mo7222b(this.f4369g);
        }
        if (this.f4370h != 0.0d) {
            jVar.mo7216a(this.f4370h);
        }
    }

    /* renamed from: a */
    public void mo7218a(String str) {
        this.f4363a = str;
    }

    /* renamed from: a */
    public void mo7219a(boolean z) {
        this.f4367e = z;
    }

    /* renamed from: b */
    public String mo7220b() {
        return this.f4364b;
    }

    /* renamed from: b */
    public void mo7221b(String str) {
        this.f4364b = str;
    }

    /* renamed from: b */
    public void mo7222b(boolean z) {
        this.f4369g = z;
    }

    /* renamed from: c */
    public String mo7223c() {
        return this.f4365c;
    }

    /* renamed from: c */
    public void mo7224c(String str) {
        this.f4365c = str;
    }

    /* renamed from: d */
    public String mo7225d() {
        return this.f4366d;
    }

    /* renamed from: d */
    public void mo7226d(String str) {
        this.f4366d = str;
    }

    /* renamed from: e */
    public void mo7227e(String str) {
        this.f4368f = str;
    }

    /* renamed from: e */
    public boolean mo7228e() {
        return this.f4367e;
    }

    /* renamed from: f */
    public String mo7229f() {
        return this.f4368f;
    }

    /* renamed from: g */
    public boolean mo7230g() {
        return this.f4369g;
    }

    /* renamed from: h */
    public double mo7231h() {
        return this.f4370h;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.f4363a);
        hashMap.put("clientId", this.f4364b);
        hashMap.put("userId", this.f4365c);
        hashMap.put("androidAdId", this.f4366d);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.f4367e));
        hashMap.put("sessionControl", this.f4368f);
        hashMap.put("nonInteraction", Boolean.valueOf(this.f4369g));
        hashMap.put("sampleRate", Double.valueOf(this.f4370h));
        return m3607a((Object) hashMap);
    }
}
