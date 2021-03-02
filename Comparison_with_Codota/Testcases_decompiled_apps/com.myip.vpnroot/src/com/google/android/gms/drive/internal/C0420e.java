package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.e */
public class C0420e implements Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> {
    /* renamed from: a */
    static void m1222a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, closeContentsAndUpdateMetadataRequest.f885BR);
        C0354b.m923a(parcel, 2, (Parcelable) closeContentsAndUpdateMetadataRequest.f886NV, i, false);
        C0354b.m923a(parcel, 3, (Parcelable) closeContentsAndUpdateMetadataRequest.f887NW, i, false);
        C0354b.m923a(parcel, 4, (Parcelable) closeContentsAndUpdateMetadataRequest.f888NX, i, false);
        C0354b.m930a(parcel, 5, closeContentsAndUpdateMetadataRequest.f891Ng);
        C0354b.m927a(parcel, 6, closeContentsAndUpdateMetadataRequest.f890Nf, false);
        C0354b.m939c(parcel, 7, closeContentsAndUpdateMetadataRequest.f889NY);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: Y */
    public CloseContentsAndUpdateMetadataRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int C = C0352a.m875C(parcel);
        boolean z = false;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    driveId = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) C0352a.m880a(parcel, B, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) C0352a.m880a(parcel, B, Contents.CREATOR);
                    break;
                case 5:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 6:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CloseContentsAndUpdateMetadataRequest(i2, driveId, metadataBundle, contents, z, str, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bh */
    public CloseContentsAndUpdateMetadataRequest[] newArray(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
