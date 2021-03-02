package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.metadata.c */
public class C0495c implements Parcelable.Creator<CustomPropertyKey> {
    /* renamed from: a */
    static void m1380a(CustomPropertyKey customPropertyKey, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, customPropertyKey.f1091BR);
        C0354b.m927a(parcel, 2, customPropertyKey.f1092JH, false);
        C0354b.m939c(parcel, 3, customPropertyKey.mVisibility);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aE */
    public CustomPropertyKey createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        String str = null;
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
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CustomPropertyKey(i2, str, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bQ */
    public CustomPropertyKey[] newArray(int i) {
        return new CustomPropertyKey[i];
    }
}
