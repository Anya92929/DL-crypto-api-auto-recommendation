package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzga;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzla;
import com.google.android.gms.internal.zzlb;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzb extends zzkc implements zzc.zza {

    /* renamed from: a */
    zzkj f3932a;

    /* renamed from: b */
    AdResponseParcel f3933b;

    /* renamed from: c */
    zzga f3934c;

    /* renamed from: d */
    private final zza.C2105zza f3935d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AdRequestInfoParcel.zza f3936e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Object f3937f = new Object();

    /* renamed from: g */
    private final Context f3938g;

    /* renamed from: h */
    private final zzas f3939h;

    /* renamed from: i */
    private AdRequestInfoParcel f3940i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Runnable f3941j;

    public zzb(Context context, AdRequestInfoParcel.zza zza, zzas zzas, zza.C2105zza zza2) {
        this.f3935d = zza2;
        this.f3938g = context;
        this.f3936e = zza;
        this.f3939h = zzas;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5734a(int i, String str) {
        if (i == 3 || i == -1) {
            zzkd.zzcw(str);
        } else {
            zzkd.zzcx(str);
        }
        if (this.f3933b == null) {
            this.f3933b = new AdResponseParcel(i);
        } else {
            this.f3933b = new AdResponseParcel(i, this.f3933b.zzbns);
        }
        this.f3935d.zza(new zzju.zza(this.f3940i != null ? this.f3940i : new AdRequestInfoParcel(this.f3936e, (String) null, -1), this.f3933b, this.f3934c, (AdSizeParcel) null, i, -1, this.f3933b.zzccc, (JSONObject) null));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AdSizeParcel mo5655a(AdRequestInfoParcel adRequestInfoParcel) {
        if (this.f3933b.zzauv) {
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzapa.zzaut) {
                if (adSizeParcel.zzauv) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.zzapa.zzaut);
                }
            }
        }
        if (this.f3933b.zzccb == null) {
            throw new C1303d("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.f3933b.zzccb.split("x");
        if (split.length != 2) {
            String valueOf = String.valueOf(this.f3933b.zzccb);
            throw new C1303d(valueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(valueOf) : new String("Invalid ad size format from the ad response: "), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (AdSizeParcel adSizeParcel2 : adRequestInfoParcel.zzapa.zzaut) {
                float f = this.f3938g.getResources().getDisplayMetrics().density;
                int i = adSizeParcel2.width == -1 ? (int) (((float) adSizeParcel2.widthPixels) / f) : adSizeParcel2.width;
                int i2 = adSizeParcel2.height == -2 ? (int) (((float) adSizeParcel2.heightPixels) / f) : adSizeParcel2.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new AdSizeParcel(adSizeParcel2, adRequestInfoParcel.zzapa.zzaut);
                }
            }
            String valueOf2 = String.valueOf(this.f3933b.zzccb);
            throw new C1303d(valueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(valueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
        } catch (NumberFormatException e) {
            String valueOf3 = String.valueOf(this.f3933b.zzccb);
            throw new C1303d(valueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(valueOf3) : new String("Invalid ad size number from the ad response: "), 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzkj mo5656a(VersionInfoParcel versionInfoParcel, zzla zzla) {
        return zzc.zza(this.f3938g, versionInfoParcel, zzla, this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5657a() {
        if (this.f3933b.errorCode != -3) {
            if (TextUtils.isEmpty(this.f3933b.body)) {
                throw new C1303d("No fill from ad server.", 3);
            }
            zzu.zzft().zzc(this.f3938g, this.f3933b.zzcaz);
            if (this.f3933b.zzcby) {
                try {
                    this.f3934c = new zzga(this.f3933b.body);
                    zzu.zzft().zzaf(this.f3934c.zzbnq);
                } catch (JSONException e) {
                    zzkd.zzb("Could not parse mediation config.", e);
                    String valueOf = String.valueOf(this.f3933b.body);
                    throw new C1303d(valueOf.length() != 0 ? "Could not parse mediation config: ".concat(valueOf) : new String("Could not parse mediation config: "), 0);
                }
            } else {
                zzu.zzft().zzaf(this.f3933b.zzbnq);
            }
            if (!TextUtils.isEmpty(this.f3933b.zzcbr) && ((Boolean) zzdc.zzbdn.get()).booleanValue()) {
                zzkd.zzcv("Received cookie from server. Setting webview cookie in CookieManager.");
                CookieManager zzao = zzu.zzfs().zzao(this.f3938g);
                if (zzao != null) {
                    zzao.setCookie("googleads.g.doubleclick.net", this.f3933b.zzcbr);
                }
            }
        }
    }

    public void onStop() {
        synchronized (this.f3937f) {
            if (this.f3932a != null) {
                this.f3932a.cancel();
            }
        }
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        JSONObject jSONObject;
        zzkd.zzcv("Received ad response.");
        this.f3933b = adResponseParcel;
        long elapsedRealtime = zzu.zzfu().elapsedRealtime();
        synchronized (this.f3937f) {
            this.f3932a = null;
        }
        zzu.zzft().zzd(this.f3938g, this.f3933b.zzcbq);
        try {
            if (this.f3933b.errorCode == -2 || this.f3933b.errorCode == -3) {
                mo5657a();
                AdSizeParcel a = this.f3940i.zzapa.zzaut != null ? mo5655a(this.f3940i) : null;
                zzu.zzft().zzae(this.f3933b.zzcci);
                if (!TextUtils.isEmpty(this.f3933b.zzccg)) {
                    try {
                        jSONObject = new JSONObject(this.f3933b.zzccg);
                    } catch (Exception e) {
                        zzkd.zzb("Error parsing the JSON for Active View.", e);
                    }
                    this.f3935d.zza(new zzju.zza(this.f3940i, this.f3933b, this.f3934c, a, -2, elapsedRealtime, this.f3933b.zzccc, jSONObject));
                    zzkh.zzclc.removeCallbacks(this.f3941j);
                    return;
                }
                jSONObject = null;
                this.f3935d.zza(new zzju.zza(this.f3940i, this.f3933b, this.f3934c, a, -2, elapsedRealtime, this.f3933b.zzccc, jSONObject));
                zzkh.zzclc.removeCallbacks(this.f3941j);
                return;
            }
            throw new C1303d(new StringBuilder(66).append("There was a problem getting an ad response. ErrorCode: ").append(this.f3933b.errorCode).toString(), this.f3933b.errorCode);
        } catch (C1303d e2) {
            m5734a(e2.mo5640a(), e2.getMessage());
            zzkh.zzclc.removeCallbacks(this.f3941j);
        }
    }

    public void zzew() {
        zzkd.zzcv("AdLoaderBackgroundTask started.");
        this.f3941j = new C1301b(this);
        zzkh.zzclc.postDelayed(this.f3941j, ((Long) zzdc.zzbbg.get()).longValue());
        zzlb zzlb = new zzlb();
        long elapsedRealtime = zzu.zzfu().elapsedRealtime();
        zzkg.zza((Runnable) new C1302c(this, zzlb));
        this.f3940i = new AdRequestInfoParcel(this.f3936e, this.f3939h.zzaw().zzb(this.f3938g), elapsedRealtime);
        zzlb.zzg(this.f3940i);
    }
}
