package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.fitness.request.ai */
public class C0657ai implements Parcelable.Creator<C0654ah> {
    /* renamed from: a */
    static void m2003a(C0654ah ahVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) ahVar.getDataType(), i, false);
        C0354b.m939c(parcel, 1000, ahVar.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) ahVar.getDataSource(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bU */
    public C0654ah createFromParcel(Parcel parcel) {
        DataSource dataSource;
        DataType dataType;
        int i;
        DataSource dataSource2 = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        DataType dataType2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = i2;
                    DataType dataType3 = (DataType) C0352a.m880a(parcel, B, DataType.CREATOR);
                    dataSource = dataSource2;
                    dataType = dataType3;
                    break;
                case 2:
                    dataSource = (DataSource) C0352a.m880a(parcel, B, DataSource.CREATOR);
                    dataType = dataType2;
                    i = i2;
                    break;
                case 1000:
                    DataSource dataSource3 = dataSource2;
                    dataType = dataType2;
                    i = C0352a.m892g(parcel, B);
                    dataSource = dataSource3;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    dataSource = dataSource2;
                    dataType = dataType2;
                    i = i2;
                    break;
            }
            i2 = i;
            dataType2 = dataType;
            dataSource2 = dataSource;
        }
        if (parcel.dataPosition() == C) {
            return new C0654ah(i2, dataType2, dataSource2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dm */
    public C0654ah[] newArray(int i) {
        return new C0654ah[i];
    }
}
