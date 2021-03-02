package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.games.a */
public class C0174a implements Parcelable.Creator<GameEntity> {
    /* renamed from: a */
    static void m397a(GameEntity gameEntity, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m349a(parcel, 1, gameEntity.getApplicationId(), false);
        C0155b.m349a(parcel, 2, gameEntity.getDisplayName(), false);
        C0155b.m349a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0155b.m349a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0155b.m349a(parcel, 5, gameEntity.getDescription(), false);
        C0155b.m349a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0155b.m348a(parcel, 7, (Parcelable) gameEntity.getIconImageUri(), i, false);
        C0155b.m348a(parcel, 8, (Parcelable) gameEntity.getHiResImageUri(), i, false);
        C0155b.m348a(parcel, 9, (Parcelable) gameEntity.getFeaturedImageUri(), i, false);
        C0155b.m352a(parcel, 10, gameEntity.isPlayEnabledGame());
        C0155b.m352a(parcel, 11, gameEntity.isInstanceInstalled());
        C0155b.m349a(parcel, 12, gameEntity.getInstancePackageName(), false);
        C0155b.m359c(parcel, 13, gameEntity.getGameplayAclStatus());
        C0155b.m359c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0155b.m359c(parcel, 15, gameEntity.getLeaderboardCount());
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, gameEntity.getVersionCode());
        C0155b.m340C(parcel, k);
    }

    /* renamed from: K */
    public GameEntity[] newArray(int i) {
        return new GameEntity[i];
    }

    /* renamed from: t */
    public GameEntity createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < j) {
            int i5 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i5)) {
                case 1:
                    str = C0153a.m322l(parcel, i5);
                    break;
                case 2:
                    str2 = C0153a.m322l(parcel, i5);
                    break;
                case 3:
                    str3 = C0153a.m322l(parcel, i5);
                    break;
                case 4:
                    str4 = C0153a.m322l(parcel, i5);
                    break;
                case 5:
                    str5 = C0153a.m322l(parcel, i5);
                    break;
                case 6:
                    str6 = C0153a.m322l(parcel, i5);
                    break;
                case 7:
                    uri = (Uri) C0153a.m305a(parcel, i5, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) C0153a.m305a(parcel, i5, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) C0153a.m305a(parcel, i5, Uri.CREATOR);
                    break;
                case 10:
                    z = C0153a.m311c(parcel, i5);
                    break;
                case 11:
                    z2 = C0153a.m311c(parcel, i5);
                    break;
                case 12:
                    str7 = C0153a.m322l(parcel, i5);
                    break;
                case 13:
                    i2 = C0153a.m314f(parcel, i5);
                    break;
                case 14:
                    i3 = C0153a.m314f(parcel, i5);
                    break;
                case 15:
                    i4 = C0153a.m314f(parcel, i5);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0153a.m314f(parcel, i5);
                    break;
                default:
                    C0153a.m308b(parcel, i5);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
