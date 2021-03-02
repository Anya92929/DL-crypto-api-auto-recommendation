package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.ads.internal.client.t */
class C1247t implements zzp {

    /* renamed from: a */
    private IBinder f3494a;

    C1247t(IBinder iBinder) {
        this.f3494a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3494a;
    }

    public void onAdClicked() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdClickListener");
            this.f3494a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
