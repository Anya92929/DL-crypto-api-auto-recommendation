package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.games.internal.IGamesSignInCallbacks;

public interface IGamesSignInService extends IInterface {

    public static abstract class Stub extends Binder implements IGamesSignInService {

        private static class Proxy implements IGamesSignInService {

            /* renamed from: lb */
            private IBinder f1938lb;

            /* renamed from: a */
            public void mo6987a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1938lb.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6988a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f1938lb.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6989a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStringArray(strArr);
                    this.f1938lb.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6990a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.f1938lb.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6991a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str3);
                    this.f1938lb.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1938lb;
            }

            /* renamed from: b */
            public void mo6992b(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeStrongBinder(iGamesSignInCallbacks != null ? iGamesSignInCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f1938lb.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bI */
            public String mo6993bI(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    this.f1938lb.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bJ */
            public String mo6994bJ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    this.f1938lb.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public String mo6995h(String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1938lb.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: w */
            public void mo6996w(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1938lb.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInService");
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    String bI = mo6993bI(data.readString());
                    reply.writeNoException();
                    reply.writeString(bI);
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    String bJ = mo6994bJ(data.readString());
                    reply.writeNoException();
                    reply.writeString(bJ);
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    mo6991a(IGamesSignInCallbacks.Stub.m3073aC(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    mo6990a(IGamesSignInCallbacks.Stub.m3073aC(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    mo6988a(IGamesSignInCallbacks.Stub.m3073aC(data.readStrongBinder()), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    mo6987a(IGamesSignInCallbacks.Stub.m3073aC(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    mo6992b(IGamesSignInCallbacks.Stub.m3073aC(data.readStrongBinder()), data.readString(), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    mo6989a(IGamesSignInCallbacks.Stub.m3073aC(data.readStrongBinder()), data.readString(), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    String h = mo6995h(data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    reply.writeString(h);
                    return true;
                case 9001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
                    mo6996w(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesSignInService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo6987a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo6988a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) throws RemoteException;

    /* renamed from: a */
    void mo6989a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo6990a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo6991a(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String[] strArr, String str3) throws RemoteException;

    /* renamed from: b */
    void mo6992b(IGamesSignInCallbacks iGamesSignInCallbacks, String str, String str2, String str3) throws RemoteException;

    /* renamed from: bI */
    String mo6993bI(String str) throws RemoteException;

    /* renamed from: bJ */
    String mo6994bJ(String str) throws RemoteException;

    /* renamed from: h */
    String mo6995h(String str, boolean z) throws RemoteException;

    /* renamed from: w */
    void mo6996w(String str, String str2) throws RemoteException;
}
