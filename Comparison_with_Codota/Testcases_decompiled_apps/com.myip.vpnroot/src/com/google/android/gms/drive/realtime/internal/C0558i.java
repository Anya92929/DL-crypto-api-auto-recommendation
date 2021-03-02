package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.drive.realtime.internal.i */
public interface C0558i extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.i$a */
    public static abstract class C0559a extends Binder implements C0558i {

        /* renamed from: com.google.android.gms.drive.realtime.internal.i$a$a */
        private static class C0560a implements C0558i {

            /* renamed from: lb */
            private IBinder f1232lb;

            C0560a(IBinder iBinder) {
                this.f1232lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f1232lb;
            }

            /* renamed from: o */
            public void mo5395o(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IErrorCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1232lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: ae */
        public static C0558i m1589ae(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0558i)) ? new C0560a(iBinder) : (C0558i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
                    mo5395o(data.readInt() != 0 ? Status.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IErrorCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: o */
    void mo5395o(Status status) throws RemoteException;
}
