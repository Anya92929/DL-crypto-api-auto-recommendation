package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.h */
public class C0523h implements Parcelable.Creator<InFilter> {
    /* renamed from: a */
    static void m1509a(InFilter inFilter, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, inFilter.f1144BR);
        C0354b.m923a(parcel, 1, (Parcelable) inFilter.f1145QD, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aP */
    public InFilter createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    metadataBundle = (MetadataBundle) C0352a.m880a(parcel, B, MetadataBundle.CREATOR);
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
            return new InFilter(i, metadataBundle);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cb */
    public InFilter[] newArray(int i) {
        return new InFilter[i];
    }
}
