package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.Session;

/* renamed from: com.google.android.gms.fitness.request.w */
public class C0685w implements Parcelable.Creator<C0682v> {
    /* renamed from: a */
    static void m2067a(C0682v vVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) vVar.getSession(), i, false);
        C0354b.m939c(parcel, 1000, vVar.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bN */
    public C0682v createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    session = (Session) C0352a.m880a(parcel, B, Session.CREATOR);
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
            return new C0682v(i, session);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: df */
    public C0682v[] newArray(int i) {
        return new C0682v[i];
    }
}
