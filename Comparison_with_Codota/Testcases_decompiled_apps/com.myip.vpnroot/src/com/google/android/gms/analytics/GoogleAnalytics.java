package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.analytics.C0199t;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {

    /* renamed from: AC */
    private static GoogleAnalytics f91AC;

    /* renamed from: Av */
    private static boolean f92Av;

    /* renamed from: AA */
    private Set<C0147a> f93AA;

    /* renamed from: AB */
    private boolean f94AB;

    /* renamed from: Aw */
    private boolean f95Aw;

    /* renamed from: Ax */
    private C0156ae f96Ax;

    /* renamed from: Ay */
    private volatile Boolean f97Ay;

    /* renamed from: Az */
    private Logger f98Az;
    private Context mContext;

    /* renamed from: xL */
    private String f99xL;

    /* renamed from: xM */
    private String f100xM;

    /* renamed from: ye */
    private C0170f f101ye;

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics$a */
    interface C0147a {
        /* renamed from: i */
        void mo3500i(Activity activity);

        /* renamed from: j */
        void mo3501j(Activity activity);
    }

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics$b */
    class C0148b implements Application.ActivityLifecycleCallbacks {
        C0148b() {
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.mo3486g(activity);
        }

        public void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.mo3489h(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, C0194s.m254B(context), C0183q.m217ea());
    }

    private GoogleAnalytics(Context context, C0170f thread, C0156ae serviceManager) {
        this.f97Ay = false;
        this.f94AB = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.f101ye = thread;
        this.f96Ax = serviceManager;
        C0171g.m176y(this.mContext);
        C0155ad.m105y(this.mContext);
        C0172h.m185y(this.mContext);
        this.f98Az = new C0177k();
        this.f93AA = new HashSet();
        m53eF();
    }

    /* renamed from: a */
    private Tracker m50a(Tracker tracker) {
        if (this.f99xL != null) {
            tracker.set("&an", this.f99xL);
        }
        if (this.f100xM != null) {
            tracker.set("&av", this.f100xM);
        }
        return tracker;
    }

    /* renamed from: ai */
    private int m51ai(String str) {
        String lowerCase = str.toLowerCase();
        if ("verbose".equals(lowerCase)) {
            return 0;
        }
        if ("info".equals(lowerCase)) {
            return 1;
        }
        if ("warning".equals(lowerCase)) {
            return 2;
        }
        return "error".equals(lowerCase) ? 3 : -1;
    }

    /* renamed from: eE */
    static GoogleAnalytics m52eE() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = f91AC;
        }
        return googleAnalytics;
    }

    /* renamed from: eF */
    private void m53eF() {
        ApplicationInfo applicationInfo;
        int i;
        C0203v vVar;
        if (!f92Av) {
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (PackageManager.NameNotFoundException e) {
                C0207z.m308V("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                C0207z.m309W("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0 && (vVar = (C0203v) new C0201u(this.mContext).mo3706w(i)) != null) {
                mo3482a(vVar);
            }
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (f91AC == null) {
                f91AC = new GoogleAnalytics(context);
            }
            googleAnalytics = f91AC;
        }
        return googleAnalytics;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3481a(C0147a aVar) {
        this.f93AA.add(aVar);
        if (this.mContext instanceof Application) {
            enableAutoActivityReports((Application) this.mContext);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3482a(C0203v vVar) {
        int ai;
        C0207z.m308V("Loading global config values.");
        if (vVar.mo3739eu()) {
            this.f99xL = vVar.mo3740ev();
            C0207z.m308V("app name loaded: " + this.f99xL);
        }
        if (vVar.mo3741ew()) {
            this.f100xM = vVar.mo3742ex();
            C0207z.m308V("app version loaded: " + this.f100xM);
        }
        if (vVar.mo3743ey() && (ai = m51ai(vVar.mo3744ez())) >= 0) {
            C0207z.m308V("log level loaded: " + ai);
            getLogger().setLogLevel(ai);
        }
        if (vVar.mo3735eA()) {
            this.f96Ax.setLocalDispatchPeriod(vVar.mo3736eB());
        }
        if (vVar.mo3737eC()) {
            setDryRun(vVar.mo3738eD());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3483b(C0147a aVar) {
        this.f93AA.remove(aVar);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.f96Ax.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (Build.VERSION.SDK_INT >= 14 && !this.f94AB) {
            application.registerActivityLifecycleCallbacks(new C0148b());
            this.f94AB = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo3486g(Activity activity) {
        for (C0147a i : this.f93AA) {
            i.mo3500i(activity);
        }
    }

    public boolean getAppOptOut() {
        C0199t.m276eq().mo3731a(C0199t.C0200a.GET_APP_OPT_OUT);
        return this.f97Ay.booleanValue();
    }

    public Logger getLogger() {
        return this.f98Az;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo3489h(Activity activity) {
        for (C0147a j : this.f93AA) {
            j.mo3501j(activity);
        }
    }

    public boolean isDryRunEnabled() {
        C0199t.m276eq().mo3731a(C0199t.C0200a.GET_DRY_RUN);
        return this.f95Aw;
    }

    public Tracker newTracker(int configResId) {
        Tracker a;
        C0161ai aiVar;
        synchronized (this) {
            C0199t.m276eq().mo3731a(C0199t.C0200a.GET_TRACKER);
            Tracker tracker = new Tracker((String) null, this, this.mContext);
            if (configResId > 0 && (aiVar = (C0161ai) new C0159ah(this.mContext).mo3706w(configResId)) != null) {
                tracker.mo3561a(aiVar);
            }
            a = m50a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String trackingId) {
        Tracker a;
        synchronized (this) {
            C0199t.m276eq().mo3731a(C0199t.C0200a.GET_TRACKER);
            a = m50a(new Tracker(trackingId, this, this.mContext));
        }
        return a;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.f94AB) {
            mo3486g(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.f94AB) {
            mo3489h(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        C0199t.m276eq().mo3731a(C0199t.C0200a.SET_APP_OPT_OUT);
        this.f97Ay = Boolean.valueOf(optOut);
        if (this.f97Ay.booleanValue()) {
            this.f101ye.mo3694dI();
        }
    }

    public void setDryRun(boolean dryRun) {
        C0199t.m276eq().mo3731a(C0199t.C0200a.SET_DRY_RUN);
        this.f95Aw = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.f96Ax.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        C0199t.m276eq().mo3731a(C0199t.C0200a.SET_LOGGER);
        this.f98Az = logger;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo3499u(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            C0162aj.m145a(map, "&ul", C0162aj.m143a(Locale.getDefault()));
            C0162aj.m144a(map, "&sr", (C0178l) C0155ad.m104eR());
            map.put("&_u", C0199t.m276eq().mo3733es());
            C0199t.m276eq().mo3732er();
            this.f101ye.mo3699u(map);
        }
    }
}
