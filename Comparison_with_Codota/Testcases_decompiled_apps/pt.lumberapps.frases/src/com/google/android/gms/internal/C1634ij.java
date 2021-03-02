package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ij */
class C1634ij implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzfp f5139a;

    /* renamed from: b */
    final /* synthetic */ C1633ii f5140b;

    C1634ij(C1633ii iiVar, zzfp zzfp) {
        this.f5140b = iiVar;
        this.f5139a = zzfp;
    }

    public void run() {
        this.f5140b.f5138a.f6205e.zzd(this.f5139a);
        this.f5139a.destroy();
    }
}
