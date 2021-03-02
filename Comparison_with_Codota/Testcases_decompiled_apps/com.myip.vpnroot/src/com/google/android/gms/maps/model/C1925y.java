package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.y */
public class C1925y implements Parcelable.Creator<VisibleRegion> {
    /* renamed from: a */
    static void m6510a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, visibleRegion.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        C0354b.m923a(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        C0354b.m923a(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        C0354b.m923a(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        C0354b.m923a(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cW */
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    latLng4 = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0352a.m880a(parcel, B, LatLngBounds.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eL */
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
