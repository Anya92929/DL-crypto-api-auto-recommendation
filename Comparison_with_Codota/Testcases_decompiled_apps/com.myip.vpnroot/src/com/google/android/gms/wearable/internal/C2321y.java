package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.y */
public class C2321y implements Parcelable.Creator<C2320x> {
    /* renamed from: a */
    static void m7756a(C2320x xVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, xVar.versionCode);
        C0354b.m939c(parcel, 2, xVar.statusCode);
        C0354b.m923a(parcel, 3, (Parcelable) xVar.avp, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dZ */
    public C2320x createFromParcel(Parcel parcel) {
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
            return new C2320x(i2, i, mVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: gb */
    public C2320x[] newArray(int i) {
        return new C2320x[i];
    }
}
