package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.C0514aa;
import com.google.android.gms.analytics.internal.C0516ac;

/* renamed from: com.google.android.gms.analytics.v */
class C0591v extends C0514aa {

    /* renamed from: a */
    final /* synthetic */ C0589t f3941a;

    /* renamed from: b */
    private long f3942b = -1;

    /* renamed from: c */
    private boolean f3943c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected C0591v(C0589t tVar, C0516ac acVar) {
        super(acVar);
        this.f3941a = tVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
    }

    /* renamed from: b */
    public synchronized boolean mo6933b() {
        boolean z;
        z = this.f3943c;
        this.f3943c = false;
        return z;
    }
}
