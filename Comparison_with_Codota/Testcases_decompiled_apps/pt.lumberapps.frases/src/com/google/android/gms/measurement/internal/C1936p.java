package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.p */
class C1936p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AtomicReference f7223a;

    /* renamed from: b */
    final /* synthetic */ boolean f7224b;

    /* renamed from: c */
    final /* synthetic */ zzad f7225c;

    C1936p(zzad zzad, AtomicReference atomicReference, boolean z) {
        this.f7225c = zzad;
        this.f7223a = atomicReference;
        this.f7224b = z;
    }

    /* JADX INFO: finally extract failed */
    public void run() {
        synchronized (this.f7223a) {
            try {
                zzm c = this.f7225c.f7248b;
                if (c == null) {
                    this.f7225c.zzbsd().zzbsv().log("Failed to get user properties");
                    this.f7223a.notify();
                    return;
                }
                this.f7223a.set(c.zza(this.f7225c.zzbrv().mo9579a((String) null), this.f7224b));
                this.f7225c.m7758i();
                this.f7223a.notify();
            } catch (RemoteException e) {
                this.f7225c.zzbsd().zzbsv().zzj("Failed to get user properties", e);
                this.f7223a.notify();
            } catch (Throwable th) {
                this.f7223a.notify();
                throw th;
            }
        }
    }
}
