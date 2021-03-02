package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzo implements Parcelable.Creator<TileOverlayOptions> {
    /* renamed from: a */
    static void m5130a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, tileOverlayOptions.mo8750a());
        C1031c.m4613a(parcel, 2, tileOverlayOptions.mo8751b(), false);
        C1031c.m4619a(parcel, 3, tileOverlayOptions.isVisible());
        C1031c.m4609a(parcel, 4, tileOverlayOptions.getZIndex());
        C1031c.m4619a(parcel, 5, tileOverlayOptions.getFadeIn());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfk */
    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = C1029a.m4587b(parcel);
        IBinder iBinder = null;
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    iBinder = C1029a.m4600l(parcel, a);
                    break;
                case 3:
                    z = C1029a.m4591c(parcel, a);
                    break;
                case 4:
                    f = C1029a.m4597i(parcel, a);
                    break;
                case 5:
                    z2 = C1029a.m4591c(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhK */
    public TileOverlayOptions[] newArray(int i) {
        return new TileOverlayOptions[i];
    }
}
