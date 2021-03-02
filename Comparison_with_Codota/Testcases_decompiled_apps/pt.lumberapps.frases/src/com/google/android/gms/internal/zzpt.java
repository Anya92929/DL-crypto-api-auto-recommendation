package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzpt implements Releasable, Result {

    /* renamed from: a */
    protected final Status f6810a;

    /* renamed from: b */
    protected final DataHolder f6811b;

    public Status getStatus() {
        return this.f6810a;
    }

    public void release() {
        if (this.f6811b != null) {
            this.f6811b.close();
        }
    }
}
