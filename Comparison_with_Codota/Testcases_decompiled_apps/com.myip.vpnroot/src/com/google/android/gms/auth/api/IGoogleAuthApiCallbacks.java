package com.google.android.gms.auth.api;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGoogleAuthApiCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IGoogleAuthApiCallbacks {

        /* renamed from: com.google.android.gms.auth.api.IGoogleAuthApiCallbacks$Stub$a */
        private static class C0227a implements IGoogleAuthApiCallbacks {

            /* renamed from: lb */
            private IBinder f388lb;

            C0227a(IBinder iBinder) {
                this.f388lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f388lb;
            }

            public void onConnectionSuccess(GoogleAuthApiResponse response) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    if (response != null) {
                        obtain.writeInt(1);
                        response.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f388lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onError(int statusCode, String errorDescription, PendingIntent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeString(errorDescription);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f388lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
        }

        public static IGoogleAuthApiCallbacks asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGoogleAuthApiCallbacks)) ? new C0227a(obj) : (IGoogleAuthApiCallbacks) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.app.PendingIntent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.auth.api.GoogleAuthApiResponse} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v13 */
        /* JADX WARNING: type inference failed for: r0v14 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x002a;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks"
                r8.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0022
                com.google.android.gms.auth.api.GoogleAuthApiResponseCreator r0 = com.google.android.gms.auth.api.GoogleAuthApiResponse.CREATOR
                com.google.android.gms.auth.api.GoogleAuthApiResponse r0 = r0.createFromParcel((android.os.Parcel) r7)
            L_0x0022:
                r5.onConnectionSuccess(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x002a:
                java.lang.String r2 = "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                java.lang.String r3 = r7.readString()
                int r4 = r7.readInt()
                if (r4 == 0) goto L_0x0045
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0045:
                r5.onError(r2, r3, r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.IGoogleAuthApiCallbacks.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onConnectionSuccess(GoogleAuthApiResponse googleAuthApiResponse) throws RemoteException;

    void onError(int i, String str, PendingIntent pendingIntent) throws RemoteException;
}
