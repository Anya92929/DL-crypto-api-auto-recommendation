package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zzlm;

@zzin
public class zzf extends zzc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: l */
    private boolean f4021l;

    public class zza {
        public zza() {
        }

        public void onClick() {
            zzf.this.onAdClicked();
        }
    }

    public zzf(Context context, AdSizeParcel adSizeParcel, String str, zzgj zzgj, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzgj, versionInfoParcel, zzd);
    }

    /* renamed from: a */
    private AdSizeParcel m5795a(zzju.zza zza2) {
        AdSize zzij;
        if (zza2.zzciq.zzauv) {
            return this.f4011f.zzapa;
        }
        String str = zza2.zzciq.zzccb;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            zzij = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            zzij = this.f4011f.zzapa.zzij();
        }
        return new AdSizeParcel(this.f4011f.zzagf, zzij);
    }

    /* renamed from: a */
    private boolean m5796a(zzju zzju, zzju zzju2) {
        if (zzju2.zzcby) {
            View zzf = zzn.zzf(zzju2);
            if (zzf == null) {
                zzkd.zzcx("Could not get mediation view");
                return false;
            }
            View nextView = this.f4011f.f4112c.getNextView();
            if (nextView != null) {
                if (nextView instanceof zzlh) {
                    ((zzlh) nextView).destroy();
                }
                this.f4011f.f4112c.removeView(nextView);
            }
            if (!zzn.zzg(zzju2)) {
                try {
                    mo5813a(zzf);
                } catch (Throwable th) {
                    zzkd.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (!(zzju2.zzcii == null || zzju2.zzbtm == null)) {
            zzju2.zzbtm.zza(zzju2.zzcii);
            this.f4011f.f4112c.removeAllViews();
            this.f4011f.f4112c.setMinimumWidth(zzju2.zzcii.widthPixels);
            this.f4011f.f4112c.setMinimumHeight(zzju2.zzcii.heightPixels);
            mo5813a(zzju2.zzbtm.getView());
        }
        if (this.f4011f.f4112c.getChildCount() > 1) {
            this.f4011f.f4112c.showNext();
        }
        if (zzju != null) {
            View nextView2 = this.f4011f.f4112c.getNextView();
            if (nextView2 instanceof zzlh) {
                ((zzlh) nextView2).zza(this.f4011f.zzagf, this.f4011f.zzapa, this.f4006a);
            } else if (nextView2 != null) {
                this.f4011f.f4112c.removeView(nextView2);
            }
            this.f4011f.zzgo();
        }
        this.f4011f.f4112c.setVisibility(0);
        return true;
    }

    /* renamed from: d */
    private void m5797d(zzju zzju) {
        if (this.f4011f.zzgp()) {
            if (zzju.zzbtm != null) {
                if (zzju.zzcie != null) {
                    this.f4013h.zza(this.f4011f.zzapa, zzju);
                }
                if (zzju.zzho()) {
                    this.f4013h.zza(this.f4011f.zzapa, zzju).zza((zzce) zzju.zzbtm);
                } else {
                    zzju.zzbtm.zzuj().zza((zzli.zzb) new C1273l(this, zzju));
                }
            }
        } else if (this.f4011f.f4129t != null && zzju.zzcie != null) {
            this.f4013h.zza(this.f4011f.zzapa, zzju, this.f4011f.f4129t);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzlh mo5843a(zzju.zza zza2, zze zze, zzjo zzjo) {
        if (this.f4011f.zzapa.zzaut == null && this.f4011f.zzapa.zzauv) {
            this.f4011f.zzapa = m5795a(zza2);
        }
        return super.mo5843a(zza2, zze, zzjo);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5830a(zzju zzju, boolean z) {
        super.mo5830a(zzju, z);
        if (zzn.zzg(zzju)) {
            zzn.zza(zzju, new zza());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public AdRequestParcel mo5853b(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.zzatr == this.f4021l) {
            return adRequestParcel;
        }
        return new AdRequestParcel(adRequestParcel.versionCode, adRequestParcel.zzatm, adRequestParcel.extras, adRequestParcel.zzatn, adRequestParcel.zzato, adRequestParcel.zzatp, adRequestParcel.zzatq, adRequestParcel.zzatr || this.f4021l, adRequestParcel.zzats, adRequestParcel.zzatt, adRequestParcel.zzatu, adRequestParcel.zzatv, adRequestParcel.zzatw, adRequestParcel.zzatx, adRequestParcel.zzaty, adRequestParcel.zzatz, adRequestParcel.zzaua, adRequestParcel.zzaub);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5854c(zzju zzju) {
        if (zzju != null && !zzju.zzcif && this.f4011f.f4112c != null && zzu.zzfq().zza((View) this.f4011f.f4112c, this.f4011f.zzagf) && this.f4011f.f4112c.getGlobalVisibleRect(new Rect(), (Point) null)) {
            if (!(zzju == null || zzju.zzbtm == null || zzju.zzbtm.zzuj() == null)) {
                zzju.zzbtm.zzuj().zza((zzli.zzd) null);
            }
            mo5830a(zzju, false);
            zzju.zzcif = true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo5832f() {
        boolean z = true;
        if (!zzu.zzfq().zza(this.f4011f.zzagf.getPackageManager(), this.f4011f.zzagf.getPackageName(), "android.permission.INTERNET")) {
            zzm.zziw().zza(this.f4011f.f4112c, this.f4011f.zzapa, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzu.zzfq().zzac(this.f4011f.zzagf)) {
            zzm.zziw().zza(this.f4011f.f4112c, this.f4011f.zzapa, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.f4011f.f4112c != null) {
            this.f4011f.f4112c.setVisibility(0);
        }
        return z;
    }

    public void onGlobalLayout() {
        mo5854c(this.f4011f.zzapb);
    }

    public void onScrollChanged() {
        mo5854c(this.f4011f.zzapb);
    }

    public void setManualImpressionsEnabled(boolean z) {
        zzab.zzhi("setManualImpressionsEnabled must be called from the main thread.");
        this.f4021l = z;
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public boolean zza(zzju zzju, zzju zzju2) {
        zzlm zzlm;
        if (!super.zza(zzju, zzju2)) {
            return false;
        }
        if (!this.f4011f.zzgp() || m5796a(zzju, zzju2)) {
            if (zzju2.zzccq) {
                mo5854c(zzju2);
                zzu.zzgk().zza((View) this.f4011f.f4112c, (ViewTreeObserver.OnGlobalLayoutListener) this);
                zzu.zzgk().zza((View) this.f4011f.f4112c, (ViewTreeObserver.OnScrollChangedListener) this);
                if (!zzju2.zzcif) {
                    C1271j jVar = new C1271j(this);
                    zzli zzuj = zzju2.zzbtm != null ? zzju2.zzbtm.zzuj() : null;
                    if (zzuj != null) {
                        zzuj.zza((zzli.zzd) new C1272k(this, zzju2, jVar));
                    }
                }
            } else if (!this.f4011f.zzgq() || ((Boolean) zzdc.zzbce.get()).booleanValue()) {
                mo5830a(zzju2, false);
            }
            if (zzju2.zzbtm != null) {
                zzlm = zzju2.zzbtm.zzut();
                zzli zzuj2 = zzju2.zzbtm.zzuj();
                if (zzuj2 != null) {
                    zzuj2.zzva();
                }
            } else {
                zzlm = null;
            }
            if (!(this.f4011f.f4124o == null || zzlm == null)) {
                zzlm.zzam(this.f4011f.f4124o.zzaxm);
            }
            m5797d(zzju2);
            return true;
        }
        mo5812a(0);
        return false;
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        return super.zzb(mo5853b(adRequestParcel));
    }

    public com.google.android.gms.ads.internal.client.zzab zzdq() {
        zzab.zzhi("getVideoController must be called from the main thread.");
        if (this.f4011f.zzapb == null || this.f4011f.zzapb.zzbtm == null) {
            return null;
        }
        return this.f4011f.zzapb.zzbtm.zzut();
    }
}
