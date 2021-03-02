package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.realtime.internal.p */
public class C0579p implements Parcelable.Creator<ParcelableCollaborator> {
    /* renamed from: a */
    static void m1697a(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, parcelableCollaborator.f1168BR);
        C0354b.m930a(parcel, 2, parcelableCollaborator.f1170Rc);
        C0354b.m930a(parcel, 3, parcelableCollaborator.f1171Rd);
        C0354b.m927a(parcel, 4, parcelableCollaborator.f1175vL, false);
        C0354b.m927a(parcel, 5, parcelableCollaborator.f1172Re, false);
        C0354b.m927a(parcel, 6, parcelableCollaborator.f1169Nz, false);
        C0354b.m927a(parcel, 7, parcelableCollaborator.f1173Rf, false);
        C0354b.m927a(parcel, 8, parcelableCollaborator.f1174Rg, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aW */
    public ParcelableCollaborator createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int C = C0352a.m875C(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 3:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 4:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cj */
    public ParcelableCollaborator[] newArray(int i) {
        return new ParcelableCollaborator[i];
    }
}
