package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.internal.zzpo;

/* renamed from: com.google.android.gms.common.api.b */
final class C1340b extends zzpo {

    /* renamed from: d */
    private final Result f4340d;

    public C1340b(Result result) {
        super(Looper.getMainLooper());
        this.f4340d = result;
    }

    /* access modifiers changed from: protected */
    public Result zzc(Status status) {
        if (status.getStatusCode() == this.f4340d.getStatus().getStatusCode()) {
            return this.f4340d;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
