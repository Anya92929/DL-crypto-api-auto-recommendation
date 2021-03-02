package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0300g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C2304h;

public class DataEventBuffer extends C0300g<DataEvent> implements Result {

    /* renamed from: CM */
    private final Status f4651CM;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.f4651CM = new Status(dataHolder.getStatusCode());
    }

    /* access modifiers changed from: protected */
    /* renamed from: gE */
    public String mo4357gE() {
        return "path";
    }

    public Status getStatus() {
        return this.f4651CM;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public DataEvent mo4356f(int i, int i2) {
        return new C2304h(this.f667IC, i, i2);
    }
}
