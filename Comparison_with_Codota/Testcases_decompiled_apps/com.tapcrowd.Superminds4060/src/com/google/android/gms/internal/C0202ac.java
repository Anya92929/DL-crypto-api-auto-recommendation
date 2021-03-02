package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0164b;

/* renamed from: com.google.android.gms.internal.ac */
public interface C0202ac extends IInterface {

    /* renamed from: com.google.android.gms.internal.ac$a */
    public static abstract class C0203a extends Binder implements C0202ac {

        /* renamed from: com.google.android.gms.internal.ac$a$a */
        private static class C0204a implements C0202ac {

            /* renamed from: dG */
            private IBinder f559dG;

            C0204a(IBinder iBinder) {
                this.f559dG = iBinder;
            }

            /* renamed from: a */
            public void mo4017a(C0199ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.f559dG.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4018a(C0208ae aeVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(aeVar != null ? aeVar.asBinder() : null);
                    this.f559dG.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo4019a(C0620v vVar) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (vVar != null) {
                        obtain.writeInt(1);
                        vVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f559dG.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f559dG;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f559dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isReady() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f559dG.transact(3, obtain, obtain2, 0);
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

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f559dG.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f559dG.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f559dG.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f559dG.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: z */
            public C0164b mo4026z() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    this.f559dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0164b.C0165a.m377z(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0203a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        /* renamed from: f */
        public static C0202ac m470f(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0202ac)) ? new C0204a(iBinder) : (C0202ac) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.v} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v21, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v24 */
        /* JADX WARNING: type inference failed for: r0v25 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r2 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0027;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0048;
                    case 5: goto L_0x0067;
                    case 6: goto L_0x0073;
                    case 7: goto L_0x007f;
                    case 8: goto L_0x0094;
                    case 9: goto L_0x00a9;
                    case 10: goto L_0x00b6;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r1 = super.onTransact(r5, r6, r7, r8)
            L_0x000a:
                return r1
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r7.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r2)
                com.google.android.gms.dynamic.b r2 = r4.mo4026z()
                r7.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r7.writeStrongBinder(r0)
                goto L_0x000a
            L_0x0027:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.destroy()
                r7.writeNoException()
                goto L_0x000a
            L_0x0033:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                boolean r0 = r4.isReady()
                r7.writeNoException()
                if (r0 == 0) goto L_0x0046
                r0 = r1
            L_0x0042:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x0046:
                r0 = r2
                goto L_0x0042
            L_0x0048:
                java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r3)
                int r3 = r6.readInt()
                if (r3 == 0) goto L_0x0059
                com.google.android.gms.internal.w r0 = com.google.android.gms.internal.C0620v.CREATOR
                com.google.android.gms.internal.v r0 = r0.createFromParcel(r6)
            L_0x0059:
                boolean r0 = r4.mo4019a((com.google.android.gms.internal.C0620v) r0)
                r7.writeNoException()
                if (r0 == 0) goto L_0x0063
                r2 = r1
            L_0x0063:
                r7.writeInt(r2)
                goto L_0x000a
            L_0x0067:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.pause()
                r7.writeNoException()
                goto L_0x000a
            L_0x0073:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.resume()
                r7.writeNoException()
                goto L_0x000a
            L_0x007f:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.ab r0 = com.google.android.gms.internal.C0199ab.C0200a.m465e(r0)
                r4.mo4017a((com.google.android.gms.internal.C0199ab) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0094:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.ae r0 = com.google.android.gms.internal.C0208ae.C0209a.m479h(r0)
                r4.mo4018a((com.google.android.gms.internal.C0208ae) r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x00a9:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.showInterstitial()
                r7.writeNoException()
                goto L_0x000a
            L_0x00b6:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdManager"
                r6.enforceInterface(r0)
                r4.stopLoading()
                r7.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0202ac.C0203a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo4017a(C0199ab abVar) throws RemoteException;

    /* renamed from: a */
    void mo4018a(C0208ae aeVar) throws RemoteException;

    /* renamed from: a */
    boolean mo4019a(C0620v vVar) throws RemoteException;

    void destroy() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    /* renamed from: z */
    C0164b mo4026z() throws RemoteException;
}
