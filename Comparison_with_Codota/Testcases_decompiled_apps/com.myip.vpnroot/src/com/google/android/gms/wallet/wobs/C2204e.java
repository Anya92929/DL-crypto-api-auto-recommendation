package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1382jr;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.e */
public class C2204e implements Parcelable.Creator<C2203d> {
    /* renamed from: a */
    static void m7429a(C2203d dVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, dVar.getVersionCode());
        C0354b.m927a(parcel, 2, dVar.auo, false);
        C0354b.m927a(parcel, 3, dVar.aup, false);
        C0354b.m940c(parcel, 4, dVar.auq, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dI */
    public C2203d createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<C2201b> hz = C1382jr.m5209hz();
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
                    hz = C0352a.m887c(parcel, B, C2201b.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2203d(i, str2, str, hz);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fK */
    public C2203d[] newArray(int i) {
        return new C2203d[i];
    }
}
