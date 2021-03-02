package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.searchads.SearchAdRequest;
import com.google.ads.util.AdUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

public class c implements Runnable {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private f f;
    /* access modifiers changed from: private */
    public d g;
    private AdRequest h;
    /* access modifiers changed from: private */
    public WebView i;
    private String j;
    private LinkedList<String> k;
    /* access modifiers changed from: private */
    public String l;
    /* access modifiers changed from: private */
    public AdSize m;
    private volatile boolean n;
    private boolean o;
    private AdRequest.ErrorCode p;
    private boolean q;
    private int r;
    private Thread s;
    private boolean t;

    private class d extends Exception {
        public d(String str) {
            super(str);
        }
    }

    private class b extends Exception {
        public b(String str) {
            super(str);
        }
    }

    private static class a implements Runnable {
        private final d a;
        private final WebView b;
        private final f c;
        private final AdRequest.ErrorCode d;
        private final boolean e;

        public a(d dVar, WebView webView, f fVar, AdRequest.ErrorCode errorCode, boolean z) {
            this.a = dVar;
            this.b = webView;
            this.c = fVar;
            this.d = errorCode;
            this.e = z;
        }

        public void run() {
            if (this.b != null) {
                this.b.stopLoading();
                this.b.destroy();
            }
            if (this.c != null) {
                this.c.a();
            }
            if (this.e) {
                AdWebView k = this.a.k();
                k.stopLoading();
                k.setVisibility(8);
            }
            this.a.a(this.d);
        }
    }

    /* renamed from: com.google.ads.internal.c$c  reason: collision with other inner class name */
    private class C0000c implements Runnable {
        private final String b;
        private final String c;
        private final WebView d;

        public C0000c(WebView webView, String str, String str2) {
            this.d = webView;
            this.b = str;
            this.c = str2;
        }

        public void run() {
            if (this.c != null) {
                this.d.loadDataWithBaseURL(this.b, this.c, "text/html", "utf-8", (String) null);
            } else {
                this.d.loadUrl(this.b);
            }
        }
    }

    private static class e implements Runnable {
        private final d a;
        private final WebView b;
        private final LinkedList<String> c;
        private final int d;
        private final boolean e;
        private final String f;
        private final AdSize g;

        public e(d dVar, WebView webView, LinkedList<String> linkedList, int i, boolean z, String str, AdSize adSize) {
            this.a = dVar;
            this.b = webView;
            this.c = linkedList;
            this.d = i;
            this.e = z;
            this.f = str;
            this.g = adSize;
        }

        public void run() {
            if (this.b != null) {
                this.b.stopLoading();
                this.b.destroy();
            }
            this.a.a(this.c);
            this.a.a(this.d);
            this.a.a(this.e);
            this.a.a(this.f);
            if (this.g != null) {
                this.a.h().i.a().b(this.g);
                this.a.k().setAdSize(this.g);
            }
            this.a.C();
        }
    }

    protected c() {
    }

    public c(d dVar) {
        this.g = dVar;
        this.j = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.k = new LinkedList<>();
        this.p = null;
        this.q = false;
        this.r = -1;
        this.e = false;
        this.o = false;
        this.l = null;
        this.m = null;
        if (dVar.h().c.a() != null) {
            this.i = new AdWebView(dVar.h(), (AdSize) null);
            this.i.setWebViewClient(i.a(dVar, a.b, false, false));
            this.i.setVisibility(8);
            this.i.setWillNotDraw(true);
            this.f = new f(this, dVar);
            return;
        }
        this.i = null;
        this.f = null;
        com.google.ads.util.b.e("activity was null while trying to create an AdLoader.");
    }

    /* access modifiers changed from: protected */
    public synchronized void a(String str) {
        this.k.add(str);
    }

    /* access modifiers changed from: protected */
    public void a() {
        com.google.ads.util.b.a("AdLoader cancelled.");
        if (this.i != null) {
            this.i.stopLoading();
            this.i.destroy();
        }
        if (this.s != null) {
            this.s.interrupt();
            this.s = null;
        }
        if (this.f != null) {
            this.f.a();
        }
        this.n = true;
    }

    /* access modifiers changed from: protected */
    public void a(AdRequest adRequest) {
        this.h = adRequest;
        this.n = false;
        this.s = new Thread(this);
        this.s.start();
    }

    public void run() {
        synchronized (this) {
            if (this.i == null || this.f == null) {
                com.google.ads.util.b.e("adRequestWebView was null while trying to load an ad.");
                a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
                return;
            }
            Activity a2 = this.g.h().c.a();
            if (a2 == null) {
                com.google.ads.util.b.e("activity was null while forming an ad request.");
                a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
                return;
            }
            long o2 = this.g.o();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Map<String, Object> requestMap = this.h.getRequestMap(this.g.h().d.a());
            Object obj = requestMap.get("extras");
            if (obj instanceof Map) {
                Map map = (Map) obj;
                Object obj2 = map.get("_adUrl");
                if (obj2 instanceof String) {
                    this.a = (String) obj2;
                }
                Object obj3 = map.get("_requestUrl");
                if (obj3 instanceof String) {
                    this.j = (String) obj3;
                }
                Object obj4 = map.get("_orientation");
                if (obj4 instanceof String) {
                    if (obj4.equals("p")) {
                        this.r = 1;
                    } else if (obj4.equals("l")) {
                        this.r = 0;
                    }
                }
                Object obj5 = map.get("_norefresh");
                if ((obj5 instanceof String) && obj5.equals("t")) {
                    this.g.d();
                }
            }
            if (this.a == null) {
                if (this.j == null) {
                    try {
                        f(a(requestMap, a2));
                        long elapsedRealtime2 = o2 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                        if (elapsedRealtime2 > 0) {
                            try {
                                wait(elapsedRealtime2);
                            } catch (InterruptedException e2) {
                                com.google.ads.util.b.a("AdLoader InterruptedException while getting the URL: " + e2);
                                return;
                            }
                        }
                        try {
                            if (!this.n) {
                                if (this.p != null) {
                                    a(this.p, false);
                                    return;
                                } else if (this.j == null) {
                                    com.google.ads.util.b.c("AdLoader timed out after " + o2 + "ms while getting the URL.");
                                    a(AdRequest.ErrorCode.NETWORK_ERROR, false);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            com.google.ads.util.b.b("An unknown error occurred in AdLoader.", th);
                            a(AdRequest.ErrorCode.INTERNAL_ERROR, true);
                        }
                    } catch (d e3) {
                        com.google.ads.util.b.c("Unable to connect to network: " + e3);
                        a(AdRequest.ErrorCode.NETWORK_ERROR, false);
                        return;
                    } catch (b e4) {
                        com.google.ads.util.b.c("Caught internal exception: " + e4);
                        a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
                        return;
                    }
                }
                this.f.a(this.t);
                this.f.a(this.j);
                long elapsedRealtime3 = o2 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                if (elapsedRealtime3 > 0) {
                    try {
                        wait(elapsedRealtime3);
                    } catch (InterruptedException e5) {
                        com.google.ads.util.b.a("AdLoader InterruptedException while getting the ad server's response: " + e5);
                        return;
                    }
                }
                if (!this.n) {
                    if (this.p != null) {
                        a(this.p, false);
                        return;
                    } else if (this.b == null) {
                        com.google.ads.util.b.c("AdLoader timed out after " + o2 + "ms while waiting for the ad server's response.");
                        a(AdRequest.ErrorCode.NETWORK_ERROR, false);
                        return;
                    } else if (this.g.h().j.a() != null) {
                        if (this.m == null) {
                            com.google.ads.util.b.b("Multiple supported ad sizes were specified, but the server did not respond with a size.");
                            a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
                            return;
                        } else if (!Arrays.asList((Object[]) this.g.h().j.a()).contains(this.m)) {
                            com.google.ads.util.b.b("The ad server did not respond with a supported AdSize: " + this.m);
                            a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
                            return;
                        }
                    } else if (this.m != null) {
                        com.google.ads.util.b.e("adSize was expected to be null in AdLoader.");
                        this.m = null;
                    }
                } else {
                    return;
                }
            }
            if (this.e) {
                this.g.b(true);
                b();
            } else if (this.d == null || (!this.d.startsWith("application/json") && !this.d.startsWith("text/javascript"))) {
                this.g.b(false);
                e();
                long elapsedRealtime4 = o2 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                if (elapsedRealtime4 > 0) {
                    try {
                        wait(elapsedRealtime4);
                    } catch (InterruptedException e6) {
                        com.google.ads.util.b.a("AdLoader InterruptedException while loading the HTML: " + e6);
                        return;
                    }
                }
                if (this.q) {
                    f();
                } else {
                    com.google.ads.util.b.c("AdLoader timed out after " + o2 + "ms while loading the HTML.");
                    a(AdRequest.ErrorCode.NETWORK_ERROR, true);
                }
            } else {
                com.google.ads.util.b.b("Expected HTML but received " + this.d + ".");
                a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        try {
            if (TextUtils.isEmpty(this.d)) {
                com.google.ads.util.b.b("Got a mediation response with no content type. Aborting mediation.");
                a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
            } else if (!this.d.startsWith("application/json")) {
                com.google.ads.util.b.b("Got a mediation response with a content type: '" + this.d + "'. Expected something starting with 'application/json'. Aborting mediation.");
                a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
            } else {
                final com.google.ads.c a2 = com.google.ads.c.a(this.b);
                a(this.c, a2, this.g.i());
                this.g.a((Runnable) new Runnable() {
                    public void run() {
                        if (c.this.i != null) {
                            c.this.i.stopLoading();
                            c.this.i.destroy();
                        }
                        c.this.g.a(c.this.l);
                        if (c.this.m != null) {
                            c.this.g.h().i.a().b(c.this.m);
                        }
                        c.this.g.a(a2);
                    }
                });
            }
        } catch (JSONException e2) {
            com.google.ads.util.b.b("AdLoader can't parse gWhirl server configuration.", e2);
            a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
        }
    }

    static void a(String str, com.google.ads.c cVar, com.google.ads.d dVar) {
        if (str != null && !str.contains("no-store") && !str.contains("no-cache")) {
            Matcher matcher = Pattern.compile("max-age\\s*=\\s*(\\d+)").matcher(str);
            if (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    dVar.a(cVar, parseInt);
                    com.google.ads.util.b.c(String.format(Locale.US, "Caching gWhirl configuration for: %d seconds", new Object[]{Integer.valueOf(parseInt)}));
                } catch (NumberFormatException e2) {
                    com.google.ads.util.b.b("Caught exception trying to parse cache control directive. Overflow?", e2);
                }
            } else {
                com.google.ads.util.b.c("Unrecognized cacheControlDirective: '" + str + "'. Not caching configuration.");
            }
        }
    }

    private String d() {
        if (this.h instanceof SearchAdRequest) {
            return "<html><head><script src=\"http://www.gstatic.com/safa/sdk-core-v40.js\"></script><script>";
        }
        return "<html><head><script src=\"http://media.admob.com/sdk-core-v40.js\"></script><script>";
    }

    public String a(Map<String, Object> map, Activity activity) throws b, d {
        Context applicationContext = activity.getApplicationContext();
        g m2 = this.g.m();
        long m3 = m2.m();
        if (m3 > 0) {
            map.put("prl", Long.valueOf(m3));
        }
        long n2 = m2.n();
        if (n2 > 0) {
            map.put("prnl", Long.valueOf(n2));
        }
        String l2 = m2.l();
        if (l2 != null) {
            map.put("ppcl", l2);
        }
        String k2 = m2.k();
        if (k2 != null) {
            map.put("pcl", k2);
        }
        long j2 = m2.j();
        if (j2 > 0) {
            map.put("pcc", Long.valueOf(j2));
        }
        map.put("preqs", Long.valueOf(m2.o()));
        map.put("toar", Long.valueOf(m2.p()));
        String r2 = m2.r();
        if (r2 != null) {
            map.put("pai", r2);
        }
        if (m2.s()) {
            map.put("aoi_timeout", "true");
        }
        if (m2.u()) {
            map.put("aoi_nofill", "true");
        }
        String x = m2.x();
        if (x != null) {
            map.put("pit", x);
        }
        map.put("ptime", Long.valueOf(g.y()));
        m2.a();
        m2.i();
        if (this.g.h().b()) {
            map.put("format", "interstitial_mb");
        } else {
            AdSize b2 = this.g.h().i.a().b();
            if (b2.isFullWidth()) {
                map.put("smart_w", "full");
            }
            if (b2.isAutoHeight()) {
                map.put("smart_h", "auto");
            }
            if (!b2.isCustomAdSize()) {
                map.put("format", b2.toString());
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("w", Integer.valueOf(b2.getWidth()));
                hashMap.put("h", Integer.valueOf(b2.getHeight()));
                map.put("ad_frame", hashMap);
            }
        }
        map.put("slotname", this.g.h().b.a());
        map.put("js", "afma-sdk-a-v6.1.0");
        try {
            int i2 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode;
            String f2 = AdUtil.f(applicationContext);
            if (!TextUtils.isEmpty(f2)) {
                map.put("mv", f2);
            }
            map.put("msid", applicationContext.getPackageName());
            map.put("app_name", i2 + ".android." + applicationContext.getPackageName());
            map.put("isu", AdUtil.a(applicationContext));
            String d2 = AdUtil.d(applicationContext);
            if (d2 == null) {
                throw new d("NETWORK_ERROR");
            }
            map.put("net", d2);
            String e2 = AdUtil.e(applicationContext);
            if (!(e2 == null || e2.length() == 0)) {
                map.put("cap", e2);
            }
            map.put("u_audio", Integer.valueOf(AdUtil.g(applicationContext).ordinal()));
            DisplayMetrics a2 = AdUtil.a(activity);
            map.put("u_sd", Float.valueOf(a2.density));
            map.put("u_h", Integer.valueOf(AdUtil.a(applicationContext, a2)));
            map.put("u_w", Integer.valueOf(AdUtil.b(applicationContext, a2)));
            map.put("hl", Locale.getDefault().getLanguage());
            StringBuilder sb = new StringBuilder();
            AdSize[] a3 = this.g.h().j.a();
            if (a3 != null) {
                for (AdSize adSize : a3) {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(adSize.getWidth() + "x" + adSize.getHeight());
                }
                map.put("sz", sb.toString());
            }
            map.put("carrier", ((TelephonyManager) applicationContext.getSystemService("phone")).getNetworkOperator());
            if (AdUtil.c()) {
                map.put("simulator", 1);
            }
            map.put("session_id", com.google.ads.b.a().b().toString());
            map.put("seq_num", com.google.ads.b.a().c().toString());
            String a4 = AdUtil.a(map);
            String str = this.g.h().a.a().a.a().l.a().booleanValue() ? d() + "AFMA_buildAdURL" + "(" + a4 + ");" + "</script></head><body></body></html>" : d() + "AFMA_getSdkConstants();" + "AFMA_buildAdURL" + "(" + a4 + ");" + "</script></head><body></body></html>";
            com.google.ads.util.b.c("adRequestUrlHtml: " + str);
            return str;
        } catch (PackageManager.NameNotFoundException e3) {
            throw new b("NameNotFoundException");
        }
    }

    /* access modifiers changed from: protected */
    public void a(AdRequest.ErrorCode errorCode, boolean z) {
        this.g.a((Runnable) new a(this.g, this.i, this.f, errorCode, z));
    }

    private void f(String str) {
        this.g.a((Runnable) new C0000c(this.i, (String) null, str));
    }

    private void e() {
        AdWebView k2 = this.g.k();
        this.g.l().c(true);
        this.g.m().h();
        this.g.a((Runnable) new C0000c(k2, this.a, this.b));
    }

    private void f() {
        this.g.a((Runnable) new e(this.g, this.i, this.k, this.r, this.o, this.l, this.m));
    }

    /* access modifiers changed from: protected */
    public synchronized void a(boolean z) {
        this.e = z;
    }

    /* access modifiers changed from: protected */
    public synchronized void b(String str) {
        this.d = str;
    }

    /* access modifiers changed from: protected */
    public synchronized void a(String str, String str2) {
        this.a = str2;
        this.b = str;
        notify();
    }

    /* access modifiers changed from: protected */
    public synchronized void c(String str) {
        this.c = str;
    }

    public synchronized void d(String str) {
        this.j = str;
        notify();
    }

    public synchronized void e(String str) {
        this.l = str;
    }

    public synchronized void a(AdSize adSize) {
        this.m = adSize;
    }

    public synchronized void a(AdRequest.ErrorCode errorCode) {
        this.p = errorCode;
        notify();
    }

    /* access modifiers changed from: protected */
    public synchronized void c() {
        this.q = true;
        notify();
    }

    public synchronized void b(boolean z) {
        this.o = z;
    }

    public synchronized void a(int i2) {
        this.r = i2;
    }

    public void c(boolean z) {
        this.t = z;
    }
}
