package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.drive.a */
public class C0362a implements Parcelable.Creator<Contents> {
    /* renamed from: a */
    static void m972a(Contents contents, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, contents.f797BR);
        C0354b.m923a(parcel, 2, (Parcelable) contents.f798Kx, i, false);
        C0354b.m939c(parcel, 3, contents.f804uQ);
        C0354b.m939c(parcel, 4, contents.f799MN);
        C0354b.m923a(parcel, 5, (Parcelable) contents.f800MO, i, false);
        C0354b.m930a(parcel, 7, contents.f801MP);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: N */
    public Contents createFromParcel(Parcel parcel) {
        DriveId driveId = null;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0352a.m880a(parcel, B, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    driveId = (DriveId) C0352a.m880a(parcel, B, DriveId.CREATOR);
                    break;
                case 7:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aS */
    public Contents[] newArray(int i) {
        return new Contents[i];
    }
}
