package com.google.android.gms.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.hb */
class C1599hb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1600hc f5059a;

    /* renamed from: b */
    final /* synthetic */ C1601hd f5060b;

    /* renamed from: c */
    final /* synthetic */ C1575ge f5061c;

    C1599hb(C1575ge geVar, C1600hc hcVar, C1601hd hdVar) {
        this.f5061c = geVar;
        this.f5059a = hcVar;
        this.f5060b = hdVar;
    }

    public void run() {
        try {
            this.f5059a.mo7287a(this.f5060b);
        } catch (RemoteException e) {
            zzkd.zzd("Could not propagate interstitial ad event.", e);
        }
    }
}
