package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.g */
class C1956g implements C1966q {

    /* renamed from: a */
    private final Executor f7440a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Continuation f7441b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1968s f7442c;

    public C1956g(Executor executor, Continuation continuation, C1968s sVar) {
        this.f7440a = executor;
        this.f7441b = continuation;
        this.f7442c = sVar;
    }

    /* renamed from: a */
    public void mo9820a() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo9821a(Task task) {
        this.f7440a.execute(new C1957h(this, task));
    }
}
