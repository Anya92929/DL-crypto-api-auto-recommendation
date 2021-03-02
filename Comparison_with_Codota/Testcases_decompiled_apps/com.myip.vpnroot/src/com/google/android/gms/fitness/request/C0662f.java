package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.request.f */
public class C0662f implements Parcelable.Creator<DataReadRequest> {
    /* renamed from: a */
    static void m2016a(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, dataReadRequest.getDataTypes(), false);
        C0354b.m939c(parcel, 1000, dataReadRequest.getVersionCode());
        C0354b.m940c(parcel, 2, dataReadRequest.getDataSources(), false);
        C0354b.m919a(parcel, 3, dataReadRequest.getStartTimeMillis());
        C0354b.m919a(parcel, 4, dataReadRequest.getEndTimeMillis());
        C0354b.m940c(parcel, 5, dataReadRequest.mo5902ja(), false);
        C0354b.m940c(parcel, 6, dataReadRequest.mo5903jb(), false);
        C0354b.m939c(parcel, 7, dataReadRequest.getBucketType());
        C0354b.m919a(parcel, 8, dataReadRequest.mo5904jc());
        C0354b.m923a(parcel, 9, (Parcelable) dataReadRequest.mo5905jd(), i, false);
        C0354b.m939c(parcel, 10, dataReadRequest.mo5906je());
        C0354b.m930a(parcel, 11, dataReadRequest.mo5907jf());
        C0354b.m930a(parcel, 12, dataReadRequest.mo5909jh());
        C0354b.m930a(parcel, 13, dataReadRequest.mo5908jg());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bD */
    public DataReadRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<DataType> arrayList = null;
        ArrayList<DataSource> arrayList2 = null;
        long j = 0;
        long j2 = 0;
        ArrayList<DataType> arrayList3 = null;
        ArrayList<DataSource> arrayList4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, DataType.CREATOR);
                    break;
                case 2:
                    arrayList2 = C0352a.m887c(parcel, B, DataSource.CREATOR);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 5:
                    arrayList3 = C0352a.m887c(parcel, B, DataType.CREATOR);
                    break;
                case 6:
                    arrayList4 = C0352a.m887c(parcel, B, DataSource.CREATOR);
                    break;
                case 7:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 8:
                    j3 = C0352a.m894i(parcel, B);
                    break;
                case 9:
                    dataSource = (DataSource) C0352a.m880a(parcel, B, DataSource.CREATOR);
                    break;
                case 10:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 11:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 12:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 13:
                    z3 = C0352a.m888c(parcel, B);
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
            return new DataReadRequest(i, arrayList, arrayList2, j, j2, arrayList3, arrayList4, i2, j3, dataSource, i3, z, z2, z3);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cU */
    public DataReadRequest[] newArray(int i) {
        return new DataReadRequest[i];
    }
}
