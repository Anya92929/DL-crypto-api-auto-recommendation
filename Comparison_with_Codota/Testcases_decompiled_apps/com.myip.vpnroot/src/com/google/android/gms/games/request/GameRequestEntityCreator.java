package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Parcelable.Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3757a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) gameRequestEntity.getGame(), i, false);
        C0354b.m939c(parcel, 1000, gameRequestEntity.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) gameRequestEntity.getSender(), i, false);
        C0354b.m931a(parcel, 3, gameRequestEntity.getData(), false);
        C0354b.m927a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C0354b.m940c(parcel, 5, gameRequestEntity.getRecipients(), false);
        C0354b.m939c(parcel, 7, gameRequestEntity.getType());
        C0354b.m919a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C0354b.m919a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C0354b.m920a(parcel, 11, gameRequestEntity.mo7750lJ(), false);
        C0354b.m939c(parcel, 12, gameRequestEntity.getStatus());
        C0354b.m915H(parcel, D);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList<PlayerEntity> arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    gameEntity = (GameEntity) C0352a.m880a(parcel, B, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) C0352a.m880a(parcel, B, PlayerEntity.CREATOR);
                    break;
                case 3:
                    bArr = C0352a.m903r(parcel, B);
                    break;
                case 4:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    arrayList = C0352a.m887c(parcel, B, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 9:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 10:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 11:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 12:
                    i3 = C0352a.m892g(parcel, B);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}
