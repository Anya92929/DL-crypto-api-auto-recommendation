package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0591c;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.internal.C1670oq;
import com.google.android.gms.internal.C1673or;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

/* renamed from: com.google.android.gms.internal.ot */
public interface C1679ot extends IInterface {

    /* renamed from: com.google.android.gms.internal.ot$a */
    public static abstract class C1680a extends Binder implements C1679ot {

        /* renamed from: com.google.android.gms.internal.ot$a$a */
        private static class C1681a implements C1679ot {

            /* renamed from: lb */
            private IBinder f4349lb;

            C1681a(IBinder iBinder) {
                this.f4349lb = iBinder;
            }

            /* renamed from: a */
            public C1670oq mo9970a(C0594d dVar, C0591c cVar, WalletFragmentOptions walletFragmentOptions, C1673or orVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (orVar != null) {
                        iBinder = orVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4349lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C1670oq.C1671a.m5853bJ(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4349lb;
            }
        }

        /* renamed from: bM */
        public static C1679ot m5878bM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1679ot)) ? new C1681a(iBinder) : (C1679ot) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    C1670oq a = mo9970a(C0594d.C0595a.m1741am(data.readStrongBinder()), C0591c.C0592a.m1734al(data.readStrongBinder()), data.readInt() != 0 ? WalletFragmentOptions.CREATOR.createFromParcel(data) : null, C1673or.C1674a.m5856bK(data.readStrongBinder()));
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    C1670oq mo9970a(C0594d dVar, C0591c cVar, WalletFragmentOptions walletFragmentOptions, C1673or orVar) throws RemoteException;
}
