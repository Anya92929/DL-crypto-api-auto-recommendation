package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Parcelable.Creator<PlayerEntity> {
    /* renamed from: a */
    static void m2179a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, playerEntity.getPlayerId(), false);
        C0354b.m927a(parcel, 2, playerEntity.getDisplayName(), false);
        C0354b.m923a(parcel, 3, (Parcelable) playerEntity.getIconImageUri(), i, false);
        C0354b.m923a(parcel, 4, (Parcelable) playerEntity.getHiResImageUri(), i, false);
        C0354b.m919a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0354b.m939c(parcel, 6, playerEntity.mo6394jR());
        C0354b.m919a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C0354b.m927a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C0354b.m927a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C0354b.m927a(parcel, 14, playerEntity.getTitle(), false);
        C0354b.m923a(parcel, 15, (Parcelable) playerEntity.mo6395jS(), i, false);
        C0354b.m923a(parcel, 16, (Parcelable) playerEntity.getLevelInfo(), i, false);
        C0354b.m939c(parcel, 1000, playerEntity.getVersionCode());
        C0354b.m930a(parcel, 18, playerEntity.isProfileVisible());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ce */
    public PlayerEntity createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
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
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 5:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 6:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 7:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 8:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 14:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) C0352a.m880a(parcel, B, MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) C0352a.m880a(parcel, B, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = C0352a.m888c(parcel, B);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dw */
    public PlayerEntity[] newArray(int i) {
        return new PlayerEntity[i];
    }
}
