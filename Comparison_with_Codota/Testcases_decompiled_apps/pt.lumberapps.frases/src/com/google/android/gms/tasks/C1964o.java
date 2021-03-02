package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.o */
class C1964o implements C1966q {

    /* renamed from: a */
    private final Executor f7460a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f7461b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnSuccessListener f7462c;

    public C1964o(Executor executor, OnSuccessListener onSuccessListener) {
        this.f7460a = executor;
        this.f7462c = onSuccessListener;
    }

    /* renamed from: a */
    public void mo9820a() {
        synchronized (this.f7461b) {
            this.f7462c = null;
        }
    }

    /* renamed from: a */
    public void mo9821a(Task task) {
        if (task.isSuccessful()) {
            synchronized (this.f7461b) {
                if (this.f7462c != null) {
                    this.f7460a.execute(new C1965p(this, task));
                }
            }
        }
    }
}
