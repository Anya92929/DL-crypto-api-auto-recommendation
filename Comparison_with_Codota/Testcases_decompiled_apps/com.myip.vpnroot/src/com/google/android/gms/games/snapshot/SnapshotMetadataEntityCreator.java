package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

public class SnapshotMetadataEntityCreator implements Parcelable.Creator<SnapshotMetadataEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3770a(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) snapshotMetadataEntity.getGame(), i, false);
        C0354b.m939c(parcel, 1000, snapshotMetadataEntity.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) snapshotMetadataEntity.getOwner(), i, false);
        C0354b.m927a(parcel, 3, snapshotMetadataEntity.getSnapshotId(), false);
        C0354b.m923a(parcel, 5, (Parcelable) snapshotMetadataEntity.getCoverImageUri(), i, false);
        C0354b.m927a(parcel, 6, snapshotMetadataEntity.getCoverImageUrl(), false);
        C0354b.m927a(parcel, 7, snapshotMetadataEntity.getTitle(), false);
        C0354b.m927a(parcel, 8, snapshotMetadataEntity.getDescription(), false);
        C0354b.m919a(parcel, 9, snapshotMetadataEntity.getLastModifiedTimestamp());
        C0354b.m919a(parcel, 10, snapshotMetadataEntity.getPlayedTime());
        C0354b.m918a(parcel, 11, snapshotMetadataEntity.getCoverImageAspectRatio());
        C0354b.m927a(parcel, 12, snapshotMetadataEntity.getUniqueName(), false);
        C0354b.m915H(parcel, D);
    }

    public SnapshotMetadataEntity createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        String str5 = null;
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
                    str = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 6:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 10:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 11:
                    f = C0352a.m897l(parcel, B);
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
            return new SnapshotMetadataEntity(i, gameEntity, playerEntity, str, uri, str2, str3, str4, j, j2, f, str5);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public SnapshotMetadataEntity[] newArray(int size) {
        return new SnapshotMetadataEntity[size];
    }
}
