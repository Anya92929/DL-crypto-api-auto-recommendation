package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.im */
public class C1328im implements Parcelable.Creator<C1327il> {
    /* renamed from: a */
    static void m4994a(C1327il ilVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, ilVar.getVersionCode());
        C0354b.m917a(parcel, 2, ilVar.mo8878fF());
        C0354b.m930a(parcel, 3, ilVar.mo8879fN());
        C0354b.m939c(parcel, 4, ilVar.mo8880fO());
        C0354b.m923a(parcel, 5, (Parcelable) ilVar.getApplicationMetadata(), i, false);
        C0354b.m939c(parcel, 6, ilVar.mo8881fP());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ah */
    public C1327il[] newArray(int i) {
        return new C1327il[i];
    }

    /* renamed from: x */
    public C1327il createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    d = C0352a.m898m(parcel, B);
                    break;
                case 3:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) C0352a.m880a(parcel, B, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1327il(i3, d, z, i2, applicationMetadata, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
