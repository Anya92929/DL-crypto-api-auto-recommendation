package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.i */
public class C0424i implements Parcelable.Creator<CreateFileIntentSenderRequest> {
    /* renamed from: a */
    static void m1235a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, createFileIntentSenderRequest.f897BR);
        C0354b.m923a(parcel, 2, (Parcelable) createFileIntentSenderRequest.f900Od, i, false);
        C0354b.m939c(parcel, 3, createFileIntentSenderRequest.f902uQ);
        C0354b.m927a(parcel, 4, createFileIntentSenderRequest.f898No, false);
        C0354b.m923a(parcel, 5, (Parcelable) createFileIntentSenderRequest.f899Nq, i, false);
        C0354b.m925a(parcel, 6, createFileIntentSenderRequest.f901Oe, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ab */
    public CreateFileIntentSenderRequest createFromParcel(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int C = C0352a.m875C(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0352a.m880a(parcel, B, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    driveId = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    break;
                case 6:
                    num = C0352a.m893h(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bl */
    public CreateFileIntentSenderRequest[] newArray(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
