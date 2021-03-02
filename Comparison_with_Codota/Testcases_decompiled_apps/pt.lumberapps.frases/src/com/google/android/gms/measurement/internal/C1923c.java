package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.c */
abstract class C1923c extends C1922bm {

    /* renamed from: a */
    private boolean f7190a;

    C1923c(zzx zzx) {
        super(zzx);
        this.f7189n.mo9652a(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9337a() {
        return this.f7190a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo9338b() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9339c() {
        if (!mo9337a()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo9226d();

    public final void initialize() {
        if (this.f7190a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo9226d();
        this.f7189n.mo9674l();
        this.f7190a = true;
    }
}
