package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;

/* renamed from: com.google.android.gms.internal.dt */
public interface C1074dt extends IInterface {

    /* renamed from: com.google.android.gms.internal.dt$a */
    public static abstract class C1075a extends Binder implements C1074dt {

        /* renamed from: com.google.android.gms.internal.dt$a$a */
        private static class C1076a implements C1074dt {

            /* renamed from: lb */
            private IBinder f3204lb;

            C1076a(IBinder iBinder) {
                this.f3204lb = iBinder;
            }

            /* renamed from: a */
            public IBinder mo8366a(C0594d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f3204lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3204lb;
            }
        }

        /* renamed from: q */
        public static C1074dt m4283q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1074dt)) ? new C1076a(iBinder) : (C1074dt) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    IBinder a = mo8366a(C0594d.C0595a.m1741am(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    IBinder mo8366a(C0594d dVar) throws RemoteException;
}
