package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C1265hm;

/* renamed from: com.google.android.gms.internal.hw */
public interface C1281hw extends IInterface {

    /* renamed from: com.google.android.gms.internal.hw$a */
    public static abstract class C1282a extends Binder implements C1281hw {

        /* renamed from: com.google.android.gms.internal.hw$a$a */
        private static class C1283a implements C1281hw {

            /* renamed from: lb */
            private IBinder f3887lb;

            C1283a(IBinder iBinder) {
                this.f3887lb = iBinder;
            }

            /* renamed from: a */
            public void mo8781a(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3887lb.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8782a(Status status, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3887lb.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8783a(Status status, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f3887lb.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8784a(C1265hm.C1267b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3887lb.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3887lb;
            }
        }

        public C1282a() {
            attachInterface(this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        }

        /* renamed from: G */
        public static C1281hw m4820G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1281hw)) ? new C1283a(iBinder) : (C1281hw) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.internal.hm$b} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.os.ParcelFileDescriptor} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v15 */
        /* JADX WARNING: type inference failed for: r0v16 */
        /* JADX WARNING: type inference failed for: r0v17 */
        /* JADX WARNING: type inference failed for: r0v18 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r2 = 1
                switch(r5) {
                    case 1: goto L_0x0010;
                    case 2: goto L_0x0025;
                    case 3: goto L_0x004a;
                    case 4: goto L_0x0068;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r2 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r2
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks"
                r7.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r1 = "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0021
                com.google.android.gms.common.api.StatusCreator r0 = com.google.android.gms.common.api.Status.CREATOR
                com.google.android.gms.common.api.Status r0 = r0.createFromParcel((android.os.Parcel) r6)
            L_0x0021:
                r4.mo8781a((com.google.android.gms.common.api.Status) r0)
                goto L_0x0009
            L_0x0025:
                java.lang.String r1 = "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0048
                com.google.android.gms.common.api.StatusCreator r1 = com.google.android.gms.common.api.Status.CREATOR
                com.google.android.gms.common.api.Status r1 = r1.createFromParcel((android.os.Parcel) r6)
            L_0x0036:
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0044
                android.os.Parcelable$Creator r0 = android.os.ParcelFileDescriptor.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                android.os.ParcelFileDescriptor r0 = (android.os.ParcelFileDescriptor) r0
            L_0x0044:
                r4.mo8782a((com.google.android.gms.common.api.Status) r1, (android.os.ParcelFileDescriptor) r0)
                goto L_0x0009
            L_0x0048:
                r1 = r0
                goto L_0x0036
            L_0x004a:
                java.lang.String r1 = "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x005b
                com.google.android.gms.common.api.StatusCreator r0 = com.google.android.gms.common.api.Status.CREATOR
                com.google.android.gms.common.api.Status r0 = r0.createFromParcel((android.os.Parcel) r6)
            L_0x005b:
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0066
                r1 = r2
            L_0x0062:
                r4.mo8783a((com.google.android.gms.common.api.Status) r0, (boolean) r1)
                goto L_0x0009
            L_0x0066:
                r1 = 0
                goto L_0x0062
            L_0x0068:
                java.lang.String r1 = "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks"
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0079
                com.google.android.gms.internal.ho r0 = com.google.android.gms.internal.C1265hm.C1267b.CREATOR
                com.google.android.gms.internal.hm$b r0 = r0.createFromParcel(r6)
            L_0x0079:
                r4.mo8784a((com.google.android.gms.internal.C1265hm.C1267b) r0)
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1281hw.C1282a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo8781a(Status status) throws RemoteException;

    /* renamed from: a */
    void mo8782a(Status status, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    /* renamed from: a */
    void mo8783a(Status status, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo8784a(C1265hm.C1267b bVar) throws RemoteException;
}
