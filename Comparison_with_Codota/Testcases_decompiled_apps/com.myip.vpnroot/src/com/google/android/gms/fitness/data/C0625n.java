package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.data.n */
public class C0625n implements Parcelable.Creator<RawDataPoint> {
    /* renamed from: a */
    static void m1866a(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m919a(parcel, 1, rawDataPoint.f1357Sz);
        C0354b.m939c(parcel, 1000, rawDataPoint.f1352BR);
        C0354b.m919a(parcel, 2, rawDataPoint.f1353SA);
        C0354b.m933a(parcel, 3, (T[]) rawDataPoint.f1354SB, i, false);
        C0354b.m939c(parcel, 4, rawDataPoint.f1358Tb);
        C0354b.m939c(parcel, 5, rawDataPoint.f1359Tc);
        C0354b.m919a(parcel, 6, rawDataPoint.f1355SD);
        C0354b.m919a(parcel, 7, rawDataPoint.f1356SE);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bs */
    public RawDataPoint createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 2:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    valueArr = (Value[]) C0352a.m886b(parcel, B, Value.CREATOR);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    j3 = C0352a.m894i(parcel, B);
                    break;
                case 7:
                    j4 = C0352a.m894i(parcel, B);
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cJ */
    public RawDataPoint[] newArray(int i) {
        return new RawDataPoint[i];
    }
}
