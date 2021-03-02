package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* renamed from: com.google.android.gms.wearable.internal.h */
public final class C2304h extends C0297d implements DataEvent {
    private final int aaz;

    public C2304h(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.aaz = i2;
    }

    public DataItem getDataItem() {
        return new C2311o(this.f693IC, this.f694JQ, this.aaz);
    }

    public int getType() {
        return getInteger("event_type");
    }

    /* renamed from: pU */
    public DataEvent freeze() {
        return new C2303g(this);
    }
}
