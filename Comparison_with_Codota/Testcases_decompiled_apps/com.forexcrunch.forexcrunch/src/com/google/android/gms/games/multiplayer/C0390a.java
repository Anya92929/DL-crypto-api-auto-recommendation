package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.a */
public class C0390a implements Parcelable.Creator<InvitationEntity> {
    /* renamed from: a */
    static void m764a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m671a(parcel, 1, (Parcelable) invitationEntity.getGame(), i, false);
        C0359b.m682c(parcel, 1000, invitationEntity.mo4334i());
        C0359b.m672a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0359b.m667a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0359b.m682c(parcel, 4, invitationEntity.mo4323aL());
        C0359b.m671a(parcel, 5, (Parcelable) invitationEntity.getInviter(), i, false);
        C0359b.m681b(parcel, 6, invitationEntity.getParticipants(), false);
        C0359b.m682c(parcel, 7, invitationEntity.getVariant());
        C0359b.m663C(parcel, d);
    }

    /* renamed from: H */
    public InvitationEntity[] newArray(int i) {
        return new InvitationEntity[i];
    }

    /* renamed from: p */
    public InvitationEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList<ParticipantEntity> arrayList = null;
        int c = C0357a.m634c(parcel);
        long j = 0;
        ParticipantEntity participantEntity = null;
        int i2 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    gameEntity = (GameEntity) C0357a.m628a(parcel, b, GameEntity.CREATOR);
                    break;
                case 2:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 3:
                    j = C0357a.m640g(parcel, b);
                    break;
                case 4:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) C0357a.m628a(parcel, b, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = C0357a.m635c(parcel, b, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 1000:
                    i3 = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new InvitationEntity(i3, gameEntity, str, j, i2, participantEntity, arrayList, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
