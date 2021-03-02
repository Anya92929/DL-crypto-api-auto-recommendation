package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.i */
public class C0547i implements Parcelable.Creator<ValuesRemovedDetails> {
    /* renamed from: a */
    static void m1569a(ValuesRemovedDetails valuesRemovedDetails, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, valuesRemovedDetails.f1221BR);
        C0354b.m939c(parcel, 2, valuesRemovedDetails.mIndex);
        C0354b.m939c(parcel, 3, valuesRemovedDetails.f1224Rj);
        C0354b.m939c(parcel, 4, valuesRemovedDetails.f1225Rk);
        C0354b.m927a(parcel, 5, valuesRemovedDetails.f1222RH, false);
        C0354b.m939c(parcel, 6, valuesRemovedDetails.f1223RI);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bg */
    public ValuesRemovedDetails createFromParcel(Parcel parcel) {
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
            return new ValuesRemovedDetails(i5, i4, i3, i2, str, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ct */
    public ValuesRemovedDetails[] newArray(int i) {
        return new ValuesRemovedDetails[i];
    }
}
