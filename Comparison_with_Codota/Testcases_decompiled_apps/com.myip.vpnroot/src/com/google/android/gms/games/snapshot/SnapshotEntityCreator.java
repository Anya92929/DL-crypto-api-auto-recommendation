package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class SnapshotEntityCreator implements Parcelable.Creator<SnapshotEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3764a(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) snapshotEntity.getMetadata(), i, false);
        C0354b.m939c(parcel, 1000, snapshotEntity.getVersionCode());
        C0354b.m923a(parcel, 3, (Parcelable) snapshotEntity.getSnapshotContents(), i, false);
        C0354b.m915H(parcel, D);
    }

    public SnapshotEntity createFromParcel(Parcel parcel) {
        SnapshotContents snapshotContents;
        SnapshotMetadataEntity snapshotMetadataEntity;
        int i;
        SnapshotContents snapshotContents2 = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        SnapshotMetadataEntity snapshotMetadataEntity2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = i2;
                    SnapshotMetadataEntity snapshotMetadataEntity3 = (SnapshotMetadataEntity) C0352a.m880a(parcel, B, SnapshotMetadataEntity.CREATOR);
                    snapshotContents = snapshotContents2;
                    snapshotMetadataEntity = snapshotMetadataEntity3;
                    break;
                case 3:
                    snapshotContents = (SnapshotContents) C0352a.m880a(parcel, B, SnapshotContents.CREATOR);
                    snapshotMetadataEntity = snapshotMetadataEntity2;
                    i = i2;
                    break;
                case 1000:
                    SnapshotContents snapshotContents3 = snapshotContents2;
                    snapshotMetadataEntity = snapshotMetadataEntity2;
                    i = C0352a.m892g(parcel, B);
                    snapshotContents = snapshotContents3;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    snapshotContents = snapshotContents2;
                    snapshotMetadataEntity = snapshotMetadataEntity2;
                    i = i2;
                    break;
            }
            i2 = i;
            snapshotMetadataEntity2 = snapshotMetadataEntity;
            snapshotContents2 = snapshotContents;
        }
        if (parcel.dataPosition() == C) {
            return new SnapshotEntity(i2, snapshotMetadataEntity2, snapshotContents2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public SnapshotEntity[] newArray(int size) {
        return new SnapshotEntity[size];
    }
}
