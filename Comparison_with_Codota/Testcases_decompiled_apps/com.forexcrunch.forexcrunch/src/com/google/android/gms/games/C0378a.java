package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.games.a */
public class C0378a implements Parcelable.Creator<GameEntity> {
    /* renamed from: a */
    static void m722a(GameEntity gameEntity, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m672a(parcel, 1, gameEntity.getApplicationId(), false);
        C0359b.m672a(parcel, 2, gameEntity.getDisplayName(), false);
        C0359b.m672a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0359b.m672a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0359b.m672a(parcel, 5, gameEntity.getDescription(), false);
        C0359b.m672a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0359b.m671a(parcel, 7, (Parcelable) gameEntity.getIconImageUri(), i, false);
        C0359b.m671a(parcel, 8, (Parcelable) gameEntity.getHiResImageUri(), i, false);
        C0359b.m671a(parcel, 9, (Parcelable) gameEntity.getFeaturedImageUri(), i, false);
        C0359b.m675a(parcel, 10, gameEntity.isPlayEnabledGame());
        C0359b.m675a(parcel, 11, gameEntity.isInstanceInstalled());
        C0359b.m672a(parcel, 12, gameEntity.getInstancePackageName(), false);
        C0359b.m682c(parcel, 13, gameEntity.getGameplayAclStatus());
        C0359b.m682c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0359b.m682c(parcel, 15, gameEntity.getLeaderboardCount());
        C0359b.m682c(parcel, 1000, gameEntity.mo4155i());
        C0359b.m663C(parcel, d);
    }

    /* renamed from: n */
    public GameEntity createFromParcel(Parcel parcel) {
        int c = C0357a.m634c(parcel);
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
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 2:
                    str2 = C0357a.m645l(parcel, b);
                    break;
                case 3:
                    str3 = C0357a.m645l(parcel, b);
                    break;
                case 4:
                    str4 = C0357a.m645l(parcel, b);
                    break;
                case 5:
                    str5 = C0357a.m645l(parcel, b);
                    break;
                case 6:
                    str6 = C0357a.m645l(parcel, b);
                    break;
                case 7:
                    uri = (Uri) C0357a.m628a(parcel, b, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) C0357a.m628a(parcel, b, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) C0357a.m628a(parcel, b, Uri.CREATOR);
                    break;
                case 10:
                    z = C0357a.m636c(parcel, b);
                    break;
                case 11:
                    z2 = C0357a.m636c(parcel, b);
                    break;
                case 12:
                    str7 = C0357a.m645l(parcel, b);
                    break;
                case 13:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 14:
                    i3 = C0357a.m639f(parcel, b);
                    break;
                case 15:
                    i4 = C0357a.m639f(parcel, b);
                    break;
                case 1000:
                    i = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: z */
    public GameEntity[] newArray(int i) {
        return new GameEntity[i];
    }
}
