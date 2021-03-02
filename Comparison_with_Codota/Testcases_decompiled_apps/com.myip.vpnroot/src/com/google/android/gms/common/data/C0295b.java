package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.common.data.b */
public class C0295b implements Parcelable.Creator<C0294a> {
    /* renamed from: a */
    static void m617a(C0294a aVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, aVar.f685BR);
        C0354b.m923a(parcel, 2, (Parcelable) aVar.f687JK, i, false);
        C0354b.m939c(parcel, 3, aVar.f686FD);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ao */
    public C0294a[] newArray(int i) {
        return new C0294a[i];
    }

    /* renamed from: y */
    public C0294a createFromParcel(Parcel parcel) {
        int g;
        ParcelFileDescriptor parcelFileDescriptor;
        int i;
        int i2 = 0;
        int C = C0352a.m875C(parcel);
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    int i4 = i2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = C0352a.m892g(parcel, B);
                    g = i4;
                    break;
                case 2:
                    i = i3;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) C0352a.m880a(parcel, B, ParcelFileDescriptor.CREATOR);
                    g = i2;
                    parcelFileDescriptor = parcelFileDescriptor3;
                    break;
                case 3:
                    g = C0352a.m892g(parcel, B);
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = i3;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    g = i2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    i = i3;
                    break;
            }
            i3 = i;
            parcelFileDescriptor2 = parcelFileDescriptor;
            i2 = g;
        }
        if (parcel.dataPosition() == C) {
            return new C0294a(i3, parcelFileDescriptor2, i2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
