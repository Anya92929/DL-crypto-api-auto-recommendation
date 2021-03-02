package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.C1831h;

public interface ILocationSourceDelegate extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.ILocationSourceDelegate$a */
    public static abstract class C1796a extends Binder implements ILocationSourceDelegate {

        /* renamed from: com.google.android.gms.maps.internal.ILocationSourceDelegate$a$a */
        private static class C1797a implements ILocationSourceDelegate {

            /* renamed from: lb */
            private IBinder f4440lb;

            C1797a(IBinder iBinder) {
                this.f4440lb = iBinder;
            }

            public void activate(C1831h listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.f4440lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4440lb;
            }

            public void deactivate() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    this.f4440lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1796a() {
            attachInterface(this, "com.google.android.gms.maps.internal.ILocationSourceDelegate");
        }

        /* renamed from: aS */
        public static ILocationSourceDelegate m6321aS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ILocationSourceDelegate)) ? new C1797a(iBinder) : (ILocationSourceDelegate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    activate(C1831h.C1832a.m6362aY(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    deactivate();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ILocationSourceDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void activate(C1831h hVar) throws RemoteException;

    void deactivate() throws RemoteException;
}
