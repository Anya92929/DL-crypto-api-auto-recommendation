package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.games.PlayerEntity;

/* renamed from: com.google.android.gms.games.multiplayer.c */
public class C0392c implements Parcelable.Creator<ParticipantEntity> {
    /* renamed from: a */
    static void m768a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m672a(parcel, 1, participantEntity.getParticipantId(), false);
        C0359b.m682c(parcel, 1000, participantEntity.mo4354i());
        C0359b.m672a(parcel, 2, participantEntity.getDisplayName(), false);
        C0359b.m671a(parcel, 3, (Parcelable) participantEntity.getIconImageUri(), i, false);
        C0359b.m671a(parcel, 4, (Parcelable) participantEntity.getHiResImageUri(), i, false);
        C0359b.m682c(parcel, 5, participantEntity.getStatus());
        C0359b.m672a(parcel, 6, participantEntity.mo4341aM(), false);
        C0359b.m675a(parcel, 7, participantEntity.isConnectedToRoom());
        C0359b.m671a(parcel, 8, (Parcelable) participantEntity.getPlayer(), i, false);
        C0359b.m682c(parcel, 9, participantEntity.mo4342aN());
        C0359b.m663C(parcel, d);
    }

    /* renamed from: I */
    public ParticipantEntity[] newArray(int i) {
        return new ParticipantEntity[i];
    }

    /* renamed from: q */
    public ParticipantEntity createFromParcel(Parcel parcel) {
        int i = 0;
        PlayerEntity playerEntity = null;
        int c = C0357a.m634c(parcel);
        boolean z = false;
        String str = null;
        int i2 = 0;
        Uri uri = null;
        Uri uri2 = null;
        String str2 = null;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    str3 = C0357a.m645l(parcel, b);
                    break;
                case 2:
                    str2 = C0357a.m645l(parcel, b);
                    break;
                case 3:
                    uri2 = (Uri) C0357a.m628a(parcel, b, Uri.CREATOR);
                    break;
                case 4:
                    uri = (Uri) C0357a.m628a(parcel, b, Uri.CREATOR);
                    break;
                case 5:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 6:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 7:
                    z = C0357a.m636c(parcel, b);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) C0357a.m628a(parcel, b, PlayerEntity.CREATOR);
                    break;
                case 9:
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
            return new ParticipantEntity(i3, str3, str2, uri2, uri, i2, str, z, playerEntity, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
