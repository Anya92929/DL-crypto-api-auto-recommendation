package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzhi;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzin;

@zzin
public class zzl {

    /* renamed from: a */
    private zzx f3598a;

    /* renamed from: b */
    private final Object f3599b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final zze f3600c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzd f3601d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzai f3602e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final zzef f3603f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzf f3604g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zzhu f3605h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final zzhh f3606i;

    public zzl(zze zze, zzd zzd, zzai zzai, zzef zzef, zzf zzf, zzhu zzhu, zzhh zzhh) {
        this.f3600c = zze;
        this.f3601d = zzd;
        this.f3602e = zzai;
        this.f3603f = zzef;
        this.f3604g = zzf;
        this.f3605h = zzhu;
        this.f3606i = zzhh;
    }

    /* renamed from: a */
    private static zzx m5603a() {
        try {
            Object newInstance = zzl.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return zzx.zza.asInterface((IBinder) newInstance);
            }
            zzb.zzcx("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Exception e) {
            zzb.zzd("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    /* renamed from: a */
    private Object m5605a(Context context, boolean z, C1246s sVar) {
        if (!z && !zzm.zziw().zzar(context)) {
            zzb.zzcv("Google Play Services is not available");
            z = true;
        }
        if (z) {
            Object c = sVar.mo5079c();
            return c == null ? sVar.mo5061b() : c;
        }
        Object b = sVar.mo5061b();
        return b == null ? sVar.mo5079c() : b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5606a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzm.zziw().zza(context, (String) null, "gmob-apps", bundle, true);
    }

    /* renamed from: a */
    private static boolean m5608a(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        zzb.m5769e("useClientJar flag not found in activity intent extras.");
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public zzx m5610b() {
        zzx zzx;
        synchronized (this.f3599b) {
            if (this.f3598a == null) {
                this.f3598a = m5603a();
            }
            zzx = this.f3598a;
        }
        return zzx;
    }

    public zzu zza(Context context, AdSizeParcel adSizeParcel, String str) {
        return (zzu) m5605a(context, false, (C1246s) new C1238k(this, context, adSizeParcel, str));
    }

    public zzu zza(Context context, AdSizeParcel adSizeParcel, String str, zzgj zzgj) {
        return (zzu) m5605a(context, false, (C1246s) new C1237j(this, context, adSizeParcel, str, zzgj));
    }

    public com.google.android.gms.ads.internal.reward.client.zzb zza(Context context, zzgj zzgj) {
        return (com.google.android.gms.ads.internal.reward.client.zzb) m5605a(context, false, (C1246s) new C1243p(this, context, zzgj));
    }

    public zzdt zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzdt) m5605a(context, false, (C1246s) new C1242o(this, frameLayout, frameLayout2, context));
    }

    public zzs zzb(Context context, String str, zzgj zzgj) {
        return (zzs) m5605a(context, false, (C1246s) new C1240m(this, context, str, zzgj));
    }

    public zzu zzb(Context context, AdSizeParcel adSizeParcel, String str, zzgj zzgj) {
        return (zzu) m5605a(context, false, (C1246s) new C1239l(this, context, adSizeParcel, str, zzgj));
    }

    public zzhp zzb(Activity activity) {
        return (zzhp) m5605a((Context) activity, m5608a(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), (C1246s) new C1244q(this, activity));
    }

    public zzhi zzc(Activity activity) {
        return (zzhi) m5605a((Context) activity, m5608a(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), (C1246s) new C1245r(this, activity));
    }

    public zzz zzl(Context context) {
        return (zzz) m5605a(context, false, (C1246s) new C1241n(this, context));
    }
}
