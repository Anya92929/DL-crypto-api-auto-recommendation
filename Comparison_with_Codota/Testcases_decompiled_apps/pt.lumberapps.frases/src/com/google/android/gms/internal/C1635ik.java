package com.google.android.gms.internal;

import com.google.android.gms.internal.zzge;

/* renamed from: com.google.android.gms.internal.ik */
class C1635ik implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgc f5141a;

    /* renamed from: b */
    final /* synthetic */ zzgd f5142b;

    C1635ik(zzgd zzgd, zzgc zzgc) {
        this.f5142b = zzgd;
        this.f5141a = zzgc;
    }

    public void run() {
        synchronized (this.f5142b.f6227i) {
            if (this.f5142b.f6234p == -2) {
                zzgk unused = this.f5142b.f6233o = this.f5142b.m7089c();
                if (this.f5142b.f6233o == null) {
                    this.f5142b.zzy(4);
                } else if (!this.f5142b.m7092d() || this.f5142b.m7081a(1)) {
                    this.f5141a.zza((zzge.zza) this.f5142b);
                    this.f5142b.m7079a(this.f5141a);
                } else {
                    String f = this.f5142b.f6219a;
                    zzkd.zzcx(new StringBuilder(String.valueOf(f).length() + 56).append("Ignoring adapter ").append(f).append(" as delayed impression is not supported").toString());
                    this.f5142b.zzy(2);
                }
            }
        }
    }
}
