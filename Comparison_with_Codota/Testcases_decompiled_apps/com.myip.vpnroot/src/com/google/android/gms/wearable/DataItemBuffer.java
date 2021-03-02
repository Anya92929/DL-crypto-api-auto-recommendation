package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0300g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C2311o;

public class DataItemBuffer extends C0300g<DataItem> implements Result {

    /* renamed from: CM */
    private final Status f4652CM;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.f4652CM = new Status(dataHolder.getStatusCode());
    }

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public String mo4357gE() {
        return "path";
    }

    public Status getStatus() {
        return this.f4652CM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public DataItem mo4356f(int i, int i2) {
        return new C2311o(this.f667IC, i, i2);
    }
}
