package com.google.android.gms.analytics;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.analytics.w */
class C0204w {

    /* renamed from: AE */
    private String f323AE;

    /* renamed from: AF */
    private final long f324AF;

    /* renamed from: AG */
    private final long f325AG;

    /* renamed from: AH */
    private String f326AH = "https:";

    C0204w(String str, long j, long j2) {
        this.f323AE = str;
        this.f324AF = j;
        this.f325AG = j2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: aj */
    public void mo3745aj(String str) {
        this.f323AE = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ak */
    public void mo3746ak(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim()) && str.toLowerCase().startsWith("http:")) {
            this.f326AH = "http:";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eG */
    public String mo3747eG() {
        return this.f323AE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eH */
    public long mo3748eH() {
        return this.f324AF;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eI */
    public long mo3749eI() {
        return this.f325AG;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eJ */
    public String mo3750eJ() {
        return this.f326AH;
    }
}
