package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.query.internal.k */
public class C0526k implements Parcelable.Creator<NotFilter> {
    /* renamed from: a */
    static void m1518a(NotFilter notFilter, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, notFilter.f1152BR);
        C0354b.m923a(parcel, 1, (Parcelable) notFilter.f1153QQ, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aS */
    public NotFilter createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    filterHolder = (FilterHolder) C0352a.m880a(parcel, B, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ce */
    public NotFilter[] newArray(int i) {
        return new NotFilter[i];
    }
}
