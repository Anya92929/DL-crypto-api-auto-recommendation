package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.internal.mu */
public interface C1572mu extends IInterface {

    /* renamed from: com.google.android.gms.internal.mu$a */
    public static abstract class C1573a extends Binder implements C1572mu {

        /* renamed from: com.google.android.gms.internal.mu$a$a */
        private static class C1574a implements C1572mu {

            /* renamed from: lb */
            private IBinder f4293lb;

            C1574a(IBinder iBinder) {
                this.f4293lb = iBinder;
            }

            /* renamed from: W */
            public void mo9467W(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4293lb.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: X */
            public void mo9468X(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4293lb.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: Y */
            public void mo9469Y(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4293lb.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4293lb;
            }
        }

        /* renamed from: aM */
        public static C1572mu m5640aM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1572mu)) ? new C1574a(iBinder) : (C1572mu) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DataHolder dataHolder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(data);
                    }
                    mo9467W(dataHolder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(data);
                    }
                    mo9468X(dataHolder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(data);
                    }
                    mo9469Y(dataHolder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: W */
    void mo9467W(DataHolder dataHolder) throws RemoteException;

    /* renamed from: X */
    void mo9468X(DataHolder dataHolder) throws RemoteException;

    /* renamed from: Y */
    void mo9469Y(DataHolder dataHolder) throws RemoteException;
}
