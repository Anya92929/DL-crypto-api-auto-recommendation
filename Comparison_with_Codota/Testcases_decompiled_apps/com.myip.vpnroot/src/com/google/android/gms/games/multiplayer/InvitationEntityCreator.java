package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Parcelable.Creator<InvitationEntity> {
    /* renamed from: a */
    static void m3681a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) invitationEntity.getGame(), i, false);
        C0354b.m939c(parcel, 1000, invitationEntity.getVersionCode());
        C0354b.m927a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0354b.m919a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0354b.m939c(parcel, 4, invitationEntity.getInvitationType());
        C0354b.m923a(parcel, 5, (Parcelable) invitationEntity.getInviter(), i, false);
        C0354b.m940c(parcel, 6, invitationEntity.getParticipants(), false);
        C0354b.m939c(parcel, 7, invitationEntity.getVariant());
        C0354b.m939c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cl */
    public InvitationEntity createFromParcel(Parcel parcel) {
        ArrayList<ParticipantEntity> arrayList = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
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
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) C0352a.m880a(parcel, B, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = C0352a.m887c(parcel, B, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 8:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 1000:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dS */
    public InvitationEntity[] newArray(int i) {
        return new InvitationEntity[i];
    }
}
