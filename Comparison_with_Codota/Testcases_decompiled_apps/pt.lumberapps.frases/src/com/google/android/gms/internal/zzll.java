package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
class zzll extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzlh {

    /* renamed from: A */
    private zzku f6705A;

    /* renamed from: B */
    private int f6706B = -1;

    /* renamed from: C */
    private int f6707C = -1;

    /* renamed from: D */
    private int f6708D = -1;

    /* renamed from: E */
    private int f6709E = -1;

    /* renamed from: F */
    private Map f6710F;

    /* renamed from: G */
    private final WindowManager f6711G;

    /* renamed from: a */
    boolean f6712a = false;

    /* renamed from: b */
    private final zza f6713b;

    /* renamed from: c */
    private final Object f6714c = new Object();

    /* renamed from: d */
    private final zzas f6715d;

    /* renamed from: e */
    private final VersionInfoParcel f6716e;

    /* renamed from: f */
    private final zzs f6717f;

    /* renamed from: g */
    private final zzd f6718g;

    /* renamed from: h */
    private zzli f6719h;

    /* renamed from: i */
    private com.google.android.gms.ads.internal.overlay.zzd f6720i;

    /* renamed from: j */
    private AdSizeParcel f6721j;

    /* renamed from: k */
    private boolean f6722k;

    /* renamed from: l */
    private boolean f6723l;

    /* renamed from: m */
    private boolean f6724m;

    /* renamed from: n */
    private boolean f6725n;

    /* renamed from: o */
    private Boolean f6726o;

    /* renamed from: p */
    private int f6727p;

    /* renamed from: q */
    private boolean f6728q = true;

    /* renamed from: r */
    private String f6729r = "";

    /* renamed from: s */
    private zzlm f6730s;

    /* renamed from: t */
    private boolean f6731t;

    /* renamed from: u */
    private zzdi f6732u;

    /* renamed from: v */
    private zzdi f6733v;

    /* renamed from: w */
    private zzdi f6734w;

    /* renamed from: x */
    private zzdj f6735x;

    /* renamed from: y */
    private WeakReference f6736y;

    /* renamed from: z */
    private com.google.android.gms.ads.internal.overlay.zzd f6737z;

    @zzin
    public class zza extends MutableContextWrapper {

        /* renamed from: a */
        private Activity f6738a;

        /* renamed from: b */
        private Context f6739b;

        /* renamed from: c */
        private Context f6740c;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Object getSystemService(String str) {
            return this.f6740c.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            this.f6739b = context.getApplicationContext();
            this.f6738a = context instanceof Activity ? (Activity) context : null;
            this.f6740c = context;
            super.setBaseContext(this.f6739b);
        }

        public void startActivity(Intent intent) {
            if (this.f6738a != null) {
                this.f6738a.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.f6739b.startActivity(intent);
        }

        public Activity zzue() {
            return this.f6738a;
        }

        public Context zzuf() {
            return this.f6740c;
        }
    }

    protected zzll(zza zza2, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzas zzas, VersionInfoParcel versionInfoParcel, zzdk zzdk, zzs zzs, zzd zzd) {
        super(zza2);
        this.f6713b = zza2;
        this.f6721j = adSizeParcel;
        this.f6724m = z;
        this.f6727p = -1;
        this.f6715d = zzas;
        this.f6716e = versionInfoParcel;
        this.f6717f = zzs;
        this.f6718g = zzd;
        this.f6711G = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzu.zzfq().zza((Context) zza2, versionInfoParcel.zzcs, settings);
        zzu.zzfs().zza(getContext(), settings);
        setDownloadListener(this);
        m7355e();
        if (com.google.android.gms.common.util.zzs.zzavs()) {
            addJavascriptInterface(new zzln(this), "googleAdsJsInterface");
        }
        if (com.google.android.gms.common.util.zzs.zzavn()) {
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        this.f6705A = new zzku(this.f6713b.zzue(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        m7350a(zzdk);
    }

    /* renamed from: a */
    static zzll m7349a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzas zzas, VersionInfoParcel versionInfoParcel, zzdk zzdk, zzs zzs, zzd zzd) {
        return new zzll(new zza(context), adSizeParcel, z, z2, zzas, versionInfoParcel, zzdk, zzs, zzd);
    }

    /* renamed from: a */
    private void m7350a(zzdk zzdk) {
        m7359i();
        this.f6735x = new zzdj(new zzdk(true, "make_wv", this.f6721j.zzaur));
        this.f6735x.zzkf().zzc(zzdk);
        this.f6733v = zzdg.zzb(this.f6735x.zzkf());
        this.f6735x.zza("native:view_create", this.f6733v);
        this.f6734w = null;
        this.f6732u = null;
    }

    /* renamed from: a */
    private void m7352a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", (Map) hashMap);
    }

    /* renamed from: c */
    private void m7353c() {
        synchronized (this.f6714c) {
            this.f6726o = zzu.zzft().zzsq();
            if (this.f6726o == null) {
                try {
                    evaluateJavascript("(function(){})()", (ValueCallback) null);
                    mo8842a((Boolean) true);
                } catch (IllegalStateException e) {
                    mo8842a((Boolean) false);
                }
            }
        }
    }

    /* renamed from: d */
    private void m7354d() {
        zzdg.zza(this.f6735x.zzkf(), this.f6733v, "aeh2");
    }

    /* renamed from: e */
    private void m7355e() {
        synchronized (this.f6714c) {
            if (this.f6724m || this.f6721j.zzaus) {
                if (Build.VERSION.SDK_INT < 14) {
                    zzkd.zzcv("Disabling hardware acceleration on an overlay.");
                    m7356f();
                } else {
                    zzkd.zzcv("Enabling hardware acceleration on an overlay.");
                    m7357g();
                }
            } else if (Build.VERSION.SDK_INT < 18) {
                zzkd.zzcv("Disabling hardware acceleration on an AdView.");
                m7356f();
            } else {
                zzkd.zzcv("Enabling hardware acceleration on an AdView.");
                m7357g();
            }
        }
    }

    /* renamed from: f */
    private void m7356f() {
        synchronized (this.f6714c) {
            if (!this.f6725n) {
                zzu.zzfs().zzp(this);
            }
            this.f6725n = true;
        }
    }

    /* renamed from: g */
    private void m7357g() {
        synchronized (this.f6714c) {
            if (this.f6725n) {
                zzu.zzfs().zzo(this);
            }
            this.f6725n = false;
        }
    }

    /* renamed from: h */
    private void m7358h() {
        synchronized (this.f6714c) {
            this.f6710F = null;
        }
    }

    /* renamed from: i */
    private void m7359i() {
        zzdk zzkf;
        if (this.f6735x != null && (zzkf = this.f6735x.zzkf()) != null && zzu.zzft().zzsl() != null) {
            zzu.zzft().zzsl().zza(zzkf);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8842a(Boolean bool) {
        synchronized (this.f6714c) {
            this.f6726o = bool;
        }
        zzu.zzft().zzb(bool);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8843a(String str) {
        synchronized (this.f6714c) {
            if (!isDestroyed()) {
                loadUrl(str);
            } else {
                zzkd.zzcx("The webview is destroyed. Ignoring action.");
            }
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(19)
    /* renamed from: a */
    public void mo8844a(String str, ValueCallback valueCallback) {
        synchronized (this.f6714c) {
            if (!isDestroyed()) {
                evaluateJavascript(str, valueCallback);
            } else {
                zzkd.zzcx("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue((Object) null);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo8845a() {
        int i;
        int i2;
        if (!zzuj().zzho()) {
            return false;
        }
        DisplayMetrics zza2 = zzu.zzfq().zza(this.f6711G);
        int zzb = zzm.zziw().zzb(zza2, zza2.widthPixels);
        int zzb2 = zzm.zziw().zzb(zza2, zza2.heightPixels);
        Activity zzue = zzue();
        if (zzue == null || zzue.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            int[] zzh = zzu.zzfq().zzh(zzue);
            i2 = zzm.zziw().zzb(zza2, zzh[0]);
            i = zzm.zziw().zzb(zza2, zzh[1]);
        }
        if (this.f6707C == zzb && this.f6706B == zzb2 && this.f6708D == i2 && this.f6709E == i) {
            return false;
        }
        boolean z = (this.f6707C == zzb && this.f6706B == zzb2) ? false : true;
        this.f6707C = zzb;
        this.f6706B = zzb2;
        this.f6708D = i2;
        this.f6709E = i;
        new zzhf(this).zza(zzb, zzb2, i2, i, zza2.density, this.f6711G.getDefaultDisplay().getRotation());
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Boolean mo8846b() {
        Boolean bool;
        synchronized (this.f6714c) {
            bool = this.f6726o;
        }
        return bool;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8847b(String str) {
        if (com.google.android.gms.common.util.zzs.zzavu()) {
            if (mo8846b() == null) {
                m7353c();
            }
            if (mo8846b().booleanValue()) {
                mo8844a(str, (ValueCallback) null);
                return;
            }
            String valueOf = String.valueOf(str);
            mo8843a(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        mo8843a(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    public void destroy() {
        synchronized (this.f6714c) {
            m7359i();
            this.f6705A.zztt();
            if (this.f6720i != null) {
                this.f6720i.close();
                this.f6720i.onDestroy();
                this.f6720i = null;
            }
            this.f6719h.reset();
            if (!this.f6723l) {
                zzu.zzgj().zzd(this);
                m7358h();
                this.f6723l = true;
                zzkd.m7303v("Initiating WebView self destruct sequence in 3...");
                this.f6719h.zzuz();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback r4) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.f6714c
            monitor-enter(r1)
            boolean r0 = r2.isDestroyed()     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.zzkd.zzcx(r0)     // Catch:{ all -> 0x001b }
            if (r4 == 0) goto L_0x0014
            r0 = 0
            r4.onReceiveValue(r0)     // Catch:{ all -> 0x001b }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
        L_0x0015:
            return
        L_0x0016:
            super.evaluateJavascript(r3, r4)     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            goto L_0x0015
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzll.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        synchronized (this.f6714c) {
            if (!this.f6723l) {
                this.f6719h.reset();
                zzu.zzgj().zzd(this);
                m7358h();
            }
        }
        super.finalize();
    }

    public String getRequestId() {
        String str;
        synchronized (this.f6714c) {
            str = this.f6729r;
        }
        return str;
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.f6714c) {
            i = this.f6727p;
        }
        return i;
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.f6714c) {
            z = this.f6723l;
        }
        return z;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.f6714c) {
            if (!isDestroyed()) {
                super.loadData(str, str2, str3);
            } else {
                zzkd.zzcx("The webview is destroyed. Ignoring action.");
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.f6714c) {
            if (!isDestroyed()) {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            } else {
                zzkd.zzcx("The webview is destroyed. Ignoring action.");
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.f6714c) {
            if (!isDestroyed()) {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    String valueOf = String.valueOf(th);
                    zzkd.zzcx(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
                }
            } else {
                zzkd.zzcx("The webview is destroyed. Ignoring action.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        synchronized (this.f6714c) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.f6705A.onAttachedToWindow();
            }
            m7352a(this.f6731t);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        synchronized (this.f6714c) {
            if (!isDestroyed()) {
                this.f6705A.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
        m7352a(false);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzu.zzfq().zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzkd.zzcv(new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (zzuj() != null && zzuj().zzvf() != null) {
                    zzuj().zzvf().zzem();
                }
            }
        }
    }

    public void onGlobalLayout() {
        boolean a = mo8845a();
        com.google.android.gms.ads.internal.overlay.zzd zzuh = zzuh();
        if (zzuh != null && a) {
            zzuh.zznz();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            r0 = 2147483647(0x7fffffff, float:NaN)
            r8 = 1073741824(0x40000000, float:2.0)
            r7 = 8
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.Object r4 = r9.f6714c
            monitor-enter(r4)
            boolean r1 = r9.isDestroyed()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0019
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r4)     // Catch:{ all -> 0x0034 }
        L_0x0018:
            return
        L_0x0019:
            boolean r1 = r9.isInEditMode()     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x002f
            boolean r1 = r9.f6724m     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x002f
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.f6721j     // Catch:{ all -> 0x0034 }
            boolean r1 = r1.zzauu     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x002f
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.f6721j     // Catch:{ all -> 0x0034 }
            boolean r1 = r1.zzauv     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0037
        L_0x002f:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x0034 }
            monitor-exit(r4)     // Catch:{ all -> 0x0034 }
            goto L_0x0018
        L_0x0034:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0034 }
            throw r0
        L_0x0037:
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.f6721j     // Catch:{ all -> 0x0034 }
            boolean r1 = r1.zzaus     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0054
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics     // Catch:{ all -> 0x0034 }
            r0.<init>()     // Catch:{ all -> 0x0034 }
            android.view.WindowManager r1 = r9.f6711G     // Catch:{ all -> 0x0034 }
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ all -> 0x0034 }
            r1.getMetrics(r0)     // Catch:{ all -> 0x0034 }
            int r1 = r0.widthPixels     // Catch:{ all -> 0x0034 }
            int r0 = r0.heightPixels     // Catch:{ all -> 0x0034 }
            r9.setMeasuredDimension(r1, r0)     // Catch:{ all -> 0x0034 }
            monitor-exit(r4)     // Catch:{ all -> 0x0034 }
            goto L_0x0018
        L_0x0054:
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x0034 }
            int r3 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x0034 }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x0034 }
            int r1 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x0034 }
            if (r2 == r6) goto L_0x0068
            if (r2 != r8) goto L_0x00ff
        L_0x0068:
            r2 = r3
        L_0x0069:
            if (r5 == r6) goto L_0x006d
            if (r5 != r8) goto L_0x006e
        L_0x006d:
            r0 = r1
        L_0x006e:
            com.google.android.gms.ads.internal.client.AdSizeParcel r5 = r9.f6721j     // Catch:{ all -> 0x0034 }
            int r5 = r5.widthPixels     // Catch:{ all -> 0x0034 }
            if (r5 > r2) goto L_0x007a
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r9.f6721j     // Catch:{ all -> 0x0034 }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x0034 }
            if (r2 <= r0) goto L_0x00e9
        L_0x007a:
            com.google.android.gms.internal.zzll$zza r0 = r9.f6713b     // Catch:{ all -> 0x0034 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x0034 }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x0034 }
            float r0 = r0.density     // Catch:{ all -> 0x0034 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r9.f6721j     // Catch:{ all -> 0x0034 }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x0034 }
            float r2 = (float) r2     // Catch:{ all -> 0x0034 }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x0034 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r5 = r9.f6721j     // Catch:{ all -> 0x0034 }
            int r5 = r5.heightPixels     // Catch:{ all -> 0x0034 }
            float r5 = (float) r5     // Catch:{ all -> 0x0034 }
            float r5 = r5 / r0
            int r5 = (int) r5     // Catch:{ all -> 0x0034 }
            float r3 = (float) r3     // Catch:{ all -> 0x0034 }
            float r3 = r3 / r0
            int r3 = (int) r3     // Catch:{ all -> 0x0034 }
            float r1 = (float) r1     // Catch:{ all -> 0x0034 }
            float r0 = r1 / r0
            int r0 = (int) r0     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r6 = 103(0x67, float:1.44E-43)
            r1.<init>(r6)     // Catch:{ all -> 0x0034 }
            java.lang.String r6 = "Not enough space to show ad. Needs "
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = " dp, but only has "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = " dp."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0034 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.internal.zzkd.zzcx(r0)     // Catch:{ all -> 0x0034 }
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x0034 }
            if (r0 == r7) goto L_0x00e1
            r0 = 4
            r9.setVisibility(r0)     // Catch:{ all -> 0x0034 }
        L_0x00e1:
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x0034 }
        L_0x00e6:
            monitor-exit(r4)     // Catch:{ all -> 0x0034 }
            goto L_0x0018
        L_0x00e9:
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x0034 }
            if (r0 == r7) goto L_0x00f3
            r0 = 0
            r9.setVisibility(r0)     // Catch:{ all -> 0x0034 }
        L_0x00f3:
            com.google.android.gms.ads.internal.client.AdSizeParcel r0 = r9.f6721j     // Catch:{ all -> 0x0034 }
            int r0 = r0.widthPixels     // Catch:{ all -> 0x0034 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.f6721j     // Catch:{ all -> 0x0034 }
            int r1 = r1.heightPixels     // Catch:{ all -> 0x0034 }
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x0034 }
            goto L_0x00e6
        L_0x00ff:
            r2 = r0
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzll.onMeasure(int, int):void");
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                if (com.google.android.gms.common.util.zzs.zzavn()) {
                    super.onPause();
                }
            } catch (Exception e) {
                zzkd.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                if (com.google.android.gms.common.util.zzs.zzavn()) {
                    super.onResume();
                }
            } catch (Exception e) {
                zzkd.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f6715d != null) {
            this.f6715d.zza(motionEvent);
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setContext(Context context) {
        this.f6713b.setBaseContext(context);
        this.f6705A.zzl(this.f6713b.zzue());
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f6736y = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setRequestedOrientation(int i) {
        synchronized (this.f6714c) {
            this.f6727p = i;
            if (this.f6720i != null) {
                this.f6720i.setRequestedOrientation(this.f6727p);
            }
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzli) {
            this.f6719h = (zzli) webViewClient;
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzkd.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zza(Context context, AdSizeParcel adSizeParcel, zzdk zzdk) {
        synchronized (this.f6714c) {
            this.f6705A.zztt();
            setContext(context);
            this.f6720i = null;
            this.f6721j = adSizeParcel;
            this.f6724m = false;
            this.f6722k = false;
            this.f6729r = "";
            this.f6727p = -1;
            zzu.zzfs().zzj(this);
            loadUrl("about:blank");
            this.f6719h.reset();
            setOnTouchListener((View.OnTouchListener) null);
            setOnClickListener((View.OnClickListener) null);
            this.f6728q = true;
            this.f6712a = false;
            this.f6730s = null;
            m7350a(zzdk);
            this.f6731t = false;
            zzu.zzgj().zzd(this);
            m7358h();
        }
    }

    public void zza(AdSizeParcel adSizeParcel) {
        synchronized (this.f6714c) {
            this.f6721j = adSizeParcel;
            requestLayout();
        }
    }

    public void zza(zzcd zzcd, boolean z) {
        synchronized (this.f6714c) {
            this.f6731t = z;
        }
        m7352a(z);
    }

    public void zza(zzlm zzlm) {
        synchronized (this.f6714c) {
            if (this.f6730s != null) {
                zzkd.m5769e("Attempt to create multiple AdWebViewVideoControllers.");
            } else {
                this.f6730s = zzlm;
            }
        }
    }

    public void zza(String str, zzep zzep) {
        if (this.f6719h != null) {
            this.f6719h.zza(str, zzep);
        }
    }

    public void zza(String str, Map map) {
        try {
            zzb(str, zzu.zzfq().zzam(map));
        } catch (JSONException e) {
            zzkd.zzcx("Could not convert parameters to JSON.");
        }
    }

    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzj(str, jSONObject.toString());
    }

    public void zzaf(int i) {
        m7354d();
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.f6716e.zzcs);
        zza("onhide", (Map) hashMap);
    }

    public void zzah(boolean z) {
        synchronized (this.f6714c) {
            this.f6724m = z;
            m7355e();
        }
    }

    public void zzai(boolean z) {
        synchronized (this.f6714c) {
            if (this.f6720i != null) {
                this.f6720i.zza(this.f6719h.zzho(), z);
            } else {
                this.f6722k = z;
            }
        }
    }

    public void zzaj(boolean z) {
        synchronized (this.f6714c) {
            this.f6728q = z;
        }
    }

    public void zzb(com.google.android.gms.ads.internal.overlay.zzd zzd) {
        synchronized (this.f6714c) {
            this.f6720i = zzd;
        }
    }

    public void zzb(String str, zzep zzep) {
        if (this.f6719h != null) {
            this.f6719h.zzb(str, zzep);
        }
    }

    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("AFMA_ReceiveMessage('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzkd.m7303v(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        mo8847b(sb.toString());
    }

    public void zzc(com.google.android.gms.ads.internal.overlay.zzd zzd) {
        synchronized (this.f6714c) {
            this.f6737z = zzd;
        }
    }

    public void zzcy(String str) {
        synchronized (this.f6714c) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                String valueOf = String.valueOf(th);
                zzkd.zzcx(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
            }
        }
    }

    public void zzcz(String str) {
        synchronized (this.f6714c) {
            if (str == null) {
                str = "";
            }
            this.f6729r = str;
        }
    }

    public AdSizeParcel zzdn() {
        AdSizeParcel adSizeParcel;
        synchronized (this.f6714c) {
            adSizeParcel = this.f6721j;
        }
        return adSizeParcel;
    }

    public void zzef() {
        synchronized (this.f6714c) {
            this.f6712a = true;
            if (this.f6717f != null) {
                this.f6717f.zzef();
            }
        }
    }

    public void zzeg() {
        synchronized (this.f6714c) {
            this.f6712a = false;
            if (this.f6717f != null) {
                this.f6717f.zzeg();
            }
        }
    }

    public void zzj(String str, String str2) {
        mo8847b(new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()).append(str).append("(").append(str2).append(");").toString());
    }

    public void zzoa() {
        if (this.f6732u == null) {
            zzdg.zza(this.f6735x.zzkf(), this.f6734w, "aes");
            this.f6732u = zzdg.zzb(this.f6735x.zzkf());
            this.f6735x.zza("native:view_show", this.f6732u);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.f6716e.zzcs);
        zza("onshow", (Map) hashMap);
    }

    public boolean zzou() {
        boolean z;
        synchronized (this.f6714c) {
            zzdg.zza(this.f6735x.zzkf(), this.f6733v, "aebb2");
            z = this.f6728q;
        }
        return z;
    }

    public void zzuc() {
        m7354d();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.f6716e.zzcs);
        zza("onhide", (Map) hashMap);
    }

    public void zzud() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzu.zzfq().zzfa()));
        hashMap.put("app_volume", String.valueOf(zzu.zzfq().zzey()));
        hashMap.put("device_volume", String.valueOf(zzu.zzfq().zzal(getContext())));
        zza("volume", (Map) hashMap);
    }

    public Activity zzue() {
        return this.f6713b.zzue();
    }

    public Context zzuf() {
        return this.f6713b.zzuf();
    }

    public zzd zzug() {
        return this.f6718g;
    }

    public com.google.android.gms.ads.internal.overlay.zzd zzuh() {
        com.google.android.gms.ads.internal.overlay.zzd zzd;
        synchronized (this.f6714c) {
            zzd = this.f6720i;
        }
        return zzd;
    }

    public com.google.android.gms.ads.internal.overlay.zzd zzui() {
        com.google.android.gms.ads.internal.overlay.zzd zzd;
        synchronized (this.f6714c) {
            zzd = this.f6737z;
        }
        return zzd;
    }

    public zzli zzuj() {
        return this.f6719h;
    }

    public boolean zzuk() {
        boolean z;
        synchronized (this.f6714c) {
            z = this.f6722k;
        }
        return z;
    }

    public zzas zzul() {
        return this.f6715d;
    }

    public VersionInfoParcel zzum() {
        return this.f6716e;
    }

    public boolean zzun() {
        boolean z;
        synchronized (this.f6714c) {
            z = this.f6724m;
        }
        return z;
    }

    public void zzuo() {
        synchronized (this.f6714c) {
            zzkd.m7303v("Destroying WebView!");
            zzkh.zzclc.post(new C1765nf(this));
        }
    }

    public boolean zzup() {
        boolean z;
        synchronized (this.f6714c) {
            z = this.f6712a;
        }
        return z;
    }

    public zzlg zzuq() {
        return null;
    }

    public zzdi zzur() {
        return this.f6734w;
    }

    public zzdj zzus() {
        return this.f6735x;
    }

    public zzlm zzut() {
        zzlm zzlm;
        synchronized (this.f6714c) {
            zzlm = this.f6730s;
        }
        return zzlm;
    }

    public void zzuu() {
        this.f6705A.zzts();
    }

    public void zzuv() {
        if (this.f6734w == null) {
            this.f6734w = zzdg.zzb(this.f6735x.zzkf());
            this.f6735x.zza("native:view_load", this.f6734w);
        }
    }

    public View.OnClickListener zzuw() {
        return (View.OnClickListener) this.f6736y.get();
    }
}
