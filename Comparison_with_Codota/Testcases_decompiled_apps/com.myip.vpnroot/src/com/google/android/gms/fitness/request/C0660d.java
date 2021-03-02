package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.request.d */
public class C0660d implements Parcelable.Creator<DataDeleteRequest> {
    /* renamed from: a */
    static void m2010a(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m919a(parcel, 1, dataDeleteRequest.getStartTimeMillis());
        C0354b.m939c(parcel, 1000, dataDeleteRequest.getVersionCode());
        C0354b.m919a(parcel, 2, dataDeleteRequest.getEndTimeMillis());
        C0354b.m940c(parcel, 3, dataDeleteRequest.getDataSources(), false);
        C0354b.m940c(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        C0354b.m940c(parcel, 5, dataDeleteRequest.getSessions(), false);
        C0354b.m930a(parcel, 6, dataDeleteRequest.mo5873iX());
        C0354b.m930a(parcel, 7, dataDeleteRequest.mo5874iY());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bB */
    public DataDeleteRequest createFromParcel(Parcel parcel) {
        long j = 0;
        ArrayList<Session> arrayList = null;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        boolean z2 = false;
        ArrayList<DataType> arrayList2 = null;
        ArrayList<DataSource> arrayList3 = null;
        long j2 = 0;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    arrayList3 = C0352a.m887c(parcel, B, DataSource.CREATOR);
                    break;
                case 4:
                    arrayList2 = C0352a.m887c(parcel, B, DataType.CREATOR);
                    break;
                case 5:
                    arrayList = C0352a.m887c(parcel, B, Session.CREATOR);
                    break;
                case 6:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 7:
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
            return new DataDeleteRequest(i, j2, j, arrayList3, arrayList2, arrayList, z2, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cS */
    public DataDeleteRequest[] newArray(int i) {
        return new DataDeleteRequest[i];
    }
}
