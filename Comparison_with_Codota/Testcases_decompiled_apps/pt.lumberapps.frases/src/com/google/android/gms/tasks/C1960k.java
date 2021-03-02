package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.k */
class C1960k implements C1966q {

    /* renamed from: a */
    private final Executor f7450a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f7451b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnCompleteListener f7452c;

    public C1960k(Executor executor, OnCompleteListener onCompleteListener) {
        this.f7450a = executor;
        this.f7452c = onCompleteListener;
    }

    /* renamed from: a */
    public void mo9820a() {
        synchronized (this.f7451b) {
            this.f7452c = null;
        }
    }

    /* renamed from: a */
    public void mo9821a(Task task) {
        synchronized (this.f7451b) {
            if (this.f7452c != null) {
                this.f7450a.execute(new C1961l(this, task));
            }
        }
    }
}
