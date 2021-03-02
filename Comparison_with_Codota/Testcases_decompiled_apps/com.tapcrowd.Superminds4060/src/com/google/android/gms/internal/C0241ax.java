package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0164b;

/* renamed from: com.google.android.gms.internal.ax */
public interface C0241ax extends IInterface {

    /* renamed from: com.google.android.gms.internal.ax$a */
    public static abstract class C0242a extends Binder implements C0241ax {

        /* renamed from: com.google.android.gms.internal.ax$a$a */
        private static class C0243a implements C0241ax {

            /* renamed from: dG */
            private IBinder f613dG;

            C0243a(IBinder iBinder) {
                this.f613dG = iBinder;
            }

            /* renamed from: a */
            public void mo4066a(C0164b bVar, C0620v vVar, String str, C0244ay ayVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (vVar != null) {
                        obtain.writeInt(1);
                        vVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ayVar != null) {
                        iBinder = ayVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f613dG.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4067a(C0164b bVar, C0622x xVar, C0620v vVar, String str, C0244ay ayVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (xVar != null) {
                        obtain.writeInt(1);
                        xVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (vVar != null) {
                        obtain.writeInt(1);
                        vVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ayVar != null) {
                        iBinder = ayVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f613dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f613dG;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f613dG.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0164b getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f613dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0164b.C0165a.m377z(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f613dG.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0242a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        /* renamed from: j */
        public static C0241ax m530j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0241ax)) ? new C0243a(iBinder) : (C0241ax) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.internal.v} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v9, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v19 */
        /* JADX WARNING: type inference failed for: r0v20 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
            /*
                r7 = this;
                r0 = 0
                r6 = 1
                switch(r8) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x004f;
                    case 3: goto L_0x0066;
                    case 4: goto L_0x0094;
                    case 5: goto L_0x00a2;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r8, r9, r10, r11)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r10.writeString(r0)
                r0 = r6
                goto L_0x0009
            L_0x0011:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r9.enforceInterface(r1)
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.dynamic.b r1 = com.google.android.gms.dynamic.C0164b.C0165a.m377z(r1)
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x004b
                com.google.android.gms.internal.y r2 = com.google.android.gms.internal.C0622x.CREATOR
                com.google.android.gms.internal.x r2 = r2.createFromParcel(r9)
            L_0x002a:
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x004d
                com.google.android.gms.internal.w r0 = com.google.android.gms.internal.C0620v.CREATOR
                com.google.android.gms.internal.v r3 = r0.createFromParcel(r9)
            L_0x0036:
                java.lang.String r4 = r9.readString()
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.internal.ay r5 = com.google.android.gms.internal.C0244ay.C0245a.m534k(r0)
                r0 = r7
                r0.mo4067a(r1, r2, r3, r4, r5)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x004b:
                r2 = r0
                goto L_0x002a
            L_0x004d:
                r3 = r0
                goto L_0x0036
            L_0x004f:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r9.enforceInterface(r1)
                com.google.android.gms.dynamic.b r1 = r7.getView()
                r10.writeNoException()
                if (r1 == 0) goto L_0x0061
                android.os.IBinder r0 = r1.asBinder()
            L_0x0061:
                r10.writeStrongBinder(r0)
                r0 = r6
                goto L_0x0009
            L_0x0066:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r9.enforceInterface(r1)
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.dynamic.b r1 = com.google.android.gms.dynamic.C0164b.C0165a.m377z(r1)
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x007f
                com.google.android.gms.internal.w r0 = com.google.android.gms.internal.C0620v.CREATOR
                com.google.android.gms.internal.v r0 = r0.createFromParcel(r9)
            L_0x007f:
                java.lang.String r2 = r9.readString()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.internal.ay r3 = com.google.android.gms.internal.C0244ay.C0245a.m534k(r3)
                r7.mo4066a(r1, r0, r2, r3)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0094:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r9.enforceInterface(r0)
                r7.showInterstitial()
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x00a2:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r9.enforceInterface(r0)
                r7.destroy()
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0241ax.C0242a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo4066a(C0164b bVar, C0620v vVar, String str, C0244ay ayVar) throws RemoteException;

    /* renamed from: a */
    void mo4067a(C0164b bVar, C0622x xVar, C0620v vVar, String str, C0244ay ayVar) throws RemoteException;

    void destroy() throws RemoteException;

    C0164b getView() throws RemoteException;

    void showInterstitial() throws RemoteException;
}
