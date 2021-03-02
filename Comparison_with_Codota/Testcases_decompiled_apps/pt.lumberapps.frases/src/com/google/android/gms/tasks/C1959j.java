package com.google.android.gms.tasks;

/* renamed from: com.google.android.gms.tasks.j */
class C1959j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f7448a;

    /* renamed from: b */
    final /* synthetic */ C1958i f7449b;

    C1959j(C1958i iVar, Task task) {
        this.f7449b = iVar;
        this.f7448a = task;
    }

    public void run() {
        try {
            Task task = (Task) this.f7449b.f7446b.then(this.f7448a);
            if (task == null) {
                this.f7449b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            task.addOnSuccessListener(TaskExecutors.f7429a, (OnSuccessListener) this.f7449b);
            task.addOnFailureListener(TaskExecutors.f7429a, (OnFailureListener) this.f7449b);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.f7449b.f7447c.mo9829a((Exception) e.getCause());
            } else {
                this.f7449b.f7447c.mo9829a((Exception) e);
            }
        } catch (Exception e2) {
            this.f7449b.f7447c.mo9829a(e2);
        }
    }
}
