package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.data.p */
public class C0627p implements Parcelable.Creator<Session> {
    /* renamed from: a */
    static void m1872a(Session session, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m919a(parcel, 1, session.getStartTimeMillis());
        C0354b.m939c(parcel, 1000, session.getVersionCode());
        C0354b.m919a(parcel, 2, session.getEndTimeMillis());
        C0354b.m927a(parcel, 3, session.getName(), false);
        C0354b.m927a(parcel, 4, session.getIdentifier(), false);
        C0354b.m927a(parcel, 5, session.getDescription(), false);
        C0354b.m939c(parcel, 7, session.getActivity());
        C0354b.m923a(parcel, 8, (Parcelable) session.mo5737iH(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bu */
    public Session createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        C0608a aVar = null;
        int C = C0352a.m875C(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        int i2 = 0;
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
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 8:
                    aVar = (C0608a) C0352a.m880a(parcel, B, C0608a.CREATOR);
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
            return new Session(i2, j2, j, str3, str2, str, i, aVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cL */
    public Session[] newArray(int i) {
        return new Session[i];
    }
}
