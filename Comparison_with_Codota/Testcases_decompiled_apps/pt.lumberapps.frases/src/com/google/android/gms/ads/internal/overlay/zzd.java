package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzhg;
import com.google.android.gms.internal.zzhi;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Future;

@zzin
public class zzd extends zzhi.zza implements zzu {

    /* renamed from: a */
    static final int f3778a = Color.argb(0, 0, 0, 0);

    /* renamed from: b */
    AdOverlayInfoParcel f3779b;

    /* renamed from: c */
    zzlh f3780c;

    /* renamed from: d */
    zzc f3781d;

    /* renamed from: e */
    zzo f3782e;

    /* renamed from: f */
    boolean f3783f = false;

    /* renamed from: g */
    FrameLayout f3784g;

    /* renamed from: h */
    WebChromeClient.CustomViewCallback f3785h;

    /* renamed from: i */
    boolean f3786i = false;

    /* renamed from: j */
    boolean f3787j = false;

    /* renamed from: k */
    C1286j f3788k;

    /* renamed from: l */
    boolean f3789l = false;

    /* renamed from: m */
    int f3790m = 0;

    /* renamed from: n */
    zzl f3791n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final Activity f3792o;

    /* renamed from: p */
    private boolean f3793p;

    /* renamed from: q */
    private boolean f3794q = false;

    /* renamed from: r */
    private boolean f3795r = true;

    @zzin
    public class zzc {
        public final int index;
        public final Context zzagf;
        public final ViewGroup.LayoutParams zzbtf;
        public final ViewGroup zzbtg;

        public zzc(zzlh zzlh) {
            this.zzbtf = zzlh.getLayoutParams();
            ViewParent parent = zzlh.getParent();
            this.zzagf = zzlh.zzuf();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new C1285i("Could not get the parent of the WebView for an overlay.");
            }
            this.zzbtg = (ViewGroup) parent;
            this.index = this.zzbtg.indexOfChild(zzlh.getView());
            this.zzbtg.removeView(zzlh.getView());
            zzlh.zzah(true);
        }
    }

    public zzd(Activity activity) {
        this.f3792o = activity;
        this.f3791n = new zzs();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5465a() {
        if (this.f3792o.isFinishing() && !this.f3794q) {
            this.f3794q = true;
            if (this.f3780c != null) {
                mo5466a(this.f3790m);
                this.f3788k.removeView(this.f3780c.getView());
                if (this.f3781d != null) {
                    this.f3780c.setContext(this.f3781d.zzagf);
                    this.f3780c.zzah(false);
                    this.f3781d.zzbtg.addView(this.f3780c.getView(), this.f3781d.index, this.f3781d.zzbtf);
                    this.f3781d = null;
                } else if (this.f3792o.getApplicationContext() != null) {
                    this.f3780c.setContext(this.f3792o.getApplicationContext());
                }
                this.f3780c = null;
            }
            if (!(this.f3779b == null || this.f3779b.zzbtl == null)) {
                this.f3779b.zzbtl.zzdx();
            }
            this.f3791n.destroy();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5466a(int i) {
        this.f3780c.zzaf(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5467a(boolean z) {
        if (!this.f3793p) {
            this.f3792o.requestWindowFeature(1);
        }
        Window window = this.f3792o.getWindow();
        if (window == null) {
            throw new C1285i("Invalid activity, no window available.");
        }
        if (!this.f3787j || (this.f3779b.zzbtv != null && this.f3779b.zzbtv.zzamf)) {
            window.setFlags(1024, 1024);
        }
        zzli zzuj = this.f3779b.zzbtm.zzuj();
        boolean zzho = zzuj != null ? zzuj.zzho() : false;
        this.f3789l = false;
        if (zzho) {
            if (this.f3779b.orientation == zzu.zzfs().zztj()) {
                this.f3789l = this.f3792o.getResources().getConfiguration().orientation == 1;
            } else if (this.f3779b.orientation == zzu.zzfs().zztk()) {
                this.f3789l = this.f3792o.getResources().getConfiguration().orientation == 2;
            }
        }
        zzkd.zzcv(new StringBuilder(46).append("Delay onShow to next orientation change: ").append(this.f3789l).toString());
        setRequestedOrientation(this.f3779b.orientation);
        if (zzu.zzfs().zza(window)) {
            zzkd.zzcv("Hardware acceleration on the AdActivity window enabled.");
        }
        if (!this.f3787j) {
            this.f3788k.setBackgroundColor(-16777216);
        } else {
            this.f3788k.setBackgroundColor(f3778a);
        }
        this.f3792o.setContentView(this.f3788k);
        zzdb();
        if (z) {
            this.f3780c = zzu.zzfr().zza(this.f3792o, this.f3779b.zzbtm.zzdn(), true, zzho, (zzas) null, this.f3779b.zzaow, (zzdk) null, (zzs) null, this.f3779b.zzbtm.zzug());
            this.f3780c.zzuj().zza((zza) null, (zzg) null, this.f3779b.zzbtn, this.f3779b.zzbtr, true, this.f3779b.zzbtt, (zzet) null, this.f3779b.zzbtm.zzuj().zzux(), (zzhg) null, (zzjo) null);
            this.f3780c.zzuj().zza((zzli.zza) new C1284h(this));
            if (this.f3779b.url != null) {
                this.f3780c.loadUrl(this.f3779b.url);
            } else if (this.f3779b.zzbtq != null) {
                this.f3780c.loadDataWithBaseURL(this.f3779b.zzbto, this.f3779b.zzbtq, "text/html", "UTF-8", (String) null);
            } else {
                throw new C1285i("No URL or HTML to display in ad overlay.");
            }
            if (this.f3779b.zzbtm != null) {
                this.f3779b.zzbtm.zzc(this);
            }
        } else {
            this.f3780c = this.f3779b.zzbtm;
            this.f3780c.setContext(this.f3792o);
        }
        this.f3780c.zzb(this);
        ViewParent parent = this.f3780c.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f3780c.getView());
        }
        if (this.f3787j) {
            this.f3780c.setBackgroundColor(f3778a);
        }
        this.f3788k.addView(this.f3780c.getView(), -1, -1);
        if (!z && !this.f3789l) {
            mo5468b();
        }
        zzz(zzho);
        if (this.f3780c.zzuk()) {
            zza(zzho, true);
        }
        com.google.android.gms.ads.internal.zzd zzug = this.f3780c.zzug();
        zzm zzm = zzug != null ? zzug.zzakl : null;
        if (zzm != null) {
            this.f3791n = zzm.zza(this.f3792o, this.f3780c, this.f3788k);
        } else {
            zzkd.zzcx("Appstreaming controller is null.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5468b() {
        this.f3780c.zzoa();
    }

    public void close() {
        this.f3790m = 2;
        this.f3792o.finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onBackPressed() {
        this.f3790m = 0;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        this.f3792o.requestWindowFeature(1);
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f3786i = z;
        try {
            this.f3779b = AdOverlayInfoParcel.zzb(this.f3792o.getIntent());
            if (this.f3779b == null) {
                throw new C1285i("Could not get info for ad overlay.");
            }
            if (this.f3779b.zzaow.zzcnl > 7500000) {
                this.f3790m = 3;
            }
            if (this.f3792o.getIntent() != null) {
                this.f3795r = this.f3792o.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.f3779b.zzbtv != null) {
                this.f3787j = this.f3779b.zzbtv.zzame;
            } else {
                this.f3787j = false;
            }
            if (((Boolean) zzdc.zzbca.get()).booleanValue() && this.f3787j && this.f3779b.zzbtv.zzamj != -1) {
                Future future = (Future) new C1287k(this, (C1284h) null).zzpy();
            }
            if (bundle == null) {
                if (this.f3779b.zzbtl != null && this.f3795r) {
                    this.f3779b.zzbtl.zzdy();
                }
                if (!(this.f3779b.zzbts == 1 || this.f3779b.zzbtk == null)) {
                    this.f3779b.zzbtk.onAdClicked();
                }
            }
            this.f3788k = new C1286j(this.f3792o, this.f3779b.zzbtu);
            this.f3788k.setId(1000);
            switch (this.f3779b.zzbts) {
                case 1:
                    mo5467a(false);
                    return;
                case 2:
                    this.f3781d = new zzc(this.f3779b.zzbtm);
                    mo5467a(false);
                    return;
                case 3:
                    mo5467a(true);
                    return;
                case 4:
                    if (this.f3786i) {
                        this.f3790m = 3;
                        this.f3792o.finish();
                        return;
                    } else if (!zzu.zzfn().zza((Context) this.f3792o, this.f3779b.zzbtj, this.f3779b.zzbtr)) {
                        this.f3790m = 3;
                        this.f3792o.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new C1285i("Could not determine ad overlay type.");
            }
        } catch (C1285i e) {
            zzkd.zzcx(e.getMessage());
            this.f3790m = 3;
            this.f3792o.finish();
        }
    }

    public void onDestroy() {
        if (this.f3780c != null) {
            this.f3788k.removeView(this.f3780c.getView());
        }
        mo5465a();
    }

    public void onPause() {
        this.f3791n.pause();
        zznu();
        if (this.f3779b.zzbtl != null) {
            this.f3779b.zzbtl.onPause();
        }
        if (this.f3780c != null && (!this.f3792o.isFinishing() || this.f3781d == null)) {
            zzu.zzfs().zzi(this.f3780c);
        }
        mo5465a();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.f3779b != null && this.f3779b.zzbts == 4) {
            if (this.f3786i) {
                this.f3790m = 3;
                this.f3792o.finish();
            } else {
                this.f3786i = true;
            }
        }
        if (this.f3779b.zzbtl != null) {
            this.f3779b.zzbtl.onResume();
        }
        if (this.f3780c == null || this.f3780c.isDestroyed()) {
            zzkd.zzcx("The webview does not exit. Ignoring action.");
        } else {
            zzu.zzfs().zzj(this.f3780c);
        }
        this.f3791n.resume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f3786i);
    }

    public void onStart() {
    }

    public void onStop() {
        mo5465a();
    }

    public void setRequestedOrientation(int i) {
        this.f3792o.setRequestedOrientation(i);
    }

    public void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f3784g = new FrameLayout(this.f3792o);
        this.f3784g.setBackgroundColor(-16777216);
        this.f3784g.addView(view, -1, -1);
        this.f3792o.setContentView(this.f3784g);
        zzdb();
        this.f3785h = customViewCallback;
        this.f3783f = true;
    }

    public void zza(boolean z, boolean z2) {
        if (this.f3782e != null) {
            this.f3782e.zza(z, z2);
        }
    }

    public void zzdb() {
        this.f3793p = true;
    }

    public void zzf(zzlh zzlh, Map map) {
        this.f3791n.zzf(zzlh, map);
    }

    public void zznu() {
        if (this.f3779b != null && this.f3783f) {
            setRequestedOrientation(this.f3779b.orientation);
        }
        if (this.f3784g != null) {
            this.f3792o.setContentView(this.f3788k);
            zzdb();
            this.f3784g.removeAllViews();
            this.f3784g = null;
        }
        if (this.f3785h != null) {
            this.f3785h.onCustomViewHidden();
            this.f3785h = null;
        }
        this.f3783f = false;
    }

    public void zznv() {
        this.f3790m = 1;
        this.f3792o.finish();
    }

    public boolean zznw() {
        boolean z = true;
        this.f3790m = 0;
        if (this.f3780c != null) {
            if (!this.f3780c.zzou() || !this.f3791n.zzou()) {
                z = false;
            }
            if (!z) {
                this.f3780c.zza("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public void zznx() {
        this.f3788k.removeView(this.f3782e);
        zzz(true);
    }

    public void zznz() {
        if (this.f3789l) {
            this.f3789l = false;
            mo5468b();
        }
    }

    public void zzob() {
        this.f3788k.mo5409a();
    }

    public void zzz(boolean z) {
        this.f3782e = new zzo(this.f3792o, z ? 50 : 32, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f3782e.zza(z, this.f3779b.zzbtp);
        this.f3788k.addView(this.f3782e, layoutParams);
    }
}
