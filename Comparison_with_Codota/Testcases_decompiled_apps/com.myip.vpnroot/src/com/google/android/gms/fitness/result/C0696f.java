package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.C0628q;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.result.f */
public class C0696f implements Parcelable.Creator<SessionReadResult> {
    /* renamed from: a */
    static void m2119a(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, sessionReadResult.getSessions(), false);
        C0354b.m939c(parcel, 1000, sessionReadResult.getVersionCode());
        C0354b.m940c(parcel, 2, sessionReadResult.mo6263jJ(), false);
        C0354b.m923a(parcel, 3, (Parcelable) sessionReadResult.getStatus(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ca */
    public SessionReadResult createFromParcel(Parcel parcel) {
        Status status = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<C0628q> arrayList = null;
        ArrayList<Session> arrayList2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList2 = C0352a.m887c(parcel, B, Session.CREATOR);
                    break;
                case 2:
                    arrayList = C0352a.m887c(parcel, B, C0628q.CREATOR);
                    break;
                case 3:
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
            return new SessionReadResult(i, arrayList2, arrayList, status);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ds */
    public SessionReadResult[] newArray(int i) {
        return new SessionReadResult[i];
    }
}
