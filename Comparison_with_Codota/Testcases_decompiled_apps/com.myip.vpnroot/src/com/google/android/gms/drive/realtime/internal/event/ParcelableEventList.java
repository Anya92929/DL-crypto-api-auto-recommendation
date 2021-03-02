package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEventList> CREATOR = new C0541c();

    /* renamed from: BR */
    final int f1200BR;

    /* renamed from: Rw */
    final DataHolder f1201Rw;

    /* renamed from: Rx */
    final boolean f1202Rx;

    /* renamed from: Ry */
    final List<String> f1203Ry;

    /* renamed from: me */
    final List<ParcelableEvent> f1204me;

    ParcelableEventList(int versionCode, List<ParcelableEvent> events, DataHolder eventData, boolean undoRedoStateChanged, List<String> affectedObjectIds) {
        this.f1200BR = versionCode;
        this.f1204me = events;
        this.f1201Rw = eventData;
        this.f1202Rx = undoRedoStateChanged;
        this.f1203Ry = affectedObjectIds;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0541c.m1551a(this, dest, flags);
    }
}
