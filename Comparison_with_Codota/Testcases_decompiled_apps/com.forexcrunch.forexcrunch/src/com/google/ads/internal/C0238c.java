package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.C0190ak;
import com.google.ads.C0192al;
import com.google.ads.C0207b;
import com.google.ads.C0208c;
import com.google.ads.C0210d;
import com.google.ads.C0264l;
import com.google.ads.C0265m;
import com.google.ads.C0272n;
import com.google.ads.searchads.SearchAdRequest;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

/* renamed from: com.google.ads.internal.c */
public class C0238c implements Runnable {

    /* renamed from: a */
    boolean f480a;

    /* renamed from: b */
    private String f481b;

    /* renamed from: c */
    private String f482c;

    /* renamed from: d */
    private String f483d;

    /* renamed from: e */
    private String f484e;

    /* renamed from: f */
    private boolean f485f;

    /* renamed from: g */
    private C0249f f486g;

    /* renamed from: h */
    private AdRequest f487h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WebView f488i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0264l f489j;

    /* renamed from: k */
    private String f490k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f491l;

    /* renamed from: m */
    private LinkedList<String> f492m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f493n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public AdSize f494o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f495p = false;

    /* renamed from: q */
    private volatile boolean f496q;

    /* renamed from: r */
    private boolean f497r;

    /* renamed from: s */
    private AdRequest.ErrorCode f498s;

    /* renamed from: t */
    private boolean f499t;

    /* renamed from: u */
    private int f500u;

    /* renamed from: v */
    private Thread f501v;

    /* renamed from: w */
    private boolean f502w;

    /* renamed from: x */
    private C0245d f503x = C0245d.ONLINE_SERVER_REQUEST;

    /* renamed from: com.google.ads.internal.c$b */
    private class C0243b extends Exception {
        public C0243b(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.ads.internal.c$a */
    private static class C0242a implements Runnable {

        /* renamed from: a */
        private final C0247d f508a;

        /* renamed from: b */
        private final WebView f509b;

        /* renamed from: c */
        private final C0249f f510c;

        /* renamed from: d */
        private final AdRequest.ErrorCode f511d;

        /* renamed from: e */
        private final boolean f512e;

        public C0242a(C0247d dVar, WebView webView, C0249f fVar, AdRequest.ErrorCode errorCode, boolean z) {
            this.f508a = dVar;
            this.f509b = webView;
            this.f510c = fVar;
            this.f511d = errorCode;
            this.f512e = z;
        }

        public void run() {
            if (this.f509b != null) {
                this.f509b.stopLoading();
                this.f509b.destroy();
            }
            if (this.f510c != null) {
                this.f510c.mo3571a();
            }
            if (this.f512e) {
                this.f508a.mo3553l().stopLoading();
                if (this.f508a.mo3550i().f662i.mo3725a() != null) {
                    this.f508a.mo3550i().f662i.mo3725a().setVisibility(8);
                }
            }
            this.f508a.mo3529a(this.f511d);
        }
    }

    /* renamed from: com.google.ads.internal.c$c */
    private class C0244c implements Runnable {

        /* renamed from: b */
        private final String f515b;

        /* renamed from: c */
        private final String f516c;

        /* renamed from: d */
        private final WebView f517d;

        public C0244c(WebView webView, String str, String str2) {
            this.f517d = webView;
            this.f515b = str;
            this.f516c = str2;
        }

        public void run() {
            C0238c.this.f489j.f613c.mo3727a(Boolean.valueOf(C0238c.this.f495p));
            C0238c.this.f489j.f611a.mo3725a().f655b.mo3725a().mo3553l().mo3454a(C0238c.this.f495p);
            if (C0238c.this.f489j.f611a.mo3725a().f658e.mo3725a() != null) {
                C0238c.this.f489j.f611a.mo3725a().f658e.mo3725a().setOverlayEnabled(!C0238c.this.f495p);
            }
            if (this.f516c != null) {
                this.f517d.loadDataWithBaseURL(this.f515b, this.f516c, "text/html", "utf-8", (String) null);
            } else {
                this.f517d.loadUrl(this.f515b);
            }
        }
    }

    /* renamed from: com.google.ads.internal.c$e */
    private class C0246e implements Runnable {

        /* renamed from: b */
        private final C0247d f525b;

        /* renamed from: c */
        private final WebView f526c;

        /* renamed from: d */
        private final LinkedList<String> f527d;

        /* renamed from: e */
        private final int f528e;

        /* renamed from: f */
        private final boolean f529f;

        /* renamed from: g */
        private final String f530g;

        /* renamed from: h */
        private final AdSize f531h;

        public C0246e(C0247d dVar, WebView webView, LinkedList<String> linkedList, int i, boolean z, String str, AdSize adSize) {
            this.f525b = dVar;
            this.f526c = webView;
            this.f527d = linkedList;
            this.f528e = i;
            this.f529f = z;
            this.f530g = str;
            this.f531h = adSize;
        }

        public void run() {
            if (this.f526c != null) {
                this.f526c.stopLoading();
                this.f526c.destroy();
            }
            this.f525b.mo3536a(this.f527d);
            this.f525b.mo3524a(this.f528e);
            this.f525b.mo3537a(this.f529f);
            this.f525b.mo3534a(this.f530g);
            if (this.f531h != null) {
                C0238c.this.f489j.f611a.mo3725a().f660g.mo3725a().mo3610b(this.f531h);
                this.f525b.mo3553l().setAdSize(this.f531h);
            }
            this.f525b.mo3520E();
        }
    }

    /* renamed from: com.google.ads.internal.c$d */
    public enum C0245d {
        ONLINE_USING_BUFFERED_ADS("online_buffered"),
        ONLINE_SERVER_REQUEST("online_request"),
        OFFLINE_USING_BUFFERED_ADS("offline_buffered"),
        OFFLINE_EMPTY("offline_empty");
        

        /* renamed from: e */
        public String f523e;

        private C0245d(String str) {
            this.f523e = str;
        }
    }

    /* renamed from: a */
    public synchronized void mo3498a(boolean z) {
        this.f495p = z;
    }

    protected C0238c() {
    }

    public C0238c(C0264l lVar) {
        this.f489j = lVar;
        this.f490k = null;
        this.f481b = null;
        this.f482c = null;
        this.f483d = null;
        this.f492m = new LinkedList<>();
        this.f498s = null;
        this.f499t = false;
        this.f500u = -1;
        this.f485f = false;
        this.f497r = false;
        this.f493n = null;
        this.f494o = null;
        if (lVar.f611a.mo3725a().f656c.mo3728a() != null) {
            this.f488i = new AdWebView(lVar.f611a.mo3725a(), (AdSize) null);
            this.f488i.setWebViewClient(C0254i.m399a(lVar.f611a.mo3725a().f655b.mo3725a(), C0232a.f475b, false, false));
            this.f488i.setVisibility(8);
            this.f488i.setWillNotDraw(true);
            this.f486g = new C0249f(lVar);
            return;
        }
        this.f488i = null;
        this.f486g = null;
        C0284b.m490e("activity was null while trying to create an AdLoader.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo3496a(String str) {
        this.f492m.add(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3489a() {
        C0284b.m480a("AdLoader cancelled.");
        if (this.f488i != null) {
            this.f488i.stopLoading();
            this.f488i.destroy();
        }
        if (this.f501v != null) {
            this.f501v.interrupt();
            this.f501v = null;
        }
        if (this.f486g != null) {
            this.f486g.mo3571a();
        }
        this.f496q = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3493a(AdRequest adRequest) {
        this.f487h = adRequest;
        this.f496q = false;
        this.f501v = new Thread(this);
        this.f501v.start();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e9 A[Catch:{ Throwable -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02f2 A[SYNTHETIC, Splitter:B:147:0x02f2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            r3 = 0
            r10 = 0
            monitor-enter(r12)
            android.webkit.WebView r0 = r12.f488i     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x000c
            com.google.ads.internal.f r0 = r12.f486g     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x0019
        L_0x000c:
            java.lang.String r0 = "adRequestWebView was null while trying to load an ad."
            com.google.ads.util.C0284b.m490e(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
        L_0x0018:
            return
        L_0x0019:
            com.google.ads.l r0 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$d<android.app.Activity> r0 = r0.f656c     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3728a()     // Catch:{ Throwable -> 0x0115 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x003d
            java.lang.String r0 = "activity was null while forming an ad request."
            com.google.ads.util.C0284b.m490e(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x003a:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            throw r0
        L_0x003d:
            com.google.ads.l r1 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r1 = r1.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r1 = (com.google.ads.C0272n) r1     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r1 = r1.f655b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r1 = (com.google.ads.internal.C0247d) r1     // Catch:{ Throwable -> 0x0115 }
            long r4 = r1.mo3557p()     // Catch:{ Throwable -> 0x0115 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest r2 = r12.f487h     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.l r1 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r1 = r1.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r1 = (com.google.ads.C0272n) r1     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<android.content.Context> r1 = r1.f659f     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Throwable -> 0x0115 }
            java.util.Map r8 = r2.getRequestMap(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "extras"
            java.lang.Object r1 = r8.get(r1)     // Catch:{ Throwable -> 0x0115 }
            boolean r2 = r1 instanceof java.util.Map     // Catch:{ Throwable -> 0x0115 }
            if (r2 == 0) goto L_0x00e1
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "_adUrl"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r9 = r2 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x0089
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0115 }
            r12.f481b = r2     // Catch:{ Throwable -> 0x0115 }
        L_0x0089:
            java.lang.String r2 = "_requestUrl"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r9 = r2 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x0097
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0115 }
            r12.f490k = r2     // Catch:{ Throwable -> 0x0115 }
        L_0x0097:
            java.lang.String r2 = "_activationOverlayUrl"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r9 = r2 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x00a5
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0115 }
            r12.f491l = r2     // Catch:{ Throwable -> 0x0115 }
        L_0x00a5:
            java.lang.String r2 = "_orientation"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r9 = r2 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x00ba
            java.lang.String r9 = "p"
            boolean r9 = r2.equals(r9)     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x0109
            r2 = 1
            r12.f500u = r2     // Catch:{ Throwable -> 0x0115 }
        L_0x00ba:
            java.lang.String r2 = "_norefresh"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r2 == 0) goto L_0x00e1
            java.lang.String r2 = "t"
            boolean r1 = r1.equals(r2)     // Catch:{ Throwable -> 0x0115 }
            if (r1 == 0) goto L_0x00e1
            com.google.ads.l r1 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r1 = r1.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r1 = (com.google.ads.C0272n) r1     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r1 = r1.f655b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r1 = (com.google.ads.internal.C0247d) r1     // Catch:{ Throwable -> 0x0115 }
            r1.mo3546e()     // Catch:{ Throwable -> 0x0115 }
        L_0x00e1:
            java.lang.String r1 = r12.f481b     // Catch:{ Throwable -> 0x0115 }
            if (r1 != 0) goto L_0x030e
            java.lang.String r1 = r12.f490k     // Catch:{ Throwable -> 0x0115 }
            if (r1 != 0) goto L_0x01c2
            java.lang.String r0 = r12.mo3488a((java.util.Map<java.lang.String, java.lang.Object>) r8, (android.app.Activity) r0)     // Catch:{ b -> 0x0124 }
            java.lang.String r1 = r12.m250f()     // Catch:{ Throwable -> 0x0115 }
            r12.m243b(r0, r1)     // Catch:{ Throwable -> 0x0115 }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Throwable -> 0x0115 }
            long r0 = r0 - r6
            long r0 = r4 - r0
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x0102
            r12.wait(r0)     // Catch:{ InterruptedException -> 0x0144 }
        L_0x0102:
            boolean r0 = r12.f496q     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x015e
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0109:
            java.lang.String r9 = "l"
            boolean r2 = r2.equals(r9)     // Catch:{ Throwable -> 0x0115 }
            if (r2 == 0) goto L_0x00ba
            r2 = 0
            r12.f500u = r2     // Catch:{ Throwable -> 0x0115 }
            goto L_0x00ba
        L_0x0115:
            r0 = move-exception
            java.lang.String r1 = "An unknown error occurred in AdLoader."
            com.google.ads.util.C0284b.m485b(r1, r0)     // Catch:{ all -> 0x003a }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ all -> 0x003a }
            r1 = 1
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ all -> 0x003a }
        L_0x0121:
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0124:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "Caught internal exception: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0144:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "AdLoader InterruptedException while getting the URL: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x015e:
            com.google.ads.AdRequest$ErrorCode r0 = r12.f498s     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x016b
            com.google.ads.AdRequest$ErrorCode r0 = r12.f498s     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x016b:
            java.lang.String r0 = r12.f490k     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x0194
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "AdLoader timed out after "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "ms while getting the URL."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0194:
            com.google.ads.l r0 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.h> r0 = r0.f660g     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.h r0 = (com.google.ads.internal.C0253h) r0     // Catch:{ Throwable -> 0x0115 }
            boolean r0 = r0.mo3611b()     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x01c2
            java.lang.String r0 = r12.f491l     // Catch:{ Throwable -> 0x0115 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x01c2
            java.lang.String r0 = "AdLoader doesn't have a URL for the activation overlay"
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x01c2:
            com.google.ads.l r0 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r0 = r0.f655b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r0 = (com.google.ads.internal.C0247d) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.g r0 = r0.mo3555n()     // Catch:{ Throwable -> 0x0115 }
            int[] r1 = com.google.ads.internal.C0238c.C02413.f507a     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.c$d r2 = r12.f503x     // Catch:{ Throwable -> 0x0115 }
            int r2 = r2.ordinal()     // Catch:{ Throwable -> 0x0115 }
            r1 = r1[r2]     // Catch:{ Throwable -> 0x0115 }
            switch(r1) {
                case 1: goto L_0x0278;
                case 2: goto L_0x0288;
                case 3: goto L_0x0292;
                case 4: goto L_0x029f;
                default: goto L_0x01e5;
            }     // Catch:{ Throwable -> 0x0115 }
        L_0x01e5:
            boolean r0 = r12.f480a     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x02f2
            java.lang.String r0 = "Not using loadUrl()."
            com.google.ads.util.C0284b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.f r0 = r12.f486g     // Catch:{ Throwable -> 0x0115 }
            boolean r1 = r12.f502w     // Catch:{ Throwable -> 0x0115 }
            r0.mo3573a((boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.l r0 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.h> r0 = r0.f660g     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.h r0 = (com.google.ads.internal.C0253h) r0     // Catch:{ Throwable -> 0x0115 }
            boolean r0 = r0.mo3611b()     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0479
            com.google.ads.l r0 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.ActivationOverlay> r0 = r0.f658e     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.ActivationOverlay r0 = (com.google.ads.internal.ActivationOverlay) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.i r3 = r0.mo3433e()     // Catch:{ Throwable -> 0x0115 }
            r0 = 1
            r3.mo3616c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.m r0 = com.google.ads.C0265m.m411a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<android.os.Handler> r0 = r0.f617c     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.c$1 r1 = new com.google.ads.internal.c$1     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            r0.post(r1)     // Catch:{ Throwable -> 0x0115 }
            r0 = r3
        L_0x023c:
            com.google.ads.internal.f r1 = r12.f486g     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = r12.f490k     // Catch:{ Throwable -> 0x0115 }
            r1.mo3572a((java.lang.String) r2)     // Catch:{ Throwable -> 0x0115 }
        L_0x0243:
            boolean r1 = r12.f496q     // Catch:{ InterruptedException -> 0x025e }
            if (r1 != 0) goto L_0x02b5
            com.google.ads.AdRequest$ErrorCode r1 = r12.f498s     // Catch:{ InterruptedException -> 0x025e }
            if (r1 != 0) goto L_0x02b5
            java.lang.String r1 = r12.f482c     // Catch:{ InterruptedException -> 0x025e }
            if (r1 != 0) goto L_0x02b5
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x025e }
            long r1 = r1 - r6
            long r1 = r4 - r1
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x02b5
            r12.wait(r1)     // Catch:{ InterruptedException -> 0x025e }
            goto L_0x0243
        L_0x025e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "AdLoader InterruptedException while getting the ad server's response: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0278:
            r0.mo3599r()     // Catch:{ Throwable -> 0x0115 }
            r0.mo3602u()     // Catch:{ Throwable -> 0x0115 }
            r0.mo3605x()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Request scenario: Online server request."
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            goto L_0x01e5
        L_0x0288:
            r0.mo3601t()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Request scenario: Online using buffered ads."
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            goto L_0x01e5
        L_0x0292:
            r0.mo3604w()     // Catch:{ Throwable -> 0x0115 }
            r0.mo3598q()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Request scenario: Offline using buffered ads."
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            goto L_0x01e5
        L_0x029f:
            r0.mo3598q()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Request scenario: Offline with no buffered ads."
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Network is unavailable.  Aborting ad request."
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x02b5:
            boolean r1 = r12.f496q     // Catch:{ Throwable -> 0x0115 }
            if (r1 == 0) goto L_0x02bc
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x02bc:
            com.google.ads.AdRequest$ErrorCode r1 = r12.f498s     // Catch:{ Throwable -> 0x0115 }
            if (r1 == 0) goto L_0x02c9
            com.google.ads.AdRequest$ErrorCode r0 = r12.f498s     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x02c9:
            java.lang.String r1 = r12.f482c     // Catch:{ Throwable -> 0x0115 }
            if (r1 != 0) goto L_0x0476
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "AdLoader timed out after "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "ms while waiting for the ad server's response."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x02f2:
            java.lang.String r0 = r12.f490k     // Catch:{ Throwable -> 0x0115 }
            r12.f481b = r0     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "Using loadUrl.  adBaseUrl: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = r12.f481b     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
        L_0x030e:
            r1 = r3
        L_0x030f:
            boolean r0 = r12.f480a     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x03e1
            boolean r0 = r12.f485f     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0333
            com.google.ads.l r0 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r0 = r0.f655b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r0 = (com.google.ads.internal.C0247d) r0     // Catch:{ Throwable -> 0x0115 }
            r1 = 1
            r0.mo3542b((boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            r12.mo3499b()     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0333:
            java.lang.String r0 = r12.f484e     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0372
            java.lang.String r0 = r12.f484e     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "application/json"
            boolean r0 = r0.startsWith(r2)     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x034b
            java.lang.String r0 = r12.f484e     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "text/javascript"
            boolean r0 = r0.startsWith(r2)     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0372
        L_0x034b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "Expected HTML but received "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = r12.f484e     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m484b(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0372:
            com.google.ads.l r0 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$c<com.google.ads.AdSize[]> r0 = r0.f667n     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3726a()     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x03d5
            com.google.ads.AdSize r0 = r12.f494o     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x0396
            java.lang.String r0 = "Multiple supported ad sizes were specified, but the server did not respond with a size."
            com.google.ads.util.C0284b.m484b(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0396:
            com.google.ads.l r0 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$c<com.google.ads.AdSize[]> r0 = r0.f667n     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3726a()     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch:{ Throwable -> 0x0115 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdSize r2 = r12.f494o     // Catch:{ Throwable -> 0x0115 }
            boolean r0 = r0.contains(r2)     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x03e1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "The ad server did not respond with a supported AdSize: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdSize r1 = r12.f494o     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m484b(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x03d5:
            com.google.ads.AdSize r0 = r12.f494o     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x03e1
            java.lang.String r0 = "adSize was expected to be null in AdLoader."
            com.google.ads.util.C0284b.m490e(r0)     // Catch:{ Throwable -> 0x0115 }
            r0 = 0
            r12.f494o = r0     // Catch:{ Throwable -> 0x0115 }
        L_0x03e1:
            com.google.ads.l r0 = r12.f489j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r0 = r0.f655b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r0 = (com.google.ads.internal.C0247d) r0     // Catch:{ Throwable -> 0x0115 }
            r2 = 0
            r0.mo3542b((boolean) r2)     // Catch:{ Throwable -> 0x0115 }
            r12.m253i()     // Catch:{ Throwable -> 0x0115 }
        L_0x03fa:
            boolean r0 = r12.f496q     // Catch:{ InterruptedException -> 0x042f }
            if (r0 != 0) goto L_0x0449
            boolean r0 = r12.f499t     // Catch:{ InterruptedException -> 0x042f }
            if (r0 == 0) goto L_0x0420
            com.google.ads.l r0 = r12.f489j     // Catch:{ InterruptedException -> 0x042f }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f611a     // Catch:{ InterruptedException -> 0x042f }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ InterruptedException -> 0x042f }
            com.google.ads.n r0 = (com.google.ads.C0272n) r0     // Catch:{ InterruptedException -> 0x042f }
            com.google.ads.util.i$b<com.google.ads.internal.h> r0 = r0.f660g     // Catch:{ InterruptedException -> 0x042f }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ InterruptedException -> 0x042f }
            com.google.ads.internal.h r0 = (com.google.ads.internal.C0253h) r0     // Catch:{ InterruptedException -> 0x042f }
            boolean r0 = r0.mo3611b()     // Catch:{ InterruptedException -> 0x042f }
            if (r0 == 0) goto L_0x0449
            boolean r0 = r1.mo3614a()     // Catch:{ InterruptedException -> 0x042f }
            if (r0 == 0) goto L_0x0449
        L_0x0420:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x042f }
            long r2 = r2 - r6
            long r2 = r4 - r2
            int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0449
            r12.wait(r2)     // Catch:{ InterruptedException -> 0x042f }
            goto L_0x03fa
        L_0x042f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "AdLoader InterruptedException while loading the HTML: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0449:
            boolean r0 = r12.f499t     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0452
            r12.m254j()     // Catch:{ Throwable -> 0x0115 }
            goto L_0x0121
        L_0x0452:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "AdLoader timed out after "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "ms while loading the HTML."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0284b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 1
            r12.mo3492a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            goto L_0x0121
        L_0x0476:
            r1 = r0
            goto L_0x030f
        L_0x0479:
            r0 = r3
            goto L_0x023c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.internal.C0238c.run():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3499b() {
        try {
            if (TextUtils.isEmpty(this.f484e)) {
                C0284b.m484b("Got a mediation response with no content type. Aborting mediation.");
                mo3492a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
            } else if (!this.f484e.startsWith("application/json")) {
                C0284b.m484b("Got a mediation response with a content type: '" + this.f484e + "'. Expected something starting with 'application/json'. Aborting mediation.");
                mo3492a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
            } else {
                final C0208c a = C0208c.m138a(this.f482c);
                m240a(this.f483d, a, this.f489j.f611a.mo3725a().f655b.mo3725a().mo3551j());
                C0265m.m411a().f617c.mo3725a().post(new Runnable() {
                    public void run() {
                        if (C0238c.this.f488i != null) {
                            C0238c.this.f488i.stopLoading();
                            C0238c.this.f488i.destroy();
                        }
                        C0238c.this.f489j.f611a.mo3725a().f655b.mo3725a().mo3534a(C0238c.this.f493n);
                        if (C0238c.this.f494o != null) {
                            C0238c.this.f489j.f611a.mo3725a().f660g.mo3725a().mo3610b(C0238c.this.f494o);
                        }
                        C0238c.this.f489j.f611a.mo3725a().f655b.mo3725a().mo3531a(a);
                    }
                });
            }
        } catch (JSONException e) {
            C0284b.m485b("AdLoader can't parse gWhirl server configuration.", e);
            mo3492a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
        }
    }

    /* renamed from: a */
    static void m240a(String str, C0208c cVar, C0210d dVar) {
        if (str != null && !str.contains("no-store") && !str.contains("no-cache")) {
            Matcher matcher = Pattern.compile("max-age\\s*=\\s*(\\d+)").matcher(str);
            if (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    dVar.mo3372a(cVar, parseInt);
                    C0284b.m486c(String.format(Locale.US, "Caching gWhirl configuration for: %d seconds", new Object[]{Integer.valueOf(parseInt)}));
                } catch (NumberFormatException e) {
                    C0284b.m485b("Caught exception trying to parse cache control directive. Overflow?", e);
                }
            } else {
                C0284b.m486c("Unrecognized cacheControlDirective: '" + str + "'. Not caching configuration.");
            }
        }
    }

    /* renamed from: a */
    public String mo3488a(Map<String, Object> map, Activity activity) throws C0243b {
        int i;
        Context applicationContext = activity.getApplicationContext();
        C0252g n = this.f489j.f611a.mo3725a().f655b.mo3725a().mo3555n();
        long m = n.mo3594m();
        if (m > 0) {
            map.put("prl", Long.valueOf(m));
        }
        long n2 = n.mo3595n();
        if (n2 > 0) {
            map.put("prnl", Long.valueOf(n2));
        }
        String l = n.mo3593l();
        if (l != null) {
            map.put("ppcl", l);
        }
        String k = n.mo3592k();
        if (k != null) {
            map.put("pcl", k);
        }
        long j = n.mo3591j();
        if (j > 0) {
            map.put("pcc", Long.valueOf(j));
        }
        map.put("preqs", Long.valueOf(n.mo3596o()));
        map.put("oar", Long.valueOf(n.mo3597p()));
        map.put("bas_on", Long.valueOf(n.mo3600s()));
        map.put("bas_off", Long.valueOf(n.mo3603v()));
        if (n.mo3606y()) {
            map.put("aoi_timeout", "true");
        }
        if (n.mo3576A()) {
            map.put("aoi_nofill", "true");
        }
        String D = n.mo3579D();
        if (D != null) {
            map.put("pit", D);
        }
        map.put("ptime", Long.valueOf(C0252g.m359E()));
        n.mo3580a();
        n.mo3590i();
        if (this.f489j.f611a.mo3725a().mo3684b()) {
            map.put("format", "interstitial_mb");
        } else {
            AdSize c = this.f489j.f611a.mo3725a().f660g.mo3725a().mo3612c();
            if (c.isFullWidth()) {
                map.put("smart_w", "full");
            }
            if (c.isAutoHeight()) {
                map.put("smart_h", "auto");
            }
            if (!c.isCustomAdSize()) {
                map.put("format", c.toString());
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("w", Integer.valueOf(c.getWidth()));
                hashMap.put("h", Integer.valueOf(c.getHeight()));
                map.put("ad_frame", hashMap);
            }
        }
        map.put("slotname", this.f489j.f611a.mo3725a().f661h.mo3725a());
        map.put("js", "afma-sdk-a-v6.4.1");
        try {
            int i2 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode;
            String f = AdUtil.m465f(applicationContext);
            if (!TextUtils.isEmpty(f)) {
                map.put("mv", f);
            }
            String a = C0265m.m411a().f615a.mo3726a();
            if (!TextUtils.isEmpty(a)) {
                map.put("imbf", a);
            }
            map.put("msid", applicationContext.getPackageName());
            map.put("app_name", i2 + ".android." + applicationContext.getPackageName());
            map.put("isu", AdUtil.m441a(applicationContext));
            String d = AdUtil.m462d(applicationContext);
            if (d == null) {
                d = "null";
            }
            map.put("net", d);
            String e = AdUtil.m464e(applicationContext);
            if (!(e == null || e.length() == 0)) {
                map.put("cap", e);
            }
            map.put("u_audio", Integer.valueOf(AdUtil.m466g(applicationContext).ordinal()));
            DisplayMetrics a2 = AdUtil.m440a(activity);
            map.put("u_sd", Float.valueOf(a2.density));
            map.put("u_h", Integer.valueOf(AdUtil.m438a(applicationContext, a2)));
            map.put("u_w", Integer.valueOf(AdUtil.m455b(applicationContext, a2)));
            map.put("hl", Locale.getDefault().getLanguage());
            C0272n a3 = this.f489j.f611a.mo3725a();
            C0190ak a4 = a3.f671r.mo3726a();
            if (a4 == null) {
                a4 = C0190ak.m71a("afma-sdk-a-v6.4.1", (Context) activity);
                a3.f671r.mo3727a(a4);
                a3.f672s.mo3727a(new C0192al(a4));
            }
            map.put("ms", a4.mo3332a(applicationContext));
            if (!(this.f489j.f611a.mo3725a().f663j == null || this.f489j.f611a.mo3725a().f663j.mo3725a() == null)) {
                AdView a5 = this.f489j.f611a.mo3725a().f663j.mo3725a();
                if (a5.getParent() != null) {
                    int[] iArr = new int[2];
                    a5.getLocationOnScreen(iArr);
                    int i3 = iArr[0];
                    int i4 = iArr[1];
                    DisplayMetrics displayMetrics = this.f489j.f611a.mo3725a().f659f.mo3725a().getResources().getDisplayMetrics();
                    int i5 = displayMetrics.widthPixels;
                    int i6 = displayMetrics.heightPixels;
                    if (!a5.isShown() || a5.getWidth() + i3 <= 0 || a5.getHeight() + i4 <= 0 || i3 > i5 || i4 > i6) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("x", Integer.valueOf(i3));
                    hashMap2.put("y", Integer.valueOf(i4));
                    hashMap2.put("width", Integer.valueOf(a5.getWidth()));
                    hashMap2.put("height", Integer.valueOf(a5.getHeight()));
                    hashMap2.put("visible", Integer.valueOf(i));
                    map.put("ad_pos", hashMap2);
                }
            }
            StringBuilder sb = new StringBuilder();
            AdSize[] a6 = this.f489j.f611a.mo3725a().f667n.mo3726a();
            if (a6 != null) {
                for (AdSize adSize : a6) {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(adSize.getWidth() + "x" + adSize.getHeight());
                }
                map.put("sz", sb.toString());
            }
            TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
            String networkOperator = telephonyManager.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                map.put("carrier", networkOperator);
            }
            map.put("pt", Integer.valueOf(telephonyManager.getPhoneType()));
            map.put("gnt", Integer.valueOf(telephonyManager.getNetworkType()));
            if (AdUtil.m460c()) {
                map.put("simulator", 1);
            }
            map.put("session_id", C0207b.m132a().mo3360b().toString());
            map.put("seq_num", C0207b.m132a().mo3361c().toString());
            if (this.f489j.f611a.mo3725a().f660g.mo3725a().mo3611b()) {
                map.put("swipeable", 1);
            }
            if (this.f489j.f611a.mo3725a().f673t.mo3726a().booleanValue()) {
                map.put("d_imp_hdr", 1);
            }
            String a7 = AdUtil.m443a(map);
            String str = this.f489j.f611a.mo3725a().f657d.mo3725a().f616b.mo3725a().f632o.mo3726a().booleanValue() ? m251g() + m246d() + "(" + a7 + ");" + m252h() : m251g() + m247e() + m246d() + "(" + a7 + ");" + m252h();
            C0284b.m486c("adRequestUrlHtml: " + str);
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new C0243b("NameNotFoundException");
        }
    }

    /* renamed from: d */
    private String m246d() {
        if (this.f487h instanceof SearchAdRequest) {
            return "AFMA_buildAdURL";
        }
        return "AFMA_buildAdURL";
    }

    /* renamed from: e */
    private String m247e() {
        if (this.f487h instanceof SearchAdRequest) {
            return "AFMA_getSdkConstants();";
        }
        return "AFMA_getSdkConstants();";
    }

    /* renamed from: f */
    private String m250f() {
        if (this.f487h instanceof SearchAdRequest) {
            return "http://www.gstatic.com/safa/";
        }
        return "http://media.admob.com/";
    }

    /* renamed from: g */
    private String m251g() {
        if (this.f487h instanceof SearchAdRequest) {
            return "<html><head><script src=\"http://www.gstatic.com/safa/sdk-core-v40.js\"></script><script>";
        }
        return "<html><head><script src=\"http://media.admob.com/sdk-core-v40.js\"></script><script>";
    }

    /* renamed from: h */
    private String m252h() {
        if (this.f487h instanceof SearchAdRequest) {
            return "</script></head><body></body></html>";
        }
        return "</script></head><body></body></html>";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3492a(AdRequest.ErrorCode errorCode, boolean z) {
        C0265m.m411a().f617c.mo3725a().post(new C0242a(this.f489j.f611a.mo3725a().f655b.mo3725a(), this.f488i, this.f486g, errorCode, z));
    }

    /* renamed from: b */
    private void m243b(String str, String str2) {
        C0265m.m411a().f617c.mo3725a().post(new C0244c(this.f488i, str2, str));
    }

    /* renamed from: i */
    private void m253i() {
        AdWebView l = this.f489j.f611a.mo3725a().f655b.mo3725a().mo3553l();
        this.f489j.f611a.mo3725a().f655b.mo3725a().mo3554m().mo3616c(true);
        this.f489j.f611a.mo3725a().f655b.mo3725a().mo3555n().mo3589h();
        C0265m.m411a().f617c.mo3725a().post(new C0244c(l, this.f481b, this.f482c));
    }

    /* renamed from: j */
    private void m254j() {
        C0265m.m411a().f617c.mo3725a().post(new C0246e(this.f489j.f611a.mo3725a().f655b.mo3725a(), this.f488i, this.f492m, this.f500u, this.f497r, this.f493n, this.f494o));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo3501b(boolean z) {
        this.f485f = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo3500b(String str) {
        this.f484e = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo3497a(String str, String str2) {
        this.f481b = str2;
        this.f482c = str;
        notify();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public synchronized void mo3503c(String str) {
        this.f483d = str;
    }

    /* renamed from: d */
    public synchronized void mo3505d(String str) {
        this.f490k = str;
        notify();
    }

    /* renamed from: e */
    public synchronized void mo3507e(String str) {
        this.f491l = str;
    }

    /* renamed from: f */
    public synchronized void mo3509f(String str) {
        this.f493n = str;
    }

    /* renamed from: a */
    public synchronized void mo3494a(AdSize adSize) {
        this.f494o = adSize;
    }

    /* renamed from: a */
    public synchronized void mo3491a(AdRequest.ErrorCode errorCode) {
        this.f498s = errorCode;
        notify();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public synchronized void mo3502c() {
        this.f499t = true;
        notify();
    }

    /* renamed from: c */
    public synchronized void mo3504c(boolean z) {
        this.f497r = z;
    }

    /* renamed from: a */
    public synchronized void mo3490a(int i) {
        this.f500u = i;
    }

    /* renamed from: d */
    public synchronized void mo3506d(boolean z) {
        this.f502w = z;
    }

    /* renamed from: a */
    public synchronized void mo3495a(C0245d dVar) {
        this.f503x = dVar;
    }

    /* renamed from: e */
    public synchronized void mo3508e(boolean z) {
        this.f480a = z;
    }
}
