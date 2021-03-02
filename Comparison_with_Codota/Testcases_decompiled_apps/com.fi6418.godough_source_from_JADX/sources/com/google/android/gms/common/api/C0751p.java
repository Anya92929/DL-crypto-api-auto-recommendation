package com.google.android.gms.common.api;

/* renamed from: com.google.android.gms.common.api.p */
class C0751p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0749n f4528a;

    /* renamed from: b */
    final /* synthetic */ C0750o f4529b;

    C0751p(C0750o oVar, C0749n nVar) {
        this.f4529b = oVar;
        this.f4528a = nVar;
    }

    public void run() {
        if (!this.f4529b.f4518j.isFinishing() && !this.f4529b.f4518j.getSupportFragmentManager().isDestroyed()) {
            this.f4529b.m4103a(C0730ba.m4050b(this.f4529b.f4518j), this.f4528a);
        }
    }
}
