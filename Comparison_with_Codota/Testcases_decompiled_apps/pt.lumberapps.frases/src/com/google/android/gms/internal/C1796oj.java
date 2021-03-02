package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.oj */
class C1796oj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1795oi f5439a;

    C1796oj(C1795oi oiVar) {
        this.f5439a = oiVar;
    }

    public void run() {
        this.f5439a.f5437m.lock();
        try {
            this.f5439a.m6522c();
        } finally {
            this.f5439a.f5437m.unlock();
        }
    }
}
