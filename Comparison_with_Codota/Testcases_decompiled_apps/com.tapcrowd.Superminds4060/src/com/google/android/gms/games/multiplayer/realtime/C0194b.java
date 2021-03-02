package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.b */
public class C0194b implements Parcelable.Creator<RoomEntity> {
    /* renamed from: a */
    static void m454a(RoomEntity roomEntity, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m349a(parcel, 1, roomEntity.getRoomId(), false);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, roomEntity.getVersionCode());
        C0155b.m349a(parcel, 2, roomEntity.getCreatorId(), false);
        C0155b.m344a(parcel, 3, roomEntity.getCreationTimestamp());
        C0155b.m359c(parcel, 4, roomEntity.getStatus());
        C0155b.m349a(parcel, 5, roomEntity.getDescription(), false);
        C0155b.m359c(parcel, 6, roomEntity.getVariant());
        C0155b.m345a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0155b.m358b(parcel, 8, roomEntity.getParticipants(), false);
        C0155b.m359c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0155b.m340C(parcel, k);
    }

    /* renamed from: V */
    public RoomEntity[] newArray(int i) {
        return new RoomEntity[i];
    }

    /* renamed from: y */
    public RoomEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList<ParticipantEntity> arrayList = null;
        int j = C0153a.m320j(parcel);
        long j2 = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < j) {
            int i5 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i5)) {
                case 1:
                    str3 = C0153a.m322l(parcel, i5);
                    break;
                case 2:
                    str2 = C0153a.m322l(parcel, i5);
                    break;
                case 3:
                    j2 = C0153a.m315g(parcel, i5);
                    break;
                case 4:
                    i3 = C0153a.m314f(parcel, i5);
                    break;
                case 5:
                    str = C0153a.m322l(parcel, i5);
                    break;
                case 6:
                    i2 = C0153a.m314f(parcel, i5);
                    break;
                case 7:
                    bundle = C0153a.m324n(parcel, i5);
                    break;
                case 8:
                    arrayList = C0153a.m310c(parcel, i5, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = C0153a.m314f(parcel, i5);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = C0153a.m314f(parcel, i5);
                    break;
                default:
                    C0153a.m308b(parcel, i5);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new RoomEntity(i4, str3, str2, j2, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
