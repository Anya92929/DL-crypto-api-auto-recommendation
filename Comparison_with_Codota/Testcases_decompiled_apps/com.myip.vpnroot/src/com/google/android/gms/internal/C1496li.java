package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSource;

/* renamed from: com.google.android.gms.internal.li */
public class C1496li implements Parcelable.Creator<C1495lh> {
    /* renamed from: a */
    static void m5425a(C1495lh lhVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) lhVar.getDataSource(), i, false);
        C0354b.m939c(parcel, 1000, lhVar.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bz */
    public C1495lh createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    dataSource = (DataSource) C0352a.m880a(parcel, B, DataSource.CREATOR);
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
            return new C1495lh(i, dataSource);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cQ */
    public C1495lh[] newArray(int i) {
        return new C1495lh[i];
    }
}
