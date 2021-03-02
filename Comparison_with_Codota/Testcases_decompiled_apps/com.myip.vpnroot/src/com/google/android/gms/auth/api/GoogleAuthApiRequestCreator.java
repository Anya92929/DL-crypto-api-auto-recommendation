package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

public class GoogleAuthApiRequestCreator implements Parcelable.Creator<GoogleAuthApiRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m356a(GoogleAuthApiRequest googleAuthApiRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, googleAuthApiRequest.name, false);
        C0354b.m939c(parcel, 1000, googleAuthApiRequest.versionCode);
        C0354b.m927a(parcel, 2, googleAuthApiRequest.version, false);
        C0354b.m927a(parcel, 3, googleAuthApiRequest.f378Dt, false);
        C0354b.m927a(parcel, 4, googleAuthApiRequest.f385yR, false);
        C0354b.m920a(parcel, 5, googleAuthApiRequest.f379Du, false);
        C0354b.m927a(parcel, 6, googleAuthApiRequest.f380Dv, false);
        C0354b.m938b(parcel, 7, googleAuthApiRequest.f381Dw, false);
        C0354b.m927a(parcel, 8, googleAuthApiRequest.f382Dx, false);
        C0354b.m939c(parcel, 9, googleAuthApiRequest.f383Dy);
        C0354b.m920a(parcel, 10, googleAuthApiRequest.f384Dz, false);
        C0354b.m931a(parcel, 11, googleAuthApiRequest.f376DA, false);
        C0354b.m919a(parcel, 12, googleAuthApiRequest.f377DB);
        C0354b.m915H(parcel, D);
    }

    public GoogleAuthApiRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Bundle bundle = null;
        String str5 = null;
        ArrayList<String> arrayList = null;
        String str6 = null;
        int i2 = 0;
        Bundle bundle2 = null;
        byte[] bArr = null;
        long j = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 6:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                case 8:
                    str6 = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 10:
                    bundle2 = C0352a.m902q(parcel, B);
                    break;
                case 11:
                    bArr = C0352a.m903r(parcel, B);
                    break;
                case 12:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 1000:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new GoogleAuthApiRequest(i, str, str2, str3, str4, bundle, str5, arrayList, str6, i2, bundle2, bArr, j);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public GoogleAuthApiRequest[] newArray(int size) {
        return new GoogleAuthApiRequest[size];
    }
}
