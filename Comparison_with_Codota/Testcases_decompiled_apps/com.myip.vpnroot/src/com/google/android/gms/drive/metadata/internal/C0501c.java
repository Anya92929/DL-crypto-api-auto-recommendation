package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

/* renamed from: com.google.android.gms.drive.metadata.internal.c */
public class C0501c implements Parcelable.Creator<CustomProperty> {
    /* renamed from: a */
    static void m1399a(CustomProperty customProperty, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, customProperty.f1101BR);
        C0354b.m923a(parcel, 2, (Parcelable) customProperty.f1102PB, i, false);
        C0354b.m927a(parcel, 3, customProperty.mValue, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aG */
    public CustomProperty createFromParcel(Parcel parcel) {
        String o;
        CustomPropertyKey customPropertyKey;
        int i;
        String str = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        CustomPropertyKey customPropertyKey2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    String str2 = str;
                    customPropertyKey = customPropertyKey2;
                    i = C0352a.m892g(parcel, B);
                    o = str2;
                    break;
                case 2:
                    i = i2;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) C0352a.m880a(parcel, B, CustomPropertyKey.CREATOR);
                    o = str;
                    customPropertyKey = customPropertyKey3;
                    break;
                case 3:
                    o = C0352a.m900o(parcel, B);
                    customPropertyKey = customPropertyKey2;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    o = str;
                    customPropertyKey = customPropertyKey2;
                    i = i2;
                    break;
            }
            i2 = i;
            customPropertyKey2 = customPropertyKey;
            str = o;
        }
        if (parcel.dataPosition() == C) {
            return new CustomProperty(i2, customPropertyKey2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bS */
    public CustomProperty[] newArray(int i) {
        return new CustomProperty[i];
    }
}
