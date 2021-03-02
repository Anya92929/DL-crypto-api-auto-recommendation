package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.fitness.FitnessStatusCodes;

/* renamed from: com.google.android.gms.internal.ic */
public interface C1306ic extends IInterface {

    /* renamed from: com.google.android.gms.internal.ic$a */
    public static abstract class C1307a extends Binder implements C1306ic {

        /* renamed from: com.google.android.gms.internal.ic$a$a */
        private static class C1308a implements C1306ic {

            /* renamed from: lb */
            private IBinder f3919lb;

            C1308a(IBinder iBinder) {
                this.f3919lb = iBinder;
            }

            /* renamed from: S */
            public void mo8795S(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    obtain.writeInt(i);
                    this.f3919lb.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8796a(int i, DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3919lb.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8797a(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3919lb.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3919lb;
            }

            /* renamed from: e */
            public void mo8798e(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f3919lb.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fq */
            public void mo8799fq() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    this.f3919lb.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1307a() {
            attachInterface(this, "com.google.android.gms.appstate.internal.IAppStateCallbacks");
        }

        /* renamed from: J */
        public static C1306ic m4888J(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1306ic)) ? new C1308a(iBinder) : (C1306ic) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DataHolder dataHolder = null;
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    int readInt = data.readInt();
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(data);
                    }
                    mo8796a(readInt, dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(data);
                    }
                    mo8797a(dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    mo8798e(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    mo8799fq();
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    mo8795S(data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: S */
    void mo8795S(int i) throws RemoteException;

    /* renamed from: a */
    void mo8796a(int i, DataHolder dataHolder) throws RemoteException;

    /* renamed from: a */
    void mo8797a(DataHolder dataHolder) throws RemoteException;

    /* renamed from: e */
    void mo8798e(int i, int i2) throws RemoteException;

    /* renamed from: fq */
    void mo8799fq() throws RemoteException;
}
