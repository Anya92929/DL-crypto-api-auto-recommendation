package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wearable.internal.w */
public class C2319w implements Parcelable.Creator<C2318v> {
    /* renamed from: a */
    static void m7753a(C2318v vVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, vVar.versionCode);
        C0354b.m939c(parcel, 2, vVar.statusCode);
        C0354b.m940c(parcel, 3, vVar.avo, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dY */
    public C2318v createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        ArrayList<C2257ak> arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    arrayList = C0352a.m887c(parcel, B, C2257ak.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2318v(i2, i, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ga */
    public C2318v[] newArray(int i) {
        return new C2318v[i];
    }
}
