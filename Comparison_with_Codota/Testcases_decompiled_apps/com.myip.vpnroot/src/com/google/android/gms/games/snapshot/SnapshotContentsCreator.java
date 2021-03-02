package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.Contents;

public class SnapshotContentsCreator implements Parcelable.Creator<SnapshotContents> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3760a(SnapshotContents snapshotContents, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) snapshotContents.getContents(), i, false);
        C0354b.m939c(parcel, 1000, snapshotContents.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    public SnapshotContents createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    contents = (Contents) C0352a.m880a(parcel, B, Contents.CREATOR);
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
            return new SnapshotContents(i, contents);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public SnapshotContents[] newArray(int size) {
        return new SnapshotContents[size];
    }
}
