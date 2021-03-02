package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.m */
class C1962m implements C1966q {

    /* renamed from: a */
    private final Executor f7455a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f7456b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnFailureListener f7457c;

    public C1962m(Executor executor, OnFailureListener onFailureListener) {
        this.f7455a = executor;
        this.f7457c = onFailureListener;
    }

    /* renamed from: a */
    public void mo9820a() {
        synchronized (this.f7456b) {
            this.f7457c = null;
        }
    }

    /* renamed from: a */
    public void mo9821a(Task task) {
        if (!task.isSuccessful()) {
            synchronized (this.f7456b) {
                if (this.f7457c != null) {
                    this.f7455a.execute(new C1963n(this, task));
                }
            }
        }
    }
}
