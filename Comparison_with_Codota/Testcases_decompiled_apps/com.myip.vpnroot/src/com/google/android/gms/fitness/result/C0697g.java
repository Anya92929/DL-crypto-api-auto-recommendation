package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.result.g */
public class C0697g implements Parcelable.Creator<SessionStopResult> {
    /* renamed from: a */
    static void m2122a(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1000, sessionStopResult.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) sessionStopResult.getStatus(), i, false);
        C0354b.m940c(parcel, 3, sessionStopResult.getSessions(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cb */
    public SessionStopResult createFromParcel(Parcel parcel) {
        ArrayList<Session> c;
        Status status;
        int i;
        ArrayList<Session> arrayList = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 2:
                    i = i2;
                    Status status3 = (Status) C0352a.m880a(parcel, B, Status.CREATOR);
                    c = arrayList;
                    status = status3;
                    break;
                case 3:
                    c = C0352a.m887c(parcel, B, Session.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    ArrayList<Session> arrayList2 = arrayList;
                    status = status2;
                    i = C0352a.m892g(parcel, B);
                    c = arrayList2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    c = arrayList;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            arrayList = c;
        }
        if (parcel.dataPosition() == C) {
            return new SessionStopResult(i2, status2, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dt */
    public SessionStopResult[] newArray(int i) {
        return new SessionStopResult[i];
    }
}
