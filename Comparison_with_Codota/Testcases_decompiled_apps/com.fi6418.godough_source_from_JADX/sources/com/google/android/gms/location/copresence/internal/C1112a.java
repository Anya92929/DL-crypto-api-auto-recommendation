package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.location.copresence.internal.a */
public class C1112a implements Parcelable.Creator<CopresenceApiOptions> {
    /* renamed from: a */
    static void m4831a(CopresenceApiOptions copresenceApiOptions, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, copresenceApiOptions.f4924b);
        C1031c.m4619a(parcel, 2, copresenceApiOptions.f4925c);
        C1031c.m4616a(parcel, 3, copresenceApiOptions.f4926d, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public CopresenceApiOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = C1029a.m4587b(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    z = C1029a.m4591c(parcel, a);
                    break;
                case 3:
                    str = C1029a.m4599k(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CopresenceApiOptions(i, z, str);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public CopresenceApiOptions[] newArray(int i) {
        return new CopresenceApiOptions[i];
    }
}
