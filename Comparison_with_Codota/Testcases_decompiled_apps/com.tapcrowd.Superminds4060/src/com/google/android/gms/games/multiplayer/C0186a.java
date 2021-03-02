package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.a */
public class C0186a implements Parcelable.Creator<InvitationEntity> {
    /* renamed from: a */
    static void m435a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m348a(parcel, 1, (Parcelable) invitationEntity.getGame(), i, false);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, invitationEntity.getVersionCode());
        C0155b.m349a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0155b.m344a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0155b.m359c(parcel, 4, invitationEntity.mo3874ch());
        C0155b.m348a(parcel, 5, (Parcelable) invitationEntity.getInviter(), i, false);
        C0155b.m358b(parcel, 6, invitationEntity.getParticipants(), false);
        C0155b.m359c(parcel, 7, invitationEntity.getVariant());
        C0155b.m340C(parcel, k);
    }

    /* renamed from: S */
    public InvitationEntity[] newArray(int i) {
        return new InvitationEntity[i];
    }

    /* renamed from: v */
    public InvitationEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList<ParticipantEntity> arrayList = null;
        int j = C0153a.m320j(parcel);
        long j2 = 0;
        ParticipantEntity participantEntity = null;
        int i2 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    gameEntity = (GameEntity) C0153a.m305a(parcel, i4, GameEntity.CREATOR);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i4);
                    break;
                case 3:
                    j2 = C0153a.m315g(parcel, i4);
                    break;
                case 4:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) C0153a.m305a(parcel, i4, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = C0153a.m310c(parcel, i4, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i = C0153a.m314f(parcel, i4);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0153a.m314f(parcel, i4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new InvitationEntity(i3, gameEntity, str, j2, i2, participantEntity, arrayList, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
