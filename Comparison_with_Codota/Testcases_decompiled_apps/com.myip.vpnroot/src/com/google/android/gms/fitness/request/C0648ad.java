package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.fitness.request.ad */
public class C0648ad implements Parcelable.Creator<C0647ac> {
    /* renamed from: a */
    static void m1982a(C0647ac acVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m921a(parcel, 1, acVar.mo6035jz(), false);
        C0354b.m939c(parcel, 1000, acVar.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bR */
    public C0647ac createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    iBinder = C0352a.m901p(parcel, B);
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
            return new C0647ac(i, iBinder);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dj */
    public C0647ac[] newArray(int i) {
        return new C0647ac[i];
    }
}
