package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.PlayerEntity;

public class AchievementEntityCreator implements Parcelable.Creator<AchievementEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2190a(AchievementEntity achievementEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, achievementEntity.getAchievementId(), false);
        C0354b.m939c(parcel, 2, achievementEntity.getType());
        C0354b.m927a(parcel, 3, achievementEntity.getName(), false);
        C0354b.m927a(parcel, 4, achievementEntity.getDescription(), false);
        C0354b.m923a(parcel, 5, (Parcelable) achievementEntity.getUnlockedImageUri(), i, false);
        C0354b.m927a(parcel, 6, achievementEntity.getUnlockedImageUrl(), false);
        C0354b.m923a(parcel, 7, (Parcelable) achievementEntity.getRevealedImageUri(), i, false);
        C0354b.m927a(parcel, 8, achievementEntity.getRevealedImageUrl(), false);
        C0354b.m939c(parcel, 9, achievementEntity.getTotalSteps());
        C0354b.m927a(parcel, 10, achievementEntity.getFormattedTotalSteps(), false);
        C0354b.m923a(parcel, 11, (Parcelable) achievementEntity.getPlayer(), i, false);
        C0354b.m939c(parcel, 12, achievementEntity.getState());
        C0354b.m939c(parcel, 13, achievementEntity.getCurrentSteps());
        C0354b.m927a(parcel, 14, achievementEntity.getFormattedCurrentSteps(), false);
        C0354b.m919a(parcel, 15, achievementEntity.getLastUpdatedTimestamp());
        C0354b.m919a(parcel, 16, achievementEntity.getXpValue());
        C0354b.m939c(parcel, 1000, achievementEntity.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    public AchievementEntity createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Uri uri2 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PlayerEntity playerEntity = null;
        int i4 = 0;
        int i5 = 0;
        String str7 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 6:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    uri2 = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 8:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 10:
                    str6 = C0352a.m900o(parcel, B);
                    break;
                case 11:
                    playerEntity = (PlayerEntity) C0352a.m880a(parcel, B, PlayerEntity.CREATOR);
                    break;
                case 12:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 13:
                    i5 = C0352a.m892g(parcel, B);
                    break;
                case 14:
                    str7 = C0352a.m900o(parcel, B);
                    break;
                case 15:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 16:
                    j2 = C0352a.m894i(parcel, B);
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
            return new AchievementEntity(i, str, i2, str2, str3, uri, str4, uri2, str5, i3, str6, playerEntity, i4, i5, str7, j, j2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public AchievementEntity[] newArray(int size) {
        return new AchievementEntity[size];
    }
}
