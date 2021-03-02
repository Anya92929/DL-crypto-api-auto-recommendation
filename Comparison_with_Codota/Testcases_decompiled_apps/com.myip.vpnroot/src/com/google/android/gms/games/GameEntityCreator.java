package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.FitnessActivities;

public class GameEntityCreator implements Parcelable.Creator<GameEntity> {
    /* renamed from: a */
    static void m2151a(GameEntity gameEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, gameEntity.getApplicationId(), false);
        C0354b.m927a(parcel, 2, gameEntity.getDisplayName(), false);
        C0354b.m927a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0354b.m927a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0354b.m927a(parcel, 5, gameEntity.getDescription(), false);
        C0354b.m927a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0354b.m923a(parcel, 7, (Parcelable) gameEntity.getIconImageUri(), i, false);
        C0354b.m923a(parcel, 8, (Parcelable) gameEntity.getHiResImageUri(), i, false);
        C0354b.m923a(parcel, 9, (Parcelable) gameEntity.getFeaturedImageUri(), i, false);
        C0354b.m930a(parcel, 10, gameEntity.mo6348jL());
        C0354b.m930a(parcel, 11, gameEntity.mo6350jN());
        C0354b.m927a(parcel, 12, gameEntity.mo6351jO(), false);
        C0354b.m939c(parcel, 13, gameEntity.mo6352jP());
        C0354b.m939c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0354b.m939c(parcel, 15, gameEntity.getLeaderboardCount());
        C0354b.m930a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C0354b.m930a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C0354b.m939c(parcel, 1000, gameEntity.getVersionCode());
        C0354b.m927a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C0354b.m927a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C0354b.m930a(parcel, 21, gameEntity.isMuted());
        C0354b.m927a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C0354b.m930a(parcel, 23, gameEntity.areSnapshotsEnabled());
        C0354b.m930a(parcel, 22, gameEntity.mo6349jM());
        C0354b.m927a(parcel, 24, gameEntity.getThemeColor(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cd */
    public GameEntity createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
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
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    str6 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 10:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 11:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 12:
                    str7 = C0352a.m900o(parcel, B);
                    break;
                case 13:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 14:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 15:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 16:
                    z3 = C0352a.m888c(parcel, B);
                    break;
                case 17:
                    z4 = C0352a.m888c(parcel, B);
                    break;
                case 18:
                    str8 = C0352a.m900o(parcel, B);
                    break;
                case 19:
                    str9 = C0352a.m900o(parcel, B);
                    break;
                case FitnessActivities.BOXING:
                    str10 = C0352a.m900o(parcel, B);
                    break;
                case 21:
                    z5 = C0352a.m888c(parcel, B);
                    break;
                case FitnessActivities.CIRCUIT_TRAINING:
                    z6 = C0352a.m888c(parcel, B);
                    break;
                case FitnessActivities.CRICKET:
                    z7 = C0352a.m888c(parcel, B);
                    break;
                case FitnessActivities.DANCING:
                    str11 = C0352a.m900o(parcel, B);
                    break;
                case 1000:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dv */
    public GameEntity[] newArray(int i) {
        return new GameEntity[i];
    }
}
