package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.in */
class C1638in implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzky f5146a;

    /* renamed from: b */
    final /* synthetic */ zzgg f5147b;

    C1638in(zzgg zzgg, zzky zzky) {
        this.f5147b = zzgg;
        this.f5146a = zzky;
    }

    public void run() {
        for (zzky zzky : this.f5147b.f6246k.keySet()) {
            if (zzky != this.f5146a) {
                ((zzgd) this.f5147b.f6246k.get(zzky)).cancel();
            }
        }
    }
}
