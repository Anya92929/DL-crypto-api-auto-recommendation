package com.google.android.gms.p018c;

import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0627ap;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.c.ap */
public abstract class C0627ap<T extends C0627ap> {

    /* renamed from: a */
    protected final C0624am f4239a;

    /* renamed from: b */
    private final C0628aq f4240b;

    /* renamed from: c */
    private final List<C0625an> f4241c = new ArrayList();

    protected C0627ap(C0628aq aqVar, C0615ad adVar) {
        C1009bf.m4528a(aqVar);
        this.f4240b = aqVar;
        C0624am amVar = new C0624am(this, adVar);
        amVar.mo7008k();
        this.f4239a = amVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6934a(C0624am amVar) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7011b(C0624am amVar) {
        for (C0625an a : this.f4241c) {
            a.mo7009a(this, amVar);
        }
    }

    /* renamed from: l */
    public C0624am mo6939l() {
        C0624am a = this.f4239a.mo6994a();
        mo7011b(a);
        return a;
    }

    /* renamed from: m */
    public C0624am mo7012m() {
        return this.f4239a;
    }

    /* renamed from: n */
    public List<C0635ax> mo7013n() {
        return this.f4239a.mo7000c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public C0628aq mo7014o() {
        return this.f4240b;
    }
}
