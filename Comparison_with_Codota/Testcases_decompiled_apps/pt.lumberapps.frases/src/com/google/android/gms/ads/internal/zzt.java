package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkg;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@zzin
public class zzt extends zzu.zza {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final VersionInfoParcel f4071a;

    /* renamed from: b */
    private final AdSizeParcel f4072b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Future f4073c = m5865d();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Context f4074d;

    /* renamed from: e */
    private final C1221ah f4075e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WebView f4076f = new WebView(this.f4074d);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public zzq f4077g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public zzbw f4078h;

    /* renamed from: i */
    private AsyncTask f4079i;

    public zzt(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this.f4074d = context;
        this.f4071a = versionInfoParcel;
        this.f4072b = adSizeParcel;
        this.f4075e = new C1221ah(str);
        m5862c();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m5859b(String str) {
        if (this.f4078h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.f4078h.zzd(parse, this.f4074d);
        } catch (RemoteException e) {
            zzkd.zzd("Unable to process ad data", e);
        } catch (zzbx e2) {
            zzkd.zzd("Unable to parse ad click url", e2);
        }
        return parse.toString();
    }

    /* renamed from: c */
    private void m5862c() {
        mo5894a(0);
        this.f4076f.setVerticalScrollBarEnabled(false);
        this.f4076f.getSettings().setJavaScriptEnabled(true);
        this.f4076f.setWebViewClient(new C1217ad(this));
        this.f4076f.setOnTouchListener(new C1218ae(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5863c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.f4074d.startActivity(intent);
    }

    /* renamed from: d */
    private Future m5865d() {
        return zzkg.zza((Callable) new C1219af(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5892a(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            return zzm.zziw().zza(this.f4074d, Integer.parseInt(queryParameter));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5893a() {
        Uri uri;
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzdc.zzbdb.get());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.f4075e.mo5014b());
        builder.appendQueryParameter("pubId", this.f4075e.mo5015c());
        Map d = this.f4075e.mo5016d();
        for (String str : d.keySet()) {
            builder.appendQueryParameter(str, (String) d.get(str));
        }
        Uri build = builder.build();
        if (this.f4078h != null) {
            try {
                uri = this.f4078h.zzc(build, this.f4074d);
            } catch (RemoteException | zzbx e) {
                zzkd.zzd("Unable to process ad data", e);
            }
            String valueOf = String.valueOf(mo5895b());
            String valueOf2 = String.valueOf(uri.getEncodedQuery());
            return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("#").append(valueOf2).toString();
        }
        uri = build;
        String valueOf3 = String.valueOf(mo5895b());
        String valueOf22 = String.valueOf(uri.getEncodedQuery());
        return new StringBuilder(String.valueOf(valueOf3).length() + 1 + String.valueOf(valueOf22).length()).append(valueOf3).append("#").append(valueOf22).toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5894a(int i) {
        if (this.f4076f != null) {
            this.f4076f.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo5895b() {
        String a = this.f4075e.mo5012a();
        String str = TextUtils.isEmpty(a) ? "www.google.com" : a;
        String valueOf = String.valueOf("https://");
        String str2 = (String) zzdc.zzbdb.get();
        return new StringBuilder(String.valueOf(valueOf).length() + 0 + String.valueOf(str).length() + String.valueOf(str2).length()).append(valueOf).append(str).append(str2).toString();
    }

    public void destroy() {
        zzab.zzhi("destroy must be called on the main UI thread.");
        this.f4079i.cancel(true);
        this.f4073c.cancel(true);
        this.f4076f.destroy();
        this.f4076f = null;
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void pause() {
        zzab.zzhi("pause must be called on the main UI thread.");
    }

    public void resume() {
        zzab.zzhi("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
    }

    public void setUserId(String str) {
        throw new IllegalStateException("Unused method");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Unused method");
    }

    public void stopLoading() {
    }

    public void zza(AdSizeParcel adSizeParcel) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public void zza(VideoOptionsParcel videoOptionsParcel) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzp zzp) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzq zzq) {
        this.f4077g = zzq;
    }

    public void zza(zzw zzw) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzy zzy) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzd zzd) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzdo zzdo) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzho zzho) {
        throw new IllegalStateException("Unused method");
    }

    public void zza(zzhs zzhs, String str) {
        throw new IllegalStateException("Unused method");
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzab.zzb((Object) this.f4076f, (Object) "This Search Ad has already been torn down");
        this.f4075e.mo5013a(adRequestParcel);
        this.f4079i = new C1220ag(this, (C1217ad) null).execute(new Void[0]);
        return true;
    }

    public com.google.android.gms.dynamic.zzd zzdm() {
        zzab.zzhi("getAdFrame must be called on the main UI thread.");
        return zze.zzac(this.f4076f);
    }

    public AdSizeParcel zzdn() {
        return this.f4072b;
    }

    public void zzdp() {
        throw new IllegalStateException("Unused method");
    }

    public com.google.android.gms.ads.internal.client.zzab zzdq() {
        return null;
    }
}
