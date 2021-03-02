package com.google.android.gms.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.signin.a */
public class C1241a implements Parcelable.Creator<GoogleSignInAccount> {
    /* renamed from: a */
    static void m5167a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, googleSignInAccount.f5252a);
        C1031c.m4616a(parcel, 2, googleSignInAccount.mo9000a(), false);
        C1031c.m4616a(parcel, 3, googleSignInAccount.mo9001b(), false);
        C1031c.m4616a(parcel, 4, googleSignInAccount.mo9002c(), false);
        C1031c.m4616a(parcel, 5, googleSignInAccount.mo9003d(), false);
        C1031c.m4614a(parcel, 6, (Parcelable) googleSignInAccount.mo9005e(), i, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public GoogleSignInAccount createFromParcel(Parcel parcel) {
        Uri uri = null;
        int b = C1029a.m4587b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    str4 = C1029a.m4599k(parcel, a);
                    break;
                case 3:
                    str3 = C1029a.m4599k(parcel, a);
                    break;
                case 4:
                    str2 = C1029a.m4599k(parcel, a);
                    break;
                case 5:
                    str = C1029a.m4599k(parcel, a);
                    break;
                case 6:
                    uri = (Uri) C1029a.m4583a(parcel, a, Uri.CREATOR);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str4, str3, str2, str, uri);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
