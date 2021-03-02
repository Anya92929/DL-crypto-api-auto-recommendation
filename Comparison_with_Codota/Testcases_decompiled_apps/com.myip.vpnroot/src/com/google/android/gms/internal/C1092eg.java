package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.eg */
public interface C1092eg extends IInterface {

    /* renamed from: com.google.android.gms.internal.eg$a */
    public static abstract class C1093a extends Binder implements C1092eg {

        /* renamed from: com.google.android.gms.internal.eg$a$a */
        private static class C1094a implements C1092eg {

            /* renamed from: lb */
            private IBinder f3247lb;

            C1094a(IBinder iBinder) {
                this.f3247lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f3247lb;
            }

            public String getProductId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    this.f3247lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void recordPlayBillingResolution(int billingResponseCode) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    obtain.writeInt(billingResponseCode);
                    this.f3247lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void recordResolution(int resolution) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    obtain.writeInt(resolution);
                    this.f3247lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1093a() {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        }

        /* renamed from: s */
        public static C1092eg m4331s(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1092eg)) ? new C1094a(iBinder) : (C1092eg) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    String productId = getProductId();
                    reply.writeNoException();
                    reply.writeString(productId);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    recordResolution(data.readInt());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    recordPlayBillingResolution(data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String getProductId() throws RemoteException;

    void recordPlayBillingResolution(int i) throws RemoteException;

    void recordResolution(int i) throws RemoteException;
}
