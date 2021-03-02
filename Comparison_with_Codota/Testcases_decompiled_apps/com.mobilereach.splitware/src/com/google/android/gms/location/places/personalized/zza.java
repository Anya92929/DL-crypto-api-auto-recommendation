package com.google.android.gms.location.places.personalized;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.location.places.personalized.zza$zza  reason: collision with other inner class name */
    public static abstract class C0458zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.location.places.personalized.zza$zza$zza  reason: collision with other inner class name */
        private static class C0459zza implements zza {
            private IBinder zzoz;

            C0459zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(PlaceAliasResult placeAliasResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    if (placeAliasResult != null) {
                        obtain.writeInt(1);
                        placeAliasResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(PlaceAliasResult placeAliasResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    if (placeAliasResult != null) {
                        obtain.writeInt(1);
                        placeAliasResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zza zzcr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C0459zza(iBinder) : (zza) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            PlaceAliasResult placeAliasResult = null;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    if (data.readInt() != 0) {
                        placeAliasResult = PlaceAliasResult.CREATOR.createFromParcel(data);
                    }
                    zza(placeAliasResult);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    if (data.readInt() != 0) {
                        placeAliasResult = PlaceAliasResult.CREATOR.createFromParcel(data);
                    }
                    zzb(placeAliasResult);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.personalized.IPlaceAliasCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(PlaceAliasResult placeAliasResult) throws RemoteException;

    void zzb(PlaceAliasResult placeAliasResult) throws RemoteException;
}
