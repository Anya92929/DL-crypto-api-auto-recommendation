package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class PlayerLevelInfoCreator implements Parcelable.Creator<PlayerLevelInfo> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2183a(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m919a(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        C0354b.m939c(parcel, 1000, playerLevelInfo.getVersionCode());
        C0354b.m919a(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        C0354b.m923a(parcel, 3, (Parcelable) playerLevelInfo.getCurrentLevel(), i, false);
        C0354b.m923a(parcel, 4, (Parcelable) playerLevelInfo.getNextLevel(), i, false);
        C0354b.m915H(parcel, D);
    }

    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    playerLevel2 = (PlayerLevel) C0352a.m880a(parcel, B, PlayerLevel.CREATOR);
                    break;
                case 4:
                    playerLevel = (PlayerLevel) C0352a.m880a(parcel, B, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public PlayerLevelInfo[] newArray(int size) {
        return new PlayerLevelInfo[size];
    }
}
