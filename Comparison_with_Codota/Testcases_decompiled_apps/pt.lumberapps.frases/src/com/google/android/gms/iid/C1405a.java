package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.iid.a */
final class C1405a implements Parcelable.Creator {
    C1405a() {
    }

    /* renamed from: a */
    public MessengerCompat createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new MessengerCompat(readStrongBinder);
        }
        return null;
    }

    /* renamed from: a */
    public MessengerCompat[] newArray(int i) {
        return new MessengerCompat[i];
    }
}
