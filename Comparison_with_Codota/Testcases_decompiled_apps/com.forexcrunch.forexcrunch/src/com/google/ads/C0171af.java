package com.google.ads;

import com.google.ads.internal.C0247d;
import com.google.ads.util.C0284b;
import java.lang.ref.WeakReference;

/* renamed from: com.google.ads.af */
public class C0171af implements Runnable {

    /* renamed from: a */
    private WeakReference<C0247d> f127a;

    public C0171af(C0247d dVar) {
        this.f127a = new WeakReference<>(dVar);
    }

    public void run() {
        C0247d dVar = (C0247d) this.f127a.get();
        if (dVar == null) {
            C0284b.m480a("The ad must be gone, so cancelling the refresh timer.");
        } else {
            dVar.mo3516A();
        }
    }
}
