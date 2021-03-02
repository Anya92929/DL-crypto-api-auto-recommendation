package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

public interface zzs extends IInterface {

    public abstract class zza extends Binder implements zzs {
        public zza() {
            attachInterface(this, "com.google.android.gms.common.internal.ICertData");
        }

        public static zzs zzdr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzs)) ? new C1386y(iBinder) : (zzs) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                    zzd zzank = zzank();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzank != null ? zzank.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                    int zzanl = zzanl();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzanl);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.ICertData");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzd zzank();

    int zzanl();
}
