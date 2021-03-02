package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.fc */
class C1546fc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zze f4985a;

    /* renamed from: b */
    private final zzk f4986b;

    /* renamed from: c */
    private final zzm f4987c;

    /* renamed from: d */
    private final Runnable f4988d;

    public C1546fc(zze zze, zzk zzk, zzm zzm, Runnable runnable) {
        this.f4985a = zze;
        this.f4986b = zzk;
        this.f4987c = zzm;
        this.f4988d = runnable;
    }

    public void run() {
        if (this.f4986b.isCanceled()) {
            this.f4986b.mo8637b("canceled-at-delivery");
            return;
        }
        if (this.f4987c.isSuccess()) {
            this.f4986b.mo7494a(this.f4987c.result);
        } else {
            this.f4986b.zzc(this.f4987c.zzbg);
        }
        if (this.f4987c.zzbh) {
            this.f4986b.zzc("intermediate-response");
        } else {
            this.f4986b.mo8637b("done");
        }
        if (this.f4988d != null) {
            this.f4988d.run();
        }
    }
}
