package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzfp;
import com.google.android.gms.internal.zzli;
import org.json.JSONObject;

@zzin
public class zzfr implements zzfp {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzlh f6192a;

    public zzfr(Context context, VersionInfoParcel versionInfoParcel, zzas zzas) {
        this.f6192a = zzu.zzfr().zza(context, new AdSizeParcel(), false, false, zzas, versionInfoParcel);
        this.f6192a.getWebView().setWillNotDraw(true);
    }

    /* renamed from: a */
    private void m7054a(Runnable runnable) {
        if (zzm.zziw().zztx()) {
            runnable.run();
        } else {
            zzkh.zzclc.post(runnable);
        }
    }

    public void destroy() {
        this.f6192a.destroy();
    }

    public void zza(zza zza, zzg zzg, zzel zzel, zzp zzp, boolean z, zzer zzer, zzet zzet, zze zze, zzhg zzhg) {
        this.f6192a.zzuj().zza(zza, zzg, zzel, zzp, z, zzer, zzet, new zze(this.f6192a.getContext(), false), zzhg, (zzjo) null);
    }

    public void zza(zzfp.zza zza) {
        this.f6192a.zzuj().zza((zzli.zza) new C1615hr(this, zza));
    }

    public void zza(String str, zzep zzep) {
        this.f6192a.zzuj().zza(str, zzep);
    }

    public void zza(String str, JSONObject jSONObject) {
        m7054a((Runnable) new C1610hm(this, str, jSONObject));
    }

    public void zzb(String str, zzep zzep) {
        this.f6192a.zzuj().zzb(str, zzep);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.f6192a.zzb(str, jSONObject);
    }

    public void zzbg(String str) {
        m7054a((Runnable) new C1612ho(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public void zzbh(String str) {
        m7054a((Runnable) new C1614hq(this, str));
    }

    public void zzbi(String str) {
        m7054a((Runnable) new C1613hp(this, str));
    }

    public void zzj(String str, String str2) {
        m7054a((Runnable) new C1611hn(this, str, str2));
    }

    public zzfu zzly() {
        return new zzfv(this);
    }
}
