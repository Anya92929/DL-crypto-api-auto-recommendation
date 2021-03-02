package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ma */
public class C1552ma implements Parcelable.Creator<C1550lz> {
    /* renamed from: a */
    static void m5580a(C1550lz lzVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) lzVar.f4279Ux, i, false);
        C0354b.m939c(parcel, 1000, lzVar.getVersionCode());
        C0354b.m930a(parcel, 2, lzVar.aeX);
        C0354b.m930a(parcel, 3, lzVar.aeY);
        C0354b.m930a(parcel, 4, lzVar.aeZ);
        C0354b.m940c(parcel, 5, lzVar.afa, false);
        C0354b.m927a(parcel, 6, lzVar.mTag, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cv */
    public C1550lz createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int C = C0352a.m875C(parcel);
        List<C1516lr> list = C1550lz.aeW;
        boolean z3 = true;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    locationRequest = (LocationRequest) C0352a.m880a(parcel, B, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 3:
                    z3 = C0352a.m888c(parcel, B);
                    break;
                case 4:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 5:
                    list = C0352a.m887c(parcel, B, C1516lr.CREATOR);
                    break;
                case 6:
                    str = C0352a.m900o(parcel, B);
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
            return new C1550lz(i, locationRequest, z2, z3, z, list, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ei */
    public C1550lz[] newArray(int i) {
        return new C1550lz[i];
    }
}
