package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.C0629a;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* renamed from: com.google.android.gms.internal.bf */
public interface C0493bf extends IInterface {

    /* renamed from: com.google.android.gms.internal.bf$a */
    public static abstract class C0494a extends Binder implements C0493bf {

        /* renamed from: com.google.android.gms.internal.bf$a$a */
        private static class C0495a implements C0493bf {

            /* renamed from: a */
            private IBinder f1109a;

            C0495a(IBinder iBinder) {
                this.f1109a = iBinder;
            }

            /* renamed from: a */
            public void mo4771a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1109a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4772a(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1109a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4773a(PendingIntent pendingIntent, C0490be beVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(beVar != null ? beVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1109a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4774a(C0490be beVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(beVar != null ? beVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1109a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4775a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1109a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4776a(LocationRequest locationRequest, C0629a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f1109a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4777a(C0629a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f1109a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4778a(List<C0505bi> list, PendingIntent pendingIntent, C0490be beVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(beVar != null ? beVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1109a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4779a(String[] strArr, C0490be beVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(beVar != null ? beVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1109a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aQ */
            public Location mo4780aQ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.f1109a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1109a;
            }

            public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (callbackIntent != null) {
                        obtain.writeInt(1);
                        callbackIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1109a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockLocation(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1109a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockMode(boolean isMockMode) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (isMockMode) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1109a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: r */
        public static C0493bf m1320r(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0493bf)) ? new C0495a(iBinder) : (C0493bf) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.location.Location} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.app.PendingIntent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: android.app.PendingIntent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.google.android.gms.location.LocationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: android.app.PendingIntent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: android.app.PendingIntent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: android.app.PendingIntent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: android.app.PendingIntent} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v45 */
        /* JADX WARNING: type inference failed for: r0v46 */
        /* JADX WARNING: type inference failed for: r0v47 */
        /* JADX WARNING: type inference failed for: r0v48 */
        /* JADX WARNING: type inference failed for: r0v49 */
        /* JADX WARNING: type inference failed for: r0v50 */
        /* JADX WARNING: type inference failed for: r0v51 */
        /* JADX WARNING: type inference failed for: r0v52 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) throws android.os.RemoteException {
            /*
                r6 = this;
                r1 = 0
                r0 = 0
                r2 = 1
                switch(r7) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x003d;
                    case 3: goto L_0x0063;
                    case 4: goto L_0x007f;
                    case 5: goto L_0x0098;
                    case 6: goto L_0x00be;
                    case 7: goto L_0x00d9;
                    case 8: goto L_0x00f4;
                    case 9: goto L_0x0115;
                    case 10: goto L_0x013e;
                    case 11: goto L_0x0153;
                    case 12: goto L_0x016e;
                    case 13: goto L_0x0182;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r2 = super.onTransact(r7, r8, r9, r10)
            L_0x000a:
                return r2
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                com.google.android.gms.internal.bj r1 = com.google.android.gms.internal.C0505bi.CREATOR
                java.util.ArrayList r1 = r8.createTypedArrayList(r1)
                int r3 = r8.readInt()
                if (r3 == 0) goto L_0x002a
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x002a:
                android.os.IBinder r3 = r8.readStrongBinder()
                com.google.android.gms.internal.be r3 = com.google.android.gms.internal.C0490be.C0491a.m1309q(r3)
                java.lang.String r4 = r8.readString()
                r6.mo4778a(r1, r0, r3, r4)
                r9.writeNoException()
                goto L_0x000a
            L_0x003d:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x0050
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0050:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.internal.be r1 = com.google.android.gms.internal.C0490be.C0491a.m1309q(r1)
                java.lang.String r3 = r8.readString()
                r6.mo4773a((android.app.PendingIntent) r0, (com.google.android.gms.internal.C0490be) r1, (java.lang.String) r3)
                r9.writeNoException()
                goto L_0x000a
            L_0x0063:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                java.lang.String[] r0 = r8.createStringArray()
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.internal.be r1 = com.google.android.gms.internal.C0490be.C0491a.m1309q(r1)
                java.lang.String r3 = r8.readString()
                r6.mo4779a((java.lang.String[]) r0, (com.google.android.gms.internal.C0490be) r1, (java.lang.String) r3)
                r9.writeNoException()
                goto L_0x000a
            L_0x007f:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.internal.be r0 = com.google.android.gms.internal.C0490be.C0491a.m1309q(r0)
                java.lang.String r1 = r8.readString()
                r6.mo4774a((com.google.android.gms.internal.C0490be) r0, (java.lang.String) r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x0098:
                java.lang.String r3 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r3)
                long r3 = r8.readLong()
                int r5 = r8.readInt()
                if (r5 == 0) goto L_0x00a8
                r1 = r2
            L_0x00a8:
                int r5 = r8.readInt()
                if (r5 == 0) goto L_0x00b6
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x00b6:
                r6.mo4771a((long) r3, (boolean) r1, (android.app.PendingIntent) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x00be:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x00d1
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x00d1:
                r6.removeActivityUpdates(r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x00d9:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.location.Location r0 = r6.mo4780aQ()
                r9.writeNoException()
                if (r0 == 0) goto L_0x00ef
                r9.writeInt(r2)
                r0.writeToParcel(r9, r2)
                goto L_0x000a
            L_0x00ef:
                r9.writeInt(r1)
                goto L_0x000a
            L_0x00f4:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x0105
                com.google.android.gms.location.LocationRequestCreator r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r0 = r0.createFromParcel((android.os.Parcel) r8)
            L_0x0105:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.location.a r1 = com.google.android.gms.location.C0629a.C0630a.m1928p(r1)
                r6.mo4776a((com.google.android.gms.location.LocationRequest) r0, (com.google.android.gms.location.C0629a) r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x0115:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x013c
                com.google.android.gms.location.LocationRequestCreator r1 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r1 = r1.createFromParcel((android.os.Parcel) r8)
            L_0x0126:
                int r3 = r8.readInt()
                if (r3 == 0) goto L_0x0134
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0134:
                r6.mo4775a((com.google.android.gms.location.LocationRequest) r1, (android.app.PendingIntent) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x013c:
                r1 = r0
                goto L_0x0126
            L_0x013e:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.a r0 = com.google.android.gms.location.C0629a.C0630a.m1928p(r0)
                r6.mo4777a((com.google.android.gms.location.C0629a) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x0153:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x0166
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0166:
                r6.mo4772a((android.app.PendingIntent) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x016e:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x017a
                r1 = r2
            L_0x017a:
                r6.setMockMode(r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x0182:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x0195
                android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.location.Location r0 = (android.location.Location) r0
            L_0x0195:
                r6.setMockLocation(r0)
                r9.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0493bf.C0494a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo4771a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo4772a(PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo4773a(PendingIntent pendingIntent, C0490be beVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo4774a(C0490be beVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo4775a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo4776a(LocationRequest locationRequest, C0629a aVar) throws RemoteException;

    /* renamed from: a */
    void mo4777a(C0629a aVar) throws RemoteException;

    /* renamed from: a */
    void mo4778a(List<C0505bi> list, PendingIntent pendingIntent, C0490be beVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo4779a(String[] strArr, C0490be beVar, String str) throws RemoteException;

    /* renamed from: aQ */
    Location mo4780aQ() throws RemoteException;

    void removeActivityUpdates(PendingIntent pendingIntent) throws RemoteException;

    void setMockLocation(Location location) throws RemoteException;

    void setMockMode(boolean z) throws RemoteException;
}
