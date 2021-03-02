package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C1911k implements Parcelable.Creator<MarkerOptions> {
    /* renamed from: a */
    static void m6478a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, markerOptions.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) markerOptions.getPosition(), i, false);
        C0354b.m927a(parcel, 3, markerOptions.getTitle(), false);
        C0354b.m927a(parcel, 4, markerOptions.getSnippet(), false);
        C0354b.m921a(parcel, 5, markerOptions.mo10888mN(), false);
        C0354b.m918a(parcel, 6, markerOptions.getAnchorU());
        C0354b.m918a(parcel, 7, markerOptions.getAnchorV());
        C0354b.m930a(parcel, 8, markerOptions.isDraggable());
        C0354b.m930a(parcel, 9, markerOptions.isVisible());
        C0354b.m930a(parcel, 10, markerOptions.isFlat());
        C0354b.m918a(parcel, 11, markerOptions.getRotation());
        C0354b.m918a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0354b.m918a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0354b.m918a(parcel, 14, markerOptions.getAlpha());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cN */
    public MarkerOptions createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    latLng = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                case 6:
                    f = C0352a.m897l(parcel, B);
                    break;
                case 7:
                    f2 = C0352a.m897l(parcel, B);
                    break;
                case 8:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 9:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 10:
                    z3 = C0352a.m888c(parcel, B);
                    break;
                case 11:
                    f3 = C0352a.m897l(parcel, B);
                    break;
                case 12:
                    f4 = C0352a.m897l(parcel, B);
                    break;
                case 13:
                    f5 = C0352a.m897l(parcel, B);
                    break;
                case 14:
                    f6 = C0352a.m897l(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eC */
    public MarkerOptions[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
