package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.internal.C1306ic;

/* renamed from: com.google.android.gms.internal.id */
public interface C1309id extends IInterface {

    /* renamed from: com.google.android.gms.internal.id$a */
    public static abstract class C1310a extends Binder implements C1309id {

        /* renamed from: com.google.android.gms.internal.id$a$a */
        private static class C1311a implements C1309id {

            /* renamed from: lb */
            private IBinder f3920lb;

            C1311a(IBinder iBinder) {
                this.f3920lb = iBinder;
            }

            /* renamed from: a */
            public void mo8812a(C1306ic icVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    this.f3920lb.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8813a(C1306ic icVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f3920lb.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8814a(C1306ic icVar, int i, String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.f3920lb.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8815a(C1306ic icVar, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.f3920lb.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3920lb;
            }

            /* renamed from: b */
            public void mo8816b(C1306ic icVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    this.f3920lb.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo8817b(C1306ic icVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f3920lb.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo8818c(C1306ic icVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    obtain.writeStrongBinder(icVar != null ? icVar.asBinder() : null);
                    this.f3920lb.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fr */
            public int mo8819fr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.f3920lb.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fs */
            public int mo8820fs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
                    this.f3920lb.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: K */
        public static C1309id m4903K(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1309id)) ? new C1311a(iBinder) : (C1309id) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int fr = mo8819fr();
                    reply.writeNoException();
                    reply.writeInt(fr);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    int fs = mo8820fs();
                    reply.writeNoException();
                    reply.writeInt(fs);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo8815a(C1306ic.C1307a.m4888J(data.readStrongBinder()), data.readInt(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo8813a(C1306ic.C1307a.m4888J(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo8812a(C1306ic.C1307a.m4888J(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo8814a(C1306ic.C1307a.m4888J(data.readStrongBinder()), data.readInt(), data.readString(), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo8817b(C1306ic.C1307a.m4888J(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo8816b(C1306ic.C1307a.m4888J(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
                    mo8818c(C1306ic.C1307a.m4888J(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo8812a(C1306ic icVar) throws RemoteException;

    /* renamed from: a */
    void mo8813a(C1306ic icVar, int i) throws RemoteException;

    /* renamed from: a */
    void mo8814a(C1306ic icVar, int i, String str, byte[] bArr) throws RemoteException;

    /* renamed from: a */
    void mo8815a(C1306ic icVar, int i, byte[] bArr) throws RemoteException;

    /* renamed from: b */
    void mo8816b(C1306ic icVar) throws RemoteException;

    /* renamed from: b */
    void mo8817b(C1306ic icVar, int i) throws RemoteException;

    /* renamed from: c */
    void mo8818c(C1306ic icVar) throws RemoteException;

    /* renamed from: fr */
    int mo8819fr() throws RemoteException;

    /* renamed from: fs */
    int mo8820fs() throws RemoteException;
}
