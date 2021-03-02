package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.i */
public class C0524i implements Parcelable.Creator<LogicalFilter> {
    /* renamed from: a */
    static void m1512a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, logicalFilter.f1147BR);
        C0354b.m923a(parcel, 1, (Parcelable) logicalFilter.f1148QC, i, false);
        C0354b.m940c(parcel, 2, logicalFilter.f1149QP, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aQ */
    public LogicalFilter createFromParcel(Parcel parcel) {
        ArrayList<FilterHolder> c;
        Operator operator;
        int i;
        ArrayList<FilterHolder> arrayList = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = i2;
                    Operator operator3 = (Operator) C0352a.m880a(parcel, B, Operator.CREATOR);
                    c = arrayList;
                    operator = operator3;
                    break;
                case 2:
                    c = C0352a.m887c(parcel, B, FilterHolder.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case 1000:
                    ArrayList<FilterHolder> arrayList2 = arrayList;
                    operator = operator2;
                    i = C0352a.m892g(parcel, B);
                    c = arrayList2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    c = arrayList;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            arrayList = c;
        }
        if (parcel.dataPosition() == C) {
            return new LogicalFilter(i2, operator2, (List<FilterHolder>) arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cc */
    public LogicalFilter[] newArray(int i) {
        return new LogicalFilter[i];
    }
}
