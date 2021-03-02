package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.p */
class C1965p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f7463a;

    /* renamed from: b */
    final /* synthetic */ C1964o f7464b;

    C1965p(C1964o oVar, Task task) {
        this.f7464b = oVar;
        this.f7463a = task;
    }

    public void run() {
        synchronized (this.f7464b.f7461b) {
            if (this.f7464b.f7462c != null) {
                this.f7464b.f7462c.onSuccess(this.f7463a.getResult());
            }
        }
    }
}
