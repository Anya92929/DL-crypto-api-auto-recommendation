package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.C0587r;

/* renamed from: com.google.android.gms.analytics.internal.bd */
class C0544bd implements C0587r {

    /* renamed from: a */
    private int f3789a = 2;

    /* renamed from: b */
    private boolean f3790b;

    C0544bd() {
    }

    /* renamed from: a */
    public int mo6757a() {
        return this.f3789a;
    }

    /* renamed from: a */
    public void mo6758a(int i) {
        this.f3789a = i;
        if (!this.f3790b) {
            Log.i(C0551bk.f3819c.mo6775a(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + C0551bk.f3819c.mo6775a() + " DEBUG");
            this.f3790b = true;
        }
    }

    /* renamed from: a */
    public void mo6759a(String str) {
    }

    /* renamed from: b */
    public void mo6760b(String str) {
    }

    /* renamed from: c */
    public void mo6761c(String str) {
    }

    /* renamed from: d */
    public void mo6762d(String str) {
    }
}
