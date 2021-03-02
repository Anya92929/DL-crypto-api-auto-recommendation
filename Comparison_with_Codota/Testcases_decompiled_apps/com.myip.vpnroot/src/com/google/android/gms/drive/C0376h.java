package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.h */
public class C0376h implements Parcelable.Creator<UserMetadata> {
    /* renamed from: a */
    static void m1008a(UserMetadata userMetadata, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, userMetadata.f848BR);
        C0354b.m927a(parcel, 2, userMetadata.f852Ny, false);
        C0354b.m927a(parcel, 3, userMetadata.f853Nz, false);
        C0354b.m927a(parcel, 4, userMetadata.f849NA, false);
        C0354b.m930a(parcel, 5, userMetadata.f850NB);
        C0354b.m927a(parcel, 6, userMetadata.f851NC, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: S */
    public UserMetadata createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int C = C0352a.m875C(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 6:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aZ */
    public UserMetadata[] newArray(int i) {
        return new UserMetadata[i];
    }
}
