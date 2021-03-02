package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p017b.C0605j;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.zza$zza  reason: collision with other inner class name */
    public abstract class C1950zza extends Binder implements zza {
        public static zza zzcO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C1220b(iBinder) : (zza) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0605j zzhM = zzhM(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzhM != null ? zzhM.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0605j zzdF = zzdF(parcel.readString());
                    parcel2.writeNoException();
                    if (zzdF != null) {
                        iBinder = zzdF.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0605j zzdG = zzdG(parcel.readString());
                    parcel2.writeNoException();
                    if (zzdG != null) {
                        iBinder = zzdG.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0605j zzxg = zzxg();
                    parcel2.writeNoException();
                    if (zzxg != null) {
                        iBinder = zzxg.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0605j zzh = zzh(parcel.readFloat());
                    parcel2.writeNoException();
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0605j zzb = zzb(parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (zzb != null) {
                        iBinder = zzb.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0605j zzdH = zzdH(parcel.readString());
                    parcel2.writeNoException();
                    if (zzdH != null) {
                        iBinder = zzdH.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    C0605j zzb(Bitmap bitmap);

    C0605j zzdF(String str);

    C0605j zzdG(String str);

    C0605j zzdH(String str);

    C0605j zzh(float f);

    C0605j zzhM(int i);

    C0605j zzxg();
}
