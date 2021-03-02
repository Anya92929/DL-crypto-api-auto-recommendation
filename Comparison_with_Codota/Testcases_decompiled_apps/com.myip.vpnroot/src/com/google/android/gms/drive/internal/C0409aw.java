package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.aw */
public class C0409aw implements Parcelable.Creator<OpenFileIntentSenderRequest> {
    /* renamed from: a */
    static void m1182a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, openFileIntentSenderRequest.f961BR);
        C0354b.m927a(parcel, 2, openFileIntentSenderRequest.f962No, false);
        C0354b.m934a(parcel, 3, openFileIntentSenderRequest.f963Np, false);
        C0354b.m923a(parcel, 4, (Parcelable) openFileIntentSenderRequest.f964Nq, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ax */
    public OpenFileIntentSenderRequest createFromParcel(Parcel parcel) {
        DriveId driveId = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    strArr = C0352a.m872A(parcel, B);
                    break;
                case 4:
                    driveId = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bJ */
    public OpenFileIntentSenderRequest[] newArray(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
