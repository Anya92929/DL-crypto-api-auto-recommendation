package com.google.android.gms.tasks;

public class TaskCompletionSource {

    /* renamed from: a */
    private final C1968s f7428a = new C1968s();

    public Task getTask() {
        return this.f7428a;
    }

    public void setException(Exception exc) {
        this.f7428a.mo9829a(exc);
    }

    public void setResult(Object obj) {
        this.f7428a.mo9830a(obj);
    }
}
