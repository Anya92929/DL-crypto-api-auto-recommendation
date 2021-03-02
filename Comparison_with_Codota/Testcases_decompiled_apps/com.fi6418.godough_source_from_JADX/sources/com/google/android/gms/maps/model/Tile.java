package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Tile implements SafeParcelable {
    public static final zzn CREATOR = new zzn();

    /* renamed from: a */
    private final int f5198a;
    public final byte[] data;
    public final int height;
    public final int width;

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.f5198a = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo8736a() {
        return this.f5198a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.m5129a(this, parcel, i);
    }
}
