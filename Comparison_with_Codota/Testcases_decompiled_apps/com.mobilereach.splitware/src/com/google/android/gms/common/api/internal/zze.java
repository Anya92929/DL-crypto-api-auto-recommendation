package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.DataHolder;

public abstract class zze<L> implements zzq.zzb<L> {
    private final DataHolder zzahi;

    protected zze(DataHolder dataHolder) {
        this.zzahi = dataHolder;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(L l, DataHolder dataHolder);

    public void zzpr() {
        if (this.zzahi != null) {
            this.zzahi.close();
        }
    }

    public final void zzt(L l) {
        zza(l, this.zzahi);
    }
}
