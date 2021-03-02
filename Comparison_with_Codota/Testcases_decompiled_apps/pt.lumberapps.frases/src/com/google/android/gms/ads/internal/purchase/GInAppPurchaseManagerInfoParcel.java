package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zzin;

@zzin
public final class GInAppPurchaseManagerInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final zza CREATOR = new zza();
    public final int versionCode;
    public final zzk zzapt;
    public final zzhn zzbwm;
    public final Context zzbwn;
    public final zzj zzbwo;

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.zzapt = (zzk) zze.zzad(zzd.zza.zzfc(iBinder));
        this.zzbwm = (zzhn) zze.zzad(zzd.zza.zzfc(iBinder2));
        this.zzbwn = (Context) zze.zzad(zzd.zza.zzfc(iBinder3));
        this.zzbwo = (zzj) zze.zzad(zzd.zza.zzfc(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk zzk, zzhn zzhn, zzj zzj) {
        this.versionCode = 2;
        this.zzbwn = context;
        this.zzapt = zzk;
        this.zzbwm = zzhn;
        this.zzbwo = zzj;
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IBinder mo5565a() {
        return zze.zzac(this.zzbwo).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public IBinder mo5566b() {
        return zze.zzac(this.zzapt).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public IBinder mo5567c() {
        return zze.zzac(this.zzbwm).asBinder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public IBinder mo5568d() {
        return zze.zzac(this.zzbwn).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m5714a(this, parcel, i);
    }
}
