package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;

/* renamed from: com.google.android.gms.internal.ej */
public interface C1101ej extends IInterface {

    /* renamed from: com.google.android.gms.internal.ej$a */
    public static abstract class C1102a extends Binder implements C1101ej {

        /* renamed from: com.google.android.gms.internal.ej$a$a */
        private static class C1103a implements C1101ej {

            /* renamed from: lb */
            private IBinder f3250lb;

            C1103a(IBinder iBinder) {
                this.f3250lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f3250lb;
            }

            /* renamed from: b */
            public IBinder mo8429b(C0594d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f3250lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: v */
        public static C1101ej m4337v(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1101ej)) ? new C1103a(iBinder) : (C1101ej) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    IBinder b = mo8429b(C0594d.C0595a.m1741am(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeStrongBinder(b);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    IBinder mo8429b(C0594d dVar) throws RemoteException;
}
