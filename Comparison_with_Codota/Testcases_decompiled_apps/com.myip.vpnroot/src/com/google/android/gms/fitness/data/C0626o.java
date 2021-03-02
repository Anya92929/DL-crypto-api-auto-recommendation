package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.data.o */
public class C0626o implements Parcelable.Creator<RawDataSet> {
    /* renamed from: a */
    static void m1869a(RawDataSet rawDataSet, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, rawDataSet.f1362Tb);
        C0354b.m939c(parcel, 1000, rawDataSet.f1360BR);
        C0354b.m939c(parcel, 2, rawDataSet.f1363Td);
        C0354b.m940c(parcel, 3, rawDataSet.f1364Te, false);
        C0354b.m930a(parcel, 4, rawDataSet.f1361Sy);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bt */
    public RawDataSet createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        ArrayList<RawDataPoint> arrayList = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    arrayList = C0352a.m887c(parcel, B, RawDataPoint.CREATOR);
                    break;
                case 4:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 1000:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new RawDataSet(i3, i2, i, arrayList, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cK */
    public RawDataSet[] newArray(int i) {
        return new RawDataSet[i];
    }
}
