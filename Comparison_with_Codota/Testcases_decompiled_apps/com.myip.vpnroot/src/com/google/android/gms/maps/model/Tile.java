package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1869v;

public final class Tile implements SafeParcelable {
    public static final C1921u CREATOR = new C1921u();

    /* renamed from: BR */
    private final int f4479BR;
    public final byte[] data;
    public final int height;
    public final int width;

    Tile(int versionCode, int width2, int height2, byte[] data2) {
        this.f4479BR = versionCode;
        this.width = width2;
        this.height = height2;
        this.data = data2;
    }

    public Tile(int width2, int height2, byte[] data2) {
        this(1, width2, height2, data2);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4479BR;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1869v.m6395mK()) {
            C1922v.m6505a(this, out, flags);
        } else {
            C1921u.m6502a(this, out, flags);
        }
    }
}
