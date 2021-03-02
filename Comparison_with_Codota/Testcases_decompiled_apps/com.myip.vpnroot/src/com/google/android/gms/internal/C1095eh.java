package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C1092eg;

/* renamed from: com.google.android.gms.internal.eh */
public interface C1095eh extends IInterface {

    /* renamed from: com.google.android.gms.internal.eh$a */
    public static abstract class C1096a extends Binder implements C1095eh {

        /* renamed from: com.google.android.gms.internal.eh$a$a */
        private static class C1097a implements C1095eh {

            /* renamed from: lb */
            private IBinder f3248lb;

            C1097a(IBinder iBinder) {
                this.f3248lb = iBinder;
            }

            /* renamed from: a */
            public void mo8422a(C1092eg egVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    obtain.writeStrongBinder(egVar != null ? egVar.asBinder() : null);
                    this.f3248lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3248lb;
            }
        }

        public C1096a() {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        }

        /* renamed from: t */
        public static C1095eh m4333t(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1095eh)) ? new C1097a(iBinder) : (C1095eh) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    mo8422a(C1092eg.C1093a.m4331s(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo8422a(C1092eg egVar) throws RemoteException;
}
