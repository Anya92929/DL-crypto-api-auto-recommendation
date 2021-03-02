package com.google.android.gms.analytics.internal;

import com.google.android.gms.p018c.C0636ay;

/* renamed from: com.google.android.gms.analytics.internal.an */
public class C0527an extends C0514aa {

    /* renamed from: a */
    private final C0636ay f3745a = new C0636ay();

    C0527an(C0516ac acVar) {
        super(acVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
        mo6889r().mo7015a().mo7010a(this.f3745a);
        mo6680b();
    }

    /* renamed from: b */
    public void mo6680b() {
        C0571s v = mo6893v();
        String c = v.mo6838c();
        if (c != null) {
            this.f3745a.mo7030a(c);
        }
        String b = v.mo6837b();
        if (b != null) {
            this.f3745a.mo7032b(b);
        }
    }

    /* renamed from: c */
    public C0636ay mo6681c() {
        mo6596D();
        return this.f3745a;
    }
}
