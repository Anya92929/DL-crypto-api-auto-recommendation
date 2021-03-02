package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.z */
public class C2322z implements SafeParcelable {
    public static final Parcelable.Creator<C2322z> CREATOR = new C2231aa();
    public final ParcelFileDescriptor avq;
    public final int statusCode;
    public final int versionCode;

    C2322z(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.versionCode = i;
        this.statusCode = i2;
        this.avq = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2231aa.m7503a(this, dest, flags | 1);
    }
}
