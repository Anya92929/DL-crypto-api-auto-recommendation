package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.g */
public class C0375g implements Parcelable.Creator<StorageStats> {
    /* renamed from: a */
    static void m1005a(StorageStats storageStats, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, storageStats.f842BR);
        C0354b.m919a(parcel, 2, storageStats.f843Nt);
        C0354b.m919a(parcel, 3, storageStats.f844Nu);
        C0354b.m919a(parcel, 4, storageStats.f845Nv);
        C0354b.m919a(parcel, 5, storageStats.f846Nw);
        C0354b.m939c(parcel, 6, storageStats.f847Nx);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: R */
    public StorageStats createFromParcel(Parcel parcel) {
        int i = 0;
        long j = 0;
        int C = C0352a.m875C(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    j4 = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    j3 = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 5:
                    j = C0352a.m894i(parcel, B);
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
            return new StorageStats(i2, j4, j3, j2, j, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aY */
    public StorageStats[] newArray(int i) {
        return new StorageStats[i];
    }
}
