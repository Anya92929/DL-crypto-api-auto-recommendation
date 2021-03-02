package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public interface zzdz extends IInterface {

    public abstract class zza extends Binder implements zzdz {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        }

        public static zzdz zzad(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzdz)) ? new C1544fa(iBinder) : (zzdz) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    String zzat = zzat(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(zzat);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    zzdr zzau = zzau(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    List availableAssetNames = getAvailableAssetNames();
                    parcel2.writeNoException();
                    parcel2.writeStringList(availableAssetNames);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    String customTemplateId = getCustomTemplateId();
                    parcel2.writeNoException();
                    parcel2.writeString(customTemplateId);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    performClick(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    recordImpression();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    List getAvailableAssetNames();

    String getCustomTemplateId();

    void performClick(String str);

    void recordImpression();

    String zzat(String str);

    zzdr zzau(String str);
}
