package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;

public interface IStreetViewPanoramaViewDelegate extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate$a */
    public static abstract class C1808a extends Binder implements IStreetViewPanoramaViewDelegate {

        /* renamed from: com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate$a$a */
        private static class C1809a implements IStreetViewPanoramaViewDelegate {

            /* renamed from: lb */
            private IBinder f4446lb;

            C1809a(IBinder iBinder) {
                this.f4446lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f4446lb;
            }

            public IStreetViewPanoramaDelegate getStreetViewPanorama() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.f4446lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return IStreetViewPanoramaDelegate.C1804a.m6325bl(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0594d getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.f4446lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0594d.C0595a.m1741am(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCreate(Bundle savedInstanceState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    if (savedInstanceState != null) {
                        obtain.writeInt(1);
                        savedInstanceState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4446lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.f4446lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLowMemory() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.f4446lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.f4446lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onResume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.f4446lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSaveInstanceState(Bundle outState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    if (outState != null) {
                        obtain.writeInt(1);
                        outState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4446lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        outState.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: bn */
        public static IStreetViewPanoramaViewDelegate m6327bn(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStreetViewPanoramaViewDelegate)) ? new C1809a(iBinder) : (IStreetViewPanoramaViewDelegate) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v23, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v29 */
        /* JADX WARNING: type inference failed for: r0v30 */
        /* JADX WARNING: type inference failed for: r0v31 */
        /* JADX WARNING: type inference failed for: r0v32 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x0043;
                    case 4: goto L_0x0050;
                    case 5: goto L_0x005d;
                    case 6: goto L_0x006a;
                    case 7: goto L_0x0077;
                    case 8: goto L_0x00a0;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
                r5.enforceInterface(r2)
                com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate r2 = r3.getStreetViewPanorama()
                r6.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x0028:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003b
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x003b:
                r3.onCreate(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0043:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
                r5.enforceInterface(r0)
                r3.onResume()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0050:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
                r5.enforceInterface(r0)
                r3.onPause()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x005d:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
                r5.enforceInterface(r0)
                r3.onDestroy()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x006a:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
                r5.enforceInterface(r0)
                r3.onLowMemory()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0077:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x008a
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x008a:
                r3.onSaveInstanceState(r0)
                r6.writeNoException()
                if (r0 == 0) goto L_0x009b
                r6.writeInt(r1)
                r0.writeToParcel(r6, r1)
            L_0x0098:
                r0 = r1
                goto L_0x0009
            L_0x009b:
                r0 = 0
                r6.writeInt(r0)
                goto L_0x0098
            L_0x00a0:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate"
                r5.enforceInterface(r2)
                com.google.android.gms.dynamic.d r2 = r3.getView()
                r6.writeNoException()
                if (r2 == 0) goto L_0x00b2
                android.os.IBinder r0 = r2.asBinder()
            L_0x00b2:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.C1808a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    IStreetViewPanoramaDelegate getStreetViewPanorama() throws RemoteException;

    C0594d getView() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;
}
