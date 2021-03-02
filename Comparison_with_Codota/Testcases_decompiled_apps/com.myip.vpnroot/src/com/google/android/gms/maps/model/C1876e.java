package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C1876e implements Parcelable.Creator<GroundOverlayOptions> {
    /* renamed from: a */
    static void m6422a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0354b.m921a(parcel, 2, groundOverlayOptions.mo10805mM(), false);
        C0354b.m923a(parcel, 3, (Parcelable) groundOverlayOptions.getLocation(), i, false);
        C0354b.m918a(parcel, 4, groundOverlayOptions.getWidth());
        C0354b.m918a(parcel, 5, groundOverlayOptions.getHeight());
        C0354b.m923a(parcel, 6, (Parcelable) groundOverlayOptions.getBounds(), i, false);
        C0354b.m918a(parcel, 7, groundOverlayOptions.getBearing());
        C0354b.m918a(parcel, 8, groundOverlayOptions.getZIndex());
        C0354b.m930a(parcel, 9, groundOverlayOptions.isVisible());
        C0354b.m918a(parcel, 10, groundOverlayOptions.getTransparency());
        C0354b.m918a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0354b.m918a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cK */
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                case 3:
                    latLng = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 4:
                    f = C0352a.m897l(parcel, B);
                    break;
                case 5:
                    f2 = C0352a.m897l(parcel, B);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0352a.m880a(parcel, B, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C0352a.m897l(parcel, B);
                    break;
                case 8:
                    f4 = C0352a.m897l(parcel, B);
                    break;
                case 9:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 10:
                    f5 = C0352a.m897l(parcel, B);
                    break;
                case 11:
                    f6 = C0352a.m897l(parcel, B);
                    break;
                case 12:
                    f7 = C0352a.m897l(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ez */
    public GroundOverlayOptions[] newArray(int i) {
        return new GroundOverlayOptions[i];
    }
}
