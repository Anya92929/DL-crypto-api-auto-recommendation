package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.zzu;
import java.util.LinkedHashMap;
import java.util.Map;

@zzin
public class zzdd {

    /* renamed from: a */
    private boolean f6100a;

    /* renamed from: b */
    private String f6101b;

    /* renamed from: c */
    private Map f6102c;

    /* renamed from: d */
    private Context f6103d = null;

    /* renamed from: e */
    private String f6104e = null;

    public zzdd(Context context, String str) {
        this.f6103d = context;
        this.f6104e = str;
        this.f6100a = ((Boolean) zzdc.zzaze.get()).booleanValue();
        this.f6101b = (String) zzdc.zzazf.get();
        this.f6102c = new LinkedHashMap();
        this.f6102c.put("s", "gmob_sdk");
        this.f6102c.put("v", "3");
        this.f6102c.put("os", Build.VERSION.RELEASE);
        this.f6102c.put("sdk", Build.VERSION.SDK);
        this.f6102c.put("device", zzu.zzfq().zztg());
        this.f6102c.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        this.f6102c.put("is_lite_sdk", zzu.zzfq().zzan(context) ? "1" : "0");
        zziv zzy = zzu.zzfw().zzy(this.f6103d);
        this.f6102c.put("network_coarse", Integer.toString(zzy.zzcgp));
        this.f6102c.put("network_fine", Integer.toString(zzy.zzcgq));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8267a() {
        return this.f6100a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo8268b() {
        return this.f6101b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Context mo8269c() {
        return this.f6103d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo8270d() {
        return this.f6104e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Map mo8271e() {
        return this.f6102c;
    }
}
