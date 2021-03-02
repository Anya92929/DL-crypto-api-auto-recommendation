package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.tasks.i */
class C1958i implements OnFailureListener, OnSuccessListener, C1966q {

    /* renamed from: a */
    private final Executor f7445a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Continuation f7446b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1968s f7447c;

    public C1958i(Executor executor, Continuation continuation, C1968s sVar) {
        this.f7445a = executor;
        this.f7446b = continuation;
        this.f7447c = sVar;
    }

    /* renamed from: a */
    public void mo9820a() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo9821a(Task task) {
        this.f7445a.execute(new C1959j(this, task));
    }

    public void onFailure(Exception exc) {
        this.f7447c.mo9829a(exc);
    }

    public void onSuccess(Object obj) {
        this.f7447c.mo9830a(obj);
    }
}
