package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.internal.jx */
class C1675jx implements zzhq {

    /* renamed from: a */
    private IBinder f5193a;

    C1675jx(IBinder iBinder) {
        this.f5193a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5193a;
    }

    public IBinder zzo(zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f5193a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
