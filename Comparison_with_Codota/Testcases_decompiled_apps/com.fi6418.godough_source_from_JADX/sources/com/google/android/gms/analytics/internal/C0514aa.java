package com.google.android.gms.analytics.internal;

/* renamed from: com.google.android.gms.analytics.internal.aa */
public abstract class C0514aa extends C0578z {

    /* renamed from: a */
    private boolean f3698a;

    /* renamed from: b */
    private boolean f3699b;

    protected C0514aa(C0516ac acVar) {
        super(acVar);
    }

    /* renamed from: C */
    public boolean mo6595C() {
        return this.f3698a && !this.f3699b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public void mo6596D() {
        if (!mo6595C()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* renamed from: E */
    public void mo6597E() {
        mo6598a();
        this.f3698a = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo6598a();
}
