package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ka */
class C1679ka implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzhy f5197a;

    C1679ka(zzhy zzhy) {
        this.f5197a = zzhy;
    }

    public void run() {
        if (this.f5197a.f6362h.get()) {
            zzkd.m5769e("Timed out waiting for WebView to finish loading.");
            this.f5197a.cancel();
        }
    }
}
