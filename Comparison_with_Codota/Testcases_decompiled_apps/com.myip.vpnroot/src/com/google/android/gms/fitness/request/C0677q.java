package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.request.q */
public class C0677q implements Parcelable.Creator<C0676p> {
    /* renamed from: a */
    static void m2049a(C0676p pVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m921a(parcel, 1, pVar.mo6148jq(), false);
        C0354b.m939c(parcel, 1000, pVar.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) pVar.mo6147jl(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bJ */
    public C0676p createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) C0352a.m880a(parcel, B, PendingIntent.CREATOR);
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
            return new C0676p(i, iBinder, pendingIntent);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: db */
    public C0676p[] newArray(int i) {
        return new C0676p[i];
    }
}
