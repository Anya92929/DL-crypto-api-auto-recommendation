package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.c */
public class C0364c implements Parcelable.Creator<DriveId> {
    /* renamed from: a */
    static void m975a(DriveId driveId, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, driveId.f814BR);
        C0354b.m927a(parcel, 2, driveId.f815Na, false);
        C0354b.m919a(parcel, 3, driveId.f816Nb);
        C0354b.m919a(parcel, 4, driveId.f817Nc);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: O */
    public DriveId createFromParcel(Parcel parcel) {
        long j = 0;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    j = C0352a.m894i(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new DriveId(i, str, j2, j);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aT */
    public DriveId[] newArray(int i) {
        return new DriveId[i];
    }
}
