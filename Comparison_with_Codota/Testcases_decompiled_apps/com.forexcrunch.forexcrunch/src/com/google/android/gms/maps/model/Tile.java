package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0708q;

public final class Tile implements SafeParcelable {
    public static final TileCreator CREATOR = new TileCreator();

    /* renamed from: ab */
    private final int f1627ab;
    public final byte[] data;
    public final int height;
    public final int width;

    Tile(int versionCode, int width2, int height2, byte[] data2) {
        this.f1627ab = versionCode;
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
    /* renamed from: i */
    public int mo6137i() {
        return this.f1627ab;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0708q.m2025bn()) {
            C0719i.m2074a(this, out, flags);
        } else {
            TileCreator.m2057a(this, out, flags);
        }
    }
}
