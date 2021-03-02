package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class GameBadgeEntityCreator implements Parcelable.Creator<GameBadgeEntity> {
    /* renamed from: a */
    static void m3584a(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, gameBadgeEntity.getType());
        C0354b.m939c(parcel, 1000, gameBadgeEntity.getVersionCode());
        C0354b.m927a(parcel, 2, gameBadgeEntity.getTitle(), false);
        C0354b.m927a(parcel, 3, gameBadgeEntity.getDescription(), false);
        C0354b.m923a(parcel, 4, (Parcelable) gameBadgeEntity.getIconImageUri(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ch */
    public GameBadgeEntity createFromParcel(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int C = C0352a.m875C(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
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
            return new GameBadgeEntity(i2, i, str2, str, uri);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dL */
    public GameBadgeEntity[] newArray(int i) {
        return new GameBadgeEntity[i];
    }
}
