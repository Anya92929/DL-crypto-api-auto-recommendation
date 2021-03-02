package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.fitness.result.d */
public class C0694d implements Parcelable.Creator<DataTypeResult> {
    /* renamed from: a */
    static void m2113a(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) dataTypeResult.getStatus(), i, false);
        C0354b.m939c(parcel, 1000, dataTypeResult.getVersionCode());
        C0354b.m923a(parcel, 3, (Parcelable) dataTypeResult.getDataType(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bY */
    public DataTypeResult createFromParcel(Parcel parcel) {
        DataType dataType;
        Status status;
        int i;
        DataType dataType2 = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = i2;
                    Status status3 = (Status) C0352a.m880a(parcel, B, Status.CREATOR);
                    dataType = dataType2;
                    status = status3;
                    break;
                case 3:
                    dataType = (DataType) C0352a.m880a(parcel, B, DataType.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    DataType dataType3 = dataType2;
                    status = status2;
                    i = C0352a.m892g(parcel, B);
                    dataType = dataType3;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    dataType = dataType2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataType2 = dataType;
        }
        if (parcel.dataPosition() == C) {
            return new DataTypeResult(i2, status2, dataType2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dq */
    public DataTypeResult[] newArray(int i) {
        return new DataTypeResult[i];
    }
}
