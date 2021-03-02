package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Parcelable.Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3730a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) turnBasedMatchEntity.getGame(), i, false);
        C0354b.m927a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C0354b.m927a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C0354b.m919a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C0354b.m927a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C0354b.m919a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C0354b.m927a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C0354b.m939c(parcel, 8, turnBasedMatchEntity.getStatus());
        C0354b.m939c(parcel, 10, turnBasedMatchEntity.getVariant());
        C0354b.m939c(parcel, 11, turnBasedMatchEntity.getVersion());
        C0354b.m931a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C0354b.m940c(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C0354b.m927a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C0354b.m931a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C0354b.m920a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C0354b.m939c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C0354b.m939c(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        C0354b.m930a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C0354b.m939c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C0354b.m927a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C0354b.m927a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C0354b.m915H(parcel, D);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList<ParticipantEntity> arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    gameEntity = (GameEntity) C0352a.m880a(parcel, B, GameEntity.CREATOR);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 5:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 7:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 10:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 11:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 12:
                    bArr = C0352a.m903r(parcel, B);
                    break;
                case 13:
                    arrayList = C0352a.m887c(parcel, B, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 15:
                    bArr2 = C0352a.m903r(parcel, B);
                    break;
                case 16:
                    i5 = C0352a.m892g(parcel, B);
                    break;
                case 17:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 18:
                    i6 = C0352a.m892g(parcel, B);
                    break;
                case 19:
                    z = C0352a.m888c(parcel, B);
                    break;
                case FitnessActivities.BOXING:
                    str6 = C0352a.m900o(parcel, B);
                    break;
                case 21:
                    str7 = C0352a.m900o(parcel, B);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}
