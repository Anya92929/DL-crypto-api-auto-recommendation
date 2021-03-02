package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.bq */
public class C1311bq implements C1334y {

    /* renamed from: a */
    private int f5395a = 5;

    /* renamed from: a */
    public void mo9161a(String str) {
        if (this.f5395a <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    /* renamed from: a */
    public void mo9162a(String str, Throwable th) {
        if (this.f5395a <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    /* renamed from: b */
    public void mo9163b(String str) {
        if (this.f5395a <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    /* renamed from: c */
    public void mo9164c(String str) {
        if (this.f5395a <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    /* renamed from: d */
    public void mo9165d(String str) {
        if (this.f5395a <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }
}
