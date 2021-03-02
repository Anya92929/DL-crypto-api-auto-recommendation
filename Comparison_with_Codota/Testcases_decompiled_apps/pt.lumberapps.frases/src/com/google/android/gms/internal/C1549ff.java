package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.ff */
class C1549ff implements zzed {

    /* renamed from: a */
    private IBinder f4991a;

    C1549ff(IBinder iBinder) {
        this.f4991a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4991a;
    }

    public void zza(zzdz zzdz, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
            obtain.writeStrongBinder(zzdz != null ? zzdz.asBinder() : null);
            obtain.writeString(str);
            this.f4991a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
