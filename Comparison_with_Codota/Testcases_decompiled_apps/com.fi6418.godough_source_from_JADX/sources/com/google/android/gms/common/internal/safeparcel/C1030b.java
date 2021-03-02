package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C1030b extends RuntimeException {
    public C1030b(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }
}
