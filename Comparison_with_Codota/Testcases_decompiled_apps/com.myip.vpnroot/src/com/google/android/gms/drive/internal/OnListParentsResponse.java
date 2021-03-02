package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.C0377i;

public class OnListParentsResponse extends C0377i implements SafeParcelable {
    public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new C0401ao();

    /* renamed from: BR */
    final int f945BR;

    /* renamed from: Pn */
    final DataHolder f946Pn;

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.f945BR = versionCode;
        this.f946Pn = parents;
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public void mo4765I(Parcel parcel, int i) {
        C0401ao.m1158a(this, parcel, i);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: ik */
    public DataHolder mo4820ik() {
        return this.f946Pn;
    }
}
