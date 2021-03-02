package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.b */
public class C0692b implements Parcelable.Creator<DataReadResult> {
    /* renamed from: a */
    static void m2107a(DataReadResult dataReadResult, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m941d(parcel, 1, dataReadResult.mo6229jH(), false);
        C0354b.m939c(parcel, 1000, dataReadResult.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) dataReadResult.getStatus(), i, false);
        C0354b.m941d(parcel, 3, dataReadResult.mo6228jG(), false);
        C0354b.m939c(parcel, 5, dataReadResult.mo6227jF());
        C0354b.m940c(parcel, 6, dataReadResult.mo6226iG(), false);
        C0354b.m940c(parcel, 7, dataReadResult.mo6230jI(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bW */
    public DataReadResult createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList<DataType> arrayList = null;
        int C = C0352a.m875C(parcel);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<DataSource> arrayList4 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    C0352a.m883a(parcel, B, (List) arrayList2, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) C0352a.m880a(parcel, B, Status.CREATOR);
                    break;
                case 3:
                    C0352a.m883a(parcel, B, (List) arrayList3, getClass().getClassLoader());
                    break;
                case 5:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    arrayList4 = C0352a.m887c(parcel, B, DataSource.CREATOR);
                    break;
                case 7:
                    arrayList = C0352a.m887c(parcel, B, DataType.CREATOR);
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
            return new DataReadResult(i2, arrayList2, status, arrayList3, i, arrayList4, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: do */
    public DataReadResult[] newArray(int i) {
        return new DataReadResult[i];
    }
}
