package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.common.api.a */
public abstract class C0273a implements Releasable, Result {

    /* renamed from: CM */
    protected final Status f599CM;

    /* renamed from: IC */
    protected final DataHolder f600IC;

    protected C0273a(DataHolder dataHolder) {
        this.f599CM = new Status(dataHolder.getStatusCode());
        this.f600IC = dataHolder;
    }

    public Status getStatus() {
        return this.f599CM;
    }

    public void release() {
        if (this.f600IC != null) {
            this.f600IC.close();
        }
    }
}
