package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;

/* renamed from: com.google.android.gms.maps.internal.h */
public interface C1831h extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.h$a */
    public static abstract class C1832a extends Binder implements C1831h {

        /* renamed from: com.google.android.gms.maps.internal.h$a$a */
        private static class C1833a implements C1831h {

            /* renamed from: lb */
            private IBinder f4454lb;

            C1833a(IBinder iBinder) {
                this.f4454lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f4454lb;
            }

            /* renamed from: l */
            public void mo10685l(C0594d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f4454lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: aY */
        public static C1831h m6362aY(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1831h)) ? new C1833a(iBinder) : (C1831h) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    mo10685l(C0594d.C0595a.m1741am(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: l */
    void mo10685l(C0594d dVar) throws RemoteException;
}
