package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Parcelable.Creator<RoomEntity> {
    /* renamed from: a */
    static void m3715a(RoomEntity roomEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, roomEntity.getRoomId(), false);
        C0354b.m939c(parcel, 1000, roomEntity.getVersionCode());
        C0354b.m927a(parcel, 2, roomEntity.getCreatorId(), false);
        C0354b.m919a(parcel, 3, roomEntity.getCreationTimestamp());
        C0354b.m939c(parcel, 4, roomEntity.getStatus());
        C0354b.m927a(parcel, 5, roomEntity.getDescription(), false);
        C0354b.m939c(parcel, 6, roomEntity.getVariant());
        C0354b.m920a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0354b.m940c(parcel, 8, roomEntity.getParticipants(), false);
        C0354b.m939c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: co */
    public RoomEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList<ParticipantEntity> arrayList = null;
        int C = C0352a.m875C(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 7:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 8:
                    arrayList = C0352a.m887c(parcel, B, ParticipantEntity.CREATOR);
                    break;
                case 9:
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
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dV */
    public RoomEntity[] newArray(int i) {
        return new RoomEntity[i];
    }
}
