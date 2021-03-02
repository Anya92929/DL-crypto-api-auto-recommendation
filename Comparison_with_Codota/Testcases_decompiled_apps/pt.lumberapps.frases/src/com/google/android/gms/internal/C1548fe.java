package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.fe */
class C1548fe implements zzec {

    /* renamed from: a */
    private IBinder f4990a;

    C1548fe(IBinder iBinder) {
        this.f4990a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4990a;
    }

    public void zza(zzdx zzdx) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
            obtain.writeStrongBinder(zzdx != null ? zzdx.asBinder() : null);
            this.f4990a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
