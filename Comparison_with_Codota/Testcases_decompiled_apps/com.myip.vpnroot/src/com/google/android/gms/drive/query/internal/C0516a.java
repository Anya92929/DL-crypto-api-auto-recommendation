package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.a */
public class C0516a implements Parcelable.Creator<ComparisonFilter> {
    /* renamed from: a */
    static void m1486a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, comparisonFilter.f1122BR);
        C0354b.m923a(parcel, 1, (Parcelable) comparisonFilter.f1123QC, i, false);
        C0354b.m923a(parcel, 2, (Parcelable) comparisonFilter.f1124QD, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aK */
    public ComparisonFilter createFromParcel(Parcel parcel) {
        MetadataBundle metadataBundle;
        Operator operator;
        int i;
        MetadataBundle metadataBundle2 = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = i2;
                    Operator operator3 = (Operator) C0352a.m880a(parcel, B, Operator.CREATOR);
                    metadataBundle = metadataBundle2;
                    operator = operator3;
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0352a.m880a(parcel, B, MetadataBundle.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case 1000:
                    MetadataBundle metadataBundle3 = metadataBundle2;
                    operator = operator2;
                    i = C0352a.m892g(parcel, B);
                    metadataBundle = metadataBundle3;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    metadataBundle = metadataBundle2;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            metadataBundle2 = metadataBundle;
        }
        if (parcel.dataPosition() == C) {
            return new ComparisonFilter(i2, operator2, metadataBundle2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bW */
    public ComparisonFilter[] newArray(int i) {
        return new ComparisonFilter[i];
    }
}
