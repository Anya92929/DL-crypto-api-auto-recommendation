package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.eu */
class C1537eu implements zzdo {

    /* renamed from: a */
    private IBinder f4976a;

    C1537eu(IBinder iBinder) {
        this.f4976a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4976a;
    }

    public void zza(zzdn zzdn) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
            obtain.writeStrongBinder(zzdn != null ? zzdn.asBinder() : null);
            this.f4976a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
