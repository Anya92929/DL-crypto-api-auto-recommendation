package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.n */
class C1963n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f7458a;

    /* renamed from: b */
    final /* synthetic */ C1962m f7459b;

    C1963n(C1962m mVar, Task task) {
        this.f7459b = mVar;
        this.f7458a = task;
    }

    public void run() {
        synchronized (this.f7459b.f7456b) {
            if (this.f7459b.f7457c != null) {
                this.f7459b.f7457c.onFailure(this.f7458a.getException());
            }
        }
    }
}
