package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.common.api.az */
public class C0728az implements Parcelable.Creator<Status> {
    /* renamed from: a */
    static void m4040a(Status status, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, status.mo7344d());
        C1031c.m4610a(parcel, 1000, status.mo7343c());
        C1031c.m4616a(parcel, 2, status.mo7342b(), false);
        C1031c.m4614a(parcel, 3, (Parcelable) status.mo7341a(), i, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public Status createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = C1029a.m4587b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    str = C1029a.m4599k(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) C1029a.m4583a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public Status[] newArray(int i) {
        return new Status[i];
    }
}
