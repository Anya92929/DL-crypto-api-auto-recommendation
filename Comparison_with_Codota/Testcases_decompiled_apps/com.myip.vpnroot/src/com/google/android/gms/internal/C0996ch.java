package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ch */
public interface C0996ch extends IInterface {

    /* renamed from: com.google.android.gms.internal.ch$a */
    public static abstract class C0997a extends Binder implements C0996ch {

        /* renamed from: com.google.android.gms.internal.ch$a$a */
        private static class C0998a implements C0996ch {

            /* renamed from: lb */
            private IBinder f3018lb;

            C0998a(IBinder iBinder) {
                this.f3018lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f3018lb;
            }

            /* renamed from: bD */
            public Bundle mo8210bD() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
                    this.f3018lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: k */
        public static C0996ch m4123k(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0996ch)) ? new C0998a(iBinder) : (C0996ch) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
                    Bundle bD = mo8210bD();
                    reply.writeNoException();
                    if (bD != null) {
                        reply.writeInt(1);
                        bD.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: bD */
    Bundle mo8210bD() throws RemoteException;
}
