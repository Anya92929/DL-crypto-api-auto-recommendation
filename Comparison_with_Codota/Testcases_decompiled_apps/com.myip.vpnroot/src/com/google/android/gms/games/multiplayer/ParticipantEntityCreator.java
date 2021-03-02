package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.PlayerEntity;

public class ParticipantEntityCreator implements Parcelable.Creator<ParticipantEntity> {
    /* renamed from: a */
    static void m3693a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, participantEntity.getParticipantId(), false);
        C0354b.m939c(parcel, 1000, participantEntity.getVersionCode());
        C0354b.m927a(parcel, 2, participantEntity.getDisplayName(), false);
        C0354b.m923a(parcel, 3, (Parcelable) participantEntity.getIconImageUri(), i, false);
        C0354b.m923a(parcel, 4, (Parcelable) participantEntity.getHiResImageUri(), i, false);
        C0354b.m939c(parcel, 5, participantEntity.getStatus());
        C0354b.m927a(parcel, 6, participantEntity.mo7546jU(), false);
        C0354b.m930a(parcel, 7, participantEntity.isConnectedToRoom());
        C0354b.m923a(parcel, 8, (Parcelable) participantEntity.getPlayer(), i, false);
        C0354b.m939c(parcel, 9, participantEntity.getCapabilities());
        C0354b.m923a(parcel, 10, (Parcelable) participantEntity.getResult(), i, false);
        C0354b.m927a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C0354b.m927a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cm */
    public ParticipantEntity createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 5:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) C0352a.m880a(parcel, B, PlayerEntity.CREATOR);
                    break;
                case 9:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 10:
                    participantResult = (ParticipantResult) C0352a.m880a(parcel, B, ParticipantResult.CREATOR);
                    break;
                case 11:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 12:
                    str5 = C0352a.m900o(parcel, B);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dT */
    public ParticipantEntity[] newArray(int i) {
        return new ParticipantEntity[i];
    }
}
