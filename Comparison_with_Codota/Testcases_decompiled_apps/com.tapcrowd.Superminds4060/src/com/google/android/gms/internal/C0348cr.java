package com.google.android.gms.internal;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.cr */
public class C0348cr extends WebViewClient {

    /* renamed from: eJ */
    private final Object f1027eJ = new Object();

    /* renamed from: ey */
    private C0212ag f1028ey;

    /* renamed from: fG */
    protected final C0347cq f1029fG;

    /* renamed from: hZ */
    private final HashMap<String, C0221ai> f1030hZ = new HashMap<>();

    /* renamed from: ia */
    private C0613q f1031ia;

    /* renamed from: ib */
    private C0286bi f1032ib;

    /* renamed from: ic */
    private C0350a f1033ic;

    /* renamed from: id */
    private boolean f1034id = false;

    /* renamed from: ie */
    private boolean f1035ie;

    /* renamed from: if */
    private C0291bl f1036if;

    /* renamed from: com.google.android.gms.internal.cr$a */
    public interface C0350a {
        /* renamed from: a */
        void mo4114a(C0347cq cqVar);
    }

    public C0348cr(C0347cq cqVar, boolean z) {
        this.f1029fG = cqVar;
        this.f1035ie = z;
    }

    /* renamed from: a */
    private void m757a(C0285bh bhVar) {
        C0280bf.m566a(this.f1029fG.getContext(), bhVar);
    }

    /* renamed from: b */
    private static boolean m758b(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* renamed from: c */
    private void m759c(Uri uri) {
        String path = uri.getPath();
        C0221ai aiVar = this.f1030hZ.get(path);
        if (aiVar != null) {
            HashMap hashMap = new HashMap();
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer.parseUrl(uri.toString());
            for (UrlQuerySanitizer.ParameterValuePair next : urlQuerySanitizer.getParameterList()) {
                hashMap.put(next.mParameter, next.mValue);
            }
            if (C0344cn.m732k(2)) {
                C0344cn.m736p("Received GMSG: " + path);
                for (String str : hashMap.keySet()) {
                    C0344cn.m736p("  " + str + ": " + ((String) hashMap.get(str)));
                }
            }
            aiVar.mo4037a(this.f1029fG, hashMap);
            return;
        }
        C0344cn.m737q("No GMSG handler found for GMSG: " + uri);
    }

    /* renamed from: S */
    public final void mo4221S() {
        synchronized (this.f1027eJ) {
            this.f1034id = false;
            this.f1035ie = true;
            final C0280bf au = this.f1029fG.mo4210au();
            if (au != null) {
                if (!C0343cm.m726ar()) {
                    C0343cm.f1013hO.post(new Runnable() {
                        public void run() {
                            au.mo4098S();
                        }
                    });
                } else {
                    au.mo4098S();
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo4222a(C0279be beVar) {
        C0286bi biVar = null;
        boolean az = this.f1029fG.mo4215az();
        C0613q qVar = (!az || this.f1029fG.mo4211av().f1582ex) ? this.f1031ia : null;
        if (!az) {
            biVar = this.f1032ib;
        }
        m757a(new C0285bh(beVar, qVar, biVar, this.f1036if, this.f1029fG.mo4214ay()));
    }

    /* renamed from: a */
    public final void mo4223a(C0350a aVar) {
        this.f1033ic = aVar;
    }

    /* renamed from: a */
    public void mo4224a(C0613q qVar, C0286bi biVar, C0212ag agVar, C0291bl blVar, boolean z) {
        mo4225a("/appEvent", (C0221ai) new C0211af(agVar));
        mo4225a("/canOpenURLs", C0213ah.f571ez);
        mo4225a("/click", C0213ah.f563eA);
        mo4225a("/close", C0213ah.f564eB);
        mo4225a("/customClose", C0213ah.f565eC);
        mo4225a("/httpTrack", C0213ah.f566eD);
        mo4225a("/log", C0213ah.f567eE);
        mo4225a("/open", C0213ah.f568eF);
        mo4225a("/touch", C0213ah.f569eG);
        mo4225a("/video", C0213ah.f570eH);
        this.f1031ia = qVar;
        this.f1032ib = biVar;
        this.f1028ey = agVar;
        this.f1036if = blVar;
        mo4230j(z);
    }

    /* renamed from: a */
    public final void mo4225a(String str, C0221ai aiVar) {
        this.f1030hZ.put(str, aiVar);
    }

    /* renamed from: a */
    public final void mo4226a(boolean z, int i) {
        m757a(new C0285bh((!this.f1029fG.mo4215az() || this.f1029fG.mo4211av().f1582ex) ? this.f1031ia : null, this.f1032ib, this.f1036if, this.f1029fG, z, i, this.f1029fG.mo4214ay()));
    }

    /* renamed from: a */
    public final void mo4227a(boolean z, int i, String str) {
        C0286bi biVar = null;
        boolean az = this.f1029fG.mo4215az();
        C0613q qVar = (!az || this.f1029fG.mo4211av().f1582ex) ? this.f1031ia : null;
        if (!az) {
            biVar = this.f1032ib;
        }
        m757a(new C0285bh(qVar, biVar, this.f1028ey, this.f1036if, this.f1029fG, z, i, str, this.f1029fG.mo4214ay()));
    }

    /* renamed from: a */
    public final void mo4228a(boolean z, int i, String str, String str2) {
        C0286bi biVar = null;
        boolean az = this.f1029fG.mo4215az();
        C0613q qVar = (!az || this.f1029fG.mo4211av().f1582ex) ? this.f1031ia : null;
        if (!az) {
            biVar = this.f1032ib;
        }
        m757a(new C0285bh(qVar, biVar, this.f1028ey, this.f1036if, this.f1029fG, z, i, str, str2, this.f1029fG.mo4214ay()));
    }

    /* renamed from: aD */
    public boolean mo4229aD() {
        boolean z;
        synchronized (this.f1027eJ) {
            z = this.f1035ie;
        }
        return z;
    }

    /* renamed from: j */
    public final void mo4230j(boolean z) {
        this.f1034id = z;
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.f1033ic != null) {
            this.f1033ic.mo4114a(this.f1029fG);
            this.f1033ic = null;
        }
    }

    public final void reset() {
        synchronized (this.f1027eJ) {
            this.f1030hZ.clear();
            this.f1031ia = null;
            this.f1032ib = null;
            this.f1033ic = null;
            this.f1028ey = null;
            this.f1034id = false;
            this.f1035ie = false;
            this.f1036if = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        Uri uri;
        C0344cn.m736p("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m759c(parse);
        } else if (this.f1034id && m758b(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (!this.f1029fG.willNotDraw()) {
                try {
                    C0599h ax = this.f1029fG.mo4213ax();
                    if (ax != null && ax.mo5303a(parse)) {
                        parse = ax.mo5301a(parse, this.f1029fG.getContext());
                    }
                    uri = parse;
                } catch (C0600i e) {
                    C0344cn.m737q("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                mo4222a(new C0279be("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
            } else {
                C0344cn.m737q("AdWebView unable to handle URL: " + url);
            }
        }
        return true;
    }
}
