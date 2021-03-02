package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0368b;

/* renamed from: com.google.android.gms.maps.internal.m */
public interface C0700m extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.m$a */
    public static abstract class C0701a extends Binder implements C0700m {

        /* renamed from: com.google.android.gms.maps.internal.m$a$a */
        private static class C0702a implements C0700m {

            /* renamed from: a */
            private IBinder f1555a;

            C0702a(IBinder iBinder) {
                this.f1555a = iBinder;
            }

            public IBinder asBinder() {
                return this.f1555a;
            }

            /* renamed from: b */
            public void mo5631b(C0368b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f1555a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0701a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
        }

        /* renamed from: J */
        public static C0700m m2014J(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0700m)) ? new C0702a(iBinder) : (C0700m) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    mo5631b(C0368b.C0369a.m700l(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    void mo5631b(C0368b bVar) throws RemoteException;
}
