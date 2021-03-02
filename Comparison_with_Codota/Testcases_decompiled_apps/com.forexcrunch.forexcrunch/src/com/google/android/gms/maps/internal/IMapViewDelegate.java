package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0368b;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;

public interface IMapViewDelegate extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.IMapViewDelegate$a */
    public static abstract class C0660a extends Binder implements IMapViewDelegate {

        /* renamed from: com.google.android.gms.maps.internal.IMapViewDelegate$a$a */
        private static class C0661a implements IMapViewDelegate {

            /* renamed from: a */
            private IBinder f1541a;

            C0661a(IBinder iBinder) {
                this.f1541a = iBinder;
            }

            public IBinder asBinder() {
                return this.f1541a;
            }

            public IGoogleMapDelegate getMap() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.f1541a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return IGoogleMapDelegate.C0654a.m1966w(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0368b getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.f1541a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0368b.C0369a.m700l(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCreate(Bundle savedInstanceState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    if (savedInstanceState != null) {
                        obtain.writeInt(1);
                        savedInstanceState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1541a.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.f1541a.transact(5, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.f1541a.transact(6, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.f1541a.transact(4, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.f1541a.transact(3, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    if (outState != null) {
                        obtain.writeInt(1);
                        outState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1541a.transact(7, obtain, obtain2, 0);
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

        /* renamed from: A */
        public static IMapViewDelegate m1969A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMapViewDelegate)) ? new C0661a(iBinder) : (IMapViewDelegate) queryLocalInterface;
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
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                com.google.android.gms.maps.internal.IGoogleMapDelegate r2 = r3.getMap()
                r6.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x0028:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
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
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onResume()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0050:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onPause()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x005d:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onDestroy()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x006a:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onLowMemory()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0077:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
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
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                com.google.android.gms.dynamic.b r2 = r3.getView()
                r6.writeNoException()
                if (r2 == 0) goto L_0x00b2
                android.os.IBinder r0 = r2.asBinder()
            L_0x00b2:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.IMapViewDelegate.C0660a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    IGoogleMapDelegate getMap() throws RemoteException;

    C0368b getView() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;
}
