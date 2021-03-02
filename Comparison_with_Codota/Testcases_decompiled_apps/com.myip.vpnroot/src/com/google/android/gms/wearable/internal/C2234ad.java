package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.wearable.internal.ad */
public interface C2234ad extends IInterface {

    /* renamed from: com.google.android.gms.wearable.internal.ad$a */
    public static abstract class C2235a extends Binder implements C2234ad {

        /* renamed from: com.google.android.gms.wearable.internal.ad$a$a */
        private static class C2236a implements C2234ad {

            /* renamed from: lb */
            private IBinder f4665lb;

            C2236a(IBinder iBinder) {
                this.f4665lb = iBinder;
            }

            /* renamed from: a */
            public void mo12326a(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12327a(C2232ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12328a(C2261ao aoVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (aoVar != null) {
                        obtain.writeInt(1);
                        aoVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12329a(C2265as asVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (asVar != null) {
                        obtain.writeInt(1);
                        asVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12330a(C2267au auVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (auVar != null) {
                        obtain.writeInt(1);
                        auVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12331a(C2312p pVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (pVar != null) {
                        obtain.writeInt(1);
                        pVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12332a(C2314r rVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (rVar != null) {
                        obtain.writeInt(1);
                        rVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12333a(C2316t tVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (tVar != null) {
                        obtain.writeInt(1);
                        tVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12334a(C2318v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (vVar != null) {
                        obtain.writeInt(1);
                        vVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12335a(C2320x xVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (xVar != null) {
                        obtain.writeInt(1);
                        xVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12336a(C2322z zVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (zVar != null) {
                        obtain.writeInt(1);
                        zVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aa */
            public void mo12337aa(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4665lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4665lb;
            }
        }

        public C2235a() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
        }

        /* renamed from: bR */
        public static C2234ad m7521bR(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2234ad)) ? new C2236a(iBinder) : (C2234ad) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.wearable.internal.au} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.google.android.gms.wearable.internal.v} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: com.google.android.gms.wearable.internal.ab} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: com.google.android.gms.wearable.internal.z} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: com.google.android.gms.wearable.internal.as} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: com.google.android.gms.wearable.internal.p} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: com.google.android.gms.wearable.internal.x} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: com.google.android.gms.wearable.internal.ao} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: com.google.android.gms.wearable.internal.t} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: com.google.android.gms.wearable.internal.r} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v62 */
        /* JADX WARNING: type inference failed for: r0v63 */
        /* JADX WARNING: type inference failed for: r0v64 */
        /* JADX WARNING: type inference failed for: r0v65 */
        /* JADX WARNING: type inference failed for: r0v66 */
        /* JADX WARNING: type inference failed for: r0v67 */
        /* JADX WARNING: type inference failed for: r0v68 */
        /* JADX WARNING: type inference failed for: r0v69 */
        /* JADX WARNING: type inference failed for: r0v70 */
        /* JADX WARNING: type inference failed for: r0v71 */
        /* JADX WARNING: type inference failed for: r0v72 */
        /* JADX WARNING: type inference failed for: r0v73 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 2: goto L_0x0011;
                    case 3: goto L_0x0047;
                    case 4: goto L_0x0062;
                    case 5: goto L_0x007d;
                    case 6: goto L_0x0097;
                    case 7: goto L_0x00b3;
                    case 8: goto L_0x00cf;
                    case 9: goto L_0x00eb;
                    case 10: goto L_0x0107;
                    case 11: goto L_0x0123;
                    case 12: goto L_0x013d;
                    case 13: goto L_0x002c;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.r> r0 = com.google.android.gms.wearable.internal.C2314r.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.r r0 = (com.google.android.gms.wearable.internal.C2314r) r0
            L_0x0024:
                r3.mo12332a((com.google.android.gms.wearable.internal.C2314r) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x002c:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003f
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.t> r0 = com.google.android.gms.wearable.internal.C2316t.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.t r0 = (com.google.android.gms.wearable.internal.C2316t) r0
            L_0x003f:
                r3.mo12333a((com.google.android.gms.wearable.internal.C2316t) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0047:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x005a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.ao> r0 = com.google.android.gms.wearable.internal.C2261ao.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.ao r0 = (com.google.android.gms.wearable.internal.C2261ao) r0
            L_0x005a:
                r3.mo12328a((com.google.android.gms.wearable.internal.C2261ao) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0062:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0075
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.x> r0 = com.google.android.gms.wearable.internal.C2320x.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.x r0 = (com.google.android.gms.wearable.internal.C2320x) r0
            L_0x0075:
                r3.mo12335a((com.google.android.gms.wearable.internal.C2320x) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x007d:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x008e
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r5)
            L_0x008e:
                r3.mo12337aa(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0097:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00aa
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.p> r0 = com.google.android.gms.wearable.internal.C2312p.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.p r0 = (com.google.android.gms.wearable.internal.C2312p) r0
            L_0x00aa:
                r3.mo12331a((com.google.android.gms.wearable.internal.C2312p) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00b3:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00c6
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.as> r0 = com.google.android.gms.wearable.internal.C2265as.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.as r0 = (com.google.android.gms.wearable.internal.C2265as) r0
            L_0x00c6:
                r3.mo12329a((com.google.android.gms.wearable.internal.C2265as) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00cf:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00e2
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.z> r0 = com.google.android.gms.wearable.internal.C2322z.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.z r0 = (com.google.android.gms.wearable.internal.C2322z) r0
            L_0x00e2:
                r3.mo12336a((com.google.android.gms.wearable.internal.C2322z) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00eb:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00fe
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.ab> r0 = com.google.android.gms.wearable.internal.C2232ab.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.ab r0 = (com.google.android.gms.wearable.internal.C2232ab) r0
            L_0x00fe:
                r3.mo12327a((com.google.android.gms.wearable.internal.C2232ab) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0107:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x011a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.v> r0 = com.google.android.gms.wearable.internal.C2318v.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.v r0 = (com.google.android.gms.wearable.internal.C2318v) r0
            L_0x011a:
                r3.mo12334a((com.google.android.gms.wearable.internal.C2318v) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0123:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0134
                com.google.android.gms.common.api.StatusCreator r0 = com.google.android.gms.common.api.Status.CREATOR
                com.google.android.gms.common.api.Status r0 = r0.createFromParcel((android.os.Parcel) r5)
            L_0x0134:
                r3.mo12326a((com.google.android.gms.common.api.Status) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x013d:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0150
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.au> r0 = com.google.android.gms.wearable.internal.C2267au.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.au r0 = (com.google.android.gms.wearable.internal.C2267au) r0
            L_0x0150:
                r3.mo12330a((com.google.android.gms.wearable.internal.C2267au) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.C2234ad.C2235a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo12326a(Status status) throws RemoteException;

    /* renamed from: a */
    void mo12327a(C2232ab abVar) throws RemoteException;

    /* renamed from: a */
    void mo12328a(C2261ao aoVar) throws RemoteException;

    /* renamed from: a */
    void mo12329a(C2265as asVar) throws RemoteException;

    /* renamed from: a */
    void mo12330a(C2267au auVar) throws RemoteException;

    /* renamed from: a */
    void mo12331a(C2312p pVar) throws RemoteException;

    /* renamed from: a */
    void mo12332a(C2314r rVar) throws RemoteException;

    /* renamed from: a */
    void mo12333a(C2316t tVar) throws RemoteException;

    /* renamed from: a */
    void mo12334a(C2318v vVar) throws RemoteException;

    /* renamed from: a */
    void mo12335a(C2320x xVar) throws RemoteException;

    /* renamed from: a */
    void mo12336a(C2322z zVar) throws RemoteException;

    /* renamed from: aa */
    void mo12337aa(DataHolder dataHolder) throws RemoteException;
}
