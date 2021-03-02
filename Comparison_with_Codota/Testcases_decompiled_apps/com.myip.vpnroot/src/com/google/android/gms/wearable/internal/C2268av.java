package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wearable.internal.av */
public class C2268av implements Parcelable.Creator<C2267au> {
    /* renamed from: a */
    static void m7636a(C2267au auVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, auVar.versionCode);
        C0354b.m939c(parcel, 2, auVar.statusCode);
        C0354b.m919a(parcel, 3, auVar.avC);
        C0354b.m940c(parcel, 4, auVar.avE, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ei */
    public C2267au createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        long j = 0;
        ArrayList<C2259am> arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    arrayList = C0352a.m887c(parcel, B, C2259am.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2267au(i2, i, j, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: gk */
    public C2267au[] newArray(int i) {
        return new C2267au[i];
    }
}
