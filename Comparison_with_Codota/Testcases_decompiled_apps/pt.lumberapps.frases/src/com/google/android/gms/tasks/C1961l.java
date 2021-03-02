package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.l */
class C1961l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f7453a;

    /* renamed from: b */
    final /* synthetic */ C1960k f7454b;

    C1961l(C1960k kVar, Task task) {
        this.f7454b = kVar;
        this.f7453a = task;
    }

    public void run() {
        synchronized (this.f7454b.f7451b) {
            if (this.f7454b.f7452c != null) {
                this.f7454b.f7452c.onComplete(this.f7453a);
            }
        }
    }
}
