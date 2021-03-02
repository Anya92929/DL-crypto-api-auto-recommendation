package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;

/* renamed from: com.google.android.gms.internal.np */
class C1775np implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzpb f5399a;

    C1775np(zzpb zzpb) {
        this.f5399a = zzpb;
    }

    public void run() {
        synchronized (this.f5399a.f6762g) {
            if (zzpb.m7389b(this.f5399a) <= this.f5399a.f6760e.elapsedRealtime() && this.f5399a.f6766k != null) {
                Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                this.f5399a.f6766k.disconnect();
                GoogleApiClient unused = this.f5399a.f6766k = null;
            }
        }
    }
}
