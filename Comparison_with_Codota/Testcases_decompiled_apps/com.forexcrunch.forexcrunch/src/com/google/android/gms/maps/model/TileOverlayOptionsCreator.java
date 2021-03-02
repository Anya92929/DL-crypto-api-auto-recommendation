package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

public class TileOverlayOptionsCreator implements Parcelable.Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2061a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, tileOverlayOptions.mo6154i());
        C0359b.m669a(parcel, 2, tileOverlayOptions.mo6150bs(), false);
        C0359b.m675a(parcel, 3, tileOverlayOptions.isVisible());
        C0359b.m666a(parcel, 4, tileOverlayOptions.getZIndex());
        C0359b.m663C(parcel, d);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int c = C0357a.m634c(parcel);
        IBinder iBinder = null;
        float f = BitmapDescriptorFactory.HUE_RED;
        int i = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    iBinder = C0357a.m647m(parcel, b);
                    break;
                case 3:
                    z = C0357a.m636c(parcel, b);
                    break;
                case 4:
                    f = C0357a.m642i(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new TileOverlayOptions(i, iBinder, z, f);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public TileOverlayOptions[] newArray(int size) {
        return new TileOverlayOptions[size];
    }
}
