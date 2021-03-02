package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ox */
abstract class C1810ox implements Runnable {

    /* renamed from: b */
    final /* synthetic */ zzpw f5461b;

    private C1810ox(zzpw zzpw) {
        this.f5461b = zzpw;
    }

    /* synthetic */ C1810ox(zzpw zzpw, C1801oo ooVar) {
        this(zzpw);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7627a();

    public void run() {
        this.f5461b.f6816b.lock();
        try {
            if (!Thread.interrupted()) {
                mo7627a();
                this.f5461b.f6816b.unlock();
            }
        } catch (RuntimeException e) {
            this.f5461b.f6815a.mo8959a(e);
        } finally {
            this.f5461b.f6816b.unlock();
        }
    }
}
