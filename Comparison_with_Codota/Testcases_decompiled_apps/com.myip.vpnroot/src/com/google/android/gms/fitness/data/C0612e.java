package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.data.e */
public class C0612e implements Parcelable.Creator<DataPoint> {
    /* renamed from: a */
    static void m1840a(DataPoint dataPoint, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) dataPoint.getDataSource(), i, false);
        C0354b.m939c(parcel, 1000, dataPoint.getVersionCode());
        C0354b.m919a(parcel, 3, dataPoint.getTimestampNanos());
        C0354b.m919a(parcel, 4, dataPoint.getStartTimeNanos());
        C0354b.m933a(parcel, 5, (T[]) dataPoint.mo5624iC(), i, false);
        C0354b.m923a(parcel, 6, (Parcelable) dataPoint.getOriginalDataSource(), i, false);
        C0354b.m919a(parcel, 7, dataPoint.mo5625iD());
        C0354b.m919a(parcel, 8, dataPoint.mo5626iE());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bl */
    public DataPoint createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    dataSource = (DataSource) C0352a.m880a(parcel, B, DataSource.CREATOR);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 5:
                    valueArr = (Value[]) C0352a.m886b(parcel, B, Value.CREATOR);
                    break;
                case 6:
                    dataSource2 = (DataSource) C0352a.m880a(parcel, B, DataSource.CREATOR);
                    break;
                case 7:
                    j3 = C0352a.m894i(parcel, B);
                    break;
                case 8:
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
            return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cC */
    public DataPoint[] newArray(int i) {
        return new DataPoint[i];
    }
}
