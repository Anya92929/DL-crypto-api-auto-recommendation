package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Parcelable.Creator<ExtendedGameEntity> {
    /* renamed from: a */
    static void m3561a(ExtendedGameEntity extendedGameEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) extendedGameEntity.getGame(), i, false);
        C0354b.m939c(parcel, 1000, extendedGameEntity.getVersionCode());
        C0354b.m939c(parcel, 2, extendedGameEntity.mo7324kP());
        C0354b.m930a(parcel, 3, extendedGameEntity.mo7325kQ());
        C0354b.m939c(parcel, 4, extendedGameEntity.mo7326kR());
        C0354b.m919a(parcel, 5, extendedGameEntity.mo7327kS());
        C0354b.m919a(parcel, 6, extendedGameEntity.mo7328kT());
        C0354b.m927a(parcel, 7, extendedGameEntity.mo7329kU(), false);
        C0354b.m919a(parcel, 8, extendedGameEntity.mo7330kV());
        C0354b.m927a(parcel, 9, extendedGameEntity.mo7331kW(), false);
        C0354b.m940c(parcel, 10, extendedGameEntity.mo7323kO(), false);
        C0354b.m923a(parcel, 11, (Parcelable) extendedGameEntity.mo7332kX(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cg */
    public ExtendedGameEntity createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        long j3 = 0;
        String str2 = null;
        ArrayList arrayList = null;
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    gameEntity = (GameEntity) C0352a.m880a(parcel, B, GameEntity.CREATOR);
                    break;
                case 2:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 4:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 6:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 7:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    j3 = C0352a.m894i(parcel, B);
                    break;
                case 9:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 10:
                    arrayList = C0352a.m887c(parcel, B, GameBadgeEntity.CREATOR);
                    break;
                case 11:
                    snapshotMetadataEntity = (SnapshotMetadataEntity) C0352a.m880a(parcel, B, SnapshotMetadataEntity.CREATOR);
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
            return new ExtendedGameEntity(i, gameEntity, i2, z, i3, j, j2, str, j3, str2, arrayList, snapshotMetadataEntity);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dJ */
    public ExtendedGameEntity[] newArray(int i) {
        return new ExtendedGameEntity[i];
    }
}
