package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.fitness.FitnessStatusCodes;

public interface IGamesSignInCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IGamesSignInCallbacks {

        private static class Proxy implements IGamesSignInCallbacks {

            /* renamed from: lb */
            private IBinder f1937lb;

            Proxy(IBinder remote) {
                this.f1937lb = remote;
            }

            /* renamed from: T */
            public void mo6979T(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1937lb.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: U */
            public void mo6980U(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1937lb.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1937lb;
            }

            /* renamed from: b */
            public void mo6981b(int i, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1937lb.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: dD */
            public void mo6982dD(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    this.f1937lb.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: dE */
            public void mo6983dE(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    this.f1937lb.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo6984g(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1937lb.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInCallbacks");
        }

        /* renamed from: aC */
        public static IGamesSignInCallbacks m3073aC(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesSignInCallbacks)) ? new Proxy(iBinder) : (IGamesSignInCallbacks) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v19, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r0v27 */
        /* JADX WARNING: type inference failed for: r0v28 */
        /* JADX WARNING: type inference failed for: r0v29 */
        /* JADX WARNING: type inference failed for: r0v30 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 5001: goto L_0x0011;
                    case 5002: goto L_0x0030;
                    case 5003: goto L_0x0049;
                    case 5004: goto L_0x0062;
                    case 5005: goto L_0x0073;
                    case 5006: goto L_0x008d;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesSignInCallbacks"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.games.internal.IGamesSignInCallbacks"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0028
                android.os.Parcelable$Creator r0 = android.content.Intent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x0028:
                r4.mo6981b(r2, r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0030:
                java.lang.String r2 = "com.google.android.gms.games.internal.IGamesSignInCallbacks"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0041
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r6)
            L_0x0041:
                r4.mo6979T(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0049:
                java.lang.String r2 = "com.google.android.gms.games.internal.IGamesSignInCallbacks"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x005a
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r6)
            L_0x005a:
                r4.mo6980U(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0062:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesSignInCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                r4.mo6982dD(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0073:
                java.lang.String r2 = "com.google.android.gms.games.internal.IGamesSignInCallbacks"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0084
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r6)
            L_0x0084:
                r4.mo6984g(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x008d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesSignInCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                r4.mo6983dE(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.IGamesSignInCallbacks.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: T */
    void mo6979T(DataHolder dataHolder) throws RemoteException;

    /* renamed from: U */
    void mo6980U(DataHolder dataHolder) throws RemoteException;

    /* renamed from: b */
    void mo6981b(int i, Intent intent) throws RemoteException;

    /* renamed from: dD */
    void mo6982dD(int i) throws RemoteException;

    /* renamed from: dE */
    void mo6983dE(int i) throws RemoteException;

    /* renamed from: g */
    void mo6984g(DataHolder dataHolder) throws RemoteException;
}
