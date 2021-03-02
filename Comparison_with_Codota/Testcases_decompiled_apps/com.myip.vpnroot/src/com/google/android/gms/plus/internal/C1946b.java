package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.C1380jp;
import com.google.android.gms.internal.C1639ny;

/* renamed from: com.google.android.gms.plus.internal.b */
public interface C1946b extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.b$a */
    public static abstract class C1947a extends Binder implements C1946b {

        /* renamed from: com.google.android.gms.plus.internal.b$a$a */
        private static class C1948a implements C1946b {

            /* renamed from: lb */
            private IBinder f4500lb;

            C1948a(IBinder iBinder) {
                this.f4500lb = iBinder;
            }

            /* renamed from: a */
            public void mo11313a(int i, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4500lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11314a(int i, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4500lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11315a(int i, Bundle bundle, C1380jp jpVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jpVar != null) {
                        obtain.writeInt(1);
                        jpVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4500lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11316a(int i, C1639ny nyVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (nyVar != null) {
                        obtain.writeInt(1);
                        nyVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4500lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11317a(DataHolder dataHolder, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f4500lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11318a(DataHolder dataHolder, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f4500lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aB */
            public void mo11319aB(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4500lb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4500lb;
            }

            /* renamed from: cb */
            public void mo11320cb(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeString(str);
                    this.f4500lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: cc */
            public void mo11321cc(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeString(str);
                    this.f4500lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo11322h(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4500lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1947a() {
            attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
        }

        /* renamed from: bE */
        public static C1946b m6564bE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1946b)) ? new C1948a(iBinder) : (C1946b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.google.android.gms.internal.ny} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.google.android.gms.internal.jp} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r2v12 */
        /* JADX WARNING: type inference failed for: r2v13 */
        /* JADX WARNING: type inference failed for: r2v14 */
        /* JADX WARNING: type inference failed for: r2v15 */
        /* JADX WARNING: type inference failed for: r2v16 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r2 = 0
                r3 = 1
                switch(r6) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0043;
                    case 3: goto L_0x0075;
                    case 4: goto L_0x0086;
                    case 5: goto L_0x00a4;
                    case 6: goto L_0x00d2;
                    case 7: goto L_0x00f4;
                    case 8: goto L_0x0116;
                    case 9: goto L_0x0128;
                    case 10: goto L_0x0146;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r8.writeString(r0)
                r0 = r3
                goto L_0x0009
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                int r4 = r7.readInt()
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x003f
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r1 = r0
            L_0x0029:
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0041
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0037:
                r5.mo11313a((int) r4, (android.os.Bundle) r1, (android.os.Bundle) r0)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x003f:
                r1 = r2
                goto L_0x0029
            L_0x0041:
                r0 = r2
                goto L_0x0037
            L_0x0043:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                int r4 = r7.readInt()
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0071
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r1 = r0
            L_0x005b:
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0073
                android.os.Parcelable$Creator r0 = android.os.ParcelFileDescriptor.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.os.ParcelFileDescriptor r0 = (android.os.ParcelFileDescriptor) r0
            L_0x0069:
                r5.mo11314a((int) r4, (android.os.Bundle) r1, (android.os.ParcelFileDescriptor) r0)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x0071:
                r1 = r2
                goto L_0x005b
            L_0x0073:
                r0 = r2
                goto L_0x0069
            L_0x0075:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                r5.mo11320cb(r0)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x0086:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0097
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r2 = r0.createFromParcel(r7)
            L_0x0097:
                java.lang.String r0 = r7.readString()
                r5.mo11317a((com.google.android.gms.common.data.DataHolder) r2, (java.lang.String) r0)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x00a4:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                int r1 = r7.readInt()
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x00d0
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00bb:
                int r4 = r7.readInt()
                if (r4 == 0) goto L_0x00c7
                com.google.android.gms.internal.jq r2 = com.google.android.gms.internal.C1380jp.CREATOR
                com.google.android.gms.internal.jp r2 = r2.createFromParcel(r7)
            L_0x00c7:
                r5.mo11315a((int) r1, (android.os.Bundle) r0, (com.google.android.gms.internal.C1380jp) r2)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x00d0:
                r0 = r2
                goto L_0x00bb
            L_0x00d2:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x00e3
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r2 = r0.createFromParcel(r7)
            L_0x00e3:
                java.lang.String r0 = r7.readString()
                java.lang.String r1 = r7.readString()
                r5.mo11318a((com.google.android.gms.common.data.DataHolder) r2, (java.lang.String) r0, (java.lang.String) r1)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x00f4:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                int r1 = r7.readInt()
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0114
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x010b:
                r5.mo11322h(r1, r0)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x0114:
                r0 = r2
                goto L_0x010b
            L_0x0116:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                r5.mo11321cc(r0)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x0128:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                int r0 = r7.readInt()
                int r1 = r7.readInt()
                if (r1 == 0) goto L_0x013d
                com.google.android.gms.internal.nz r1 = com.google.android.gms.internal.C1639ny.CREATOR
                com.google.android.gms.internal.ny r2 = r1.createFromParcel(r7)
            L_0x013d:
                r5.mo11316a((int) r0, (com.google.android.gms.internal.C1639ny) r2)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x0146:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0157
                com.google.android.gms.common.api.StatusCreator r0 = com.google.android.gms.common.api.Status.CREATOR
                com.google.android.gms.common.api.Status r2 = r0.createFromParcel((android.os.Parcel) r7)
            L_0x0157:
                r5.mo11319aB(r2)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.plus.internal.C1946b.C1947a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo11313a(int i, Bundle bundle, Bundle bundle2) throws RemoteException;

    /* renamed from: a */
    void mo11314a(int i, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    /* renamed from: a */
    void mo11315a(int i, Bundle bundle, C1380jp jpVar) throws RemoteException;

    /* renamed from: a */
    void mo11316a(int i, C1639ny nyVar) throws RemoteException;

    /* renamed from: a */
    void mo11317a(DataHolder dataHolder, String str) throws RemoteException;

    /* renamed from: a */
    void mo11318a(DataHolder dataHolder, String str, String str2) throws RemoteException;

    /* renamed from: aB */
    void mo11319aB(Status status) throws RemoteException;

    /* renamed from: cb */
    void mo11320cb(String str) throws RemoteException;

    /* renamed from: cc */
    void mo11321cc(String str) throws RemoteException;

    /* renamed from: h */
    void mo11322h(int i, Bundle bundle) throws RemoteException;
}
