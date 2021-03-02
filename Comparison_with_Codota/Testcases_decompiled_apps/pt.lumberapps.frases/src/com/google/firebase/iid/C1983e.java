package com.google.firebase.iid;

import android.content.Intent;

/* renamed from: com.google.firebase.iid.e */
class C1983e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Intent f7520a;

    /* renamed from: b */
    final /* synthetic */ C1981c f7521b;

    C1983e(C1981c cVar, Intent intent) {
        this.f7521b = cVar;
        this.f7520a = intent;
    }

    public void run() {
        this.f7521b.zzm(this.f7520a);
        this.f7521b.mo9871b();
    }
}
