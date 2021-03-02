package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.nv */
final class C1781nv extends C1780nu {

    /* renamed from: d */
    private final LogEventParcelable f5407d;

    C1781nv(LogEventParcelable logEventParcelable, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.f5407d = logEventParcelable;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Status zzc(Status status) {
        return status;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7586a(zzpc zzpc) {
        C1782nw nwVar = new C1782nw(this);
        try {
            zzpb.m7391b(this.f5407d);
            zzpc.zza(nwVar, this.f5407d);
        } catch (RuntimeException e) {
            Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
            zzz(new Status(10, "MessageProducer"));
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1781nv)) {
            return false;
        }
        return this.f5407d.equals(((C1781nv) obj).f5407d);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f5407d);
        return new StringBuilder(String.valueOf(valueOf).length() + 12).append("MethodImpl(").append(valueOf).append(")").toString();
    }
}
