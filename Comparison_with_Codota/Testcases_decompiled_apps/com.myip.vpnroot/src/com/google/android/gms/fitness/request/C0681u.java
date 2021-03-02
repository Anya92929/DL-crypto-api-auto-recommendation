package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.request.u */
public class C0681u implements Parcelable.Creator<C0680t> {
    /* renamed from: a */
    static void m2060a(C0680t tVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) tVar.mo6167jl(), i, false);
        C0354b.m939c(parcel, 1000, tVar.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bM */
    public C0680t createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
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
            return new C0680t(i, pendingIntent);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: de */
    public C0680t[] newArray(int i) {
        return new C0680t[i];
    }
}
