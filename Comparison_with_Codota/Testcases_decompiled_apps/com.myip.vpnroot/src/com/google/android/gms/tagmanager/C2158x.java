package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.x */
class C2158x implements C2029bi {

    /* renamed from: xW */
    private int f4607xW = 5;

    C2158x() {
    }

    /* renamed from: S */
    public void mo11576S(String str) {
        if (this.f4607xW <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    /* renamed from: T */
    public void mo11577T(String str) {
        if (this.f4607xW <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    /* renamed from: U */
    public void mo11578U(String str) {
        if (this.f4607xW <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    /* renamed from: V */
    public void mo11579V(String str) {
        if (this.f4607xW <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    /* renamed from: W */
    public void mo11580W(String str) {
        if (this.f4607xW <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    /* renamed from: b */
    public void mo11581b(String str, Throwable th) {
        if (this.f4607xW <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    /* renamed from: d */
    public void mo11582d(String str, Throwable th) {
        if (this.f4607xW <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void setLogLevel(int logLevel) {
        this.f4607xW = logLevel;
    }
}
