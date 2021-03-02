package com.google.android.gms.gass.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.gass.internal.b */
class C1404b implements zze {

    /* renamed from: a */
    private IBinder f4810a;

    C1404b(IBinder iBinder) {
        this.f4810a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4810a;
    }

    public GassResponseParcel zza(GassRequestParcel gassRequestParcel) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.gass.internal.IGassService");
            if (gassRequestParcel != null) {
                obtain.writeInt(1);
                gassRequestParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4810a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (GassResponseParcel) GassResponseParcel.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
