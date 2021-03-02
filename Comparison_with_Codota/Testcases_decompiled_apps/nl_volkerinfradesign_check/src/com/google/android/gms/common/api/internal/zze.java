package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.DataHolder;

public abstract class zze<L> implements zzq.zzb<L> {

    /* renamed from: a */
    private final DataHolder f2690a;

    protected zze(DataHolder dataHolder) {
        this.f2690a = dataHolder;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(L l, DataHolder dataHolder);

    public void zzpr() {
        if (this.f2690a != null) {
            this.f2690a.close();
        }
    }

    public final void zzt(L l) {
        zza(l, this.f2690a);
    }
}
