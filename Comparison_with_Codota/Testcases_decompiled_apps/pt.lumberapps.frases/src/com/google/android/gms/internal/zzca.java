package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

public interface zzca extends IInterface {

    public abstract class zza extends Binder implements zzca {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        }

        public static zzca zzd(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzca)) ? new C1506dq(iBinder) : (zzca) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            int i3 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    String zzdf = zzdf();
                    parcel2.writeNoException();
                    parcel2.writeString(zzdf);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    zzb(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    boolean zza = zza(zzd.zza.zzfc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (zza) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    boolean zzb = zzb(zzd.zza.zzfc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (zzb) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    zzk(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    zzd zza2 = zza(zzd.zza.zzfc(parcel.readStrongBinder()), zzd.zza.zzfc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zza2 != null ? zza2.asBinder() : null);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    String zzc = zzc(zzd.zza.zzfc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeString(zzc);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    String zza3 = zza(zzd.zza.zzfc(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(zza3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    zzd(zzd.zza.zzfc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    zzd zzb2 = zzb(zzd.zza.zzfc(parcel.readStrongBinder()), zzd.zza.zzfc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (zzb2 != null) {
                        iBinder = zzb2.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    boolean zzb3 = zzb(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (zzb3) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzd zza(zzd zzd, zzd zzd2);

    String zza(zzd zzd, String str);

    boolean zza(zzd zzd);

    zzd zzb(zzd zzd, zzd zzd2);

    void zzb(String str, String str2);

    boolean zzb(zzd zzd);

    boolean zzb(String str, boolean z);

    String zzc(zzd zzd);

    void zzd(zzd zzd);

    String zzdf();

    void zzk(String str);
}
