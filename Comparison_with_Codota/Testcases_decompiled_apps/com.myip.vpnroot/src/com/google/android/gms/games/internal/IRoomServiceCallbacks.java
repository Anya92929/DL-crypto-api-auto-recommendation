package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.myip.vpnroot.OrderActivity;

public interface IRoomServiceCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IRoomServiceCallbacks {

        private static class Proxy implements IRoomServiceCallbacks {

            /* renamed from: lb */
            private IBinder f1940lb;

            Proxy(IBinder remote) {
                this.f1940lb = remote;
            }

            /* renamed from: a */
            public void mo7015a(ParcelFileDescriptor parcelFileDescriptor, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f1940lb.transact(1024, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7016a(ConnectionInfo connectionInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (connectionInfo != null) {
                        obtain.writeInt(1);
                        connectionInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1940lb.transact(1022, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7017a(String str, byte[] bArr, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    this.f1940lb.transact(1002, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7018a(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1940lb.transact(1008, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: aD */
            public void mo7019aD(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeStrongBinder(iBinder);
                    this.f1940lb.transact(1021, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1940lb;
            }

            /* renamed from: b */
            public void mo7020b(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1940lb.transact(1009, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: bM */
            public void mo7021bM(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.f1940lb.transact(1003, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: bN */
            public void mo7022bN(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.f1940lb.transact(1004, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: bO */
            public void mo7023bO(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.f1940lb.transact(1005, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: bP */
            public void mo7024bP(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.f1940lb.transact(OrderActivity.REQUEST_CODE_RESOLVE_ADDRESS_LOOKUP, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: bQ */
            public void mo7025bQ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.f1940lb.transact(OrderActivity.REQUEST_CODE_RESOLVE_ERR, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: bR */
            public void mo7026bR(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.f1940lb.transact(1019, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo7027c(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.f1940lb.transact(1001, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo7028c(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.f1940lb.transact(1018, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo7029c(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1940lb.transact(1010, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo7030d(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1940lb.transact(1011, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: dF */
            public void mo7031dF(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    this.f1940lb.transact(1020, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo7032e(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1940lb.transact(1012, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo7033f(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1940lb.transact(1013, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo7034g(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1940lb.transact(1017, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo7035i(String str, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f1940lb.transact(1026, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: kH */
            public void mo7036kH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.f1940lb.transact(1016, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: kI */
            public void mo7037kI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.f1940lb.transact(1023, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(participantId);
                    this.f1940lb.transact(1014, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(participantId);
                    this.f1940lb.transact(1015, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: v */
            public void mo7040v(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1940lb.transact(1025, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
        }

        /* renamed from: aE */
        public static IRoomServiceCallbacks m3152aE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRoomServiceCallbacks)) ? new Proxy(iBinder) : (IRoomServiceCallbacks) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.os.ParcelFileDescriptor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.google.android.gms.games.internal.ConnectionInfo} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v58 */
        /* JADX WARNING: type inference failed for: r0v59 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1001: goto L_0x0010;
                    case 1002: goto L_0x0025;
                    case 1003: goto L_0x003a;
                    case 1004: goto L_0x0047;
                    case 1005: goto L_0x0054;
                    case 1006: goto L_0x0061;
                    case 1007: goto L_0x006e;
                    case 1008: goto L_0x007b;
                    case 1009: goto L_0x008d;
                    case 1010: goto L_0x009f;
                    case 1011: goto L_0x00b1;
                    case 1012: goto L_0x00c3;
                    case 1013: goto L_0x00d5;
                    case 1014: goto L_0x00e7;
                    case 1015: goto L_0x00f5;
                    case 1016: goto L_0x0103;
                    case 1017: goto L_0x010d;
                    case 1018: goto L_0x011f;
                    case 1019: goto L_0x0131;
                    case 1020: goto L_0x013f;
                    case 1021: goto L_0x014d;
                    case 1022: goto L_0x015b;
                    case 1023: goto L_0x0171;
                    case 1024: goto L_0x017b;
                    case 1025: goto L_0x0197;
                    case 1026: goto L_0x01a9;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r1 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r1
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r7.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                int r2 = r6.readInt()
                java.lang.String r3 = r6.readString()
                r4.mo7027c(r0, r2, r3)
                goto L_0x0009
            L_0x0025:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                byte[] r2 = r6.createByteArray()
                int r3 = r6.readInt()
                r4.mo7017a(r0, r2, r3)
                goto L_0x0009
            L_0x003a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.mo7021bM(r0)
                goto L_0x0009
            L_0x0047:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.mo7022bN(r0)
                goto L_0x0009
            L_0x0054:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.mo7023bO(r0)
                goto L_0x0009
            L_0x0061:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.mo7024bP(r0)
                goto L_0x0009
            L_0x006e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.mo7025bQ(r0)
                goto L_0x0009
            L_0x007b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                java.lang.String[] r2 = r6.createStringArray()
                r4.mo7018a((java.lang.String) r0, (java.lang.String[]) r2)
                goto L_0x0009
            L_0x008d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                java.lang.String[] r2 = r6.createStringArray()
                r4.mo7020b(r0, r2)
                goto L_0x0009
            L_0x009f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                java.lang.String[] r2 = r6.createStringArray()
                r4.mo7029c((java.lang.String) r0, (java.lang.String[]) r2)
                goto L_0x0009
            L_0x00b1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                java.lang.String[] r2 = r6.createStringArray()
                r4.mo7030d(r0, r2)
                goto L_0x0009
            L_0x00c3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                java.lang.String[] r2 = r6.createStringArray()
                r4.mo7032e(r0, r2)
                goto L_0x0009
            L_0x00d5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                java.lang.String[] r2 = r6.createStringArray()
                r4.mo7033f(r0, r2)
                goto L_0x0009
            L_0x00e7:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.onP2PConnected(r0)
                goto L_0x0009
            L_0x00f5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.onP2PDisconnected(r0)
                goto L_0x0009
            L_0x0103:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                r4.mo7036kH()
                goto L_0x0009
            L_0x010d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                java.lang.String[] r2 = r6.createStringArray()
                r4.mo7034g(r0, r2)
                goto L_0x0009
            L_0x011f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                byte[] r2 = r6.createByteArray()
                r4.mo7028c((java.lang.String) r0, (byte[]) r2)
                goto L_0x0009
            L_0x0131:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.mo7026bR(r0)
                goto L_0x0009
            L_0x013f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                r4.mo7031dF(r0)
                goto L_0x0009
            L_0x014d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                r4.mo7019aD(r0)
                goto L_0x0009
            L_0x015b:
                java.lang.String r2 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x016c
                com.google.android.gms.games.internal.ConnectionInfoCreator r0 = com.google.android.gms.games.internal.ConnectionInfo.CREATOR
                com.google.android.gms.games.internal.ConnectionInfo r0 = r0.createFromParcel(r6)
            L_0x016c:
                r4.mo7016a(r0)
                goto L_0x0009
            L_0x0171:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                r4.mo7037kI()
                goto L_0x0009
            L_0x017b:
                java.lang.String r2 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x018e
                android.os.Parcelable$Creator r0 = android.os.ParcelFileDescriptor.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                android.os.ParcelFileDescriptor r0 = (android.os.ParcelFileDescriptor) r0
            L_0x018e:
                int r2 = r6.readInt()
                r4.mo7015a((android.os.ParcelFileDescriptor) r0, (int) r2)
                goto L_0x0009
            L_0x0197:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                int r2 = r6.readInt()
                r4.mo7040v(r0, r2)
                goto L_0x0009
            L_0x01a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IRoomServiceCallbacks"
                r6.enforceInterface(r0)
                java.lang.String r2 = r6.readString()
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x01be
                r0 = r1
            L_0x01b9:
                r4.mo7035i(r2, r0)
                goto L_0x0009
            L_0x01be:
                r0 = 0
                goto L_0x01b9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.IRoomServiceCallbacks.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo7015a(ParcelFileDescriptor parcelFileDescriptor, int i) throws RemoteException;

    /* renamed from: a */
    void mo7016a(ConnectionInfo connectionInfo) throws RemoteException;

    /* renamed from: a */
    void mo7017a(String str, byte[] bArr, int i) throws RemoteException;

    /* renamed from: a */
    void mo7018a(String str, String[] strArr) throws RemoteException;

    /* renamed from: aD */
    void mo7019aD(IBinder iBinder) throws RemoteException;

    /* renamed from: b */
    void mo7020b(String str, String[] strArr) throws RemoteException;

    /* renamed from: bM */
    void mo7021bM(String str) throws RemoteException;

    /* renamed from: bN */
    void mo7022bN(String str) throws RemoteException;

    /* renamed from: bO */
    void mo7023bO(String str) throws RemoteException;

    /* renamed from: bP */
    void mo7024bP(String str) throws RemoteException;

    /* renamed from: bQ */
    void mo7025bQ(String str) throws RemoteException;

    /* renamed from: bR */
    void mo7026bR(String str) throws RemoteException;

    /* renamed from: c */
    void mo7027c(int i, int i2, String str) throws RemoteException;

    /* renamed from: c */
    void mo7028c(String str, byte[] bArr) throws RemoteException;

    /* renamed from: c */
    void mo7029c(String str, String[] strArr) throws RemoteException;

    /* renamed from: d */
    void mo7030d(String str, String[] strArr) throws RemoteException;

    /* renamed from: dF */
    void mo7031dF(int i) throws RemoteException;

    /* renamed from: e */
    void mo7032e(String str, String[] strArr) throws RemoteException;

    /* renamed from: f */
    void mo7033f(String str, String[] strArr) throws RemoteException;

    /* renamed from: g */
    void mo7034g(String str, String[] strArr) throws RemoteException;

    /* renamed from: i */
    void mo7035i(String str, boolean z) throws RemoteException;

    /* renamed from: kH */
    void mo7036kH() throws RemoteException;

    /* renamed from: kI */
    void mo7037kI() throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    /* renamed from: v */
    void mo7040v(String str, int i) throws RemoteException;
}
