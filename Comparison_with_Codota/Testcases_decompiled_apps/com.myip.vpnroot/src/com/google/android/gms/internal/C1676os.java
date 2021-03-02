package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C1682ou;
import com.google.android.gms.internal.C1685ov;
import com.google.android.gms.wallet.C2173d;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

/* renamed from: com.google.android.gms.internal.os */
public interface C1676os extends IInterface {

    /* renamed from: com.google.android.gms.internal.os$a */
    public static abstract class C1677a extends Binder implements C1676os {

        /* renamed from: com.google.android.gms.internal.os$a$a */
        private static class C1678a implements C1676os {

            /* renamed from: lb */
            private IBinder f4348lb;

            C1678a(IBinder iBinder) {
                this.f4348lb = iBinder;
            }

            /* renamed from: a */
            public void mo9959a(Bundle bundle, C1685ov ovVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ovVar != null) {
                        iBinder = ovVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4348lb.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9960a(C1666om omVar, Bundle bundle, C1685ov ovVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (omVar != null) {
                        obtain.writeInt(1);
                        omVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ovVar != null) {
                        iBinder = ovVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4348lb.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9961a(FullWalletRequest fullWalletRequest, Bundle bundle, C1685ov ovVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ovVar != null) {
                        iBinder = ovVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4348lb.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9962a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, C1682ou ouVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ouVar != null) {
                        iBinder = ouVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4348lb.transact(7, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9963a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, C1685ov ovVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ovVar != null) {
                        iBinder = ovVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4348lb.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9964a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4348lb.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9965a(C2173d dVar, Bundle bundle, C1685ov ovVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ovVar != null) {
                        iBinder = ovVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4348lb.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9966a(String str, String str2, Bundle bundle, C1685ov ovVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ovVar != null) {
                        iBinder = ovVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f4348lb.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4348lb;
            }

            /* renamed from: p */
            public void mo9967p(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4348lb.transact(9, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        /* renamed from: bL */
        public static C1676os m5867bL(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1676os)) ? new C1678a(iBinder) : (C1676os) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo9963a(data.readInt() != 0 ? MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1685ov.C1686a.m5888bO(data.readStrongBinder()));
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo9961a(data.readInt() != 0 ? FullWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1685ov.C1686a.m5888bO(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo9966a(data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1685ov.C1686a.m5888bO(data.readStrongBinder()));
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo9964a(data.readInt() != 0 ? NotifyTransactionStatusRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo9959a(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1685ov.C1686a.m5888bO(data.readStrongBinder()));
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo9965a(data.readInt() != 0 ? C2173d.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1685ov.C1686a.m5888bO(data.readStrongBinder()));
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo9962a(data.readInt() != 0 ? MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1682ou.C1683a.m5881bN(data.readStrongBinder()));
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo9960a(data.readInt() != 0 ? C1666om.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1685ov.C1686a.m5888bO(data.readStrongBinder()));
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo9967p(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9959a(Bundle bundle, C1685ov ovVar) throws RemoteException;

    /* renamed from: a */
    void mo9960a(C1666om omVar, Bundle bundle, C1685ov ovVar) throws RemoteException;

    /* renamed from: a */
    void mo9961a(FullWalletRequest fullWalletRequest, Bundle bundle, C1685ov ovVar) throws RemoteException;

    /* renamed from: a */
    void mo9962a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, C1682ou ouVar) throws RemoteException;

    /* renamed from: a */
    void mo9963a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, C1685ov ovVar) throws RemoteException;

    /* renamed from: a */
    void mo9964a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo9965a(C2173d dVar, Bundle bundle, C1685ov ovVar) throws RemoteException;

    /* renamed from: a */
    void mo9966a(String str, String str2, Bundle bundle, C1685ov ovVar) throws RemoteException;

    /* renamed from: p */
    void mo9967p(Bundle bundle) throws RemoteException;
}
