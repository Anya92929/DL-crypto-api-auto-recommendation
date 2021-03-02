package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

/* renamed from: com.google.android.gms.internal.r */
public interface C1728r extends IInterface {

    /* renamed from: com.google.android.gms.internal.r$a */
    public static abstract class C1729a extends Binder implements C1728r {

        /* renamed from: com.google.android.gms.internal.r$a$a */
        private static class C1730a implements C1728r {

            /* renamed from: lb */
            private IBinder f4359lb;

            C1730a(IBinder iBinder) {
                this.f4359lb = iBinder;
            }

            /* renamed from: a */
            public Bundle mo10128a(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4359lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Bundle mo10129a(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4359lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public AccountChangeEventsResponse mo10130a(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    if (accountChangeEventsRequest != null) {
                        obtain.writeInt(1);
                        accountChangeEventsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4359lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? AccountChangeEventsResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4359lb;
            }
        }

        /* renamed from: a */
        public static C1728r m6153a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1728r)) ? new C1730a(iBinder) : (C1728r) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.auth.AccountChangeEventsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v21 */
        /* JADX WARNING: type inference failed for: r0v22 */
        /* JADX WARNING: type inference failed for: r0v23 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) throws android.os.RemoteException {
            /*
                r6 = this;
                r0 = 0
                r5 = 0
                r1 = 1
                switch(r7) {
                    case 1: goto L_0x0012;
                    case 2: goto L_0x0042;
                    case 3: goto L_0x006e;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r0 = super.onTransact(r7, r8, r9, r10)
            L_0x000a:
                return r0
            L_0x000b:
                java.lang.String r0 = "com.google.android.auth.IAuthManagerService"
                r9.writeString(r0)
                r0 = r1
                goto L_0x000a
            L_0x0012:
                java.lang.String r2 = "com.google.android.auth.IAuthManagerService"
                r8.enforceInterface(r2)
                java.lang.String r2 = r8.readString()
                java.lang.String r3 = r8.readString()
                int r4 = r8.readInt()
                if (r4 == 0) goto L_0x002d
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x002d:
                android.os.Bundle r0 = r6.mo10129a(r2, r3, r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x003e
                r9.writeInt(r1)
                r0.writeToParcel(r9, r1)
            L_0x003c:
                r0 = r1
                goto L_0x000a
            L_0x003e:
                r9.writeInt(r5)
                goto L_0x003c
            L_0x0042:
                java.lang.String r2 = "com.google.android.auth.IAuthManagerService"
                r8.enforceInterface(r2)
                java.lang.String r2 = r8.readString()
                int r3 = r8.readInt()
                if (r3 == 0) goto L_0x0059
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0059:
                android.os.Bundle r0 = r6.mo10128a(r2, r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x006a
                r9.writeInt(r1)
                r0.writeToParcel(r9, r1)
            L_0x0068:
                r0 = r1
                goto L_0x000a
            L_0x006a:
                r9.writeInt(r5)
                goto L_0x0068
            L_0x006e:
                java.lang.String r2 = "com.google.android.auth.IAuthManagerService"
                r8.enforceInterface(r2)
                int r2 = r8.readInt()
                if (r2 == 0) goto L_0x007f
                com.google.android.gms.auth.AccountChangeEventsRequestCreator r0 = com.google.android.gms.auth.AccountChangeEventsRequest.CREATOR
                com.google.android.gms.auth.AccountChangeEventsRequest r0 = r0.createFromParcel((android.os.Parcel) r8)
            L_0x007f:
                com.google.android.gms.auth.AccountChangeEventsResponse r0 = r6.mo10130a(r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x0091
                r9.writeInt(r1)
                r0.writeToParcel(r9, r1)
            L_0x008e:
                r0 = r1
                goto L_0x000a
            L_0x0091:
                r9.writeInt(r5)
                goto L_0x008e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1728r.C1729a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    Bundle mo10128a(String str, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    Bundle mo10129a(String str, String str2, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    AccountChangeEventsResponse mo10130a(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException;
}
