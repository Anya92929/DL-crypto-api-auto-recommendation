package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.aa */
public class C2231aa implements Parcelable.Creator<C2322z> {
    /* renamed from: a */
    static void m7503a(C2322z zVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, zVar.versionCode);
        C0354b.m939c(parcel, 2, zVar.statusCode);
        C0354b.m923a(parcel, 3, (Parcelable) zVar.avq, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ea */
    public C2322z createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                    parcelFileDescriptor = (ParcelFileDescriptor) C0352a.m880a(parcel, B, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2322z(i2, i, parcelFileDescriptor);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: gc */
    public C2322z[] newArray(int i) {
        return new C2322z[i];
    }
}
