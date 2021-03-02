package com.google.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.google.ads.ah;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.internal.e;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.g;
import java.util.HashMap;

public class AdActivity extends Activity implements View.OnClickListener {
    public static final String BASE_URL_PARAM = "baseurl";
    public static final String HTML_PARAM = "html";
    public static final String INTENT_ACTION_PARAM = "i";
    public static final String ORIENTATION_PARAM = "o";
    public static final String TYPE_PARAM = "m";
    public static final String URL_PARAM = "u";
    private static final a a = a.a.b();
    /* access modifiers changed from: private */
    public static final Object b = new Object();
    private static AdActivity c = null;
    /* access modifiers changed from: private */
    public static d d = null;
    /* access modifiers changed from: private */
    public static AdActivity e = null;
    private static AdActivity f = null;
    private static final StaticMethodWrapper g = new StaticMethodWrapper();
    private AdWebView h;
    private ViewGroup i = null;
    private boolean j;
    private long k;
    private RelativeLayout l;
    private AdActivity m = null;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private AdVideoView r;

    public static class StaticMethodWrapper {
        public boolean isShowing() {
            boolean z;
            synchronized (AdActivity.b) {
                z = AdActivity.e != null;
            }
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
            r1 = new android.content.Intent(r0.getApplicationContext(), com.google.ads.AdActivity.class);
            r1.putExtra("com.google.ads.AdOpener", r6.a());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            com.google.ads.util.b.a("Launching AdActivity.");
            r0.startActivity(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            com.google.ads.util.b.b("Activity not found.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
            r0 = r5.h().c.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
            if (r0 != null) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
            com.google.ads.util.b.e("activity was null while launching an AdActivity.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void launchAdActivity(com.google.ads.internal.d r5, com.google.ads.internal.e r6) {
            /*
                r4 = this;
                java.lang.Object r1 = com.google.ads.AdActivity.b
                monitor-enter(r1)
                com.google.ads.internal.d r0 = com.google.ads.AdActivity.d     // Catch:{ all -> 0x0030 }
                if (r0 != 0) goto L_0x0023
                com.google.ads.internal.d unused = com.google.ads.AdActivity.d = r5     // Catch:{ all -> 0x0030 }
            L_0x000e:
                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                com.google.ads.m r0 = r5.h()
                com.google.ads.util.i$d<android.app.Activity> r0 = r0.c
                java.lang.Object r0 = r0.a()
                android.app.Activity r0 = (android.app.Activity) r0
                if (r0 != 0) goto L_0x0033
                java.lang.String r0 = "activity was null while launching an AdActivity."
                com.google.ads.util.b.e(r0)
            L_0x0022:
                return
            L_0x0023:
                com.google.ads.internal.d r0 = com.google.ads.AdActivity.d     // Catch:{ all -> 0x0030 }
                if (r0 == r5) goto L_0x000e
                java.lang.String r0 = "Tried to launch a new AdActivity with a different AdManager."
                com.google.ads.util.b.b(r0)     // Catch:{ all -> 0x0030 }
                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                goto L_0x0022
            L_0x0030:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                throw r0
            L_0x0033:
                android.content.Intent r1 = new android.content.Intent
                android.content.Context r2 = r0.getApplicationContext()
                java.lang.Class<com.google.ads.AdActivity> r3 = com.google.ads.AdActivity.class
                r1.<init>(r2, r3)
                java.lang.String r2 = "com.google.ads.AdOpener"
                android.os.Bundle r3 = r6.a()
                r1.putExtra(r2, r3)
                java.lang.String r2 = "Launching AdActivity."
                com.google.ads.util.b.a((java.lang.String) r2)     // Catch:{ ActivityNotFoundException -> 0x0050 }
                r0.startActivity(r1)     // Catch:{ ActivityNotFoundException -> 0x0050 }
                goto L_0x0022
            L_0x0050:
                r0 = move-exception
                java.lang.String r1 = "Activity not found."
                com.google.ads.util.b.b(r1, r0)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.StaticMethodWrapper.launchAdActivity(com.google.ads.internal.d, com.google.ads.internal.e):void");
        }
    }

    /* access modifiers changed from: protected */
    public View a(int i2) {
        ImageButton imageButton = new ImageButton(getApplicationContext());
        imageButton.setImageResource(17301527);
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        imageButton.setPadding(0, 0, 0, 0);
        int applyDimension = (int) TypedValue.applyDimension(1, (float) i2, getResources().getDisplayMetrics());
        FrameLayout frameLayout = new FrameLayout(getApplicationContext());
        frameLayout.addView(imageButton, applyDimension, applyDimension);
        return frameLayout;
    }

    private void a(String str) {
        b.b(str);
        finish();
    }

    private void a(String str, Throwable th) {
        b.b(str, th);
        finish();
    }

    public AdVideoView getAdVideoView() {
        return this.r;
    }

    public AdWebView getOpeningAdWebView() {
        if (this.m != null) {
            return this.m.h;
        }
        synchronized (b) {
            if (d == null) {
                b.e("currentAdManager was null while trying to get the opening AdWebView.");
                return null;
            }
            AdWebView k2 = d.k();
            if (k2 != this.h) {
                return k2;
            }
            return null;
        }
    }

    public static boolean isShowing() {
        return g.isShowing();
    }

    public static void launchAdActivity(d adManager, e adOpener) {
        g.launchAdActivity(adManager, adOpener);
    }

    /* access modifiers changed from: protected */
    public void a(HashMap<String, String> hashMap, d dVar) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.putExtras(getIntent().getExtras());
        intent.putExtra("com.google.circles.platform.intent.extra.ENTITY", hashMap.get(URL_PARAM));
        intent.putExtra("com.google.circles.platform.intent.extra.ENTITY_TYPE", ah.b.AD.c);
        intent.putExtra("com.google.circles.platform.intent.extra.ACTION", hashMap.get("a"));
        a(dVar);
        try {
            b.a("Launching Google+ intent from AdActivity.");
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e2) {
            a(e2.getMessage(), (Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    public void b(HashMap<String, String> hashMap, d dVar) {
        if (hashMap == null) {
            a("Could not get the paramMap in launchIntent()");
            return;
        }
        String str = hashMap.get(URL_PARAM);
        if (str == null) {
            a("Could not get the URL parameter in launchIntent().");
            return;
        }
        String str2 = hashMap.get(INTENT_ACTION_PARAM);
        String str3 = hashMap.get(TYPE_PARAM);
        Uri parse = Uri.parse(str);
        Intent intent = str2 == null ? new Intent("android.intent.action.VIEW", parse) : new Intent(str2, parse);
        if (str3 != null) {
            intent.setDataAndType(parse, str3);
        }
        a(dVar);
        try {
            b.a("Launching an intent from AdActivity: " + intent.getAction() + " - " + parse);
            startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            a(e2.getMessage(), (Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(d dVar) {
        this.h = null;
        this.k = SystemClock.elapsedRealtime();
        this.n = true;
        synchronized (b) {
            if (c == null) {
                c = this;
                dVar.v();
            }
        }
    }

    /* access modifiers changed from: protected */
    public AdVideoView a(Activity activity) {
        return new AdVideoView(activity, this.h);
    }

    public void moveAdVideoView(int x, int y, int width, int height) {
        if (this.r != null) {
            this.r.setLayoutParams(a(x, y, width, height));
            this.r.requestLayout();
        }
    }

    public void newAdVideoView(int x, int y, int width, int height) {
        if (this.r == null) {
            this.r = a((Activity) this);
            this.l.addView(this.r, 0, a(x, y, width, height));
            synchronized (b) {
                if (d == null) {
                    b.e("currentAdManager was null while trying to get the opening AdWebView.");
                } else {
                    d.l().b(false);
                }
            }
        }
    }

    private RelativeLayout.LayoutParams a(int i2, int i3, int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams.setMargins(i2, i3, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public void onClick(View v) {
        finish();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0088, code lost:
        r10.l = null;
        r10.n = false;
        r10.o = true;
        r10.r = null;
        r0 = getIntent().getBundleExtra("com.google.ads.AdOpener");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        if (r0 != null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        a("Could not get the Bundle used to create AdActivity.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
        r1 = new com.google.ads.internal.e(r0);
        r0 = r1.b();
        r9 = r1.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c3, code lost:
        if (r0.equals("plusone") == false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c5, code lost:
        a(r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cf, code lost:
        if (r0.equals("intent") == false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        b(r9, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d5, code lost:
        r10.l = new android.widget.RelativeLayout(getApplicationContext());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e6, code lost:
        if (r0.equals("webapp") == false) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e8, code lost:
        r10.h = new com.google.ads.internal.AdWebView(r7.h(), (com.google.ads.AdSize) null);
        r1 = com.google.ads.internal.a.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f5, code lost:
        if (r8 != false) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f7, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f8, code lost:
        r0 = com.google.ads.internal.i.a(r7, r1, true, r0);
        r0.d(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ff, code lost:
        if (r8 == false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0101, code lost:
        r0.a(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0104, code lost:
        r10.h.setWebViewClient(r0);
        r0 = r9.get(URL_PARAM);
        r1 = r9.get(BASE_URL_PARAM);
        r2 = r9.get(HTML_PARAM);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0121, code lost:
        if (r0 == null) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0123, code lost:
        r10.h.loadUrl(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0128, code lost:
        r0 = r9.get(ORIENTATION_PARAM);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0136, code lost:
        if ("p".equals(r0) == false) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0138, code lost:
        r0 = com.google.ads.util.AdUtil.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013c, code lost:
        a(r10.h, false, r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0143, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0145, code lost:
        if (r2 == null) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0147, code lost:
        r10.h.loadDataWithBaseURL(r1, r2, "text/html", "utf-8", (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0151, code lost:
        a("Could not get the URL or HTML parameter to show a web app.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x015e, code lost:
        if ("l".equals(r0) == false) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0160, code lost:
        r0 = com.google.ads.util.AdUtil.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0167, code lost:
        if (r10 != e) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0169, code lost:
        r0 = r7.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x016e, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0176, code lost:
        if (r0.equals("interstitial") != false) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x017e, code lost:
        if (r0.equals("expand") == false) goto L_0x01b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0180, code lost:
        r10.h = r7.k();
        r1 = r7.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0190, code lost:
        if (r0.equals("expand") == false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0192, code lost:
        r10.h.setIsExpandedMraid(true);
        r10.o = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x019b, code lost:
        if (r10.p == false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x019f, code lost:
        if (r10.q != false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a1, code lost:
        com.google.ads.util.b.a("Re-enabling hardware acceleration on expanding MRAID WebView.");
        r10.h.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ab, code lost:
        a(r10.h, true, r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b2, code lost:
        a("Unknown AdOpener, <action: " + r0 + ">");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            r5 = 0
            r6 = 0
            r2 = 1
            super.onCreate(r11)
            r10.j = r6
            java.lang.Object r3 = b
            monitor-enter(r3)
            com.google.ads.internal.d r0 = d     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x00a2
            com.google.ads.internal.d r7 = d     // Catch:{ all -> 0x00a9 }
            com.google.ads.AdActivity r0 = e     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x001a
            e = r10     // Catch:{ all -> 0x00a9 }
            r7.u()     // Catch:{ all -> 0x00a9 }
        L_0x001a:
            com.google.ads.AdActivity r0 = r10.m     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x0026
            com.google.ads.AdActivity r0 = f     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0026
            com.google.ads.AdActivity r0 = f     // Catch:{ all -> 0x00a9 }
            r10.m = r0     // Catch:{ all -> 0x00a9 }
        L_0x0026:
            f = r10     // Catch:{ all -> 0x00a9 }
            com.google.ads.m r0 = r7.h()     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0036
            com.google.ads.AdActivity r0 = e     // Catch:{ all -> 0x00a9 }
            if (r0 == r10) goto L_0x0046
        L_0x0036:
            com.google.ads.m r0 = r7.h()     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.b()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0049
            com.google.ads.AdActivity r0 = r10.m     // Catch:{ all -> 0x00a9 }
            com.google.ads.AdActivity r1 = e     // Catch:{ all -> 0x00a9 }
            if (r0 != r1) goto L_0x0049
        L_0x0046:
            r7.w()     // Catch:{ all -> 0x00a9 }
        L_0x0049:
            boolean r8 = r7.q()     // Catch:{ all -> 0x00a9 }
            com.google.ads.m r0 = r7.h()     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$b<com.google.ads.l> r0 = r0.a     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.a()     // Catch:{ all -> 0x00a9 }
            com.google.ads.l r0 = (com.google.ads.l) r0     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$b<com.google.ads.l$a> r0 = r0.a     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.a()     // Catch:{ all -> 0x00a9 }
            com.google.ads.l$a r0 = (com.google.ads.l.a) r0     // Catch:{ all -> 0x00a9 }
            int r4 = com.google.ads.util.AdUtil.a     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$c<java.lang.Integer> r1 = r0.a     // Catch:{ all -> 0x00a9 }
            java.lang.Object r1 = r1.a()     // Catch:{ all -> 0x00a9 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00a9 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00a9 }
            if (r4 < r1) goto L_0x00ac
            r1 = r2
        L_0x0072:
            r10.q = r1     // Catch:{ all -> 0x00a9 }
            int r1 = com.google.ads.util.AdUtil.a     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$c<java.lang.Integer> r0 = r0.b     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.a()     // Catch:{ all -> 0x00a9 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00a9 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x00a9 }
            if (r1 < r0) goto L_0x00ae
            r0 = r2
        L_0x0085:
            r10.p = r0     // Catch:{ all -> 0x00a9 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a9 }
            r10.l = r5
            r10.n = r6
            r10.o = r2
            r10.r = r5
            android.content.Intent r0 = r10.getIntent()
            java.lang.String r1 = "com.google.ads.AdOpener"
            android.os.Bundle r0 = r0.getBundleExtra(r1)
            if (r0 != 0) goto L_0x00b0
            java.lang.String r0 = "Could not get the Bundle used to create AdActivity."
            r10.a((java.lang.String) r0)
        L_0x00a1:
            return
        L_0x00a2:
            java.lang.String r0 = "Could not get currentAdManager."
            r10.a((java.lang.String) r0)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r3)     // Catch:{ all -> 0x00a9 }
            goto L_0x00a1
        L_0x00a9:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00a9 }
            throw r0
        L_0x00ac:
            r1 = r6
            goto L_0x0072
        L_0x00ae:
            r0 = r6
            goto L_0x0085
        L_0x00b0:
            com.google.ads.internal.e r1 = new com.google.ads.internal.e
            r1.<init>((android.os.Bundle) r0)
            java.lang.String r0 = r1.b()
            java.util.HashMap r9 = r1.c()
            java.lang.String r1 = "plusone"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00c9
            r10.a((java.util.HashMap<java.lang.String, java.lang.String>) r9, (com.google.ads.internal.d) r7)
            goto L_0x00a1
        L_0x00c9:
            java.lang.String r1 = "intent"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00d5
            r10.b(r9, r7)
            goto L_0x00a1
        L_0x00d5:
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout
            android.content.Context r3 = r10.getApplicationContext()
            r1.<init>(r3)
            r10.l = r1
            java.lang.String r1 = "webapp"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0170
            com.google.ads.internal.AdWebView r0 = new com.google.ads.internal.AdWebView
            com.google.ads.m r1 = r7.h()
            r0.<init>(r1, r5)
            r10.h = r0
            java.util.Map<java.lang.String, com.google.ads.n> r1 = com.google.ads.internal.a.c
            if (r8 != 0) goto L_0x0143
            r0 = r2
        L_0x00f8:
            com.google.ads.internal.i r0 = com.google.ads.internal.i.a(r7, r1, r2, r0)
            r0.d(r2)
            if (r8 == 0) goto L_0x0104
            r0.a(r2)
        L_0x0104:
            com.google.ads.internal.AdWebView r1 = r10.h
            r1.setWebViewClient(r0)
            java.lang.String r0 = "u"
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "baseurl"
            java.lang.Object r1 = r9.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "html"
            java.lang.Object r2 = r9.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r0 == 0) goto L_0x0145
            com.google.ads.internal.AdWebView r1 = r10.h
            r1.loadUrl(r0)
        L_0x0128:
            java.lang.String r0 = "o"
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "p"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0158
            int r0 = com.google.ads.util.AdUtil.b()
        L_0x013c:
            com.google.ads.internal.AdWebView r1 = r10.h
            r10.a((com.google.ads.internal.AdWebView) r1, (boolean) r6, (int) r0, (boolean) r8)
            goto L_0x00a1
        L_0x0143:
            r0 = r6
            goto L_0x00f8
        L_0x0145:
            if (r2 == 0) goto L_0x0151
            com.google.ads.internal.AdWebView r0 = r10.h
            java.lang.String r3 = "text/html"
            java.lang.String r4 = "utf-8"
            r0.loadDataWithBaseURL(r1, r2, r3, r4, r5)
            goto L_0x0128
        L_0x0151:
            java.lang.String r0 = "Could not get the URL or HTML parameter to show a web app."
            r10.a((java.lang.String) r0)
            goto L_0x00a1
        L_0x0158:
            java.lang.String r1 = "l"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0165
            int r0 = com.google.ads.util.AdUtil.a()
            goto L_0x013c
        L_0x0165:
            com.google.ads.AdActivity r0 = e
            if (r10 != r0) goto L_0x016e
            int r0 = r7.n()
            goto L_0x013c
        L_0x016e:
            r0 = -1
            goto L_0x013c
        L_0x0170:
            java.lang.String r1 = "interstitial"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0180
            java.lang.String r1 = "expand"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01b2
        L_0x0180:
            com.google.ads.internal.AdWebView r1 = r7.k()
            r10.h = r1
            int r1 = r7.n()
            java.lang.String r3 = "expand"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01ab
            com.google.ads.internal.AdWebView r0 = r10.h
            r0.setIsExpandedMraid(r2)
            r10.o = r6
            boolean r0 = r10.p
            if (r0 == 0) goto L_0x01ab
            boolean r0 = r10.q
            if (r0 != 0) goto L_0x01ab
            java.lang.String r0 = "Re-enabling hardware acceleration on expanding MRAID WebView."
            com.google.ads.util.b.a((java.lang.String) r0)
            com.google.ads.internal.AdWebView r0 = r10.h
            r0.c()
        L_0x01ab:
            com.google.ads.internal.AdWebView r0 = r10.h
            r10.a((com.google.ads.internal.AdWebView) r0, (boolean) r2, (int) r1, (boolean) r8)
            goto L_0x00a1
        L_0x01b2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown AdOpener, <action: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = ">"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.a((java.lang.String) r0)
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void a(AdWebView adWebView, boolean z, int i2, boolean z2) {
        requestWindowFeature(1);
        Window window = getWindow();
        window.setFlags(1024, 1024);
        if (AdUtil.a >= 11) {
            if (this.p) {
                b.a("Enabling hardware acceleration on the AdActivity window.");
                g.a(window);
            } else {
                b.a("Disabling hardware acceleration on the AdActivity WebView.");
                adWebView.b();
            }
        }
        ViewParent parent = adWebView.getParent();
        if (parent != null) {
            if (!z2) {
                a("Interstitial created with an AdWebView that has a parent.");
                return;
            } else if (parent instanceof ViewGroup) {
                this.i = (ViewGroup) parent;
                this.i.removeView(adWebView);
            } else {
                a("MRAID banner was not a child of a ViewGroup.");
                return;
            }
        }
        if (adWebView.d() != null) {
            a("Interstitial created with an AdWebView that is already in use by another AdActivity.");
            return;
        }
        setRequestedOrientation(i2);
        adWebView.setAdActivity(this);
        View a2 = a(z2 ? 50 : 32);
        this.l.addView(adWebView, -1, -1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (z2) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
        this.l.addView(a2, layoutParams);
        this.l.setKeepScreenOn(true);
        setContentView(this.l);
        this.l.getRootView().setBackgroundColor(-16777216);
        if (z) {
            a.a((WebView) adWebView);
        }
    }

    public void onDestroy() {
        if (this.l != null) {
            this.l.removeAllViews();
        }
        if (isFinishing()) {
            d();
            if (this.o && this.h != null) {
                this.h.stopLoading();
                this.h.destroy();
                this.h = null;
            }
        }
        super.onDestroy();
    }

    public void onPause() {
        if (isFinishing()) {
            d();
        }
        super.onPause();
    }

    private void d() {
        if (!this.j) {
            if (this.h != null) {
                a.b((WebView) this.h);
                this.h.setAdActivity((AdActivity) null);
                this.h.setIsExpandedMraid(false);
                if (!(this.o || this.l == null || this.i == null)) {
                    if (this.p && !this.q) {
                        b.a("Disabling hardware acceleration on collapsing MRAID WebView.");
                        this.h.b();
                    } else if (!this.p && this.q) {
                        b.a("Re-enabling hardware acceleration on collapsing MRAID WebView.");
                        this.h.c();
                    }
                    this.l.removeView(this.h);
                    this.i.addView(this.h);
                }
            }
            if (this.r != null) {
                this.r.e();
                this.r = null;
            }
            if (this == c) {
                c = null;
            }
            f = this.m;
            synchronized (b) {
                if (!(d == null || !this.o || this.h == null)) {
                    if (this.h == d.k()) {
                        d.a();
                    }
                    this.h.stopLoading();
                }
                if (this == e) {
                    e = null;
                    if (d != null) {
                        d.t();
                        d = null;
                    } else {
                        b.e("currentAdManager is null while trying to destroy AdActivity.");
                    }
                }
            }
            this.j = true;
            b.a("AdActivity is closing.");
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (this.n && hasFocus && SystemClock.elapsedRealtime() - this.k > 250) {
            b.d("Launcher AdActivity got focus and is closing.");
            finish();
        }
        super.onWindowFocusChanged(hasFocus);
    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (!(getOpeningAdWebView() == null || data == null || data.getExtras() == null || data.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION") == null || data.getExtras().getString("com.google.circles.platform.result.extra.ACTION") == null)) {
            String string = data.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION");
            String string2 = data.getExtras().getString("com.google.circles.platform.result.extra.ACTION");
            if (string.equals("yes")) {
                if (string2.equals("insert")) {
                    af.a((WebView) getOpeningAdWebView(), true);
                } else if (string2.equals("delete")) {
                    af.a((WebView) getOpeningAdWebView(), false);
                }
            }
        }
        finish();
    }
}
