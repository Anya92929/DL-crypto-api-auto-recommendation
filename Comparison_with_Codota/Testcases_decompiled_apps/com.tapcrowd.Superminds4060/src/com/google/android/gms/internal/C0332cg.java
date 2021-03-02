package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cg */
public abstract class C0332cg {

    /* renamed from: el */
    private final Runnable f999el = new Runnable() {
        public final void run() {
            Thread unused = C0332cg.this.f1000hD = Thread.currentThread();
            C0332cg.this.mo4155ac();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: hD */
    public volatile Thread f1000hD;

    /* renamed from: ac */
    public abstract void mo4155ac();

    public final void cancel() {
        onStop();
        if (this.f1000hD != null) {
            this.f1000hD.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        C0334ch.execute(this.f999el);
    }
}
