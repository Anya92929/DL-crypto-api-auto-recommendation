package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.games.multiplayer.c */
public class C0188c implements Parcelable.Creator<ParticipantEntity> {
    /* renamed from: a */
    static void m439a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m349a(parcel, 1, participantEntity.getParticipantId(), false);
        C0155b.m359c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, participantEntity.getVersionCode());
        C0155b.m349a(parcel, 2, participantEntity.getDisplayName(), false);
        C0155b.m348a(parcel, 3, (Parcelable) participantEntity.getIconImageUri(), i, false);
        C0155b.m348a(parcel, 4, (Parcelable) participantEntity.getHiResImageUri(), i, false);
        C0155b.m359c(parcel, 5, participantEntity.getStatus());
        C0155b.m349a(parcel, 6, participantEntity.mo3892ci(), false);
        C0155b.m352a(parcel, 7, participantEntity.isConnectedToRoom());
        C0155b.m348a(parcel, 8, (Parcelable) participantEntity.getPlayer(), i, false);
        C0155b.m359c(parcel, 9, participantEntity.getCapabilities());
        C0155b.m340C(parcel, k);
    }

    /* renamed from: T */
    public ParticipantEntity[] newArray(int i) {
        return new ParticipantEntity[i];
    }

    /* renamed from: w */
    public ParticipantEntity createFromParcel(Parcel parcel) {
        int i = 0;
        PlayerEntity playerEntity = null;
        int j = C0153a.m320j(parcel);
        boolean z = false;
        String str = null;
        int i2 = 0;
        Uri uri = null;
        Uri uri2 = null;
        String str2 = null;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    str3 = C0153a.m322l(parcel, i4);
                    break;
                case 2:
                    str2 = C0153a.m322l(parcel, i4);
                    break;
                case 3:
                    uri2 = (Uri) C0153a.m305a(parcel, i4, Uri.CREATOR);
                    break;
                case 4:
                    uri = (Uri) C0153a.m305a(parcel, i4, Uri.CREATOR);
                    break;
                case 5:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 6:
                    str = C0153a.m322l(parcel, i4);
                    break;
                case 7:
                    z = C0153a.m311c(parcel, i4);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) C0153a.m305a(parcel, i4, PlayerEntity.CREATOR);
                    break;
                case 9:
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
            return new ParticipantEntity(i3, str3, str2, uri2, uri, i2, str, z, playerEntity, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
