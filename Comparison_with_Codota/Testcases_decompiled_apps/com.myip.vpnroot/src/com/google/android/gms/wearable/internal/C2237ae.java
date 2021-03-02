package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.wearable.internal.ae */
public interface C2237ae extends IInterface {

    /* renamed from: com.google.android.gms.wearable.internal.ae$a */
    public static abstract class C2238a extends Binder implements C2237ae {

        /* renamed from: com.google.android.gms.wearable.internal.ae$a$a */
        private static class C2239a implements C2237ae {

            /* renamed from: lb */
            private IBinder f4666lb;

            C2239a(IBinder iBinder) {
                this.f4666lb = iBinder;
            }

            /* renamed from: Z */
            public void mo12290Z(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4666lb.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12291a(C2248ah ahVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (ahVar != null) {
                        obtain.writeInt(1);
                        ahVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4666lb.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo12292a(C2257ak akVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (akVar != null) {
                        obtain.writeInt(1);
                        akVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4666lb.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4666lb;
            }

            /* renamed from: b */
            public void mo12293b(C2257ak akVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (akVar != null) {
                        obtain.writeInt(1);
                        akVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4666lb.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C2238a() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        /* renamed from: bS */
        public static C2237ae m7538bS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2237ae)) ? new C2239a(iBinder) : (C2237ae) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.wearable.internal.ak} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.wearable.internal.ak} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.wearable.internal.ah} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v23 */
        /* JADX WARNING: type inference failed for: r0v24 */
        /* JADX WARNING: type inference failed for: r0v25 */
        /* JADX WARNING: type inference failed for: r0v26 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0027;
                    case 3: goto L_0x003f;
                    case 4: goto L_0x0057;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableListener"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0022
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r5)
            L_0x0022:
                r3.mo12290Z(r0)
                r0 = r1
                goto L_0x0009
            L_0x0027:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.ah> r0 = com.google.android.gms.wearable.internal.C2248ah.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.ah r0 = (com.google.android.gms.wearable.internal.C2248ah) r0
            L_0x003a:
                r3.mo12291a((com.google.android.gms.wearable.internal.C2248ah) r0)
                r0 = r1
                goto L_0x0009
            L_0x003f:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0052
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.ak> r0 = com.google.android.gms.wearable.internal.C2257ak.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.ak r0 = (com.google.android.gms.wearable.internal.C2257ak) r0
            L_0x0052:
                r3.mo12292a((com.google.android.gms.wearable.internal.C2257ak) r0)
                r0 = r1
                goto L_0x0009
            L_0x0057:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x006a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.ak> r0 = com.google.android.gms.wearable.internal.C2257ak.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.ak r0 = (com.google.android.gms.wearable.internal.C2257ak) r0
            L_0x006a:
                r3.mo12293b(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.C2237ae.C2238a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: Z */
    void mo12290Z(DataHolder dataHolder) throws RemoteException;

    /* renamed from: a */
    void mo12291a(C2248ah ahVar) throws RemoteException;

    /* renamed from: a */
    void mo12292a(C2257ak akVar) throws RemoteException;

    /* renamed from: b */
    void mo12293b(C2257ak akVar) throws RemoteException;
}
