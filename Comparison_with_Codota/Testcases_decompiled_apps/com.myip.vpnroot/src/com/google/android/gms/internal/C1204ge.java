package com.google.android.gms.internal;

import android.os.Bundle;

@C1130ez
/* renamed from: com.google.android.gms.internal.ge */
public class C1204ge {

    /* renamed from: mw */
    private final Object f3735mw;

    /* renamed from: vA */
    private final String f3736vA;

    /* renamed from: vx */
    private final C1201gb f3737vx;

    /* renamed from: wc */
    private int f3738wc;

    /* renamed from: wd */
    private int f3739wd;

    C1204ge(C1201gb gbVar, String str) {
        this.f3735mw = new Object();
        this.f3737vx = gbVar;
        this.f3736vA = str;
    }

    public C1204ge(String str) {
        this(C1201gb.m4564cV(), str);
    }

    /* renamed from: d */
    public void mo8581d(int i, int i2) {
        synchronized (this.f3735mw) {
            this.f3738wc = i;
            this.f3739wd = i2;
            this.f3737vx.mo8558a(this.f3736vA, this);
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.f3735mw) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f3738wc);
            bundle.putInt("pmnll", this.f3739wd);
        }
        return bundle;
    }
}
