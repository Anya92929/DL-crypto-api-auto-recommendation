package com.google.android.gms.common.api;

/* renamed from: com.google.android.gms.common.api.ar */
abstract class C0720ar {

    /* renamed from: a */
    private final C0724av f4479a;

    protected C0720ar(C0724av avVar) {
        this.f4479a = avVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7356a();

    /* renamed from: a */
    public final void mo7397a(C0714al alVar) {
        alVar.f4456k.lock();
        try {
            if (alVar.f4467v == this.f4479a) {
                mo7356a();
                alVar.f4456k.unlock();
            }
        } finally {
            alVar.f4456k.unlock();
        }
    }
}
