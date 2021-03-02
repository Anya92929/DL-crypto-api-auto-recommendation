package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;

/* renamed from: com.google.android.gms.maps.internal.o */
public interface C1852o extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.o$a */
    public static abstract class C1853a extends Binder implements C1852o {

        /* renamed from: com.google.android.gms.maps.internal.o$a$a */
        private static class C1854a implements C1852o {

            /* renamed from: lb */
            private IBinder f4461lb;

            C1854a(IBinder iBinder) {
                this.f4461lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f4461lb;
            }

            /* renamed from: g */
            public void mo10306g(C0594d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f4461lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1853a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
        }

        /* renamed from: bf */
        public static C1852o m6379bf(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1852o)) ? new C1854a(iBinder) : (C1852o) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    mo10306g(C0594d.C0595a.m1741am(data.readStrongBinder()));
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

    /* renamed from: g */
    void mo10306g(C0594d dVar) throws RemoteException;
}
