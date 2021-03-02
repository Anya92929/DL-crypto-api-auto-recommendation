package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.internal.C1092eg;
import com.myip.vpnroot.Prop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@C1130ez
/* renamed from: com.google.android.gms.internal.dy */
public final class C1082dy extends C1092eg.C1093a {
    private Context mContext;

    /* renamed from: mv */
    private String f3220mv;

    /* renamed from: su */
    private String f3221su;

    /* renamed from: sv */
    private ArrayList<String> f3222sv;

    public C1082dy(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.f3221su = str;
        this.f3222sv = arrayList;
        this.f3220mv = str2;
        this.mContext = context;
    }

    /* renamed from: cr */
    private void m4306cr() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke((Object) null, new Object[]{this.mContext, this.f3221su, "", true});
        } catch (ClassNotFoundException e) {
            C1229gs.m4679W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            C1229gs.m4679W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Exception e3) {
            C1229gs.m4683d("Fail to report a conversion.", e3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo8389a(String str, HashMap<String, String> hashMap) {
        String str2;
        String packageName = this.mContext.getPackageName();
        try {
            str2 = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            C1229gs.m4683d("Error to retrieve app version", e);
            str2 = "";
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - C1201gb.m4566cZ().mo8579di();
        for (String next : hashMap.keySet()) {
            str = str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{next}), String.format("$1%s$2", new Object[]{hashMap.get(next)}));
        }
        return str.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{C1201gb.f3708vK})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appid"}), String.format("$1%s$2", new Object[]{packageName})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(Build.VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.f3220mv})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{str2})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(elapsedRealtime)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
    }

    public String getProductId() {
        return this.f3221su;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public int mo8391o(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return i == 4 ? 3 : 0;
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        if (billingResponseCode == 0) {
            m4306cr();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("google_play_status", String.valueOf(billingResponseCode));
        hashMap.put(Prop.EXTRA_SKU, this.f3221su);
        hashMap.put("status", String.valueOf(mo8391o(billingResponseCode)));
        Iterator<String> it = this.f3222sv.iterator();
        while (it.hasNext()) {
            new C1227gq(this.mContext, this.f3220mv, mo8389a(it.next(), hashMap)).start();
        }
    }

    public void recordResolution(int resolution) {
        if (resolution == 1) {
            m4306cr();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("status", String.valueOf(resolution));
        hashMap.put(Prop.EXTRA_SKU, this.f3221su);
        Iterator<String> it = this.f3222sv.iterator();
        while (it.hasNext()) {
            new C1227gq(this.mContext, this.f3220mv, mo8389a(it.next(), hashMap)).start();
        }
    }
}
