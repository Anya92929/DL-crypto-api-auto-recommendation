package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.query.Query;

/* renamed from: com.google.android.gms.drive.internal.ax */
public class C0410ax implements Parcelable.Creator<QueryRequest> {
    /* renamed from: a */
    static void m1185a(QueryRequest queryRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, queryRequest.f965BR);
        C0354b.m923a(parcel, 2, (Parcelable) queryRequest.f966Pq, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ay */
    public QueryRequest createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    query = (Query) C0352a.m880a(parcel, B, Query.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new QueryRequest(i, query);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bK */
    public QueryRequest[] newArray(int i) {
        return new QueryRequest[i];
    }
}
