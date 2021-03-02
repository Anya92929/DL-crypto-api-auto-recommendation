package com.google.android.gms.ads.internal.request;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.ads.internal.request.j */
class C1309j implements zzl {

    /* renamed from: a */
    private IBinder f3923a;

    C1309j(IBinder iBinder) {
        this.f3923a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3923a;
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdResponseListener");
            if (adResponseParcel != null) {
                obtain.writeInt(1);
                adResponseParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3923a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
