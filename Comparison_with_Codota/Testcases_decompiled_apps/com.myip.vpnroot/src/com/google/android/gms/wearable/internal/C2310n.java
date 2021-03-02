package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.n */
public class C2310n implements Parcelable.Creator<C2309m> {
    /* renamed from: a */
    static void m7740a(C2309m mVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, mVar.f4689BR);
        C0354b.m923a(parcel, 2, (Parcelable) mVar.getUri(), i, false);
        C0354b.m920a(parcel, 4, mVar.mo12499pR(), false);
        C0354b.m931a(parcel, 5, mVar.getData(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dU */
    public C2309m createFromParcel(Parcel parcel) {
        byte[] r;
        Bundle bundle;
        Uri uri;
        int i;
        byte[] bArr = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        Bundle bundle2 = null;
        Uri uri2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    byte[] bArr2 = bArr;
                    bundle = bundle2;
                    uri = uri2;
                    i = C0352a.m892g(parcel, B);
                    r = bArr2;
                    break;
                case 2:
                    i = i2;
                    Bundle bundle3 = bundle2;
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    r = bArr;
                    bundle = bundle3;
                    break;
                case 4:
                    uri = uri2;
                    i = i2;
                    byte[] bArr3 = bArr;
                    bundle = C0352a.m902q(parcel, B);
                    r = bArr3;
                    break;
                case 5:
                    r = C0352a.m903r(parcel, B);
                    bundle = bundle2;
                    uri = uri2;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    r = bArr;
                    bundle = bundle2;
                    uri = uri2;
                    i = i2;
                    break;
            }
            i2 = i;
            uri2 = uri;
            bundle2 = bundle;
            bArr = r;
        }
        if (parcel.dataPosition() == C) {
            return new C2309m(i2, uri2, bundle2, bArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fW */
    public C2309m[] newArray(int i) {
        return new C2309m[i];
    }
}
