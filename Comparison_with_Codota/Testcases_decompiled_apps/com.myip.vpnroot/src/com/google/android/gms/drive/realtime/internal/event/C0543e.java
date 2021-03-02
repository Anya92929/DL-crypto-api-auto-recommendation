package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.e */
public class C0543e implements Parcelable.Creator<TextDeletedDetails> {
    /* renamed from: a */
    static void m1557a(TextDeletedDetails textDeletedDetails, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, textDeletedDetails.f1210BR);
        C0354b.m939c(parcel, 2, textDeletedDetails.mIndex);
        C0354b.m939c(parcel, 3, textDeletedDetails.f1211RD);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bc */
    public TextDeletedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new TextDeletedDetails(i3, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cp */
    public TextDeletedDetails[] newArray(int i) {
        return new TextDeletedDetails[i];
    }
}
