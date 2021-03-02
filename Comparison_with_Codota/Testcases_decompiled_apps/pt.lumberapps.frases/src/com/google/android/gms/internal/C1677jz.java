package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.jz */
class C1677jz implements zzhs {

    /* renamed from: a */
    private IBinder f5195a;

    C1677jz(IBinder iBinder) {
        this.f5195a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5195a;
    }

    public boolean isValidPurchase(String str) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            obtain.writeString(str);
            this.f5195a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zza(zzhr zzhr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            obtain.writeStrongBinder(zzhr != null ? zzhr.asBinder() : null);
            this.f5195a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
