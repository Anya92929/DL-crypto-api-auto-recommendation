package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzqn;

public abstract class zzps implements zzqn.zzb {

    /* renamed from: a */
    private final DataHolder f6809a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8937a(Object obj, DataHolder dataHolder);

    public void zzapj() {
        if (this.f6809a != null) {
            this.f6809a.close();
        }
    }

    public final void zzt(Object obj) {
        mo8937a(obj, this.f6809a);
    }
}
