package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.maps.model.CameraPosition;

/* renamed from: com.google.android.gms.maps.a */
public class C1789a implements Parcelable.Creator<GoogleMapOptions> {
    /* renamed from: a */
    static void m6312a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, googleMapOptions.getVersionCode());
        C0354b.m916a(parcel, 2, googleMapOptions.mo10352mp());
        C0354b.m916a(parcel, 3, googleMapOptions.mo10353mq());
        C0354b.m939c(parcel, 4, googleMapOptions.getMapType());
        C0354b.m923a(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        C0354b.m916a(parcel, 6, googleMapOptions.mo10354mr());
        C0354b.m916a(parcel, 7, googleMapOptions.mo10355ms());
        C0354b.m916a(parcel, 8, googleMapOptions.mo10356mt());
        C0354b.m916a(parcel, 9, googleMapOptions.mo10357mu());
        C0354b.m916a(parcel, 10, googleMapOptions.mo10358mv());
        C0354b.m916a(parcel, 11, googleMapOptions.mo10359mw());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cG */
    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = 0;
        int C = C0352a.m875C(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        int i = 0;
        byte b7 = 0;
        byte b8 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    b8 = C0352a.m890e(parcel, B);
                    break;
                case 3:
                    b7 = C0352a.m890e(parcel, B);
                    break;
                case 4:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C0352a.m880a(parcel, B, CameraPosition.CREATOR);
                    break;
                case 6:
                    b6 = C0352a.m890e(parcel, B);
                    break;
                case 7:
                    b5 = C0352a.m890e(parcel, B);
                    break;
                case 8:
                    b4 = C0352a.m890e(parcel, B);
                    break;
                case 9:
                    b3 = C0352a.m890e(parcel, B);
                    break;
                case 10:
                    b2 = C0352a.m890e(parcel, B);
                    break;
                case 11:
                    b = C0352a.m890e(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ev */
    public GoogleMapOptions[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
