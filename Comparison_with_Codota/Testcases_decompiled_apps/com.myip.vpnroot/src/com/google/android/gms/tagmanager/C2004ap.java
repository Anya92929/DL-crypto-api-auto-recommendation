package com.google.android.gms.tagmanager;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.tagmanager.ap */
class C2004ap {

    /* renamed from: AF */
    private final long f4536AF;

    /* renamed from: AG */
    private final long f4537AG;
    private final long apb;
    private String apc;

    C2004ap(long j, long j2, long j3) {
        this.f4536AF = j;
        this.f4537AG = j2;
        this.apb = j3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ak */
    public void mo11552ak(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.apc = str;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eH */
    public long mo11553eH() {
        return this.f4536AF;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: or */
    public long mo11554or() {
        return this.apb;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: os */
    public String mo11555os() {
        return this.apc;
    }
}
