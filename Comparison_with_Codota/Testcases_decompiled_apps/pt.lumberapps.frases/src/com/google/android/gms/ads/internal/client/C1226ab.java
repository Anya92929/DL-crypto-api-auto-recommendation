package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzhi;
import com.google.android.gms.internal.zzhp;

/* renamed from: com.google.android.gms.ads.internal.client.ab */
class C1226ab implements zzx {

    /* renamed from: a */
    private IBinder f3452a;

    C1226ab(IBinder iBinder) {
        this.f3452a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3452a;
    }

    public zzs createAdLoaderBuilder(zzd zzd, String str, zzgj zzgj, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeString(str);
            if (zzgj != null) {
                iBinder = zzgj.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f3452a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return zzs.zza.zzl(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzhi createAdOverlay(zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f3452a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            return zzhi.zza.zzaq(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzu createBannerAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgj zzgj, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (zzgj != null) {
                iBinder = zzgj.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f3452a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return zzu.zza.zzn(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzhp createInAppPurchaseManager(zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f3452a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            return zzhp.zza.zzav(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzu createInterstitialAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgj zzgj, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (zzgj != null) {
                iBinder = zzgj.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f3452a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return zzu.zza.zzn(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzdt createNativeAdViewDelegate(zzd zzd, zzd zzd2) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (zzd2 != null) {
                iBinder = zzd2.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f3452a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return zzdt.zza.zzz(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzb createRewardedVideoAd(zzd zzd, zzgj zzgj, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (zzgj != null) {
                iBinder = zzgj.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f3452a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            return zzb.zza.zzbf(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzu createSearchAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            obtain.writeInt(i);
            this.f3452a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            return zzu.zza.zzn(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzz getMobileAdsSettingsManager(zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f3452a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return zzz.zza.zzr(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzz getMobileAdsSettingsManagerWithClientJarVersion(zzd zzd, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeInt(i);
            this.f3452a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            return zzz.zza.zzr(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
