package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.C0516ac;
import com.google.android.gms.analytics.internal.C0549bi;
import com.google.android.gms.analytics.internal.C0562j;

/* renamed from: com.google.android.gms.analytics.c */
class C0506c implements C0549bi {

    /* renamed from: a */
    final /* synthetic */ int f3674a;

    /* renamed from: b */
    final /* synthetic */ C0516ac f3675b;

    /* renamed from: c */
    final /* synthetic */ C0562j f3676c;

    /* renamed from: d */
    final /* synthetic */ C0505b f3677d;

    C0506c(C0505b bVar, int i, C0516ac acVar, C0562j jVar) {
        this.f3677d = bVar;
        this.f3674a = i;
        this.f3675b = acVar;
        this.f3676c = jVar;
    }

    /* renamed from: a */
    public void mo6574a(Throwable th) {
        this.f3677d.f3673a.post(new C0507d(this));
    }
}
