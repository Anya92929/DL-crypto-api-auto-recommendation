package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.C0333i;
import com.google.android.gms.internal.C1361jb;
import com.google.android.gms.internal.C1380jp;
import java.util.List;

/* renamed from: com.google.android.gms.plus.internal.d */
public interface C1952d extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.d$a */
    public static abstract class C1953a extends Binder implements C1952d {

        /* renamed from: com.google.android.gms.plus.internal.d$a$a */
        private static class C1954a implements C1952d {

            /* renamed from: lb */
            private IBinder f4502lb;

            C1954a(IBinder iBinder) {
                this.f4502lb = iBinder;
            }

            /* renamed from: a */
            public C0333i mo11330a(C1946b bVar, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.f4502lb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0333i.C0334a.m758O(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11331a(C1380jp jpVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (jpVar != null) {
                        obtain.writeInt(1);
                        jpVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4502lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11332a(C1946b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f4502lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11333a(C1946b bVar, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f4502lb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11334a(C1946b bVar, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4502lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11335a(C1946b bVar, C1380jp jpVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (jpVar != null) {
                        obtain.writeInt(1);
                        jpVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4502lb.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11336a(C1946b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4502lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11337a(C1946b bVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f4502lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11338a(C1946b bVar, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeStringList(list);
                    this.f4502lb.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11339a(String str, C1361jb jbVar, C1361jb jbVar2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    if (jbVar != null) {
                        obtain.writeInt(1);
                        jbVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jbVar2 != null) {
                        obtain.writeInt(1);
                        jbVar2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4502lb.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4502lb;
            }

            /* renamed from: b */
            public void mo11340b(C1946b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f4502lb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo11341b(C1946b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4502lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo11342c(C1946b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4502lb.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f4502lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo11344d(C1946b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4502lb.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo11345e(C1946b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4502lb.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f4502lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: mZ */
            public String mo11347mZ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f4502lb.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: na */
            public boolean mo11348na() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f4502lb.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: nb */
            public String mo11349nb() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f4502lb.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.f4502lb.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: bG */
        public static C1952d m6598bG(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1952d)) ? new C1954a(iBinder) : (C1952d) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.google.android.gms.internal.jb} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.google.android.gms.internal.jp} */
        /* JADX WARNING: type inference failed for: r6v0 */
        /* JADX WARNING: type inference failed for: r6v5, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r6v8 */
        /* JADX WARNING: type inference failed for: r6v9 */
        /* JADX WARNING: type inference failed for: r6v10 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
            /*
                r8 = this;
                r6 = 0
                r7 = 1
                switch(r9) {
                    case 1: goto L_0x0010;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x0044;
                    case 4: goto L_0x005c;
                    case 5: goto L_0x0076;
                    case 6: goto L_0x0086;
                    case 8: goto L_0x0093;
                    case 9: goto L_0x00a8;
                    case 14: goto L_0x00de;
                    case 16: goto L_0x0115;
                    case 17: goto L_0x0145;
                    case 18: goto L_0x0156;
                    case 19: goto L_0x016f;
                    case 34: goto L_0x0184;
                    case 40: goto L_0x019d;
                    case 41: goto L_0x01b6;
                    case 42: goto L_0x01c7;
                    case 43: goto L_0x01dd;
                    case 44: goto L_0x01ee;
                    case 45: goto L_0x0207;
                    case 46: goto L_0x0228;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r7 = super.onTransact(r9, r10, r11, r12)
            L_0x0009:
                return r7
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r11.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                java.lang.String r1 = r10.readString()
                r8.mo11336a((com.google.android.gms.plus.internal.C1946b) r0, (java.lang.String) r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x0028:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                java.lang.String r1 = r10.readString()
                java.lang.String r2 = r10.readString()
                r8.mo11337a((com.google.android.gms.plus.internal.C1946b) r0, (java.lang.String) r1, (java.lang.String) r2)
                r11.writeNoException()
                goto L_0x0009
            L_0x0044:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                java.lang.String r1 = r10.readString()
                r8.mo11341b(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x005c:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0074
                com.google.android.gms.internal.jq r0 = com.google.android.gms.internal.C1380jp.CREATOR
                com.google.android.gms.internal.jp r0 = r0.createFromParcel(r10)
            L_0x006d:
                r8.mo11331a((com.google.android.gms.internal.C1380jp) r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x0074:
                r0 = r6
                goto L_0x006d
            L_0x0076:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.getAccountName()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x0009
            L_0x0086:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                r8.clearDefaultAccount()
                r11.writeNoException()
                goto L_0x0009
            L_0x0093:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                r8.mo11332a((com.google.android.gms.plus.internal.C1946b) r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x00a8:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r2 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00da
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.net.Uri r0 = (android.net.Uri) r0
                r1 = r0
            L_0x00c4:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00dc
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00d2:
                r8.mo11334a((com.google.android.gms.plus.internal.C1946b) r2, (android.net.Uri) r1, (android.os.Bundle) r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x00da:
                r1 = r6
                goto L_0x00c4
            L_0x00dc:
                r0 = r6
                goto L_0x00d2
            L_0x00de:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r1 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                int r2 = r10.readInt()
                java.lang.String r3 = r10.readString()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0113
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.net.Uri r0 = (android.net.Uri) r0
                r4 = r0
            L_0x0102:
                java.lang.String r5 = r10.readString()
                java.lang.String r6 = r10.readString()
                r0 = r8
                r0.mo11333a(r1, r2, r3, r4, r5, r6)
                r11.writeNoException()
                goto L_0x0009
            L_0x0113:
                r4 = r6
                goto L_0x0102
            L_0x0115:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r1 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                int r2 = r10.readInt()
                int r3 = r10.readInt()
                int r4 = r10.readInt()
                java.lang.String r5 = r10.readString()
                r0 = r8
                com.google.android.gms.common.internal.i r0 = r0.mo11330a(r1, r2, r3, r4, r5)
                r11.writeNoException()
                if (r0 == 0) goto L_0x0140
                android.os.IBinder r6 = r0.asBinder()
            L_0x0140:
                r11.writeStrongBinder(r6)
                goto L_0x0009
            L_0x0145:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r10.readString()
                r8.removeMoment(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x0156:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                java.lang.String r1 = r10.readString()
                r8.mo11342c(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x016f:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                r8.mo11340b(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x0184:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                java.util.ArrayList r1 = r10.createStringArrayList()
                r8.mo11338a((com.google.android.gms.plus.internal.C1946b) r0, (java.util.List<java.lang.String>) r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x019d:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                java.lang.String r1 = r10.readString()
                r8.mo11344d(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x01b6:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.mo11347mZ()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x0009
            L_0x01c7:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                boolean r0 = r8.mo11348na()
                r11.writeNoException()
                if (r0 == 0) goto L_0x01db
                r0 = r7
            L_0x01d6:
                r11.writeInt(r0)
                goto L_0x0009
            L_0x01db:
                r0 = 0
                goto L_0x01d6
            L_0x01dd:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.mo11349nb()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x0009
            L_0x01ee:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                java.lang.String r1 = r10.readString()
                r8.mo11345e(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x0207:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1946b.C1947a.m6564bE(r0)
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x0220
                com.google.android.gms.internal.jq r1 = com.google.android.gms.internal.C1380jp.CREATOR
                com.google.android.gms.internal.jp r6 = r1.createFromParcel(r10)
            L_0x0220:
                r8.mo11335a((com.google.android.gms.plus.internal.C1946b) r0, (com.google.android.gms.internal.C1380jp) r6)
                r11.writeNoException()
                goto L_0x0009
            L_0x0228:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r1 = r10.readString()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0251
                com.google.android.gms.internal.jc r0 = com.google.android.gms.internal.C1361jb.CREATOR
                com.google.android.gms.internal.jb r0 = r0.createFromParcel(r10)
            L_0x023d:
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x0249
                com.google.android.gms.internal.jc r2 = com.google.android.gms.internal.C1361jb.CREATOR
                com.google.android.gms.internal.jb r6 = r2.createFromParcel(r10)
            L_0x0249:
                r8.mo11339a((java.lang.String) r1, (com.google.android.gms.internal.C1361jb) r0, (com.google.android.gms.internal.C1361jb) r6)
                r11.writeNoException()
                goto L_0x0009
            L_0x0251:
                r0 = r6
                goto L_0x023d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.plus.internal.C1952d.C1953a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    C0333i mo11330a(C1946b bVar, int i, int i2, int i3, String str) throws RemoteException;

    /* renamed from: a */
    void mo11331a(C1380jp jpVar) throws RemoteException;

    /* renamed from: a */
    void mo11332a(C1946b bVar) throws RemoteException;

    /* renamed from: a */
    void mo11333a(C1946b bVar, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    /* renamed from: a */
    void mo11334a(C1946b bVar, Uri uri, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo11335a(C1946b bVar, C1380jp jpVar) throws RemoteException;

    /* renamed from: a */
    void mo11336a(C1946b bVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo11337a(C1946b bVar, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo11338a(C1946b bVar, List<String> list) throws RemoteException;

    /* renamed from: a */
    void mo11339a(String str, C1361jb jbVar, C1361jb jbVar2) throws RemoteException;

    /* renamed from: b */
    void mo11340b(C1946b bVar) throws RemoteException;

    /* renamed from: b */
    void mo11341b(C1946b bVar, String str) throws RemoteException;

    /* renamed from: c */
    void mo11342c(C1946b bVar, String str) throws RemoteException;

    void clearDefaultAccount() throws RemoteException;

    /* renamed from: d */
    void mo11344d(C1946b bVar, String str) throws RemoteException;

    /* renamed from: e */
    void mo11345e(C1946b bVar, String str) throws RemoteException;

    String getAccountName() throws RemoteException;

    /* renamed from: mZ */
    String mo11347mZ() throws RemoteException;

    /* renamed from: na */
    boolean mo11348na() throws RemoteException;

    /* renamed from: nb */
    String mo11349nb() throws RemoteException;

    void removeMoment(String str) throws RemoteException;
}
