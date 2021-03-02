package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.a */
public class C0539a implements Parcelable.Creator<ObjectChangedDetails> {
    /* renamed from: a */
    static void m1545a(ObjectChangedDetails objectChangedDetails, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, objectChangedDetails.f1182BR);
        C0354b.m939c(parcel, 2, objectChangedDetails.f1183Rj);
        C0354b.m939c(parcel, 3, objectChangedDetails.f1184Rk);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aY */
    public ObjectChangedDetails createFromParcel(Parcel parcel) {
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
            return new ObjectChangedDetails(i3, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cl */
    public ObjectChangedDetails[] newArray(int i) {
        return new ObjectChangedDetails[i];
    }
}
