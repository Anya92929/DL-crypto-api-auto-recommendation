package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhn;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzin
public class zzd extends zzhn.zza {

    /* renamed from: a */
    private String f3874a;

    /* renamed from: b */
    private Context f3875b;

    /* renamed from: c */
    private String f3876c;

    /* renamed from: d */
    private ArrayList f3877d;

    public zzd(String str, ArrayList arrayList, Context context, String str2) {
        this.f3876c = str;
        this.f3877d = arrayList;
        this.f3874a = str2;
        this.f3875b = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo5587a(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return i == 4 ? 3 : 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map mo5588a() {
        String packageName = this.f3875b.getPackageName();
        String str = "";
        try {
            str = this.f3875b.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            zzkd.zzd("Error to retrieve app version", e);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzu.zzft().zzsk().zzsx();
        HashMap hashMap = new HashMap();
        hashMap.put("sessionid", zzu.zzft().getSessionId());
        hashMap.put("appid", packageName);
        hashMap.put("osversion", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("sdkversion", this.f3874a);
        hashMap.put("appversion", str);
        hashMap.put("timestamp", String.valueOf(elapsedRealtime));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5589b() {
        try {
            this.f3875b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke((Object) null, new Object[]{this.f3875b, this.f3876c, "", true});
        } catch (ClassNotFoundException e) {
            zzkd.zzcx("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            zzkd.zzcx("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Exception e3) {
            zzkd.zzd("Fail to report a conversion.", e3);
        }
    }

    public String getProductId() {
        return this.f3876c;
    }

    public void recordPlayBillingResolution(int i) {
        if (i == 0) {
            mo5589b();
        }
        Map a = mo5588a();
        a.put("google_play_status", String.valueOf(i));
        a.put("sku", this.f3876c);
        a.put("status", String.valueOf(mo5587a(i)));
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f3877d.iterator();
        while (it.hasNext()) {
            linkedList.add(zzu.zzfq().zzb((String) it.next(), a));
        }
        zzu.zzfq().zza(this.f3875b, this.f3874a, (List) linkedList);
    }

    public void recordResolution(int i) {
        if (i == 1) {
            mo5589b();
        }
        Map a = mo5588a();
        a.put("status", String.valueOf(i));
        a.put("sku", this.f3876c);
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f3877d.iterator();
        while (it.hasNext()) {
            linkedList.add(zzu.zzfq().zzb((String) it.next(), a));
        }
        zzu.zzfq().zza(this.f3875b, this.f3874a, (List) linkedList);
    }
}
