package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.ju */
class C1672ju implements zzhn {

    /* renamed from: a */
    private IBinder f5190a;

    C1672ju(IBinder iBinder) {
        this.f5190a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5190a;
    }

    public String getProductId() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            this.f5190a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void recordPlayBillingResolution(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            obtain.writeInt(i);
            this.f5190a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void recordResolution(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            obtain.writeInt(i);
            this.f5190a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
