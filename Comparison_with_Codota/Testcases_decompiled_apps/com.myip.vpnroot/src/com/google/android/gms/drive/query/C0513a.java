package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.drive.query.a */
public class C0513a implements Parcelable.Creator<Query> {
    /* renamed from: a */
    static void m1459a(Query query, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, query.f1106BR);
        C0354b.m923a(parcel, 1, (Parcelable) query.f1107Qt, i, false);
        C0354b.m927a(parcel, 3, query.f1108Qu, false);
        C0354b.m923a(parcel, 4, (Parcelable) query.f1109Qv, i, false);
        C0354b.m938b(parcel, 5, query.f1110Qw, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aI */
    public Query createFromParcel(Parcel parcel) {
        ArrayList<String> arrayList = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    logicalFilter = (LogicalFilter) C0352a.m880a(parcel, B, LogicalFilter.CREATOR);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    sortOrder = (SortOrder) C0352a.m880a(parcel, B, SortOrder.CREATOR);
                    break;
                case 5:
                    arrayList = C0352a.m876C(parcel, B);
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
            return new Query(i, logicalFilter, str, sortOrder, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bU */
    public Query[] newArray(int i) {
        return new Query[i];
    }
}
