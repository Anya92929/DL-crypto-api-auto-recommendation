package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.d */
public class C0542d implements Parcelable.Creator<ReferenceShiftedDetails> {
    /* renamed from: a */
    static void m1554a(ReferenceShiftedDetails referenceShiftedDetails, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, referenceShiftedDetails.f1205BR);
        C0354b.m927a(parcel, 2, referenceShiftedDetails.f1209Rz, false);
        C0354b.m927a(parcel, 3, referenceShiftedDetails.f1206RA, false);
        C0354b.m939c(parcel, 4, referenceShiftedDetails.f1207RB);
        C0354b.m939c(parcel, 5, referenceShiftedDetails.f1208RC);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bb */
    public ReferenceShiftedDetails createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ReferenceShiftedDetails(i3, str2, str, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: co */
    public ReferenceShiftedDetails[] newArray(int i) {
        return new ReferenceShiftedDetails[i];
    }
}
