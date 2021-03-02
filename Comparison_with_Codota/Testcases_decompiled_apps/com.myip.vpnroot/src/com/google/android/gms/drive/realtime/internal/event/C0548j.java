package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.j */
public class C0548j implements Parcelable.Creator<ValuesSetDetails> {
    /* renamed from: a */
    static void m1572a(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, valuesSetDetails.f1226BR);
        C0354b.m939c(parcel, 2, valuesSetDetails.mIndex);
        C0354b.m939c(parcel, 3, valuesSetDetails.f1227Rj);
        C0354b.m939c(parcel, 4, valuesSetDetails.f1228Rk);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bh */
    public ValuesSetDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ValuesSetDetails(i4, i3, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cu */
    public ValuesSetDetails[] newArray(int i) {
        return new ValuesSetDetails[i];
    }
}
