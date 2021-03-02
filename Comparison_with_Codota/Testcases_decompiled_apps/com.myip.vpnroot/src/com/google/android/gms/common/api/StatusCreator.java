package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class StatusCreator implements Parcelable.Creator<Status> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m530a(Status status, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, status.getStatusCode());
        C0354b.m939c(parcel, 1000, status.getVersionCode());
        C0354b.m927a(parcel, 2, status.getStatusMessage(), false);
        C0354b.m923a(parcel, 3, (Parcelable) status.getPendingIntent(), i, false);
        C0354b.m915H(parcel, D);
    }

    public Status createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i2 = 0;
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
                    pendingIntent = (PendingIntent) C0352a.m880a(parcel, B, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public Status[] newArray(int size) {
        return new Status[size];
    }
}
