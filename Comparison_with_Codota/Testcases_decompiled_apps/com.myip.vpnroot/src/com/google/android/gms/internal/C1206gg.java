package com.google.android.gms.internal;

@C1130ez
/* renamed from: com.google.android.gms.internal.gg */
public abstract class C1206gg {

    /* renamed from: mk */
    private final Runnable f3742mk = new Runnable() {
        public final void run() {
            Thread unused = C1206gg.this.f3743wf = Thread.currentThread();
            C1206gg.this.mo8384cp();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: wf */
    public volatile Thread f3743wf;

    public final void cancel() {
        onStop();
        if (this.f3743wf != null) {
            this.f3743wf.interrupt();
        }
    }

    /* renamed from: cp */
    public abstract void mo8384cp();

    public abstract void onStop();

    public final void start() {
        C1209gi.m4606a(this.f3742mk);
    }
}
