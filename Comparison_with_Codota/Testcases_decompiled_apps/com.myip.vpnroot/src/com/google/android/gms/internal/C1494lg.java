package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.lg */
public class C1494lg implements Parcelable.Creator<C1493lf> {
    /* renamed from: a */
    static void m5422a(C1493lf lfVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, lfVar.getDataTypes(), false);
        C0354b.m939c(parcel, 1000, lfVar.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: by */
    public C1493lf createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<DataType> arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, DataType.CREATOR);
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
            return new C1493lf(i, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cP */
    public C1493lf[] newArray(int i) {
        return new C1493lf[i];
    }
}
