package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzli;
import java.util.concurrent.atomic.AtomicBoolean;

@zzin
public abstract class zzhy implements zzkj, zzli.zza {

    /* renamed from: a */
    protected final zzic.zza f6355a;

    /* renamed from: b */
    protected final Context f6356b;

    /* renamed from: c */
    protected final zzlh f6357c;

    /* renamed from: d */
    protected final zzju.zza f6358d;

    /* renamed from: e */
    protected AdResponseParcel f6359e;

    /* renamed from: f */
    protected final Object f6360f = new Object();

    /* renamed from: g */
    private Runnable f6361g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AtomicBoolean f6362h = new AtomicBoolean(true);

    protected zzhy(Context context, zzju.zza zza, zzlh zzlh, zzic.zza zza2) {
        this.f6356b = context;
        this.f6358d = zza;
        this.f6359e = this.f6358d.zzciq;
        this.f6357c = zzlh;
        this.f6355a = zza2;
    }

    /* renamed from: b */
    private zzju m7144b(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.f6358d.zzcip;
        return new zzju(adRequestInfoParcel.zzcar, this.f6357c, this.f6359e.zzbnm, i, this.f6359e.zzbnn, this.f6359e.zzcca, this.f6359e.orientation, this.f6359e.zzbns, adRequestInfoParcel.zzcau, this.f6359e.zzcby, (zzfz) null, (zzgk) null, (String) null, (zzga) null, (zzgc) null, this.f6359e.zzcbz, this.f6358d.zzapa, this.f6359e.zzcbx, this.f6358d.zzcik, this.f6359e.zzccc, this.f6359e.zzccd, this.f6358d.zzcie, (zzh.zza) null, this.f6359e.zzccn, this.f6359e.zzcco, this.f6359e.zzccp, this.f6359e.zzccq, this.f6359e.zzccr, (String) null, this.f6359e.zzbnp);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8486a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8487a(int i) {
        if (i != -2) {
            this.f6359e = new AdResponseParcel(i, this.f6359e.zzbns);
        }
        this.f6357c.zzud();
        this.f6355a.zzb(m7144b(i));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo8488b() {
        return -2;
    }

    public void cancel() {
        if (this.f6362h.getAndSet(false)) {
            this.f6357c.stopLoading();
            zzu.zzfs().zzi(this.f6357c);
            mo8487a(-1);
            zzkh.zzclc.removeCallbacks(this.f6361g);
        }
    }

    public void zza(zzlh zzlh, boolean z) {
        int i = 0;
        zzkd.zzcv("WebView finished loading.");
        if (this.f6362h.getAndSet(false)) {
            if (z) {
                i = mo8488b();
            }
            mo8487a(i);
            zzkh.zzclc.removeCallbacks(this.f6361g);
        }
    }

    /* renamed from: zzpv */
    public final Void zzpy() {
        zzab.zzhi("Webview render task needs to be called on UI thread.");
        this.f6361g = new C1679ka(this);
        zzkh.zzclc.postDelayed(this.f6361g, ((Long) zzdc.zzbbh.get()).longValue());
        mo8486a();
        return null;
    }
}
