package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzhg;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzlh;

@zzin
public abstract class zzc extends zzb implements zzh, zzhg {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzgj zzgj, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzgj, versionInfoParcel, zzd);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzlh mo5843a(zzju.zza zza, zze zze, zzjo zzjo) {
        zzlh zzlh = null;
        View nextView = this.f4011f.f4112c.getNextView();
        if (nextView instanceof zzlh) {
            zzlh = (zzlh) nextView;
            if (((Boolean) zzdc.zzazz.get()).booleanValue()) {
                zzkd.zzcv("Reusing webview...");
                zzlh.zza(this.f4011f.zzagf, this.f4011f.zzapa, this.f4006a);
            } else {
                zzlh.destroy();
                zzlh = null;
            }
        }
        if (zzlh == null) {
            if (nextView != null) {
                this.f4011f.f4112c.removeView(nextView);
            }
            zzlh = zzu.zzfr().zza(this.f4011f.zzagf, this.f4011f.zzapa, false, false, this.f4011f.f4111b, this.f4011f.zzaow, this.f4006a, this, this.f4014i);
            if (this.f4011f.zzapa.zzaut == null) {
                mo5813a(zzlh.getView());
            }
        }
        zzlh zzlh2 = zzlh;
        zzlh2.zzuj().zza(this, this, this, this, false, this, (zzet) null, zze, this, zzjo);
        mo5844a(zzlh2);
        zzlh2.zzcz(zza.zzcip.zzcbg);
        return zzlh2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5844a(zzft zzft) {
        zzft.zza("/trackActiveViewUnit", (zzep) new C1255e(this));
    }

    public void zza(int i, int i2, int i3, int i4) {
        mo5819c();
    }

    public void zza(zzdo zzdo) {
        zzab.zzhi("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f4011f.f4125p = zzdo;
    }

    /* access modifiers changed from: protected */
    public void zza(zzju.zza zza, zzdk zzdk) {
        zzjo zzjo = null;
        if (zza.errorCode != -2) {
            zzkh.zzclc.post(new C1256f(this, zza));
            return;
        }
        if (zza.zzapa != null) {
            this.f4011f.zzapa = zza.zzapa;
        }
        if (!zza.zzciq.zzcby || zza.zzciq.zzauw) {
            if (((Boolean) zzdc.zzbdf.get()).booleanValue()) {
                zzjo = this.f4014i.zzakm.zza(this.f4011f.zzagf, zza.zzciq);
            }
            zzkh.zzclc.post(new C1268g(this, zza, zzjo, zzdk));
            return;
        }
        this.f4011f.zzapw = 0;
        this.f4011f.zzaoz = zzu.zzfp().zza(this.f4011f.zzagf, this, zza, this.f4011f.f4111b, (zzlh) null, this.f4015j, this, zzdk);
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzju zzju, zzju zzju2) {
        if (this.f4011f.zzgp() && this.f4011f.f4112c != null) {
            this.f4011f.f4112c.zzgv().zzcs(zzju2.zzccd);
        }
        return super.zza(zzju, zzju2);
    }

    public void zzc(View view) {
        this.f4011f.f4129t = view;
        zzb(new zzju(this.f4011f.zzapc, (zzlh) null, (zzfz) null, (zzgk) null, (String) null, (zzgc) null, (zzh.zza) null, (String) null));
    }

    public void zzeh() {
        onAdClicked();
    }

    public void zzei() {
        recordImpression();
        zzdp();
    }

    public void zzej() {
        mo5811a();
    }
}
