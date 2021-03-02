package com.google.android.gms.p018c;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.google.android.gms.c.bg */
public final class C0645bg extends C0626ao<C0645bg> {

    /* renamed from: a */
    public String f4295a;

    /* renamed from: b */
    public long f4296b;

    /* renamed from: c */
    public String f4297c;

    /* renamed from: d */
    public String f4298d;

    /* renamed from: a */
    public String mo7117a() {
        return this.f4295a;
    }

    /* renamed from: a */
    public void mo7118a(long j) {
        this.f4296b = j;
    }

    /* renamed from: a */
    public void mo7010a(C0645bg bgVar) {
        if (!TextUtils.isEmpty(this.f4295a)) {
            bgVar.mo7120a(this.f4295a);
        }
        if (this.f4296b != 0) {
            bgVar.mo7118a(this.f4296b);
        }
        if (!TextUtils.isEmpty(this.f4297c)) {
            bgVar.mo7122b(this.f4297c);
        }
        if (!TextUtils.isEmpty(this.f4298d)) {
            bgVar.mo7124c(this.f4298d);
        }
    }

    /* renamed from: a */
    public void mo7120a(String str) {
        this.f4295a = str;
    }

    /* renamed from: b */
    public long mo7121b() {
        return this.f4296b;
    }

    /* renamed from: b */
    public void mo7122b(String str) {
        this.f4297c = str;
    }

    /* renamed from: c */
    public String mo7123c() {
        return this.f4297c;
    }

    /* renamed from: c */
    public void mo7124c(String str) {
        this.f4298d = str;
    }

    /* renamed from: d */
    public String mo7125d() {
        return this.f4298d;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.f4295a);
        hashMap.put("timeInMillis", Long.valueOf(this.f4296b));
        hashMap.put("category", this.f4297c);
        hashMap.put("label", this.f4298d);
        return m3607a((Object) hashMap);
    }
}
