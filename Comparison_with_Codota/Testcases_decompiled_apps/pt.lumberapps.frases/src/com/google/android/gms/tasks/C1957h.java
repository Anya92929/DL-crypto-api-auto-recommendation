package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.h */
class C1957h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f7443a;

    /* renamed from: b */
    final /* synthetic */ C1956g f7444b;

    C1957h(C1956g gVar, Task task) {
        this.f7444b = gVar;
        this.f7443a = task;
    }

    public void run() {
        try {
            this.f7444b.f7442c.mo9830a(this.f7444b.f7441b.then(this.f7443a));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f7444b.f7442c.mo9829a((Exception) e.getCause());
            } else {
                this.f7444b.f7442c.mo9829a((Exception) e);
            }
        } catch (Exception e2) {
            this.f7444b.f7442c.mo9829a(e2);
        }
    }
}
