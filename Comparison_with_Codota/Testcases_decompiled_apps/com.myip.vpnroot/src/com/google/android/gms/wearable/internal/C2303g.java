package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* renamed from: com.google.android.gms.wearable.internal.g */
public class C2303g implements DataEvent {

    /* renamed from: FD */
    private int f4686FD;
    private DataItem avh;

    public C2303g(DataEvent dataEvent) {
        this.f4686FD = dataEvent.getType();
        this.avh = (DataItem) dataEvent.getDataItem().freeze();
    }

    public DataItem getDataItem() {
        return this.avh;
    }

    public int getType() {
        return this.f4686FD;
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: pU */
    public DataEvent freeze() {
        return this;
    }
}
