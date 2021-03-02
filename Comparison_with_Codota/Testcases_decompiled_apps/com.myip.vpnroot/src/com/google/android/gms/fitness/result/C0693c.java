package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSource;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.result.c */
public class C0693c implements Parcelable.Creator<DataSourcesResult> {
    /* renamed from: a */
    static void m2110a(DataSourcesResult dataSourcesResult, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, dataSourcesResult.getDataSources(), false);
        C0354b.m939c(parcel, 1000, dataSourcesResult.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) dataSourcesResult.getStatus(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bX */
    public DataSourcesResult createFromParcel(Parcel parcel) {
        Status status = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<DataSource> arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, DataSource.CREATOR);
                    break;
                case 2:
                    status = (Status) C0352a.m880a(parcel, B, Status.CREATOR);
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
            return new DataSourcesResult(i, arrayList, status);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dp */
    public DataSourcesResult[] newArray(int i) {
        return new DataSourcesResult[i];
    }
}
