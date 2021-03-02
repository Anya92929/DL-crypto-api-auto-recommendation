package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.ac */
public class C2233ac implements Parcelable.Creator<C2232ab> {
    /* renamed from: a */
    static void m7506a(C2232ab abVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, abVar.versionCode);
        C0354b.m939c(parcel, 2, abVar.statusCode);
        C0354b.m923a(parcel, 3, (Parcelable) abVar.avr, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: eb */
    public C2232ab createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        C2257ak akVar = null;
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
                    akVar = (C2257ak) C0352a.m880a(parcel, B, C2257ak.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2232ab(i2, i, akVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: gd */
    public C2232ab[] newArray(int i) {
        return new C2232ab[i];
    }
}
