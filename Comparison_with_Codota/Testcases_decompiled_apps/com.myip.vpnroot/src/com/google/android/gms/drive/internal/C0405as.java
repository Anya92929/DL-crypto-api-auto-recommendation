package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.StorageStats;

/* renamed from: com.google.android.gms.drive.internal.as */
public class C0405as implements Parcelable.Creator<OnStorageStatsResponse> {
    /* renamed from: a */
    static void m1170a(OnStorageStatsResponse onStorageStatsResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onStorageStatsResponse.f953BR);
        C0354b.m923a(parcel, 2, (Parcelable) onStorageStatsResponse.f954Po, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: au */
    public OnStorageStatsResponse createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        StorageStats storageStats = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    storageStats = (StorageStats) C0352a.m880a(parcel, B, StorageStats.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new OnStorageStatsResponse(i, storageStats);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bG */
    public OnStorageStatsResponse[] newArray(int i) {
        return new OnStorageStatsResponse[i];
    }
}
