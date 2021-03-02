package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.ap */
public class C2262ap implements Parcelable.Creator<C2261ao> {
    /* renamed from: a */
    static void m7626a(C2261ao aoVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, aoVar.versionCode);
        C0354b.m939c(parcel, 2, aoVar.statusCode);
        C0354b.m923a(parcel, 3, (Parcelable) aoVar.avp, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ef */
    public C2261ao createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        C2309m mVar = null;
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
                    mVar = (C2309m) C0352a.m880a(parcel, B, C2309m.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2261ao(i2, i, mVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: gh */
    public C2261ao[] newArray(int i) {
        return new C2261ao[i];
    }
}
