package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.jv */
class C1673jv implements zzho {

    /* renamed from: a */
    private IBinder f5191a;

    C1673jv(IBinder iBinder) {
        this.f5191a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5191a;
    }

    public void zza(zzhn zzhn) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            obtain.writeStrongBinder(zzhn != null ? zzhn.asBinder() : null);
            this.f5191a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
