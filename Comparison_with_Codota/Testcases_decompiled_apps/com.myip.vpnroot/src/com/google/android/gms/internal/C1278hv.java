package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C1265hm;
import com.google.android.gms.internal.C1281hw;

/* renamed from: com.google.android.gms.internal.hv */
public interface C1278hv extends IInterface {

    /* renamed from: com.google.android.gms.internal.hv$a */
    public static abstract class C1279a extends Binder implements C1278hv {

        /* renamed from: com.google.android.gms.internal.hv$a$a */
        private static class C1280a implements C1278hv {

            /* renamed from: lb */
            private IBinder f3886lb;

            C1280a(IBinder iBinder) {
                this.f3886lb = iBinder;
            }

            /* renamed from: a */
            public void mo8774a(C1265hm.C1266a aVar, C1281hw hwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hwVar != null ? hwVar.asBinder() : null);
                    this.f3886lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8775a(C1281hw hwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(hwVar != null ? hwVar.asBinder() : null);
                    this.f3886lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8776a(C1281hw hwVar, String str, C1274hs[] hsVarArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(hwVar != null ? hwVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedArray(hsVarArr, 0);
                    this.f3886lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo8777a(C1281hw hwVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(hwVar != null ? hwVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f3886lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3886lb;
            }

            /* renamed from: b */
            public void mo8778b(C1281hw hwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(hwVar != null ? hwVar.asBinder() : null);
                    this.f3886lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: F */
        public static C1278hv m4810F(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1278hv)) ? new C1280a(iBinder) : (C1278hv) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo8776a(C1281hw.C1282a.m4820G(data.readStrongBinder()), data.readString(), (C1274hs[]) data.createTypedArray(C1274hs.CREATOR));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo8775a(C1281hw.C1282a.m4820G(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo8778b(C1281hw.C1282a.m4820G(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo8777a(C1281hw.C1282a.m4820G(data.readStrongBinder()), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo8774a(data.readInt() != 0 ? C1265hm.C1266a.CREATOR.createFromParcel(data) : null, C1281hw.C1282a.m4820G(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo8774a(C1265hm.C1266a aVar, C1281hw hwVar) throws RemoteException;

    /* renamed from: a */
    void mo8775a(C1281hw hwVar) throws RemoteException;

    /* renamed from: a */
    void mo8776a(C1281hw hwVar, String str, C1274hs[] hsVarArr) throws RemoteException;

    /* renamed from: a */
    void mo8777a(C1281hw hwVar, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo8778b(C1281hw hwVar) throws RemoteException;
}
