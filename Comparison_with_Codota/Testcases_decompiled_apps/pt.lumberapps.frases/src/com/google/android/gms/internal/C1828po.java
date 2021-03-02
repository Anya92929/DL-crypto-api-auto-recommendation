package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.po */
class C1828po implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzqj f5502a;

    /* renamed from: b */
    final /* synthetic */ String f5503b;

    /* renamed from: c */
    final /* synthetic */ zzqv f5504c;

    C1828po(zzqv zzqv, zzqj zzqj, String str) {
        this.f5504c = zzqv;
        this.f5502a = zzqj;
        this.f5503b = str;
    }

    public void run() {
        if (this.f5504c.f6922c >= 1) {
            this.f5502a.onCreate(this.f5504c.f6923d != null ? this.f5504c.f6923d.getBundle(this.f5503b) : null);
        }
        if (this.f5504c.f6922c >= 2) {
            this.f5502a.onStart();
        }
        if (this.f5504c.f6922c >= 3) {
            this.f5502a.onStop();
        }
    }
}
