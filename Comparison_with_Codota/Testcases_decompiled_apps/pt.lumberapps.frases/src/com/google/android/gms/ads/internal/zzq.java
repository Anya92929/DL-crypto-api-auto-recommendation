package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.p009v4.p019f.C0150o;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzgn;
import com.google.android.gms.internal.zzgo;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzlh;
import java.util.List;

@zzin
public class zzq extends zzb {
    public zzq(Context context, zzd zzd, AdSizeParcel adSizeParcel, String str, zzgj zzgj, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzgj, versionInfoParcel, zzd);
    }

    /* renamed from: a */
    private static zzd m5847a(zzgn zzgn) {
        return new zzd(zzgn.getHeadline(), zzgn.getImages(), zzgn.getBody(), zzgn.zzku() != null ? zzgn.zzku() : null, zzgn.getCallToAction(), zzgn.getStarRating(), zzgn.getStore(), zzgn.getPrice(), (zza) null, zzgn.getExtras());
    }

    /* renamed from: a */
    private static zze m5848a(zzgo zzgo) {
        return new zze(zzgo.getHeadline(), zzgo.getImages(), zzgo.getBody(), zzgo.zzky() != null ? zzgo.zzky() : null, zzgo.getCallToAction(), zzgo.getAdvertiser(), (zza) null, zzgo.getExtras());
    }

    /* renamed from: a */
    private void m5849a(zzd zzd) {
        zzkh.zzclc.post(new C1329z(this, zzd));
    }

    /* renamed from: a */
    private void m5850a(zze zze) {
        zzkh.zzclc.post(new C1214aa(this, zze));
    }

    /* renamed from: a */
    private void m5851a(zzju zzju, String str) {
        zzkh.zzclc.post(new C1215ab(this, str, zzju));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5831a(AdRequestParcel adRequestParcel, zzju zzju, boolean z) {
        return this.f4010e.zzfc();
    }

    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(C0150o oVar) {
        zzab.zzhi("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.f4011f.f4122m = oVar;
    }

    public void zza(zzh zzh) {
        if (this.f4011f.zzapb.zzcie != null) {
            zzu.zzft().zzsu().zza(this.f4011f.zzapa, this.f4011f.zzapb, zzh);
        }
    }

    public void zza(zzdo zzdo) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void zza(zzho zzho) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(zzju.zza zza, zzdk zzdk) {
        if (zza.zzapa != null) {
            this.f4011f.zzapa = zza.zzapa;
        }
        if (zza.errorCode != -2) {
            zzkh.zzclc.post(new C1328y(this, zza));
            return;
        }
        this.f4011f.zzapw = 0;
        this.f4011f.zzaoz = zzu.zzfp().zza(this.f4011f.zzagf, this, zza, this.f4011f.f4111b, (zzlh) null, this.f4015j, this, zzdk);
        String valueOf = String.valueOf(this.f4011f.zzaoz.getClass().getName());
        zzkd.zzcv(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzju zzju, zzju zzju2) {
        zzgo zzgo = null;
        zzb((List) null);
        if (!this.f4011f.zzgp()) {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        if (zzju2.zzcby) {
            try {
                zzgn zzmo = zzju2.zzboo != null ? zzju2.zzboo.zzmo() : null;
                if (zzju2.zzboo != null) {
                    zzgo = zzju2.zzboo.zzmp();
                }
                if (zzmo == null || this.f4011f.f4119j == null) {
                    if (zzgo != null) {
                        if (this.f4011f.f4120k != null) {
                            zze a = m5848a(zzgo);
                            a.zzb(new zzg(this.f4011f.zzagf, this, this.f4011f.f4111b, zzgo));
                            m5850a(a);
                        }
                    }
                    zzkd.zzcx("No matching mapper/listener for retrieved native ad template.");
                    mo5812a(0);
                    return false;
                }
                zzd a2 = m5847a(zzmo);
                a2.zzb(new zzg(this.f4011f.zzagf, this, this.f4011f.f4111b, zzmo));
                m5849a(a2);
            } catch (RemoteException e) {
                zzkd.zzd("Failed to get native ad mapper", e);
            }
        } else {
            zzh.zza zza = zzju2.zzcim;
            if ((zza instanceof zze) && this.f4011f.f4120k != null) {
                m5850a((zze) zzju2.zzcim);
            } else if ((zza instanceof zzd) && this.f4011f.f4119j != null) {
                m5849a((zzd) zzju2.zzcim);
            } else if (!(zza instanceof zzf) || this.f4011f.f4122m == null || this.f4011f.f4122m.get(((zzf) zza).getCustomTemplateId()) == null) {
                zzkd.zzcx("No matching listener for retrieved native ad template.");
                mo5812a(0);
                return false;
            } else {
                m5851a(zzju2, ((zzf) zza).getCustomTemplateId());
            }
        }
        return super.zza(zzju, zzju2);
    }

    public void zzb(C0150o oVar) {
        zzab.zzhi("setOnCustomClickListener must be called on the main UI thread.");
        this.f4011f.f4121l = oVar;
    }

    public void zzb(NativeAdOptionsParcel nativeAdOptionsParcel) {
        zzab.zzhi("setNativeAdOptions must be called on the main UI thread.");
        this.f4011f.f4123n = nativeAdOptionsParcel;
    }

    public void zzb(zzeb zzeb) {
        zzab.zzhi("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.f4011f.f4119j = zzeb;
    }

    public void zzb(zzec zzec) {
        zzab.zzhi("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.f4011f.f4120k = zzec;
    }

    public void zzb(List list) {
        zzab.zzhi("setNativeTemplates must be called on the main UI thread.");
        this.f4011f.f4127r = list;
    }

    public C0150o zzfb() {
        zzab.zzhi("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.f4011f.f4122m;
    }

    public zzed zzv(String str) {
        zzab.zzhi("getOnCustomClickListener must be called on the main UI thread.");
        return (zzed) this.f4011f.f4121l.get(str);
    }
}
