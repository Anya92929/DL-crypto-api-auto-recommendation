package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.common.internal.a */
final class C1358a implements Parcelable.Creator {
    C1358a() {
    }

    /* renamed from: a */
    public BinderWrapper createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (C1358a) null);
    }

    /* renamed from: a */
    public BinderWrapper[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
