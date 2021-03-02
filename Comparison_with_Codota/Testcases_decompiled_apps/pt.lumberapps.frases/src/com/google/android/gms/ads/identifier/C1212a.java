package com.google.android.gms.ads.identifier;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.ads.identifier.a */
class C1212a extends Thread {

    /* renamed from: a */
    CountDownLatch f3425a = new CountDownLatch(1);

    /* renamed from: b */
    boolean f3426b = false;

    /* renamed from: c */
    private WeakReference f3427c;

    /* renamed from: d */
    private long f3428d;

    public C1212a(AdvertisingIdClient advertisingIdClient, long j) {
        this.f3427c = new WeakReference(advertisingIdClient);
        this.f3428d = j;
        start();
    }

    /* renamed from: c */
    private void m5518c() {
        AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.f3427c.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.finish();
            this.f3426b = true;
        }
    }

    /* renamed from: a */
    public void mo4985a() {
        this.f3425a.countDown();
    }

    /* renamed from: b */
    public boolean mo4986b() {
        return this.f3426b;
    }

    public void run() {
        try {
            if (!this.f3425a.await(this.f3428d, TimeUnit.MILLISECONDS)) {
                m5518c();
            }
        } catch (InterruptedException e) {
            m5518c();
        }
    }
}
