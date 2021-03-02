package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.common.internal.i */
public interface C0333i extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.i$a */
    public static abstract class C0334a extends Binder implements C0333i {

        /* renamed from: com.google.android.gms.common.internal.i$a$a */
        private static class C0335a implements C0333i {

            /* renamed from: lb */
            private IBinder f790lb;

            C0335a(IBinder iBinder) {
                this.f790lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f790lb;
            }

            public void cancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
                    this.f790lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: O */
        public static C0333i m758O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0333i)) ? new C0335a(iBinder) : (C0333i) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.common.internal.ICancelToken");
                    cancel();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ICancelToken");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void cancel() throws RemoteException;
}
