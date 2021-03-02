package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.query.internal.d */
public class C0519d implements Parcelable.Creator<FilterHolder> {
    /* renamed from: a */
    static void m1495a(FilterHolder filterHolder, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) filterHolder.f1133QG, i, false);
        C0354b.m939c(parcel, 1000, filterHolder.f1132BR);
        C0354b.m923a(parcel, 2, (Parcelable) filterHolder.f1134QH, i, false);
        C0354b.m923a(parcel, 3, (Parcelable) filterHolder.f1135QI, i, false);
        C0354b.m923a(parcel, 4, (Parcelable) filterHolder.f1136QJ, i, false);
        C0354b.m923a(parcel, 5, (Parcelable) filterHolder.f1137QK, i, false);
        C0354b.m923a(parcel, 6, (Parcelable) filterHolder.f1138QL, i, false);
        C0354b.m923a(parcel, 7, (Parcelable) filterHolder.f1139QM, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aN */
    public FilterHolder createFromParcel(Parcel parcel) {
        HasFilter hasFilter = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) C0352a.m880a(parcel, B, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) C0352a.m880a(parcel, B, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) C0352a.m880a(parcel, B, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) C0352a.m880a(parcel, B, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) C0352a.m880a(parcel, B, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) C0352a.m880a(parcel, B, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) C0352a.m880a(parcel, B, HasFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bZ */
    public FilterHolder[] newArray(int i) {
        return new FilterHolder[i];
    }
}
