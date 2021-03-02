package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

/* renamed from: com.google.android.gms.internal.pp */
class C1829pp implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Result f5505a;

    /* renamed from: b */
    final /* synthetic */ zzqx f5506b;

    C1829pp(zzqx zzqx, Result result) {
        this.f5506b = zzqx;
        this.f5505a = result;
    }

    public void run() {
        try {
            zzpo.f6791a.set(true);
            this.f5506b.f6931h.sendMessage(this.f5506b.f6931h.obtainMessage(0, this.f5506b.f6924a.onSuccess(this.f5505a)));
            zzpo.f6791a.set(false);
            this.f5506b.m7528a(this.f5505a);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.f5506b.f6930g.get();
            if (googleApiClient != null) {
                googleApiClient.zzb(this.f5506b);
            }
        } catch (RuntimeException e) {
            this.f5506b.f6931h.sendMessage(this.f5506b.f6931h.obtainMessage(1, e));
            zzpo.f6791a.set(false);
            this.f5506b.m7528a(this.f5505a);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.f5506b.f6930g.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zzb(this.f5506b);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            zzpo.f6791a.set(false);
            this.f5506b.m7528a(this.f5505a);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) this.f5506b.f6930g.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zzb(this.f5506b);
            }
            throw th2;
        }
    }
}
