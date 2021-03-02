package com.google.android.gms.p018c;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: com.google.android.gms.c.bc */
public final class C0641bc extends C0626ao<C0641bc> {

    /* renamed from: a */
    private String f4278a;

    /* renamed from: b */
    private String f4279b;

    /* renamed from: c */
    private String f4280c;

    /* renamed from: d */
    private long f4281d;

    /* renamed from: a */
    public String mo7081a() {
        return this.f4278a;
    }

    /* renamed from: a */
    public void mo7082a(long j) {
        this.f4281d = j;
    }

    /* renamed from: a */
    public void mo7010a(C0641bc bcVar) {
        if (!TextUtils.isEmpty(this.f4278a)) {
            bcVar.mo7084a(this.f4278a);
        }
        if (!TextUtils.isEmpty(this.f4279b)) {
            bcVar.mo7086b(this.f4279b);
        }
        if (!TextUtils.isEmpty(this.f4280c)) {
            bcVar.mo7088c(this.f4280c);
        }
        if (this.f4281d != 0) {
            bcVar.mo7082a(this.f4281d);
        }
    }

    /* renamed from: a */
    public void mo7084a(String str) {
        this.f4278a = str;
    }

    /* renamed from: b */
    public String mo7085b() {
        return this.f4279b;
    }

    /* renamed from: b */
    public void mo7086b(String str) {
        this.f4279b = str;
    }

    /* renamed from: c */
    public String mo7087c() {
        return this.f4280c;
    }

    /* renamed from: c */
    public void mo7088c(String str) {
        this.f4280c = str;
    }

    /* renamed from: d */
    public long mo7089d() {
        return this.f4281d;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.f4278a);
        hashMap.put("action", this.f4279b);
        hashMap.put("label", this.f4280c);
        hashMap.put("value", Long.valueOf(this.f4281d));
        return m3607a((Object) hashMap);
    }
}
