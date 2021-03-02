package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.data.r */
public class C0629r implements Parcelable.Creator<C0628q> {
    /* renamed from: a */
    static void m1877a(C0628q qVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) qVar.getSession(), i, false);
        C0354b.m939c(parcel, 1000, qVar.f1400BR);
        C0354b.m923a(parcel, 2, (Parcelable) qVar.mo5847iP(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bv */
    public C0628q createFromParcel(Parcel parcel) {
        DataSet dataSet;
        Session session;
        int i;
        DataSet dataSet2 = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        Session session2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = i2;
                    Session session3 = (Session) C0352a.m880a(parcel, B, Session.CREATOR);
                    dataSet = dataSet2;
                    session = session3;
                    break;
                case 2:
                    dataSet = (DataSet) C0352a.m880a(parcel, B, DataSet.CREATOR);
                    session = session2;
                    i = i2;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet2;
                    session = session2;
                    i = C0352a.m892g(parcel, B);
                    dataSet = dataSet3;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    dataSet = dataSet2;
                    session = session2;
                    i = i2;
                    break;
            }
            i2 = i;
            session2 = session;
            dataSet2 = dataSet;
        }
        if (parcel.dataPosition() == C) {
            return new C0628q(i2, session2, dataSet2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cM */
    public C0628q[] newArray(int i) {
        return new C0628q[i];
    }
}
