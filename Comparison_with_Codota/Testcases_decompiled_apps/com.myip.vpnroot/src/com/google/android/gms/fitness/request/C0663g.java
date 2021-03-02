package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.request.g */
public class C0663g implements Parcelable.Creator<DataSourcesRequest> {
    /* renamed from: a */
    static void m2019a(DataSourcesRequest dataSourcesRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, dataSourcesRequest.getDataTypes(), false);
        C0354b.m939c(parcel, 1000, dataSourcesRequest.getVersionCode());
        C0354b.m928a(parcel, 2, dataSourcesRequest.mo5930jj(), false);
        C0354b.m930a(parcel, 3, dataSourcesRequest.mo5929ji());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bE */
    public DataSourcesRequest createFromParcel(Parcel parcel) {
        ArrayList<Integer> arrayList = null;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        ArrayList<DataType> arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList2 = C0352a.m887c(parcel, B, DataType.CREATOR);
                    break;
                case 2:
                    arrayList = C0352a.m874B(parcel, B);
                    break;
                case 3:
                    z = C0352a.m888c(parcel, B);
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
            return new DataSourcesRequest(i, arrayList2, arrayList, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cV */
    public DataSourcesRequest[] newArray(int i) {
        return new DataSourcesRequest[i];
    }
}
