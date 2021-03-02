package com.google.android.gms.common.api;

/* renamed from: com.google.android.gms.common.api.aj */
abstract class C0712aj implements Runnable {

    /* renamed from: b */
    final /* synthetic */ C0758w f4443b;

    private C0712aj(C0758w wVar) {
        this.f4443b = wVar;
    }

    /* synthetic */ C0712aj(C0758w wVar, C0759x xVar) {
        this(wVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7357a();

    public void run() {
        this.f4443b.f4534b.lock();
        try {
            if (!Thread.interrupted()) {
                mo7357a();
                this.f4443b.f4534b.unlock();
            }
        } catch (RuntimeException e) {
            this.f4443b.f4533a.mo7378a(e);
        } finally {
            this.f4443b.f4534b.unlock();
        }
    }
}
