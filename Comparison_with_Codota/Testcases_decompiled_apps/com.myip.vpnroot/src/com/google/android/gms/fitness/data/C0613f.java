package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.f */
public class C0613f implements Parcelable.Creator<DataSet> {
    /* renamed from: a */
    static void m1843a(DataSet dataSet, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) dataSet.getDataSource(), i, false);
        C0354b.m939c(parcel, 1000, dataSet.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) dataSet.getDataType(), i, false);
        C0354b.m941d(parcel, 3, dataSet.mo5649iF(), false);
        C0354b.m940c(parcel, 4, dataSet.mo5650iG(), false);
        C0354b.m930a(parcel, 5, dataSet.mo5648iB());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bm */
    public DataSet createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList<DataSource> arrayList = null;
        int C = C0352a.m875C(parcel);
        ArrayList arrayList2 = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
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
                    C0352a.m883a(parcel, B, (List) arrayList2, getClass().getClassLoader());
                    break;
                case 4:
                    arrayList = C0352a.m887c(parcel, B, DataSource.CREATOR);
                    break;
                case 5:
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
            return new DataSet(i, dataSource, dataType, arrayList2, arrayList, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cD */
    public DataSet[] newArray(int i) {
        return new DataSet[i];
    }
}
