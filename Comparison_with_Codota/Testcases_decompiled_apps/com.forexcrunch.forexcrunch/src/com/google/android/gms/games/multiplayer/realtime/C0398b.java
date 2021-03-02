package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.b */
public class C0398b implements Parcelable.Creator<RoomEntity> {
    /* renamed from: a */
    static void m785a(RoomEntity roomEntity, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m672a(parcel, 1, roomEntity.getRoomId(), false);
        C0359b.m682c(parcel, 1000, roomEntity.mo4412i());
        C0359b.m672a(parcel, 2, roomEntity.getCreatorId(), false);
        C0359b.m667a(parcel, 3, roomEntity.getCreationTimestamp());
        C0359b.m682c(parcel, 4, roomEntity.getStatus());
        C0359b.m672a(parcel, 5, roomEntity.getDescription(), false);
        C0359b.m682c(parcel, 6, roomEntity.getVariant());
        C0359b.m668a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0359b.m681b(parcel, 8, roomEntity.getParticipants(), false);
        C0359b.m682c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0359b.m663C(parcel, d);
    }

    /* renamed from: K */
    public RoomEntity[] newArray(int i) {
        return new RoomEntity[i];
    }

    /* renamed from: s */
    public RoomEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList<ParticipantEntity> arrayList = null;
        int c = C0357a.m634c(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
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
                    j = C0357a.m640g(parcel, b);
                    break;
                case 4:
                    i3 = C0357a.m639f(parcel, b);
                    break;
                case 5:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 6:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 7:
                    bundle = C0357a.m648n(parcel, b);
                    break;
                case 8:
                    arrayList = C0357a.m635c(parcel, b, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 1000:
                    i4 = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
