package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

@C1130ez
/* renamed from: com.google.android.gms.internal.gw */
public class C1234gw extends WebViewClient {

    /* renamed from: md */
    protected final C1232gv f3795md;

    /* renamed from: mw */
    private final Object f3796mw;

    /* renamed from: pJ */
    private C0988cb f3797pJ;

    /* renamed from: pL */
    private C0975bz f3798pL;

    /* renamed from: pM */
    private C1741v f3799pM;

    /* renamed from: pz */
    private C0964bw f3800pz;

    /* renamed from: tg */
    private C1236a f3801tg;

    /* renamed from: wP */
    private final HashMap<String, C0974by> f3802wP;

    /* renamed from: wQ */
    private C1734t f3803wQ;

    /* renamed from: wR */
    private C1063dn f3804wR;

    /* renamed from: wS */
    private boolean f3805wS;

    /* renamed from: wT */
    private boolean f3806wT;

    /* renamed from: wU */
    private C1068dq f3807wU;

    /* renamed from: wV */
    private final C1052dg f3808wV;

    /* renamed from: com.google.android.gms.internal.gw$a */
    public interface C1236a {
        /* renamed from: a */
        void mo7957a(C1232gv gvVar);
    }

    public C1234gw(C1232gv gvVar, boolean z) {
        this(gvVar, z, new C1052dg(gvVar, gvVar.getContext(), new C0950bl(gvVar.getContext())));
    }

    C1234gw(C1232gv gvVar, boolean z, C1052dg dgVar) {
        this.f3802wP = new HashMap<>();
        this.f3796mw = new Object();
        this.f3805wS = false;
        this.f3795md = gvVar;
        this.f3806wT = z;
        this.f3808wV = dgVar;
    }

    /* renamed from: d */
    private static boolean m4713d(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* renamed from: e */
    private void m4714e(Uri uri) {
        String path = uri.getPath();
        C0974by byVar = this.f3802wP.get(path);
        if (byVar != null) {
            Map<String, String> c = C1213gj.m4629c(uri);
            if (C1229gs.m4684u(2)) {
                C1229gs.m4678V("Received GMSG: " + path);
                for (String next : c.keySet()) {
                    C1229gs.m4678V("  " + next + ": " + c.get(next));
                }
            }
            byVar.mo7942a(this.f3795md, c);
            return;
        }
        C1229gs.m4678V("No GMSG handler found for GMSG: " + uri);
    }

    /* renamed from: a */
    public final void mo8647a(C1055dj djVar) {
        C1063dn dnVar = null;
        boolean dz = this.f3795md.mo8635dz();
        C1734t tVar = (!dz || this.f3795md.mo8618Y().f2623og) ? this.f3803wQ : null;
        if (!dz) {
            dnVar = this.f3804wR;
        }
        mo8648a(new C1062dm(djVar, tVar, dnVar, this.f3807wU, this.f3795md.mo8634dy()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8648a(C1062dm dmVar) {
        C1056dk.m4233a(this.f3795md.getContext(), dmVar);
    }

    /* renamed from: a */
    public final void mo8649a(C1236a aVar) {
        this.f3801tg = aVar;
    }

    /* renamed from: a */
    public void mo8650a(C1734t tVar, C1063dn dnVar, C0964bw bwVar, C1068dq dqVar, boolean z, C0975bz bzVar, C0988cb cbVar, C1741v vVar) {
        mo8651a(tVar, dnVar, bwVar, dqVar, z, bzVar, vVar);
        mo8652a("/setInterstitialProperties", (C0974by) new C0987ca(cbVar));
        this.f3797pJ = cbVar;
    }

    /* renamed from: a */
    public void mo8651a(C1734t tVar, C1063dn dnVar, C0964bw bwVar, C1068dq dqVar, boolean z, C0975bz bzVar, C1741v vVar) {
        if (vVar == null) {
            vVar = new C1741v(false);
        }
        mo8652a("/appEvent", (C0974by) new C0963bv(bwVar));
        mo8652a("/canOpenURLs", C0965bx.f2943pB);
        mo8652a("/click", C0965bx.f2944pC);
        mo8652a("/close", C0965bx.f2945pD);
        mo8652a("/customClose", C0965bx.f2946pE);
        mo8652a("/httpTrack", C0965bx.f2947pF);
        mo8652a("/log", C0965bx.f2948pG);
        mo8652a("/open", (C0974by) new C0990cd(bzVar, vVar));
        mo8652a("/touch", C0965bx.f2949pH);
        mo8652a("/video", C0965bx.f2950pI);
        mo8652a("/mraid", (C0974by) new C0989cc());
        this.f3803wQ = tVar;
        this.f3804wR = dnVar;
        this.f3800pz = bwVar;
        this.f3798pL = bzVar;
        this.f3807wU = dqVar;
        this.f3799pM = vVar;
        mo8664y(z);
    }

    /* renamed from: a */
    public final void mo8652a(String str, C0974by byVar) {
        this.f3802wP.put(str, byVar);
    }

    /* renamed from: a */
    public final void mo8653a(boolean z, int i) {
        mo8648a(new C1062dm((!this.f3795md.mo8635dz() || this.f3795md.mo8618Y().f2623og) ? this.f3803wQ : null, this.f3804wR, this.f3807wU, this.f3795md, z, i, this.f3795md.mo8634dy()));
    }

    /* renamed from: a */
    public final void mo8654a(boolean z, int i, String str) {
        C1063dn dnVar = null;
        boolean dz = this.f3795md.mo8635dz();
        C1734t tVar = (!dz || this.f3795md.mo8618Y().f2623og) ? this.f3803wQ : null;
        if (!dz) {
            dnVar = this.f3804wR;
        }
        mo8648a(new C1062dm(tVar, dnVar, this.f3800pz, this.f3807wU, this.f3795md, z, i, str, this.f3795md.mo8634dy(), this.f3798pL));
    }

    /* renamed from: a */
    public final void mo8655a(boolean z, int i, String str, String str2) {
        boolean dz = this.f3795md.mo8635dz();
        mo8648a(new C1062dm((!dz || this.f3795md.mo8618Y().f2623og) ? this.f3803wQ : null, dz ? null : this.f3804wR, this.f3800pz, this.f3807wU, this.f3795md, z, i, str, str2, this.f3795md.mo8634dy(), this.f3798pL));
    }

    /* renamed from: bY */
    public final void mo8656bY() {
        synchronized (this.f3796mw) {
            this.f3805wS = false;
            this.f3806wT = true;
            final C1056dk du = this.f3795md.mo8630du();
            if (du != null) {
                if (!C1228gr.m4673dt()) {
                    C1228gr.f3776wC.post(new Runnable() {
                        public void run() {
                            du.mo8311bY();
                        }
                    });
                } else {
                    du.mo8311bY();
                }
            }
        }
    }

    /* renamed from: dE */
    public C1741v mo8657dE() {
        return this.f3799pM;
    }

    /* renamed from: dF */
    public boolean mo8658dF() {
        boolean z;
        synchronized (this.f3796mw) {
            z = this.f3806wT;
        }
        return z;
    }

    /* renamed from: dG */
    public void mo8659dG() {
        if (mo8658dF()) {
            this.f3808wV.mo8295bQ();
        }
    }

    public final void onLoadResource(WebView webView, String url) {
        C1229gs.m4678V("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m4714e(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.f3801tg != null) {
            this.f3801tg.mo7957a(this.f3795md);
            this.f3801tg = null;
        }
    }

    public final void reset() {
        synchronized (this.f3796mw) {
            this.f3802wP.clear();
            this.f3803wQ = null;
            this.f3804wR = null;
            this.f3801tg = null;
            this.f3800pz = null;
            this.f3805wS = false;
            this.f3806wT = false;
            this.f3798pL = null;
            this.f3807wU = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        Uri uri;
        C1229gs.m4678V("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m4714e(parse);
        } else if (this.f3805wS && webView == this.f3795md && m4713d(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (!this.f3795md.willNotDraw()) {
                try {
                    C1391k dx = this.f3795md.mo8633dx();
                    if (dx != null && dx.mo9091b(parse)) {
                        parse = dx.mo9088a(parse, this.f3795md.getContext());
                    }
                    uri = parse;
                } catch (C1467l e) {
                    C1229gs.m4679W("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                if (this.f3799pM == null || this.f3799pM.mo10154av()) {
                    mo8647a(new C1055dj("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
                } else {
                    this.f3799pM.mo10155d(url);
                }
            } else {
                C1229gs.m4679W("AdWebView unable to handle URL: " + url);
            }
        }
        return true;
    }

    /* renamed from: y */
    public final void mo8664y(boolean z) {
        this.f3805wS = z;
    }
}
