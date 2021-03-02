package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSet;

/* renamed from: com.google.android.gms.fitness.request.e */
public class C0661e implements Parcelable.Creator<DataInsertRequest> {
    /* renamed from: a */
    static void m2013a(DataInsertRequest dataInsertRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) dataInsertRequest.mo5888iP(), i, false);
        C0354b.m939c(parcel, 1000, dataInsertRequest.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bC */
    public DataInsertRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        DataSet dataSet = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    dataSet = (DataSet) C0352a.m880a(parcel, B, DataSet.CREATOR);
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
            return new DataInsertRequest(i, dataSet);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cT */
    public DataInsertRequest[] newArray(int i) {
        return new DataInsertRequest[i];
    }
}
