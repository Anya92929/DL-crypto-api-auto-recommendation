package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.fg */
class C1550fg implements zzee {

    /* renamed from: a */
    private IBinder f4992a;

    C1550fg(IBinder iBinder) {
        this.f4992a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4992a;
    }

    public void zza(zzdz zzdz) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
            obtain.writeStrongBinder(zzdz != null ? zzdz.asBinder() : null);
            this.f4992a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
