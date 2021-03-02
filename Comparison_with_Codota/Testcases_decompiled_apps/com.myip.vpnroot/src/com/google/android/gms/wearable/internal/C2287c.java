package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.c */
public class C2287c implements Parcelable.Creator<C2286b> {
    /* renamed from: a */
    static void m7688a(C2286b bVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, bVar.f4681BR);
        C0354b.m921a(parcel, 2, bVar.mo12461pT(), false);
        C0354b.m933a(parcel, 3, (T[]) bVar.ava, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dS */
    public C2286b createFromParcel(Parcel parcel) {
        IntentFilter[] intentFilterArr = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) C0352a.m886b(parcel, B, IntentFilter.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2286b(i, iBinder, intentFilterArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fU */
    public C2286b[] newArray(int i) {
        return new C2286b[i];
    }
}
