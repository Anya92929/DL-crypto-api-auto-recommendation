package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzf;

public interface zzi extends IInterface {

    public static abstract class zza extends Binder implements zzi {

        /* renamed from: com.google.android.gms.maps.internal.zzi$zza$a */
        static class C0859a implements zzi {

            /* renamed from: a */
            private IBinder f3452a;

            C0859a(IBinder iBinder) {
                this.f3452a = iBinder;
            }

            public IBinder asBinder() {
                return this.f3452a;
            }

            public void zza(zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.f3452a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
        }

        public static zzi zzcE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new C0859a(iBinder) : (zzi) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
                    zza(zzf.zza.zzdi(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzf zzf) throws RemoteException;
}
