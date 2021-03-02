package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;

/* renamed from: com.google.android.gms.iid.c */
class C1407c implements zzb {

    /* renamed from: a */
    private IBinder f4815a;

    C1407c(IBinder iBinder) {
        this.f4815a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4815a;
    }

    public void send(Message message) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            if (message != null) {
                obtain.writeInt(1);
                message.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4815a.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
