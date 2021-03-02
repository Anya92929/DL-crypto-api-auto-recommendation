package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.C0377i;

public class OnListEntriesResponse extends C0377i implements SafeParcelable {
    public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new C0400an();

    /* renamed from: BR */
    final int f942BR;

    /* renamed from: Or */
    final boolean f943Or;

    /* renamed from: Pm */
    final DataHolder f944Pm;

    OnListEntriesResponse(int versionCode, DataHolder entries, boolean moreEntriesMayExist) {
        this.f942BR = versionCode;
        this.f944Pm = entries;
        this.f943Or = moreEntriesMayExist;
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public void mo4765I(Parcel parcel, int i) {
        C0400an.m1155a(this, parcel, i);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: ii */
    public DataHolder mo4817ii() {
        return this.f944Pm;
    }

    /* renamed from: ij */
    public boolean mo4818ij() {
        return this.f943Or;
    }
}
