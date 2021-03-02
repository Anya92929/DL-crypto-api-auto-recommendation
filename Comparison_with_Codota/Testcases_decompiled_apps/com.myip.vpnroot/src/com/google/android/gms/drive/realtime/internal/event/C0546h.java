package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.h */
public class C0546h implements Parcelable.Creator<ValuesAddedDetails> {
    /* renamed from: a */
    static void m1566a(ValuesAddedDetails valuesAddedDetails, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, valuesAddedDetails.f1216BR);
        C0354b.m939c(parcel, 2, valuesAddedDetails.mIndex);
        C0354b.m939c(parcel, 3, valuesAddedDetails.f1219Rj);
        C0354b.m939c(parcel, 4, valuesAddedDetails.f1220Rk);
        C0354b.m927a(parcel, 5, valuesAddedDetails.f1217RF, false);
        C0354b.m939c(parcel, 6, valuesAddedDetails.f1218RG);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bf */
    public ValuesAddedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i5 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ValuesAddedDetails(i5, i4, i3, i2, str, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cs */
    public ValuesAddedDetails[] newArray(int i) {
        return new ValuesAddedDetails[i];
    }
}