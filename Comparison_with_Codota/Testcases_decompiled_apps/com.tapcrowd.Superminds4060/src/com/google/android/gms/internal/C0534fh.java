package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.C0140d;

/* renamed from: com.google.android.gms.internal.fh */
public interface C0534fh extends IInterface {

    /* renamed from: com.google.android.gms.internal.fh$a */
    public static abstract class C0535a extends Binder implements C0534fh {

        /* renamed from: com.google.android.gms.internal.fh$a$a */
        private static class C0536a implements C0534fh {

            /* renamed from: dG */
            private IBinder f1330dG;

            C0536a(IBinder iBinder) {
                this.f1330dG = iBinder;
            }

            /* renamed from: W */
            public void mo4794W(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeString(str);
                    this.f1330dG.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: X */
            public void mo4795X(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    obtain.writeString(str);
                    this.f1330dG.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4796a(int i, Bundle bundle, Bundle bundle2) throws RemoteException {
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
                    this.f1330dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4797a(int i, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
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
                    this.f1330dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4798a(int i, Bundle bundle, C0433ec ecVar) throws RemoteException {
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
                    if (ecVar != null) {
                        obtain.writeInt(1);
                        ecVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1330dG.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4799a(C0140d dVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f1330dG.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4800a(C0140d dVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusCallbacks");
                    if (dVar != null) {
                        obtain.writeInt(1);
                        dVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1330dG.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1330dG;
            }

            /* renamed from: b */
            public void mo4801b(int i, Bundle bundle) throws RemoteException {
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
                    this.f1330dG.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0535a() {
            attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
        }

        /* renamed from: an */
        public static C0534fh m1593an(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0534fh)) ? new C0536a(iBinder) : (C0534fh) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.google.android.gms.common.data.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.google.android.gms.internal.ec} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.google.android.gms.common.data.d} */
        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r2v8 */
        /* JADX WARNING: type inference failed for: r2v9 */
        /* JADX WARNING: type inference failed for: r2v10 */
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
                r5.mo4796a((int) r4, (android.os.Bundle) r1, (android.os.Bundle) r0)
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
                r5.mo4797a((int) r4, (android.os.Bundle) r1, (android.os.ParcelFileDescriptor) r0)
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
                r5.mo4794W(r0)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            L_0x0086:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusCallbacks"
                r7.enforceInterface(r0)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0097
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r2 = r0.createFromParcel(r7)
            L_0x0097:
                java.lang.String r0 = r7.readString()
                r5.mo4799a(r2, r0)
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
                com.google.android.gms.internal.ed r2 = com.google.android.gms.internal.C0433ec.CREATOR
                com.google.android.gms.internal.ec r2 = r2.createFromParcel(r7)
            L_0x00c7:
                r5.mo4798a((int) r1, (android.os.Bundle) r0, (com.google.android.gms.internal.C0433ec) r2)
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
                com.google.android.gms.common.data.e r0 = com.google.android.gms.common.data.C0140d.CREATOR
                com.google.android.gms.common.data.d r2 = r0.createFromParcel(r7)
            L_0x00e3:
                java.lang.String r0 = r7.readString()
                java.lang.String r1 = r7.readString()
                r5.mo4800a((com.google.android.gms.common.data.C0140d) r2, (java.lang.String) r0, (java.lang.String) r1)
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
                r5.mo4801b(r1, r0)
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
                r5.mo4795X(r0)
                r8.writeNoException()
                r0 = r3
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0534fh.C0535a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: W */
    void mo4794W(String str) throws RemoteException;

    /* renamed from: X */
    void mo4795X(String str) throws RemoteException;

    /* renamed from: a */
    void mo4796a(int i, Bundle bundle, Bundle bundle2) throws RemoteException;

    /* renamed from: a */
    void mo4797a(int i, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    /* renamed from: a */
    void mo4798a(int i, Bundle bundle, C0433ec ecVar) throws RemoteException;

    /* renamed from: a */
    void mo4799a(C0140d dVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo4800a(C0140d dVar, String str, String str2) throws RemoteException;

    /* renamed from: b */
    void mo4801b(int i, Bundle bundle) throws RemoteException;
}
