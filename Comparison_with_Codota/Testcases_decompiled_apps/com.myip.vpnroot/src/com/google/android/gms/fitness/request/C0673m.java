package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.fitness.request.m */
public class C0673m implements Parcelable.Creator<C0670l> {
    /* renamed from: a */
    static void m2033a(C0670l lVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) lVar.getDataType(), i, false);
        C0354b.m939c(parcel, 1000, lVar.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bH */
    public C0670l createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        DataType dataType = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    dataType = (DataType) C0352a.m880a(parcel, B, DataType.CREATOR);
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
            return new C0670l(i, dataType);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cY */
    public C0670l[] newArray(int i) {
        return new C0670l[i];
    }
}
