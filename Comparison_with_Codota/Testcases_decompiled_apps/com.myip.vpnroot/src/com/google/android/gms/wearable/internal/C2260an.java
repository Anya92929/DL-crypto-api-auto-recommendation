package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.an */
public class C2260an implements Parcelable.Creator<C2259am> {
    /* renamed from: a */
    static void m7623a(C2259am amVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, amVar.versionCode);
        C0354b.m927a(parcel, 2, amVar.packageName, false);
        C0354b.m927a(parcel, 3, amVar.label, false);
        C0354b.m919a(parcel, 4, amVar.avC);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ee */
    public C2259am createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    j = C0352a.m894i(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2259am(i, str2, str, j);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: gg */
    public C2259am[] newArray(int i) {
        return new C2259am[i];
    }
}
