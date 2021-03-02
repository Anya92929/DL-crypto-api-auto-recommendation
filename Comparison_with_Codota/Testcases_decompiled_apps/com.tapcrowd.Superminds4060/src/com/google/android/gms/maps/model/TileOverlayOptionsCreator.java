package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class TileOverlayOptionsCreator implements Parcelable.Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2100a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0155b.m346a(parcel, 2, tileOverlayOptions.mo5988cP(), false);
        C0155b.m352a(parcel, 3, tileOverlayOptions.isVisible());
        C0155b.m343a(parcel, 4, tileOverlayOptions.getZIndex());
        C0155b.m340C(parcel, k);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int j = C0153a.m320j(parcel);
        IBinder iBinder = null;
        float f = BitmapDescriptorFactory.HUE_RED;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    iBinder = C0153a.m323m(parcel, i2);
                    break;
                case 3:
                    z = C0153a.m311c(parcel, i2);
                    break;
                case 4:
                    f = C0153a.m317i(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new TileOverlayOptions(i, iBinder, z, f);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public TileOverlayOptions[] newArray(int size) {
        return new TileOverlayOptions[size];
    }
}
