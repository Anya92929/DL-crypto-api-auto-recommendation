package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ng */
public interface C1600ng extends IInterface {

    /* renamed from: com.google.android.gms.internal.ng$a */
    public static abstract class C1601a extends Binder implements C1600ng {

        /* renamed from: com.google.android.gms.internal.ng$a$a */
        private static class C1602a implements C1600ng {

            /* renamed from: lb */
            private IBinder f4302lb;

            C1602a(IBinder iBinder) {
                this.f4302lb = iBinder;
            }

            /* renamed from: a */
            public void mo9510a(String str, C1609nl nlVar, C1603nh nhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (nlVar != null) {
                        obtain.writeInt(1);
                        nlVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (nhVar != null) {
                        obtain.writeInt(1);
                        nhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4302lb.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9511a(String str, C1609nl nlVar, List<C1603nh> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (nlVar != null) {
                        obtain.writeInt(1);
                        nlVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.f4302lb.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9512a(String str, C1609nl nlVar, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (nlVar != null) {
                        obtain.writeInt(1);
                        nlVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.f4302lb.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4302lb;
            }
        }

        /* renamed from: bC */
        public static C1600ng m5689bC(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1600ng)) ? new C1602a(iBinder) : (C1600ng) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.nl} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.gms.internal.nl} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.internal.nh} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v10 */
        /* JADX WARNING: type inference failed for: r1v11 */
        /* JADX WARNING: type inference failed for: r1v12 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r1 = 0
                r2 = 1
                switch(r6) {
                    case 2: goto L_0x0011;
                    case 3: goto L_0x0039;
                    case 4: goto L_0x0059;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r8.writeString(r0)
                r0 = r2
                goto L_0x0009
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r7.enforceInterface(r0)
                java.lang.String r3 = r7.readString()
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0037
                com.google.android.gms.internal.nm r0 = com.google.android.gms.internal.C1609nl.CREATOR
                com.google.android.gms.internal.nl r0 = r0.createFromParcel(r7)
            L_0x0026:
                int r4 = r7.readInt()
                if (r4 == 0) goto L_0x0032
                com.google.android.gms.internal.nj r1 = com.google.android.gms.internal.C1603nh.CREATOR
                com.google.android.gms.internal.nh r1 = r1.createFromParcel(r7)
            L_0x0032:
                r5.mo9510a((java.lang.String) r3, (com.google.android.gms.internal.C1609nl) r0, (com.google.android.gms.internal.C1603nh) r1)
                r0 = r2
                goto L_0x0009
            L_0x0037:
                r0 = r1
                goto L_0x0026
            L_0x0039:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x004e
                com.google.android.gms.internal.nm r1 = com.google.android.gms.internal.C1609nl.CREATOR
                com.google.android.gms.internal.nl r1 = r1.createFromParcel(r7)
            L_0x004e:
                com.google.android.gms.internal.nj r3 = com.google.android.gms.internal.C1603nh.CREATOR
                java.util.ArrayList r3 = r7.createTypedArrayList(r3)
                r5.mo9511a((java.lang.String) r0, (com.google.android.gms.internal.C1609nl) r1, (java.util.List<com.google.android.gms.internal.C1603nh>) r3)
                r0 = r2
                goto L_0x0009
            L_0x0059:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x006e
                com.google.android.gms.internal.nm r1 = com.google.android.gms.internal.C1609nl.CREATOR
                com.google.android.gms.internal.nl r1 = r1.createFromParcel(r7)
            L_0x006e:
                byte[] r3 = r7.createByteArray()
                r5.mo9512a((java.lang.String) r0, (com.google.android.gms.internal.C1609nl) r1, (byte[]) r3)
                r0 = r2
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1600ng.C1601a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo9510a(String str, C1609nl nlVar, C1603nh nhVar) throws RemoteException;

    /* renamed from: a */
    void mo9511a(String str, C1609nl nlVar, List<C1603nh> list) throws RemoteException;

    /* renamed from: a */
    void mo9512a(String str, C1609nl nlVar, byte[] bArr) throws RemoteException;
}
