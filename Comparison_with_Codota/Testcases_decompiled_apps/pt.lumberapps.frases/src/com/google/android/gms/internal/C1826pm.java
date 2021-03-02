package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.pm */
class C1826pm implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzqj f5498a;

    /* renamed from: b */
    final /* synthetic */ String f5499b;

    /* renamed from: c */
    final /* synthetic */ zzql f5500c;

    C1826pm(zzql zzql, zzqj zzqj, String str) {
        this.f5500c = zzql;
        this.f5498a = zzqj;
        this.f5499b = str;
    }

    public void run() {
        if (this.f5500c.f6911c >= 1) {
            this.f5498a.onCreate(this.f5500c.f6912d != null ? this.f5500c.f6912d.getBundle(this.f5499b) : null);
        }
        if (this.f5500c.f6911c >= 2) {
            this.f5498a.onStart();
        }
        if (this.f5500c.f6911c >= 3) {
            this.f5498a.onStop();
        }
    }
}
