package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.request.r */
public class C0678r implements Parcelable.Creator<SessionInsertRequest> {
    /* renamed from: a */
    static void m2052a(SessionInsertRequest sessionInsertRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) sessionInsertRequest.getSession(), i, false);
        C0354b.m939c(parcel, 1000, sessionInsertRequest.getVersionCode());
        C0354b.m940c(parcel, 2, sessionInsertRequest.getDataSets(), false);
        C0354b.m940c(parcel, 3, sessionInsertRequest.mo5972js(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bK */
    public SessionInsertRequest createFromParcel(Parcel parcel) {
        ArrayList<DataPoint> c;
        ArrayList<DataSet> arrayList;
        Session session;
        int i;
        ArrayList<DataPoint> arrayList2 = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        ArrayList<DataSet> arrayList3 = null;
        Session session2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = i2;
                    ArrayList<DataSet> arrayList4 = arrayList3;
                    session = (Session) C0352a.m880a(parcel, B, Session.CREATOR);
                    c = arrayList2;
                    arrayList = arrayList4;
                    break;
                case 2:
                    session = session2;
                    i = i2;
                    ArrayList<DataPoint> arrayList5 = arrayList2;
                    arrayList = C0352a.m887c(parcel, B, DataSet.CREATOR);
                    c = arrayList5;
                    break;
                case 3:
                    c = C0352a.m887c(parcel, B, DataPoint.CREATOR);
                    arrayList = arrayList3;
                    session = session2;
                    i = i2;
                    break;
                case 1000:
                    ArrayList<DataPoint> arrayList6 = arrayList2;
                    arrayList = arrayList3;
                    session = session2;
                    i = C0352a.m892g(parcel, B);
                    c = arrayList6;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    c = arrayList2;
                    arrayList = arrayList3;
                    session = session2;
                    i = i2;
                    break;
            }
            i2 = i;
            session2 = session;
            arrayList3 = arrayList;
            arrayList2 = c;
        }
        if (parcel.dataPosition() == C) {
            return new SessionInsertRequest(i2, session2, arrayList3, arrayList2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dc */
    public SessionInsertRequest[] newArray(int i) {
        return new SessionInsertRequest[i];
    }
}
