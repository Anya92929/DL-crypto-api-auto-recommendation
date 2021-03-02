package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzf implements Parcelable.Creator<MarkerOptions> {
    /* renamed from: a */
    static void m5121a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, markerOptions.mo8597a());
        C1031c.m4614a(parcel, 2, (Parcelable) markerOptions.getPosition(), i, false);
        C1031c.m4616a(parcel, 3, markerOptions.getTitle(), false);
        C1031c.m4616a(parcel, 4, markerOptions.getSnippet(), false);
        C1031c.m4613a(parcel, 5, markerOptions.mo8600b(), false);
        C1031c.m4609a(parcel, 6, markerOptions.getAnchorU());
        C1031c.m4609a(parcel, 7, markerOptions.getAnchorV());
        C1031c.m4619a(parcel, 8, markerOptions.isDraggable());
        C1031c.m4619a(parcel, 9, markerOptions.isVisible());
        C1031c.m4619a(parcel, 10, markerOptions.isFlat());
        C1031c.m4609a(parcel, 11, markerOptions.getRotation());
        C1031c.m4609a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C1031c.m4609a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C1031c.m4609a(parcel, 14, markerOptions.getAlpha());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfb */
    public MarkerOptions createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = BitmapDescriptorFactory.HUE_RED;
        float f2 = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float f4 = 0.5f;
        float f5 = BitmapDescriptorFactory.HUE_RED;
        float f6 = 1.0f;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    str = C1029a.m4599k(parcel, a);
                    break;
                case 4:
                    str2 = C1029a.m4599k(parcel, a);
                    break;
                case 5:
                    iBinder = C1029a.m4600l(parcel, a);
                    break;
                case 6:
                    f = C1029a.m4597i(parcel, a);
                    break;
                case 7:
                    f2 = C1029a.m4597i(parcel, a);
                    break;
                case 8:
                    z = C1029a.m4591c(parcel, a);
                    break;
                case 9:
                    z2 = C1029a.m4591c(parcel, a);
                    break;
                case 10:
                    z3 = C1029a.m4591c(parcel, a);
                    break;
                case 11:
                    f3 = C1029a.m4597i(parcel, a);
                    break;
                case 12:
                    f4 = C1029a.m4597i(parcel, a);
                    break;
                case 13:
                    f5 = C1029a.m4597i(parcel, a);
                    break;
                case 14:
                    f6 = C1029a.m4597i(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhB */
    public MarkerOptions[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
