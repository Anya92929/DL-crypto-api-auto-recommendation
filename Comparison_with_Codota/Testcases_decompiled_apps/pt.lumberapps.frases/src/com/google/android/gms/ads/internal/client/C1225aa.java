package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.ads.internal.client.aa */
class C1225aa implements zzw {

    /* renamed from: a */
    private IBinder f3451a;

    C1225aa(IBinder iBinder) {
        this.f3451a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3451a;
    }

    public void onAppEvent(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAppEventListener");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f3451a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
