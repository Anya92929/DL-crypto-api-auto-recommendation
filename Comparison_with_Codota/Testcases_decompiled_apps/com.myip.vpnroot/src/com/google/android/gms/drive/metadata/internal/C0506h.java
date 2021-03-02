package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.metadata.internal.h */
public class C0506h implements Parcelable.Creator<MetadataBundle> {
    /* renamed from: a */
    static void m1423a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, metadataBundle.f1103BR);
        C0354b.m920a(parcel, 2, metadataBundle.f1104PD, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aH */
    public MetadataBundle createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new MetadataBundle(i, bundle);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bT */
    public MetadataBundle[] newArray(int i) {
        return new MetadataBundle[i];
    }
}
