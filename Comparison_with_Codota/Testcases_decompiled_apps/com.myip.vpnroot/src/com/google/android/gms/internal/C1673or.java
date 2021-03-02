package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.or */
public interface C1673or extends IInterface {

    /* renamed from: com.google.android.gms.internal.or$a */
    public static abstract class C1674a extends Binder implements C1673or {

        /* renamed from: com.google.android.gms.internal.or$a$a */
        private static class C1675a implements C1673or {

            /* renamed from: lb */
            private IBinder f4347lb;

            C1675a(IBinder iBinder) {
                this.f4347lb = iBinder;
            }

            /* renamed from: a */
            public void mo9955a(int i, int i2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4347lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4347lb;
            }
        }

        public C1674a() {
            attachInterface(this, "com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
        }

        /* renamed from: bK */
        public static C1673or m5856bK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1673or)) ? new C1675a(iBinder) : (C1673or) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
                    mo9955a(data.readInt(), data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.fragment.internal.IWalletFragmentStateListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9955a(int i, int i2, Bundle bundle) throws RemoteException;
}
