package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.j */
public class C0425j implements Parcelable.Creator<CreateFileRequest> {
    /* renamed from: a */
    static void m1238a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, createFileRequest.f903BR);
        C0354b.m923a(parcel, 2, (Parcelable) createFileRequest.f908Of, i, false);
        C0354b.m923a(parcel, 3, (Parcelable) createFileRequest.f906Od, i, false);
        C0354b.m923a(parcel, 4, (Parcelable) createFileRequest.f904NX, i, false);
        C0354b.m925a(parcel, 5, createFileRequest.f907Oe, false);
        C0354b.m930a(parcel, 6, createFileRequest.f909Og);
        C0354b.m927a(parcel, 7, createFileRequest.f905Nf, false);
        C0354b.m939c(parcel, 8, createFileRequest.f910Oh);
        C0354b.m939c(parcel, 9, createFileRequest.f911Oi);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ac */
    public CreateFileRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        boolean z = false;
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
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
                    num = C0352a.m893h(parcel, B);
                    break;
                case 6:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 7:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 9:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bm */
    public CreateFileRequest[] newArray(int i) {
        return new CreateFileRequest[i];
    }
}
