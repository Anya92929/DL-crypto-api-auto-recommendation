package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzr extends IInterface {

    public abstract class zza extends Binder implements zzr {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
        }

        public static zzr zzk(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzr)) ? new C1249v(iBinder) : (zzr) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    zzf(parcel.readInt() != 0 ? (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    String mediationAdapterClassName = getMediationAdapterClassName();
                    parcel2.writeNoException();
                    parcel2.writeString(mediationAdapterClassName);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    boolean isLoading = isLoading();
                    parcel2.writeNoException();
                    parcel2.writeInt(isLoading ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoader");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String getMediationAdapterClassName();

    boolean isLoading();

    void zzf(AdRequestParcel adRequestParcel);
}
