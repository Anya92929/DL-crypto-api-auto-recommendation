package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.games.c */
public class C0177c implements Parcelable.Creator<PlayerEntity> {
    /* renamed from: a */
    static void m400a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m349a(parcel, 1, playerEntity.getPlayerId(), false);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, playerEntity.getVersionCode());
        C0155b.m349a(parcel, 2, playerEntity.getDisplayName(), false);
        C0155b.m348a(parcel, 3, (Parcelable) playerEntity.getIconImageUri(), i, false);
        C0155b.m348a(parcel, 4, (Parcelable) playerEntity.getHiResImageUri(), i, false);
        C0155b.m344a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0155b.m340C(parcel, k);
    }

    /* renamed from: L */
    public PlayerEntity[] newArray(int i) {
        return new PlayerEntity[i];
    }

    /* renamed from: u */
    public PlayerEntity createFromParcel(Parcel parcel) {
        Uri uri = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        long j2 = 0;
        Uri uri2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i2);
                    break;
                case 3:
                    uri2 = (Uri) C0153a.m305a(parcel, i2, Uri.CREATOR);
                    break;
                case 4:
                    uri = (Uri) C0153a.m305a(parcel, i2, Uri.CREATOR);
                    break;
                case 5:
                    j2 = C0153a.m315g(parcel, i2);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0153a.m314f(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new PlayerEntity(i, str2, str, uri2, uri, j2);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
