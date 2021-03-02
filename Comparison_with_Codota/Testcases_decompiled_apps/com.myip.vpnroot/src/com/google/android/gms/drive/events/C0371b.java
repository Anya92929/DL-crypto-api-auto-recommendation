package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.drive.events.b */
public class C0371b implements Parcelable.Creator<CompletionEvent> {
    /* renamed from: a */
    static void m997a(CompletionEvent completionEvent, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, completionEvent.f857BR);
        C0354b.m923a(parcel, 2, (Parcelable) completionEvent.f860MO, i, false);
        C0354b.m927a(parcel, 3, completionEvent.f858Dd, false);
        C0354b.m923a(parcel, 4, (Parcelable) completionEvent.f861NF, i, false);
        C0354b.m923a(parcel, 5, (Parcelable) completionEvent.f862NG, i, false);
        C0354b.m923a(parcel, 6, (Parcelable) completionEvent.f863NH, i, false);
        C0354b.m938b(parcel, 7, completionEvent.f864NI, false);
        C0354b.m939c(parcel, 8, completionEvent.f859Fa);
        C0354b.m921a(parcel, 9, completionEvent.f865NJ, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: U */
    public CompletionEvent createFromParcel(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int C = C0352a.m875C(parcel);
        ArrayList<String> arrayList = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
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
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) C0352a.m880a(parcel, B, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0352a.m880a(parcel, B, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) C0352a.m880a(parcel, B, MetadataBundle.CREATOR);
                    break;
                case 7:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                case 8:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 9:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, arrayList, i, iBinder);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bb */
    public CompletionEvent[] newArray(int i) {
        return new CompletionEvent[i];
    }
}
