package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.q */
public class C0580q implements Parcelable.Creator<ParcelableIndexReference> {
    /* renamed from: a */
    static void m1700a(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, parcelableIndexReference.f1176BR);
        C0354b.m927a(parcel, 2, parcelableIndexReference.f1177Rh, false);
        C0354b.m939c(parcel, 3, parcelableIndexReference.mIndex);
        C0354b.m930a(parcel, 4, parcelableIndexReference.f1178Ri);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aX */
    public ParcelableIndexReference createFromParcel(Parcel parcel) {
        boolean z = false;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ParcelableIndexReference(i2, str, i, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ck */
    public ParcelableIndexReference[] newArray(int i) {
        return new ParcelableIndexReference[i];
    }
}
