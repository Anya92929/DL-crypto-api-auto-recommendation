package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.az */
public class C0928az implements Parcelable.Creator<C0927ay> {
    /* renamed from: a */
    static void m3917a(C0927ay ayVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, ayVar.versionCode);
        C0354b.m927a(parcel, 2, ayVar.f2622of, false);
        C0354b.m939c(parcel, 3, ayVar.height);
        C0354b.m939c(parcel, 4, ayVar.heightPixels);
        C0354b.m930a(parcel, 5, ayVar.f2623og);
        C0354b.m939c(parcel, 6, ayVar.width);
        C0354b.m939c(parcel, 7, ayVar.widthPixels);
        C0354b.m933a(parcel, 8, (T[]) ayVar.f2624oh, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: c */
    public C0927ay createFromParcel(Parcel parcel) {
        C0927ay[] ayVarArr = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i5 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 6:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 7:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 8:
                    ayVarArr = (C0927ay[]) C0352a.m886b(parcel, B, C0927ay.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C0927ay(i5, str, i4, i3, z, i2, i, ayVarArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: f */
    public C0927ay[] newArray(int i) {
        return new C0927ay[i];
    }
}
