package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.mr */
public class C1569mr implements Parcelable.Creator<C1568mq> {
    /* renamed from: a */
    static void m5630a(C1568mq mqVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, mqVar.getName(), false);
        C0354b.m939c(parcel, 1000, mqVar.f4289BR);
        C0354b.m923a(parcel, 2, (Parcelable) mqVar.mo9450mj(), i, false);
        C0354b.m927a(parcel, 3, mqVar.getAddress(), false);
        C0354b.m940c(parcel, 4, mqVar.mo9451mk(), false);
        C0354b.m927a(parcel, 5, mqVar.getPhoneNumber(), false);
        C0354b.m927a(parcel, 6, mqVar.mo9452ml(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cD */
    public C1568mq createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str2 = null;
        ArrayList arrayList = null;
        String str3 = null;
        LatLng latLng = null;
        String str4 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    latLng = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    arrayList = C0352a.m887c(parcel, B, C1566mo.CREATOR);
                    break;
                case 5:
                    str2 = C0352a.m900o(parcel, B);
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
            return new C1568mq(i, str4, latLng, str3, arrayList, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: es */
    public C1568mq[] newArray(int i) {
        return new C1568mq[i];
    }
}
