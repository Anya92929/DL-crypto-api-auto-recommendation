package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.fd */
class C1547fd implements zzeb {

    /* renamed from: a */
    private IBinder f4989a;

    C1547fd(IBinder iBinder) {
        this.f4989a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4989a;
    }

    public void zza(zzdv zzdv) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
            obtain.writeStrongBinder(zzdv != null ? zzdv.asBinder() : null);
            this.f4989a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
