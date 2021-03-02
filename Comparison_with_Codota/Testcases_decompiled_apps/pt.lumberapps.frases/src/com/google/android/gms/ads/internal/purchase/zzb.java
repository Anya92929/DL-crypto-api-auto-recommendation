package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;

@zzin
public class zzb {

    /* renamed from: a */
    Object f3863a;

    /* renamed from: b */
    private final Context f3864b;

    /* renamed from: c */
    private final boolean f3865c;

    public zzb(Context context) {
        this(context, true);
    }

    public zzb(Context context, boolean z) {
        this.f3864b = context;
        this.f3865c = z;
    }

    public void destroy() {
        this.f3863a = null;
    }

    public void zzas(IBinder iBinder) {
        try {
            this.f3863a = this.f3864b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder});
        } catch (Exception e) {
            if (this.f3865c) {
                zzkd.zzcx("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            }
        }
    }

    public int zzb(int i, String str, String str2) {
        try {
            Class<?> loadClass = this.f3864b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("isBillingSupported", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.f3863a), new Object[]{Integer.valueOf(i), str, str2})).intValue();
        } catch (Exception e) {
            if (this.f3865c) {
                zzkd.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public Bundle zzb(String str, String str2, String str3) {
        try {
            Class<?> loadClass = this.f3864b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.f3863a), new Object[]{3, str, str2, "inapp", str3});
        } catch (Exception e) {
            if (this.f3865c) {
                zzkd.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }

    public int zzm(String str, String str2) {
        try {
            Class<?> loadClass = this.f3864b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.f3863a), new Object[]{3, str, str2})).intValue();
        } catch (Exception e) {
            if (this.f3865c) {
                zzkd.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public Bundle zzn(String str, String str2) {
        try {
            Class<?> loadClass = this.f3864b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.f3863a), new Object[]{3, str, "inapp", str2});
        } catch (Exception e) {
            if (this.f3865c) {
                zzkd.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }
}
