package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.support.p003v7.internal.widget.ActivityChooserView;
import android.text.TextUtils;
import com.google.android.gms.analytics.C0199t;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C1385ju;
import com.google.android.gms.internal.C1387jw;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {

    /* renamed from: Bm */
    private final TrackerHandler f109Bm;

    /* renamed from: Bn */
    private C0154ac f110Bn;

    /* renamed from: Bo */
    private final C0172h f111Bo;

    /* renamed from: Bp */
    private final C0155ad f112Bp;

    /* renamed from: Bq */
    private final C0171g f113Bq;

    /* renamed from: Br */
    private boolean f114Br;
    /* access modifiers changed from: private */

    /* renamed from: Bs */
    public C0149a f115Bs;
    /* access modifiers changed from: private */

    /* renamed from: Bt */
    public C0161ai f116Bt;

    /* renamed from: Bu */
    private ExceptionReporter f117Bu;
    private Context mContext;

    /* renamed from: qM */
    private final Map<String, String> f118qM;

    /* renamed from: com.google.android.gms.analytics.Tracker$a */
    private class C0149a implements GoogleAnalytics.C0147a {

        /* renamed from: Bv */
        private boolean f120Bv = false;

        /* renamed from: Bw */
        private int f121Bw = 0;

        /* renamed from: Bx */
        private long f122Bx = -1;

        /* renamed from: By */
        private boolean f123By = false;

        /* renamed from: Bz */
        private long f124Bz;

        /* renamed from: yD */
        private C1385ju f125yD = C1387jw.m5217hA();

        public C0149a() {
        }

        /* renamed from: eX */
        private void m67eX() {
            GoogleAnalytics eE = GoogleAnalytics.m52eE();
            if (eE == null) {
                C0207z.m306T("GoogleAnalytics isn't initialized for the Tracker!");
            } else if (this.f122Bx >= 0 || this.f120Bv) {
                eE.mo3481a((GoogleAnalytics.C0147a) Tracker.this.f115Bs);
            } else {
                eE.mo3483b(Tracker.this.f115Bs);
            }
        }

        /* renamed from: eU */
        public long mo3590eU() {
            return this.f122Bx;
        }

        /* renamed from: eV */
        public boolean mo3591eV() {
            return this.f120Bv;
        }

        /* renamed from: eW */
        public boolean mo3592eW() {
            boolean z = this.f123By;
            this.f123By = false;
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: eY */
        public boolean mo3593eY() {
            return this.f125yD.elapsedRealtime() >= this.f124Bz + Math.max(1000, this.f122Bx);
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.f120Bv = enabled;
            m67eX();
        }

        /* renamed from: i */
        public void mo3500i(Activity activity) {
            C0199t.m276eq().mo3731a(C0199t.C0200a.EASY_TRACKER_ACTIVITY_START);
            if (this.f121Bw == 0 && mo3593eY()) {
                this.f123By = true;
            }
            this.f121Bw++;
            if (this.f120Bv) {
                HashMap hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                C0199t.m276eq().mo3730B(true);
                Tracker.this.set("&cd", Tracker.this.f116Bt != null ? Tracker.this.f116Bt.mo3650k(activity) : activity.getClass().getCanonicalName());
                Tracker.this.send(hashMap);
                C0199t.m276eq().mo3730B(false);
            }
        }

        /* renamed from: j */
        public void mo3501j(Activity activity) {
            C0199t.m276eq().mo3731a(C0199t.C0200a.EASY_TRACKER_ACTIVITY_STOP);
            this.f121Bw--;
            this.f121Bw = Math.max(0, this.f121Bw);
            if (this.f121Bw == 0) {
                this.f124Bz = this.f125yD.elapsedRealtime();
            }
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.f122Bx = sessionTimeout;
            m67eX();
        }
    }

    Tracker(String trackingId, TrackerHandler handler, Context context) {
        this(trackingId, handler, C0172h.m182dR(), C0155ad.m104eR(), C0171g.m175dQ(), new C0206y("tracking"), context);
    }

    Tracker(String trackingId, TrackerHandler handler, C0172h clientIdDefaultProvider, C0155ad screenResolutionDefaultProvider, C0171g appFieldsDefaultProvider, C0154ac rateLimiter, Context context) {
        this.f118qM = new HashMap();
        this.f109Bm = handler;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        if (trackingId != null) {
            this.f118qM.put("&tid", trackingId);
        }
        this.f118qM.put("useSecure", "1");
        this.f111Bo = clientIdDefaultProvider;
        this.f112Bp = screenResolutionDefaultProvider;
        this.f113Bq = appFieldsDefaultProvider;
        this.f118qM.put("&a", Integer.toString(new Random().nextInt(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        this.f110Bn = rateLimiter;
        this.f115Bs = new C0149a();
        enableAdvertisingIdCollection(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3561a(C0161ai aiVar) {
        C0207z.m308V("Loading Tracker config values.");
        this.f116Bt = aiVar;
        if (this.f116Bt.mo3639fa()) {
            String fb = this.f116Bt.mo3640fb();
            set("&tid", fb);
            C0207z.m308V("[Tracker] trackingId loaded: " + fb);
        }
        if (this.f116Bt.mo3641fc()) {
            String d = Double.toString(this.f116Bt.mo3642fd());
            set("&sf", d);
            C0207z.m308V("[Tracker] sample frequency loaded: " + d);
        }
        if (this.f116Bt.mo3643fe()) {
            setSessionTimeout((long) this.f116Bt.getSessionTimeout());
            C0207z.m308V("[Tracker] session timeout loaded: " + mo3562eU());
        }
        if (this.f116Bt.mo3644ff()) {
            enableAutoActivityTracking(this.f116Bt.mo3645fg());
            C0207z.m308V("[Tracker] auto activity tracking loaded: " + mo3563eV());
        }
        if (this.f116Bt.mo3646fh()) {
            if (this.f116Bt.mo3647fi()) {
                set("&aip", "1");
                C0207z.m308V("[Tracker] anonymize ip loaded: true");
            }
            C0207z.m308V("[Tracker] anonymize ip loaded: false");
        }
        enableExceptionReporting(this.f116Bt.mo3648fj());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eU */
    public long mo3562eU() {
        return this.f115Bs.mo3590eU();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: eV */
    public boolean mo3563eV() {
        return this.f115Bs.mo3591eV();
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        if (!enabled) {
            this.f118qM.put("&ate", (Object) null);
            this.f118qM.put("&adid", (Object) null);
            return;
        }
        if (this.f118qM.containsKey("&ate")) {
            this.f118qM.remove("&ate");
        }
        if (this.f118qM.containsKey("&adid")) {
            this.f118qM.remove("&adid");
        }
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.f115Bs.enableAutoActivityTracking(enabled);
    }

    public void enableExceptionReporting(boolean enabled) {
        if (this.f114Br != enabled) {
            this.f114Br = enabled;
            if (enabled) {
                this.f117Bu = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
                Thread.setDefaultUncaughtExceptionHandler(this.f117Bu);
                C0207z.m308V("Uncaught exceptions will be reported to Google Analytics.");
                return;
            }
            if (this.f117Bu != null) {
                Thread.setDefaultUncaughtExceptionHandler(this.f117Bu.mo3477dZ());
            } else {
                Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler) null);
            }
            C0207z.m308V("Uncaught exceptions will not be reported to Google Analytics.");
        }
    }

    public String get(String key) {
        C0199t.m276eq().mo3731a(C0199t.C0200a.GET);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.f118qM.containsKey(key)) {
            return this.f118qM.get(key);
        }
        if (key.equals("&ul")) {
            return C0162aj.m143a(Locale.getDefault());
        }
        if (this.f111Bo != null && this.f111Bo.mo3701ac(key)) {
            return this.f111Bo.getValue(key);
        }
        if (this.f112Bp != null && this.f112Bp.mo3615ac(key)) {
            return this.f112Bp.getValue(key);
        }
        if (this.f113Bq == null || !this.f113Bq.mo3700ac(key)) {
            return null;
        }
        return this.f113Bq.getValue(key);
    }

    public void send(Map<String, String> params) {
        C0199t.m276eq().mo3731a(C0199t.C0200a.SEND);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f118qM);
        if (params != null) {
            hashMap.putAll(params);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            C0207z.m309W(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str)) {
            C0207z.m309W(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str = "";
        }
        if (this.f115Bs.mo3592eW()) {
            hashMap.put("&sc", "start");
        }
        String lowerCase = str.toLowerCase();
        if ("screenview".equals(lowerCase) || "pageview".equals(lowerCase) || "appview".equals(lowerCase) || TextUtils.isEmpty(lowerCase)) {
            int parseInt = Integer.parseInt(this.f118qM.get("&a")) + 1;
            if (parseInt >= Integer.MAX_VALUE) {
                parseInt = 1;
            }
            this.f118qM.put("&a", Integer.toString(parseInt));
        }
        if (lowerCase.equals("transaction") || lowerCase.equals("item") || this.f110Bn.mo3614eK()) {
            this.f109Bm.mo3499u(hashMap);
        } else {
            C0207z.m309W("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String key, String value) {
        C0348n.m857b(key, (Object) "Key should be non-null");
        C0199t.m276eq().mo3731a(C0199t.C0200a.SET);
        this.f118qM.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", C0162aj.m141C(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toHexString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            C0207z.m309W("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.f115Bs.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", C0162aj.m141C(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }
}
