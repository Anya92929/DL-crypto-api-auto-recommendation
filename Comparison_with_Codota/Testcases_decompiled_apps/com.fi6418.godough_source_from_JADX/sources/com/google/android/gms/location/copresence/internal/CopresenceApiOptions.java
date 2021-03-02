package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CopresenceApiOptions implements SafeParcelable {
    public static final Parcelable.Creator<CopresenceApiOptions> CREATOR = new C1112a();

    /* renamed from: a */
    public static final CopresenceApiOptions f4923a = new CopresenceApiOptions(true, (String) null);

    /* renamed from: b */
    final int f4924b;

    /* renamed from: c */
    public final boolean f4925c;

    /* renamed from: d */
    public final String f4926d;

    CopresenceApiOptions(int i, boolean z, String str) {
        this.f4924b = i;
        this.f4925c = z;
        this.f4926d = str;
    }

    public CopresenceApiOptions(boolean z, String str) {
        this(1, z, str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1112a.m4831a(this, parcel, i);
    }
}
