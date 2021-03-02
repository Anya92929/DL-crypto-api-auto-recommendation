package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.lk */
class C1716lk implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5296a;

    /* renamed from: b */
    final /* synthetic */ long f5297b;

    /* renamed from: c */
    final /* synthetic */ zzk f5298c;

    C1716lk(zzk zzk, String str, long j) {
        this.f5298c = zzk;
        this.f5296a = str;
        this.f5297b = j;
    }

    public void run() {
        this.f5298c.f6586a.mo7684a(this.f5296a, this.f5297b);
        this.f5298c.f6586a.mo7683a(toString());
    }
}
