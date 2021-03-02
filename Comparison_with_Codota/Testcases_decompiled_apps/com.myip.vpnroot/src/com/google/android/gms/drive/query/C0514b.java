package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.b */
public class C0514b implements Parcelable.Creator<SortOrder> {
    /* renamed from: a */
    static void m1462a(SortOrder sortOrder, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, sortOrder.f1117BR);
        C0354b.m940c(parcel, 1, sortOrder.f1118QA, false);
        C0354b.m930a(parcel, 2, sortOrder.f1119QB);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aJ */
    public SortOrder createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, FieldWithSortOrder.CREATOR);
                    break;
                case 2:
                    z = C0352a.m888c(parcel, B);
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
            return new SortOrder(i, (List<FieldWithSortOrder>) arrayList, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bV */
    public SortOrder[] newArray(int i) {
        return new SortOrder[i];
    }
}
