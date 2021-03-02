package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.games.c */
public class C0381c implements Parcelable.Creator<PlayerEntity> {
    /* renamed from: a */
    static void m725a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m672a(parcel, 1, playerEntity.getPlayerId(), false);
        C0359b.m682c(parcel, 1000, playerEntity.mo4234i());
        C0359b.m672a(parcel, 2, playerEntity.getDisplayName(), false);
        C0359b.m671a(parcel, 3, (Parcelable) playerEntity.getIconImageUri(), i, false);
        C0359b.m671a(parcel, 4, (Parcelable) playerEntity.getHiResImageUri(), i, false);
        C0359b.m667a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0359b.m663C(parcel, d);
    }

    /* renamed from: A */
    public PlayerEntity[] newArray(int i) {
        return new PlayerEntity[i];
    }

    /* renamed from: o */
    public PlayerEntity createFromParcel(Parcel parcel) {
        Uri uri = null;
        int c = C0357a.m634c(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    str2 = C0357a.m645l(parcel, b);
                    break;
                case 2:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 3:
                    uri2 = (Uri) C0357a.m628a(parcel, b, Uri.CREATOR);
                    break;
                case 4:
                    uri = (Uri) C0357a.m628a(parcel, b, Uri.CREATOR);
                    break;
                case 5:
                    j = C0357a.m640g(parcel, b);
                    break;
                case 1000:
                    i = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new PlayerEntity(i, str2, str, uri2, uri, j);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
