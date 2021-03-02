package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C1898f;

/* renamed from: com.google.android.gms.maps.internal.l */
public interface C1843l extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.l$a */
    public static abstract class C1844a extends Binder implements C1843l {

        /* renamed from: com.google.android.gms.maps.internal.l$a$a */
        private static class C1845a implements C1843l {

            /* renamed from: lb */
            private IBinder f4458lb;

            C1845a(IBinder iBinder) {
                this.f4458lb = iBinder;
            }

            /* renamed from: a */
            public boolean mo10299a(C1898f fVar) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.f4458lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4458lb;
            }
        }

        public C1844a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
        }

        /* renamed from: bc */
        public static C1843l m6368bc(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1843l)) ? new C1845a(iBinder) : (C1843l) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    boolean a = mo10299a(C1898f.C1899a.m6467bu(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(a ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    boolean mo10299a(C1898f fVar) throws RemoteException;
}
