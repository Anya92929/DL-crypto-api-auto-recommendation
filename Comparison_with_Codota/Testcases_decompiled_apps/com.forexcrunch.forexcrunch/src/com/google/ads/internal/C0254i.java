package com.google.ads.internal;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdRequest;
import com.google.ads.C0273o;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import com.google.ads.util.C0293g;
import java.util.Map;

/* renamed from: com.google.ads.internal.i */
public class C0254i extends WebViewClient {

    /* renamed from: c */
    private static final C0232a f588c = C0232a.f474a.mo3484b();

    /* renamed from: a */
    protected C0247d f589a;

    /* renamed from: b */
    protected boolean f590b = false;

    /* renamed from: d */
    private final Map<String, C0273o> f591d;

    /* renamed from: e */
    private final boolean f592e;

    /* renamed from: f */
    private boolean f593f;

    /* renamed from: g */
    private boolean f594g;

    /* renamed from: h */
    private boolean f595h = false;

    /* renamed from: i */
    private boolean f596i = false;

    public C0254i(C0247d dVar, Map<String, C0273o> map, boolean z, boolean z2) {
        this.f589a = dVar;
        this.f591d = map;
        this.f592e = z;
        this.f594g = z2;
    }

    /* renamed from: a */
    public static C0254i m399a(C0247d dVar, Map<String, C0273o> map, boolean z, boolean z2) {
        if (AdUtil.f690a >= 11) {
            return new C0293g.C0302b(dVar, map, z, z2);
        }
        return new C0254i(dVar, map, z, z2);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) {
        /*
            r5 = this;
            r3 = 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00cf }
            r0.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "shouldOverrideUrlLoading(\""
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x00cf }
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "\")"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.util.C0284b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x00cf }
            android.net.Uri r2 = android.net.Uri.parse(r7)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.a r0 = f588c     // Catch:{ Throwable -> 0x00cf }
            boolean r0 = r0.mo3479a((android.net.Uri) r2)     // Catch:{ Throwable -> 0x00cf }
            if (r0 == 0) goto L_0x0034
            com.google.ads.internal.a r0 = f588c     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.d r1 = r5.f589a     // Catch:{ Throwable -> 0x00cf }
            java.util.Map<java.lang.String, com.google.ads.o> r4 = r5.f591d     // Catch:{ Throwable -> 0x00cf }
            r0.mo3478a(r1, r4, r2, r6)     // Catch:{ Throwable -> 0x00cf }
            r0 = r3
        L_0x0033:
            return r0
        L_0x0034:
            boolean r0 = r5.f594g     // Catch:{ Throwable -> 0x00cf }
            if (r0 == 0) goto L_0x005b
            boolean r0 = com.google.ads.util.AdUtil.m452a((android.net.Uri) r2)     // Catch:{ Throwable -> 0x00cf }
            if (r0 == 0) goto L_0x0043
            boolean r0 = super.shouldOverrideUrlLoading(r6, r7)     // Catch:{ Throwable -> 0x00cf }
            goto L_0x0033
        L_0x0043:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Throwable -> 0x00cf }
            r0.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "u"
            r0.put(r1, r7)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.d r1 = r5.f589a     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.e r2 = new com.google.ads.internal.e     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r4 = "intent"
            r2.<init>(r4, r0)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.AdActivity.launchAdActivity(r1, r2)     // Catch:{ Throwable -> 0x00cf }
            r0 = r3
            goto L_0x0033
        L_0x005b:
            boolean r0 = r5.f592e     // Catch:{ Throwable -> 0x00cf }
            if (r0 == 0) goto L_0x00b6
            com.google.ads.internal.d r0 = r5.f589a     // Catch:{ am -> 0x009d }
            com.google.ads.n r1 = r0.mo3550i()     // Catch:{ am -> 0x009d }
            com.google.ads.util.i$b<android.content.Context> r0 = r1.f659f     // Catch:{ am -> 0x009d }
            java.lang.Object r0 = r0.mo3725a()     // Catch:{ am -> 0x009d }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ am -> 0x009d }
            com.google.ads.util.i$c<com.google.ads.al> r1 = r1.f672s     // Catch:{ am -> 0x009d }
            java.lang.Object r1 = r1.mo3726a()     // Catch:{ am -> 0x009d }
            com.google.ads.al r1 = (com.google.ads.C0192al) r1     // Catch:{ am -> 0x009d }
            if (r1 == 0) goto L_0x00b4
            boolean r4 = r1.mo3344a((android.net.Uri) r2)     // Catch:{ am -> 0x009d }
            if (r4 == 0) goto L_0x00b4
            android.net.Uri r0 = r1.mo3342a(r2, r0)     // Catch:{ am -> 0x009d }
        L_0x0081:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Throwable -> 0x00cf }
            r1.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r2 = "u"
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00cf }
            r1.put(r2, r0)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.d r0 = r5.f589a     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.e r2 = new com.google.ads.internal.e     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r4 = "intent"
            r2.<init>(r4, r1)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.AdActivity.launchAdActivity(r0, r2)     // Catch:{ Throwable -> 0x00cf }
            r0 = r3
            goto L_0x0033
        L_0x009d:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00cf }
            r0.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "Unable to append parameter to URL: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x00cf }
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.util.C0284b.m490e(r0)     // Catch:{ Throwable -> 0x00cf }
        L_0x00b4:
            r0 = r2
            goto L_0x0081
        L_0x00b6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00cf }
            r0.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "URL is not a GMSG and can't handle URL: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x00cf }
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.util.C0284b.m490e(r0)     // Catch:{ Throwable -> 0x00cf }
        L_0x00cc:
            r0 = r3
            goto L_0x0033
        L_0x00cf:
            r0 = move-exception
            java.lang.String r1 = "An unknown error occurred in shouldOverrideUrlLoading."
            com.google.ads.util.C0284b.m489d(r1, r0)
            goto L_0x00cc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.internal.C0254i.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public void onPageStarted(WebView webView, String url, Bitmap favicon) {
        this.f593f = true;
    }

    public void onPageFinished(WebView view, String url) {
        this.f593f = false;
        if (this.f595h) {
            C0238c k = this.f589a.mo3552k();
            if (k != null) {
                k.mo3502c();
            } else {
                C0284b.m480a("adLoader was null while trying to setFinishedLoadingHtml().");
            }
            this.f595h = false;
        }
        if (this.f596i) {
            f588c.mo3474a(view);
            this.f596i = false;
        }
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        this.f593f = false;
        C0238c k = this.f589a.mo3552k();
        if (k != null) {
            k.mo3491a(AdRequest.ErrorCode.NETWORK_ERROR);
        }
    }

    /* renamed from: a */
    public void mo3613a(boolean z) {
        this.f590b = z;
    }

    /* renamed from: b */
    public void mo3615b(boolean z) {
        this.f594g = z;
    }

    /* renamed from: c */
    public void mo3616c(boolean z) {
        this.f595h = z;
    }

    /* renamed from: d */
    public void mo3617d(boolean z) {
        this.f596i = z;
    }

    /* renamed from: a */
    public boolean mo3614a() {
        return this.f593f;
    }
}
