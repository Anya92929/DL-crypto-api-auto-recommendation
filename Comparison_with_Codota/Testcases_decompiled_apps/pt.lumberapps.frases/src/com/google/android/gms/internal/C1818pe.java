package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.pe */
abstract class C1818pe {

    /* renamed from: a */
    private final zzpz f5475a;

    protected C1818pe(zzpz zzpz) {
        this.f5475a = zzpz;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7625a();

    /* renamed from: a */
    public final void mo7632a(zzqa zzqa) {
        zzqa.f6869i.lock();
        try {
            if (zzqa.f6874n == this.f5475a) {
                mo7625a();
                zzqa.f6869i.unlock();
            }
        } finally {
            zzqa.f6869i.unlock();
        }
    }
}
