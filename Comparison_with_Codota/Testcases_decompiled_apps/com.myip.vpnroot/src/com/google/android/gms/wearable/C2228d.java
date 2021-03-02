package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.d */
public class C2228d implements Parcelable.Creator<C2227c> {
    /* renamed from: a */
    static void m7484a(C2227c cVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, cVar.f4659BR);
        C0354b.m927a(parcel, 2, cVar.getName(), false);
        C0354b.m927a(parcel, 3, cVar.getAddress(), false);
        C0354b.m939c(parcel, 4, cVar.getType());
        C0354b.m939c(parcel, 5, cVar.getRole());
        C0354b.m930a(parcel, 6, cVar.isEnabled());
        C0354b.m930a(parcel, 7, cVar.isConnected());
        C0354b.m927a(parcel, 8, cVar.mo12311pQ(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dQ */
    public C2227c createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        String str2 = null;
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
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 7:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 8:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2227c(i3, str3, str2, i2, i, z2, z, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fS */
    public C2227c[] newArray(int i) {
        return new C2227c[i];
    }
}
