package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.C2227c;
import com.google.android.gms.wearable.PutDataRequest;

/* renamed from: com.google.android.gms.wearable.internal.af */
public interface C2240af extends IInterface {

    /* renamed from: com.google.android.gms.wearable.internal.af$a */
    public static abstract class C2241a extends Binder implements C2240af {

        /* renamed from: com.google.android.gms.wearable.internal.af$a$a */
        private static class C2242a implements C2240af {

            /* renamed from: lb */
            private IBinder f4667lb;

            C2242a(IBinder iBinder) {
                this.f4667lb = iBinder;
            }

            /* renamed from: a */
            public void mo12354a(C2234ad adVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    this.f4667lb.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12355a(C2234ad adVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4667lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12356a(C2234ad adVar, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4667lb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12357a(C2234ad adVar, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4667lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12358a(C2234ad adVar, C2227c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4667lb.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12359a(C2234ad adVar, C2263aq aqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    if (aqVar != null) {
                        obtain.writeInt(1);
                        aqVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4667lb.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12360a(C2234ad adVar, C2286b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4667lb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12361a(C2234ad adVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4667lb.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12362a(C2234ad adVar, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.f4667lb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4667lb;
            }

            /* renamed from: b */
            public void mo12363b(C2234ad adVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    this.f4667lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12364b(C2234ad adVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4667lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12365b(C2234ad adVar, C2227c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4667lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo12366b(C2234ad adVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4667lb.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12367c(C2234ad adVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    this.f4667lb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12368c(C2234ad adVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4667lb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo12369c(C2234ad adVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4667lb.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo12370d(C2234ad adVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    this.f4667lb.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo12371e(C2234ad adVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    this.f4667lb.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo12372f(C2234ad adVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    this.f4667lb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo12373g(C2234ad adVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    this.f4667lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo12374h(C2234ad adVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    this.f4667lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo12375i(C2234ad adVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    this.f4667lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: bT */
        public static C2240af m7565bT(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2240af)) ? new C2242a(iBinder) : (C2240af) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.google.android.gms.wearable.c} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: com.google.android.gms.wearable.internal.aq} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: com.google.android.gms.wearable.internal.b} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: com.google.android.gms.wearable.Asset} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v58, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v72, resolved type: com.google.android.gms.wearable.PutDataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v93, resolved type: com.google.android.gms.wearable.c} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v101 */
        /* JADX WARNING: type inference failed for: r0v102 */
        /* JADX WARNING: type inference failed for: r0v103 */
        /* JADX WARNING: type inference failed for: r0v104 */
        /* JADX WARNING: type inference failed for: r0v105 */
        /* JADX WARNING: type inference failed for: r0v106 */
        /* JADX WARNING: type inference failed for: r0v107 */
        /* JADX WARNING: type inference failed for: r0v108 */
        /* JADX WARNING: type inference failed for: r0v109 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 2: goto L_0x0221;
                    case 3: goto L_0x0245;
                    case 4: goto L_0x025b;
                    case 5: goto L_0x0271;
                    case 6: goto L_0x0095;
                    case 7: goto L_0x00b9;
                    case 8: goto L_0x00dd;
                    case 9: goto L_0x00f3;
                    case 11: goto L_0x0117;
                    case 12: goto L_0x013b;
                    case 13: goto L_0x015d;
                    case 14: goto L_0x0181;
                    case 15: goto L_0x0197;
                    case 16: goto L_0x01ad;
                    case 17: goto L_0x01d1;
                    case 18: goto L_0x01f5;
                    case 19: goto L_0x020b;
                    case 20: goto L_0x0011;
                    case 21: goto L_0x0034;
                    case 22: goto L_0x004d;
                    case 23: goto L_0x0062;
                    case 24: goto L_0x007b;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r8.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r2)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r2 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r2)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x002c
                android.os.Parcelable$Creator<com.google.android.gms.wearable.c> r0 = com.google.android.gms.wearable.C2227c.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.wearable.c r0 = (com.google.android.gms.wearable.C2227c) r0
            L_0x002c:
                r5.mo12358a((com.google.android.gms.wearable.internal.C2234ad) r2, (com.google.android.gms.wearable.C2227c) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0034:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                java.lang.String r2 = r7.readString()
                r5.mo12361a((com.google.android.gms.wearable.internal.C2234ad) r0, (java.lang.String) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x004d:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                r5.mo12354a(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0062:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                java.lang.String r2 = r7.readString()
                r5.mo12366b((com.google.android.gms.wearable.internal.C2234ad) r0, (java.lang.String) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x007b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                java.lang.String r2 = r7.readString()
                r5.mo12369c((com.google.android.gms.wearable.internal.C2234ad) r0, (java.lang.String) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0095:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r2)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r2 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r2)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x00b0
                android.os.Parcelable$Creator<com.google.android.gms.wearable.PutDataRequest> r0 = com.google.android.gms.wearable.PutDataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.wearable.PutDataRequest r0 = (com.google.android.gms.wearable.PutDataRequest) r0
            L_0x00b0:
                r5.mo12357a((com.google.android.gms.wearable.internal.C2234ad) r2, (com.google.android.gms.wearable.PutDataRequest) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00b9:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r2)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r2 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r2)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x00d4
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x00d4:
                r5.mo12355a((com.google.android.gms.wearable.internal.C2234ad) r2, (android.net.Uri) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00dd:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                r5.mo12363b(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00f3:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r2)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r2 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r2)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x010e
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x010e:
                r5.mo12364b((com.google.android.gms.wearable.internal.C2234ad) r2, (android.net.Uri) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0117:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r2)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r2 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r2)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x0132
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x0132:
                r5.mo12368c((com.google.android.gms.wearable.internal.C2234ad) r2, (android.net.Uri) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x013b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                java.lang.String r2 = r7.readString()
                java.lang.String r3 = r7.readString()
                byte[] r4 = r7.createByteArray()
                r5.mo12362a(r0, r2, r3, r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x015d:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r2)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r2 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r2)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x0178
                android.os.Parcelable$Creator<com.google.android.gms.wearable.Asset> r0 = com.google.android.gms.wearable.Asset.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.wearable.Asset r0 = (com.google.android.gms.wearable.Asset) r0
            L_0x0178:
                r5.mo12356a((com.google.android.gms.wearable.internal.C2234ad) r2, (com.google.android.gms.wearable.Asset) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0181:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                r5.mo12367c(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0197:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                r5.mo12370d(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01ad:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r2)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r2 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r2)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x01c8
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.b> r0 = com.google.android.gms.wearable.internal.C2286b.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.wearable.internal.b r0 = (com.google.android.gms.wearable.internal.C2286b) r0
            L_0x01c8:
                r5.mo12360a((com.google.android.gms.wearable.internal.C2234ad) r2, (com.google.android.gms.wearable.internal.C2286b) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01d1:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r2)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r2 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r2)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x01ec
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.aq> r0 = com.google.android.gms.wearable.internal.C2263aq.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.wearable.internal.aq r0 = (com.google.android.gms.wearable.internal.C2263aq) r0
            L_0x01ec:
                r5.mo12359a((com.google.android.gms.wearable.internal.C2234ad) r2, (com.google.android.gms.wearable.internal.C2263aq) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01f5:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                r5.mo12371e(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x020b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                r5.mo12372f(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0221:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r2)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r2 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r2)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x023c
                android.os.Parcelable$Creator<com.google.android.gms.wearable.c> r0 = com.google.android.gms.wearable.C2227c.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.wearable.c r0 = (com.google.android.gms.wearable.C2227c) r0
            L_0x023c:
                r5.mo12365b((com.google.android.gms.wearable.internal.C2234ad) r2, (com.google.android.gms.wearable.C2227c) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0245:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                r5.mo12373g(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x025b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                r5.mo12374h(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0271:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.wearable.internal.ad r0 = com.google.android.gms.wearable.internal.C2234ad.C2235a.m7521bR(r0)
                r5.mo12375i(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.C2240af.C2241a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo12354a(C2234ad adVar) throws RemoteException;

    /* renamed from: a */
    void mo12355a(C2234ad adVar, Uri uri) throws RemoteException;

    /* renamed from: a */
    void mo12356a(C2234ad adVar, Asset asset) throws RemoteException;

    /* renamed from: a */
    void mo12357a(C2234ad adVar, PutDataRequest putDataRequest) throws RemoteException;

    /* renamed from: a */
    void mo12358a(C2234ad adVar, C2227c cVar) throws RemoteException;

    /* renamed from: a */
    void mo12359a(C2234ad adVar, C2263aq aqVar) throws RemoteException;

    /* renamed from: a */
    void mo12360a(C2234ad adVar, C2286b bVar) throws RemoteException;

    /* renamed from: a */
    void mo12361a(C2234ad adVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo12362a(C2234ad adVar, String str, String str2, byte[] bArr) throws RemoteException;

    /* renamed from: b */
    void mo12363b(C2234ad adVar) throws RemoteException;

    /* renamed from: b */
    void mo12364b(C2234ad adVar, Uri uri) throws RemoteException;

    /* renamed from: b */
    void mo12365b(C2234ad adVar, C2227c cVar) throws RemoteException;

    /* renamed from: b */
    void mo12366b(C2234ad adVar, String str) throws RemoteException;

    /* renamed from: c */
    void mo12367c(C2234ad adVar) throws RemoteException;

    /* renamed from: c */
    void mo12368c(C2234ad adVar, Uri uri) throws RemoteException;

    /* renamed from: c */
    void mo12369c(C2234ad adVar, String str) throws RemoteException;

    /* renamed from: d */
    void mo12370d(C2234ad adVar) throws RemoteException;

    /* renamed from: e */
    void mo12371e(C2234ad adVar) throws RemoteException;

    /* renamed from: f */
    void mo12372f(C2234ad adVar) throws RemoteException;

    /* renamed from: g */
    void mo12373g(C2234ad adVar) throws RemoteException;

    /* renamed from: h */
    void mo12374h(C2234ad adVar) throws RemoteException;

    /* renamed from: i */
    void mo12375i(C2234ad adVar) throws RemoteException;
}
