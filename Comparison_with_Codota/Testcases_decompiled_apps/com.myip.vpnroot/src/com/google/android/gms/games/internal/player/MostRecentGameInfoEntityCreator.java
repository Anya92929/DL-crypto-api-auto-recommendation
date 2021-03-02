package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class MostRecentGameInfoEntityCreator implements Parcelable.Creator<MostRecentGameInfoEntity> {
    /* renamed from: a */
    static void m3621a(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, mostRecentGameInfoEntity.mo7409ln(), false);
        C0354b.m939c(parcel, 1000, mostRecentGameInfoEntity.getVersionCode());
        C0354b.m927a(parcel, 2, mostRecentGameInfoEntity.mo7410lo(), false);
        C0354b.m919a(parcel, 3, mostRecentGameInfoEntity.mo7411lp());
        C0354b.m923a(parcel, 4, (Parcelable) mostRecentGameInfoEntity.mo7412lq(), i, false);
        C0354b.m923a(parcel, 5, (Parcelable) mostRecentGameInfoEntity.mo7413lr(), i, false);
        C0354b.m923a(parcel, 6, (Parcelable) mostRecentGameInfoEntity.mo7414ls(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cj */
    public MostRecentGameInfoEntity createFromParcel(Parcel parcel) {
        Uri uri = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    uri3 = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dP */
    public MostRecentGameInfoEntity[] newArray(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}
