package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.C0294a;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class SnapshotMetadataChangeCreator implements Parcelable.Creator<SnapshotMetadataChange> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3766a(SnapshotMetadataChange snapshotMetadataChange, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, snapshotMetadataChange.getDescription(), false);
        C0354b.m939c(parcel, 1000, snapshotMetadataChange.getVersionCode());
        C0354b.m926a(parcel, 2, snapshotMetadataChange.getPlayedTimeMillis(), false);
        C0354b.m923a(parcel, 4, (Parcelable) snapshotMetadataChange.getCoverImageUri(), i, false);
        C0354b.m923a(parcel, 5, (Parcelable) snapshotMetadataChange.mo7805lK(), i, false);
        C0354b.m915H(parcel, D);
    }

    public SnapshotMetadataChange createFromParcel(Parcel parcel) {
        Uri uri = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        C0294a aVar = null;
        Long l = null;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    l = C0352a.m895j(parcel, B);
                    break;
                case 4:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 5:
                    aVar = (C0294a) C0352a.m880a(parcel, B, C0294a.CREATOR);
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
            return new SnapshotMetadataChange(i, str, l, aVar, uri);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public SnapshotMetadataChange[] newArray(int size) {
        return new SnapshotMetadataChange[size];
    }
}
