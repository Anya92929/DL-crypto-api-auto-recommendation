package com.google.android.gms.ads.internal.util.client;

/* renamed from: com.google.android.gms.ads.internal.util.client.b */
class C1324b extends Thread {

    /* renamed from: a */
    final /* synthetic */ String f3988a;

    /* renamed from: b */
    final /* synthetic */ C1323a f3989b;

    C1324b(C1323a aVar, String str) {
        this.f3989b = aVar;
        this.f3988a = str;
    }

    public void run() {
        new zzc().zzcr(this.f3988a);
    }
}
