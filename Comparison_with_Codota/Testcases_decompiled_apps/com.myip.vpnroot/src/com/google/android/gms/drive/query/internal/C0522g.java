package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.g */
public class C0522g implements Parcelable.Creator<HasFilter> {
    /* renamed from: a */
    static void m1506a(HasFilter hasFilter, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, hasFilter.f1141BR);
        C0354b.m923a(parcel, 1, (Parcelable) hasFilter.f1142QD, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aO */
    public HasFilter createFromParcel(Parcel parcel) {
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
            return new HasFilter(i, metadataBundle);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ca */
    public HasFilter[] newArray(int i) {
        return new HasFilter[i];
    }
}
