package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.common.internal.a */
final class C0976a implements Parcelable.Creator<BinderWrapper> {
    C0976a() {
    }

    /* renamed from: a */
    public BinderWrapper createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (C0976a) null);
    }

    /* renamed from: a */
    public BinderWrapper[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
