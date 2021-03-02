package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class GoogleAuthApiResponseCreator implements Parcelable.Creator<GoogleAuthApiResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m358a(GoogleAuthApiResponse googleAuthApiResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, googleAuthApiResponse.responseCode);
        C0354b.m939c(parcel, 1000, googleAuthApiResponse.versionCode);
        C0354b.m920a(parcel, 2, googleAuthApiResponse.f387Dz, false);
        C0354b.m931a(parcel, 3, googleAuthApiResponse.f386DA, false);
        C0354b.m915H(parcel, D);
    }

    public GoogleAuthApiResponse createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 3:
                    bArr = C0352a.m903r(parcel, B);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new GoogleAuthApiResponse(i2, i, bundle, bArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public GoogleAuthApiResponse[] newArray(int size) {
        return new GoogleAuthApiResponse[size];
    }
}
