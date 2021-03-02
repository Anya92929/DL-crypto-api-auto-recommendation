package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0164b;
import com.google.android.gms.maps.model.internal.C0731d;

/* renamed from: com.google.android.gms.maps.internal.d */
public interface C0670d extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.d$a */
    public static abstract class C0671a extends Binder implements C0670d {

        /* renamed from: com.google.android.gms.maps.internal.d$a$a */
        private static class C0672a implements C0670d {

            /* renamed from: dG */
            private IBinder f1685dG;

            C0672a(IBinder iBinder) {
                this.f1685dG = iBinder;
            }

            public IBinder asBinder() {
                return this.f1685dG;
            }

            /* renamed from: f */
            public C0164b mo5454f(C0731d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f1685dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0164b.C0165a.m377z(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public C0164b mo5455g(C0731d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f1685dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0164b.C0165a.m377z(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0671a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        /* renamed from: L */
        public static C0670d m2036L(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0670d)) ? new C0672a(iBinder) : (C0670d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    C0164b f = mo5454f(C0731d.C0732a.m2141af(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    C0164b g = mo5455g(C0731d.C0732a.m2141af(data.readStrongBinder()));
                    reply.writeNoException();
                    if (g != null) {
                        iBinder = g.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: f */
    C0164b mo5454f(C0731d dVar) throws RemoteException;

    /* renamed from: g */
    C0164b mo5455g(C0731d dVar) throws RemoteException;
}
