package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.nm */
public class C1610nm implements Parcelable.Creator<C1609nl> {
    /* renamed from: a */
    static void m5702a(C1609nl nlVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, nlVar.versionCode);
        C0354b.m927a(parcel, 2, nlVar.packageName, false);
        C0354b.m939c(parcel, 3, nlVar.akG);
        C0354b.m939c(parcel, 4, nlVar.akH);
        C0354b.m927a(parcel, 5, nlVar.akI, false);
        C0354b.m927a(parcel, 6, nlVar.akJ, false);
        C0354b.m930a(parcel, 7, nlVar.akK);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cY */
    public C1609nl createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        boolean z = true;
        String str2 = null;
        int i2 = 0;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1609nl(i3, str3, i2, i, str2, str, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eO */
    public C1609nl[] newArray(int i) {
        return new C1609nl[i];
    }
}
