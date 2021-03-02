package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;

@C1130ez
/* renamed from: com.google.android.gms.internal.dw */
public class C1079dw {
    private final Context mContext;

    /* renamed from: sk */
    private Object f3209sk;

    public C1079dw(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    public Bundle mo8379a(String str, String str2, String str3) {
        try {
            Class<?> loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.f3209sk), new Object[]{3, str, str2, "inapp", str3});
        } catch (Exception e) {
            C1229gs.m4683d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }

    /* renamed from: c */
    public int mo8380c(String str, String str2) {
        try {
            Class<?> loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.f3209sk), new Object[]{3, str, str2})).intValue();
        } catch (Exception e) {
            C1229gs.m4683d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return 5;
        }
    }

    /* renamed from: d */
    public Bundle mo8381d(String str, String str2) {
        try {
            Class<?> loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.f3209sk), new Object[]{3, str, "inapp", str2});
        } catch (Exception e) {
            C1229gs.m4683d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }

    public void destroy() {
        this.f3209sk = null;
    }

    /* renamed from: r */
    public void mo8383r(IBinder iBinder) {
        try {
            this.f3209sk = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder});
        } catch (Exception e) {
            C1229gs.m4679W("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }
}
