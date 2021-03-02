package com.google.android.gms.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.nh */
class C1767nh implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f5388a;

    /* renamed from: b */
    final /* synthetic */ int f5389b;

    /* renamed from: c */
    final /* synthetic */ zzlm f5390c;

    C1767nh(zzlm zzlm, int i, int i2) {
        this.f5390c = zzlm;
        this.f5388a = i;
        this.f5389b = i2;
    }

    public void run() {
        boolean z = false;
        synchronized (this.f5390c.f6742b) {
            boolean z2 = this.f5388a != this.f5389b;
            boolean z3 = !this.f5390c.f6746f && this.f5389b == 1;
            boolean z4 = z2 && this.f5389b == 1;
            boolean z5 = z2 && this.f5389b == 2;
            boolean z6 = z2 && this.f5389b == 3;
            zzlm zzlm = this.f5390c;
            if (this.f5390c.f6746f || z3) {
                z = true;
            }
            boolean unused = zzlm.f6746f = z;
            if (this.f5390c.f6745e != null) {
                if (z3) {
                    try {
                        this.f5390c.f6745e.zzjb();
                    } catch (RemoteException e) {
                        zzkd.zzd("Unable to call onVideoStart()", e);
                    }
                }
                if (z4) {
                    try {
                        this.f5390c.f6745e.zzjc();
                    } catch (RemoteException e2) {
                        zzkd.zzd("Unable to call onVideoPlay()", e2);
                    }
                }
                if (z5) {
                    try {
                        this.f5390c.f6745e.zzjd();
                    } catch (RemoteException e3) {
                        zzkd.zzd("Unable to call onVideoPause()", e3);
                    }
                }
                if (z6) {
                    try {
                        this.f5390c.f6745e.onVideoEnd();
                    } catch (RemoteException e4) {
                        zzkd.zzd("Unable to call onVideoEnd()", e4);
                    }
                }
            }
        }
    }
}
