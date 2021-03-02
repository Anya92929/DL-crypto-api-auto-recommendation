package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.data.s */
public class C0630s implements Parcelable.Creator<Subscription> {
    /* renamed from: a */
    static void m1880a(Subscription subscription, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) subscription.getDataSource(), i, false);
        C0354b.m939c(parcel, 1000, subscription.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) subscription.getDataType(), i, false);
        C0354b.m919a(parcel, 3, subscription.getSamplingRateMicros());
        C0354b.m939c(parcel, 4, subscription.mo5755iQ());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bw */
    public Subscription createFromParcel(Parcel parcel) {
        DataType dataType = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    dataSource = (DataSource) C0352a.m880a(parcel, B, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) C0352a.m880a(parcel, B, DataType.CREATOR);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new Subscription(i2, dataSource, dataType, j, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cN */
    public Subscription[] newArray(int i) {
        return new Subscription[i];
    }
}
