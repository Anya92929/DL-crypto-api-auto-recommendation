package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.query.internal.c */
public class C0518c implements Parcelable.Creator<FieldWithSortOrder> {
    /* renamed from: a */
    static void m1492a(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, fieldWithSortOrder.f1129BR);
        C0354b.m927a(parcel, 1, fieldWithSortOrder.f1130Pt, false);
        C0354b.m930a(parcel, 2, fieldWithSortOrder.f1131QF);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aM */
    public FieldWithSortOrder createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
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
            return new FieldWithSortOrder(i, str, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bY */
    public FieldWithSortOrder[] newArray(int i) {
        return new FieldWithSortOrder[i];
    }
}
