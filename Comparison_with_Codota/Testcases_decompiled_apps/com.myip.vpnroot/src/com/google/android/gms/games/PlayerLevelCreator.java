package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class PlayerLevelCreator implements Parcelable.Creator<PlayerLevel> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2182a(PlayerLevel playerLevel, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, playerLevel.getLevelNumber());
        C0354b.m939c(parcel, 1000, playerLevel.getVersionCode());
        C0354b.m919a(parcel, 2, playerLevel.getMinXp());
        C0354b.m919a(parcel, 3, playerLevel.getMaxXp());
        C0354b.m915H(parcel, D);
    }

    public PlayerLevel createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int C = C0352a.m875C(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new PlayerLevel(i2, i, j2, j);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public PlayerLevel[] newArray(int size) {
        return new PlayerLevel[size];
    }
}
